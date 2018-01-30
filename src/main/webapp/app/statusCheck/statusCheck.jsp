<%@page contentType="text/html" pageEncoding="UTF-8" %>
<style>
	.statusCheck-container{
		margin-top: 50px;
	}
	.check-btn .ui.blue.header{
		color: #40b77d !important;
	}
</style>

<div class="statusCheck-container" >
	<div class="ui aligned center"><span>{{userid}}</span></div>
	<div class="ui middle aligned center aligned grid">
		<div class="column">
			<div class="ui aligned center c100 big  p{{value}}">
				<span ng-show="firstLoadPage" style="">--</span>
				<span ng-hide="firstLoadPage">{{display}}</span>
				<div class="slice">
					<div class="bar"></div>
					<div class="fill"></div>
				</div>
			</div>

			<%--<circle-progress class="ui aligned center " last-value="value"></circle-progress>--%>
		</div>
	</div>

	<div class="ui middle aligned center aligned grid">
		<div class="column">
			<button class="ui basic button check-btn" ng-click="statusCheck()"><h4 class="ui blue header">一键检测</h4> </button>
		</div>
	</div>
	<div ng-show="firstLoadPage" class="ui middle aligned center aligned grid" style="">如果想获取您管理的设备的健康状态，请点击"一键检测"按钮完成检测。</div>
	<div ng-show="error" class="ui middle aligned center aligned grid" style="">网络错误，请检查手机网络，或者重试。</div>
	<div class="ui middle grid" ng-hide="firstLoadPage || hideErrorDetail">
		<div class="ui unstackable divided items column">

			<div class="item">
				<div class="content">
					<div class="meta">
						<span class="ui header">检测详情</span><br>
						<small>故障大棚个数：{{errorDetail.length}}个</small>&nbsp;&nbsp;|&nbsp;&nbsp;<small>故障开关总个数：{{errorSwitchCount}}个</small>
					</div>
				</div>
				<div class=""  >
					<a href="javascript:void(0);" ng-click="toggleDetailBtn()">详情<i class="chevron right icon" ng-hide="toggleDetail"></i><i class="chevron down icon" ng-show="toggleDetail"></i></a>
				</div>
			</div>
			<div class="ui list" ng-show="toggleDetail">
				<div class="item">
					<i class="codepen icon suimei-color" style="font-size: 18px;"></i>
					<div class="content" ng-repeat="shed in errorDetail">
						<div class="header">大棚名字：{{shed.name}} &nbsp;&nbsp;<small>大棚编号：{{shed.id}}</small></div>
						有{{shed.switchDetails.length}}个开关故障
						<div class="list">
							<div class="item" ng-repeat="switchItem in shed.switchDetails">
								<i class="plug icon suimei-color"></i>
								<div class="content">
									<span  >开关名字：{{switchItem.name}}&nbsp;&nbsp;<small>开关编号{{switchItem.id}}</small></span><br>
									<small>{{switchItem.errorInfo}}</small>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

	</div>
</div>
