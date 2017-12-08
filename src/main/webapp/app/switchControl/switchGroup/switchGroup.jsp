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

			<div class="ui right floated  green button">保存</div>
			<button class="ui floating grey basic button">取消</button>

		</div>

	</div>
	<div class="ui items">
		<div class="item" style="border-radius: 0.9em; background-color: #fff; padding: 1em">
			<div class="middle aligned content"  >
				<div class="ui labeled input">
					<div class="ui label">
						组名字
					</div>
					<input type="text" value="$52.03" style="border: none;">
				</div>
			</div>
		</div>
		<span>已选中的0个设备</span>
		<div class="item" style="border-radius: 0.9em; background-color: #fff; padding: 1em">
			<div class="middle aligned content">
				<div class="ui styled fluid accordion">
					<div class="title" ng-repeat="shed in sheds"><i class="dropdown icon"></i>
						{{shed.name}}
					</div>
					<div class="content" ng-repeat="switch in switchs">
						<p class="transition hidden">
							{{switch.name}}
						</p>
					</div>
				</div>
			</div>
		</div>
	</div>

</div>

<div class="ui modal strategy-name-modal">
	<i class="close icon"></i>
	<div class="header">
		输入策略名称
	</div>
	<div class="ui content input">
		<input type="text" placeholder="策略名--改成anglar">
	</div>
	<div class="actions">
		<div class="ui button">Cancel</div>
		<div class="ui positive button">OK</div>
	</div>
</div>


<div class="ui modal strategy-repeat-modal">
	<i class="close icon"></i>
	<div class="header">
		重复
	</div>
	<div class="content">
		<div class="ui form">
			<div class="ui relaxed divided list">
				<div class="item">
					<div class="ui content checkbox">
						<label>周一</label>
						<input type="checkbox" tabindex="0" class="hidden">
					</div>
				</div>
				<div class="item">
					<div class="ui content checkbox">
						<label>周二</label>
						<input type="checkbox" tabindex="0" class="hidden">
					</div>
				</div>
				<div class="item">
					<div class="ui content checkbox">
						<label>周三</label>
						<input type="checkbox" tabindex="0" class="hidden">
					</div>
				</div>
				<div class="item">
					<div class="ui content checkbox">
						<label>周四</label>
						<input type="checkbox" tabindex="0" class="hidden">
					</div>
				</div>
				<div class="item">
					<div class="ui content checkbox">
						<label>周五</label>
						<input type="checkbox" tabindex="0" class="hidden">
					</div>
				</div>
				<div class="item">
					<div class="ui content checkbox">
						<label>周六</label>
						<input type="checkbox" tabindex="0" class="hidden">
					</div>
				</div>
				<div class="item">
					<div class="ui content checkbox">
						<label>周日</label>
						<input type="checkbox" tabindex="0" class="hidden">
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="actions">
		<div class="ui button">Cancel</div>
		<div class="ui positive button">OK</div>
	</div>
</div>
