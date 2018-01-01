<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
	.switchGroup{
		margin-top: 10px;
		height: 80% ;
	}

	.ui.menu .item{
		position: static;
	}
</style>
<div class="switchGroup">
	<div class="ui container">
		<div class="introduction">

			<h1 class="ui header" style="font-size: 18px;">
				按钮组管理
				<div class="sub header">
					按钮组可以更加方便地管理一组功能相近的按钮。
				</div>
			</h1>

			<button class="ui right floated  green button" >保存</button>
			<button class="ui floating grey basic button" ng-click="returnSwitchControl()">取消</button>

		</div>

	</div>
	<div class="ui items">
		<div class="item" style="border-radius: 0.9em; background-color: #fff; padding: 1em">
			<div class="middle aligned content"  >
				<div class="ui labeled input">
					<div class="ui label">
						组名字
					</div>
					<input type="text" value="" style="border: none;">
				</div>
			</div>
		</div>
		<span>已选中的0个设备</span>
		<div class="item" style="border-radius: 0.9em; background-color: #fff; padding: 1em">
			<div class="middle aligned content">
				<div class="ui styled fluid accordion">
					<div ng-repeat="shed in sheds">
						<div class="title" ><i class="dropdown icon"></i>
							{{shed.name}}
						</div>
						<div class="content test">
							<%--<p class="transition hidden" ng-repeat="switch in shed.switch">--%>
							<div class="ui checkbox" ng-repeat="switch in shed.switch" ng-click="selectSwitch(switch)">
								<input type="checkbox" ng-checked="switch.selected">
								<label>{{switch.name}}</label>
							</div>
						</div>
					</div>

				</div>
			</div>
		</div>
	</div>

</div>
