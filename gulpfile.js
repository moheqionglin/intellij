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
const karma = require('gulp-karma');
const flatten = require('gulp-flatten');
const rev = require('gulp-rev');
const cdnizer = require("gulp-cdnizer");
const revReplace = require("gulp-rev-replace");
const filter = require("gulp-filter");
const del = require('del');
const sourcemap = require('gulp-sourcemaps');
const gulpUtil = require('gulp-util');
const replace = require('gulp-replace');
const CDN = '${resourceUrl}';

gulp.task('convert-sass', function () {
	return gulp.src('src/main/webapp/app/sass/*.scss')
		.pipe(sourcemap.init())
		.pipe(sourcemap.write('./'))
		.pipe(gulp.dest('src/main/webapp/app/styles/'));
});

gulp.task('scripts', function () {
	return gulp.src('app/**/*.js', {cwd: 'src/main/webapp/'})
		.pipe(jshint())
		.pipe(jshint.reporter(stylish));
});


gulp.task('usemin', ['scripts', 'convert-sass'], function () {
	return gulp.src('app/index.jsp', {cwd: 'src/main/webapp/'})
		.pipe(usemin({
			cssLibIndex: [minifyCss({processImport: false})],
			appCss: [minifyCss()],
			jsLibIndex: [ngmin(), uglify()],
			appJs: [ngmin(), uglify().on('error', gulpUtil.log)]
		}))
		.pipe(gulp.dest('target/frontend-app/'));
});

gulp.task('cdnify', ['usemin'], function () {
	return cdned(CDN);
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
	return gulp.src(['**/*.js', '**/*.css', '**/index.jsp', '!**/structureEditor.jsp', '', '!bower_components', '!components'], {cwd: 'target/frontend-app/'})
		.pipe(jsFilter)
		.pipe(rev())
		.pipe(jsFilter.restore())
		.pipe(cssFilter)
		.pipe(rev())
		.pipe(cssFilter.restore())
		.pipe(revReplace({replaceInExtensions: ['.html', '.jsp']}))
		.pipe(cdnizer({
			defaultCDNBase: cdn,
			relativeRoot: '/',
			files: [
				'**/*.js',
				'**/external.css',
				'**/all.css'
			]
		}))
		.pipe(gulp.dest('target/frontend-app/'));
};

