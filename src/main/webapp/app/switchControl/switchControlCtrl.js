/**
 * Created by zhouwanli on 26/08/2017.
 */
'use strict';
angular.module('FSwitchControl').controller('FSwitchControl.ctrl', function ($scope, $location) {
	$('#context2 .menu .item')
		.tab({
			context: 'parent'
		})
	;
	$('.ui.modal.shed-modal').modal('attach events', '#context2 .select-shed-btn', 'show')
	$('.ui.modal.switch-modal').modal('attach events', '#context2 .select-switch-btn', 'show')
	$('.ui.basic.modal').modal('attach events', '.switch-btn', 'show')


	$scope.items = [];

	for(var i = 1; i <= 20; i++){
		$scope.items.push({image: 'http://www.semantic-ui.cn/images/avatar/large/elliot.jpg', name: '大棚' + i})
	}


	// var toCalendar = new datePicker();
	// toCalendar.init({
	// 	'trigger': '.select-history-btn', /*按钮选择器，用于触发弹出插件*/
	// 	'type': 'date',/*模式：date日期；datetime日期时间；time时间；ym年月；*/
	// 	'minDate':'1900-1-1',/*最小日期*/
	// 	'maxDate':'2100-12-31',/*最大日期*/
	// 	'onSubmit':function(){/*确认时触发事件*/
	// 		var theSelectData=toCalendar.value;
	// 		// alert(theSelectData);
	// 		$scope.$apply(function() {
	// 			$location.path("/controlHistory");
	// 			console.log($location.path());
	// 		});
	// 	},
	// 	'onClose':function(){/*取消时触发事件*/
	// 		$location.path('/controlHistory');
	// 	}
	// });

});
