/**
 * Created by zhouwanli on 26/08/2017.
 */
'use strict';
angular.module('FSwitchControl').controller('FSwitchControl.ctrl', function ($scope) {
	$('#context2 .menu .item')
		.tab({
			context: 'parent'
		})
	;
});
