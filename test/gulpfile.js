const gulp = require('gulp');
const rev = require('gulp-rev');

gulp.task('default', () =>
	gulp.src('test/*.css')
		.pipe(rev())
		.pipe(gulp.dest('test/dist'))
);
