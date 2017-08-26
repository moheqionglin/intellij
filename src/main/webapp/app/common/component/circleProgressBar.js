/**
 * Created by zhouwanli on 26/08/2017.
 */
'use strict';
angular.module('FCommon').directive('circleProgressBar', function () {
	return {
		templateUrl: 'app/common/component/circleProgressBar',
		restrict: 'E',
		replace : true,
		scope: {

		},
		controller: function () {

		},
		compile: function (tElem) {
			var pele = tElem.find('#progress');
			var circle = new ProgressBar.Circle('#progress', {
				strokeWidth: 4,
				color: '#FCB03C',
				duration: 3000,
				easing: 'easeInOut',
				svgStyle: {
					//display: 'block',
					width: '70%'
				},
				text: {
					// Initial value for text.
					// Default: null
					value: '50%',

					// Class name for text element.
					// Default: 'progressbar-text'
					className: 'progressbar__label',

					// Inline CSS styles for the text element.
					// If you want to modify all CSS your self, set null to disable
					// all default styles.
					// If the style option contains values, container is automatically
					// set to position: relative. You can disable behavior this with
					// autoStyleContainer: false
					// If you specify anything in this object, none of the default styles
					// apply
					// Default: object speficied below
					style: {
						// Text color.
						// Default: same as stroke color (options.color)
						color: '#f00',
						position: 'absolute',
						left: '50%',
						top: '50%',
						padding: 0,
						margin: 0,
						// You can specify styles which will be browser prefixed
						transform: {
							prefix: true,
							value: 'translate(-50%, -50%)'
						}
					},
					// Only effective if the text.style is not null
					// By default position: relative is applied to container if text
					// is set. Setting this to false disables that feature.
					autoStyleContainer: true,

					// Only effective if the shape is SemiCircle.
					// If true, baseline for text is aligned with bottom of
					// the SVG canvas. If false, bottom line of SVG canvas
					// is in the center of text.
					// Default: true
					alignToBottom: true
				}
			});
			circle.animate(1);
		}
	};
})
