/**
 * Created by zhouwanli on 26/08/2017.
 */
'use strict';
angular.module('FSwitchControl').controller('FSwitchControl.switchGroup', function ($scope) {
	$('.strategy-name-modal').modal('attach events', '.switch-group-btn', 'show');
	$('.strategy-repeat-modal').modal('attach events', '.add-switch-btn', 'show')
	$('.ui.checkbox').checkbox();
});
