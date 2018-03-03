/**
 * Created by zhouwanli on 26/08/2017.
 */
'use strict';
angular.module('FSLogin').controller('FSLoginControl.ctrl', function ($scope, $location, $rootScope, $window, $cookies) {
	/**
	 * _config comes from server-side template. see views/index.jade
	 */
	$rootScope.loginPage = true;
	$rootScope.showNav = false;
	$scope.error = false;
	var cookieUserId = $cookies.get('userid');
	if(!!cookieUserId){
		$window.location.href = '/p/#/statusCheck';
		return;
	}

	dd.config({
		agentId: _config.agentid,
		corpId: _config.corpId,
		timeStamp: _config.timeStamp,
		nonceStr: _config.nonceStr,
		signature: _config.signature,
		jsApiList: ['runtime.info', 'biz.contact.choose',
			'device.notification.confirm', 'device.notification.alert',
			'device.notification.prompt', 'biz.ding.post',
			'biz.util.openLink']
	});


	dd.ready(function () {
		dd.runtime.info({
			onSuccess: function (info) {
				// alert('runtime info: ' + JSON.stringify(info))
				logger.e('runtime info: ' + JSON.stringify(info));
			},
			onFail: function (err) {
				// alert('fail: ' + JSON.stringify(err))
				logger.e('fail: ' + JSON.stringify(err));
			}
		});

		dd.runtime.permission.requestAuthCode({
			corpId: _config.corpId,
			onSuccess: function (info) {

				var contextPath = 'http://106.14.133.77:8888/resources/';
				var url = contextPath + 'userinfo?code=' + info.code + '&corpid=' + _config.corpId;
				// $http.get('../resources/userinfo?code=' + info.code + '&corpid=' + _config.corpId )
				// 	.success(function(){
				// 		$scope.error = false;
				// 		var now = new Date(),
				// 			exp = new Date(now.getFullYear()+1, now.getMonth(), now.getDate());
				// 		$cookies.put('userid', data.userid, {
				// 			expires: exp
				// 		});
                //
				// 		$window.location.href = '/p/#/statusCheck';
				// 	}).error(function(){
				// 	$scope.error = true;
				// });
				$.ajax({
					url: url,
					type: 'GET',
					contentType: 'application/json;charset=utf-8',
					dataType: 'json',
					success: function (data, status, xhr) {

						$scope.error = false;
						var now = new Date(),
							exp = new Date(now.getFullYear()+1, now.getMonth(), now.getDate());
						$cookies.put('userid', data.userid, {
							expires: exp
						});

						$window.location.href = '/p/#/statusCheck';
						return;
					},
					error: function (xhr, errorType, error) {
						$scope.error = true;
						// alert(errorType + ', ' + error);
					}
				});


			},
			onFail: function (err) {
				// alert('fail: ' + JSON.stringify(err));
			}
		});
	});

	dd.error(function (err) {
		alert('dd error: ' + JSON.stringify(err));
	});

});

/***************
 *
 */

//******************设置 nav 标题栏
//			dd.biz.navigation.setTitle({
//				title: '钉钉demo',
//				onSuccess: function(data) {
//				},
//				onFail: function(err) {
//					log.e(JSON.stringify(err));
//				}
//			});
//	 alert('dd.ready rocks!');

// ******************设置 右上角的...菜单
//			dd.ui.pullToRefresh.enable({
//				onSuccess: function() {
//				},
//				onFail: function() {
//				}
//			})

//			dd.biz.navigation.setMenu({
//				backgroundColor : "#ADD8E6",
//				items : [
//					{
//						id:"此处可以设置帮助",//字符串
//						// "iconId":"file",//字符串，图标命名
//						text:"帮助"
//					}
//					,
//					{
//						"id":"2",
//						"iconId":"photo",
//						"text":"我们"
//					}
//					,
//					{
//						"id":"3",
//						"iconId":"file",
//						"text":"你们"
//					}
//					,
//					{
//						"id":"4",
//						"iconId":"time",
//						"text":"他们"
//					}
//				],
//				onSuccess: function(data) {
//					alert(JSON.stringify(data));
//
//				},
//				onFail: function(err) {
//					alert(JSON.stringify(err));
//				}
//			});

