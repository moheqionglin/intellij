/**
 * Created by zhouwanli on 26/08/2017.
 */
'use strict';
angular.module('FStrategy').controller('FStrategy.detailCtrl', function ($scope) {
	$('.strategy-name-modal').modal('attach events', '.strategy-name-btn', 'show');
	$('.strategy-desc-modal').modal('attach events', '.strategy-desc-btn', 'show');
	$('.strategy-repeat-modal').modal('attach events', '.strategy-repeat-btn', 'show');
	$('.strategy-switch-group-modal').modal('attach events', '.strategy-switch-group-btn', 'show')
	$('.ui.checkbox').checkbox();
	// $('.strategy-time-from-modal').modal('attach events', '.strategy-time-from-btn', 'show');
	// $('.strategy-time-to-modal').modal('attach events', '.strategy-time-to-btn', 'show');
	var fromCalendar = new datePicker();
	fromCalendar.init({
		'trigger': '.strategy-time-from-btn', /*按钮选择器，用于触发弹出插件*/
		'type': 'time',/*模式：date日期；datetime日期时间；time时间；ym年月；*/
		'minDate':'1900-1-1',/*最小日期*/
		'maxDate':'2100-12-31',/*最大日期*/
		'onSubmit':function(){/*确认时触发事件*/
			var theSelectData=fromCalendar.value;
			alert(theSelectData)
		},
		'onClose':function(){/*取消时触发事件*/
		}
	});
	var toCalendar = new datePicker();
	toCalendar.init({
		'trigger': '.strategy-time-to-btn', /*按钮选择器，用于触发弹出插件*/
		'type': 'time',/*模式：date日期；datetime日期时间；time时间；ym年月；*/
		'minDate':'1900-1-1',/*最小日期*/
		'maxDate':'2100-12-31',/*最大日期*/
		'onSubmit':function(){/*确认时触发事件*/
			var theSelectData=toCalendar.value;
			alert(theSelectData)
		},
		'onClose':function(){/*取消时触发事件*/}
	});


	$scope.switchGroups = [];
	for(var i = 1; i< 20; i ++){
		$scope.switchGroups.push({
			id: 1,
				name: '开关组' + i,
			selected: false
		});
	}

	$scope.selectSwitchGroup = function (switchGroup) {
		switchGroup.selected = !switchGroup.selected;
	}
});
