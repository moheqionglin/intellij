/**
 * Created by zhouwanli on 16/03/2017.
 */
'use strict'
const gulp = require('gulp');
const usemin = require('gulp-usemin');
const uglify = require('gulp-uglify');
const ngmin = require('gulp-ng-annotate');
const minifyCss = require('gulp-minify-css');
const sass = require('gulp-sass');
const jshint = require('gulp-jshint');
const stylish = require('jshint-stylish');
const rev = require('gulp-rev');
const cdnizer = require("gulp-cdnizer");
const revReplace = require("gulp-rev-replace");
const filter = require("gulp-filter");
const del = require('del');
const sourcemap = require('gulp-sourcemaps');
const gulpUtil = require('gulp-util');
const CDN = 'http://p4tfz730q.bkt.clouddn.com';

gulp.task('convert-sass', function () {
	return gulp.src('src/main/webapp/app/sass/*.scss')
		.pipe(sourcemap.init())
		.pipe(sass())
		.pipe(sourcemap.write('./'))
		.pipe(gulp.dest('src/main/webapp/app/styles/'));
});

gulp.task('scripts', function () {
	return gulp.src('app/**/*.js', {cwd: 'src/main/webapp/'})
		.pipe(jshint())
		.pipe(jshint.reporter(stylish));
});

gulp.task('copy-fonts', function () {
	return gulp.src(['src/main/webapp/components/semantic-ui/dist/themes/default/assets/fonts/*.{ttf,woff,woff2,eot,svg}'])
		// .pipe(flatten())
		.pipe(gulp.dest('target/intellij/flower_intellij/themes/default/assets/fonts/'));
});

gulp.task('usemin', ['copy-fonts', 'scripts', 'convert-sass'], function () {
	return gulp.src('**/*.jsp', {cwd: 'src/main/webapp/'})
		.pipe(usemin({
			externalCss: [minifyCss({processImport: false})],
			appCss: [minifyCss()],
			printCss: [minifyCss()],
			externalJs: [ngmin(), uglify()],
			appJs: [ngmin(), uglify().on('error', gulpUtil.log)]
		}))
		.pipe(gulp.dest('target/intellij/'));
});

gulp.task('cdnify', ['usemin'], function () {
	var cssFilter = filter('**/external.css', {restore: true});
	var jsFilter = filter('**/*-all.js', {restore: true});
	return gulp.src(['target/intellij/flower_intellij/*.js', 'target/intellij/flower_intellij/*.css', 'target/intellij/app/index.jsp'])
		.pipe(jsFilter)
		.pipe(rev())
		.pipe(jsFilter.restore)
		.pipe(gulp.dest('target/intellij/flower_intellij'))
		.pipe(cssFilter)
		.pipe(rev())
		.pipe(cssFilter.restore)
		.pipe(gulp.dest('target/intellij/flower_intellij'))
		.pipe(revReplace({replaceInExtensions: ['.jsp']}))
		.pipe(cdnizer({
			defaultCDNBase: CDN ,
			relativeRoot: '/',
			files: [
				// {
				// 	//ignore this file, otherwise it tries to map this to our cdn, which breaks the url
				// 	file: 'http://g.alicdn.com/ilw/ding/0.8.6/scripts/dingtalk.js',
				// 	cdn: 'http://g.alicdn.com/ilw/ding/0.8.6/scripts/dingtalk.js'
				// },
				'**/external-*.css',
				'**/lib-all-*.js',
				'**/app-all-*.js'
			]}
		))
		.pipe(gulp.dest("target/intellij/app/"));
});

gulp.task('default', ['scripts', 'convert-sass']);

gulp.task('prod', ['usemin'], function (cb) {
	del([
		'target/frontend-app/bower_components'
	]);
});


function cdned(cdn) {
	var cssFilter = filter('**/*.css');
	var jsFilter = filter('**/*.js');
	var jspFilter = filter('**/*.jsp');
	return gulp.src(['index.jsp'], {cwd: 'target/intellij/app'})
		.pipe(jsFilter)
		.pipe(rev())
		// .pipe(jsFilter.restore())
		.pipe(cssFilter)
		.pipe(rev())
		// .pipe(cssFilter.restore())
		.pipe(revReplace({replaceInExtensions: ['.html', '.jsp']}))
		.pipe(cdnizer({
			defaultCDNBase: cdn,
			relativeRoot: '/',
			files: [
				{
					//ignore this file, otherwise it tries to map this to our cdn, which breaks the url
					file: 'http://g.alicdn.com/ilw/ding/0.8.6/scripts/dingtalk.js',
					cdn: 'http://g.alicdn.com/ilw/ding/0.8.6/scripts/dingtalk.js'
				},
				'**/external-*.css',
				'**/lib-all-*.js',
				'**/app-all-*.js'
			]
		}))
		.pipe(gulp.dest('target/intellij/app/'));
};

