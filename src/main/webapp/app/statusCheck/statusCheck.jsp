<%@page contentType="text/html" pageEncoding="UTF-8" %>
<style>
	.statusCheck-container{
		margin-top: 50px;
	}
	.check-btn .ui.blue.header{
		color: #40b77d !important;
	}
</style>

<div class="ui container statusCheck-container" >
	<div class="ui middle aligned center aligned grid">
		<div class="column">
			<circle-progress class="ui aligned center " last-value="value"></circle-progress>
		</div>
	</div>
	<div class="ui middle aligned center aligned grid">
		<div class="column">
			<button class="ui basic button check-btn" ng-click="stop()"><h4 class="ui blue header">一键检测</h4> </button>
		</div>
	</div>
	<div class="ui middle grid">
		<div class="ui unstackable divided items column">

			<div class="item">
				<div class="content">
					<div class="meta">
						<span class="ui header">检测详情</span><br>
						<small>故障大棚个数：1个</small>&nbsp;&nbsp;|&nbsp;&nbsp;<small>故障开关总个数：4个</small>
					</div>
				</div>
				<div class=""  >
					<a href="javascript:void(0);" ng-click="toggleDetailBtn()">详情<i class="chevron right icon" ng-hide="toggleDetail"></i><i class="chevron down icon" ng-show="toggleDetail"></i></a>
				</div>
			</div>
			<div class="ui list" ng-show="toggleDetail">
				<div class="item">
					<i class="codepen icon suimei-color" style="font-size: 18px;"></i>
					<div class="content">
						<div class="header">大棚1</div>
						有3个开关故障
						<div class="list">
							<div class="item">
								<i class="plug icon suimei-color"></i>
								<div class="content">
									<span  >开关3</span><br>
									<small>开关连接不上</small>
								</div>
							</div>
							<div class="item">
								<i class="plug icon suimei-color"></i>
								<div class="content">
									<span  >开关35</span><br>
									<small>开关连接不上</small>
								</div>
							</div>
							<div class="item">
								<i class="plug icon suimei-color"></i>
								<div class="content">
									<span  >开关33</span><br>
									<small>开关连接不上</small>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

	</div>
</div>
