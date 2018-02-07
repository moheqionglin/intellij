<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
	.strategyDetail{
		margin-top: 10px;
		height: 80% ;
	}
	.ui.items > .item > .content > .header{
		font-size: 1.1em !important;
		font-weight: 500 !important;
		color: #000;
	}
	.ui.items > .item .meta{
		font-size: 0.9em;
		font-weight: 300;
	}
	.nav-segment{
		display: flex;
		flex-direction: row;
		justify-content: space-between;
	}

</style>
<div class="strategyDetail">
	<div class="ui container">
		<div class="introduction">

			<h1 class="ui header" style="font-size: 18px;">
				策略管理
				<div class="sub header">
					自定义策略可以更方便的管理您的设备。
				</div>
			</h1>

			<button class="ui right floated  green button" ng-click="save()" ng-disabled="!enableSave()">保存</button>
			<button class="ui floating grey basic button" ng-click="returnStrategyListPage()">取消</button>
			<div class="ui red message" ng-show="error">操作失败！请检查您是否输入内容合法，或者忘记填写某个字段。</div>
			<div class="ui green message" ng-show="success">操作成功。</div>

		</div>

	</div>
	<div class="ui divided items">
		<div class="item">
			<div class="middle aligned content">
				<div class="header"><i class="id badge icon"></i> 策略名字*</div>
				<div class="description">
					<p>{{strategyDetail.name}}</p>
				</div>
				<div class="extra">
					<button class="ui right floated primary tiny basic button edit-btn strategy-name-btn">
						修改
						<i class="edit icon"></i>
					</button>
				</div>
			</div>
		</div>
		<div class="item">
			<div class="middle aligned content">
				<div class="header"><i class="id card icon"></i> 策略描述*</div>
				<div class="description">
					<p>{{strategyDetail.desc}}</p>
				</div>
				<div class="extra">
					<button class="ui right floated primary tiny basic button edit-btn strategy-desc-btn">
						修改
						<i class="edit icon"></i>
					</button>
				</div>
			</div>
		</div>
		<div class="item">
			<div class="middle aligned content">
				<div class="header"><i class="grid layout icon"></i>选择开关组*</div>
				<div class="description">
					<p ng-repeat="sg in strategyDetail.switchGroups">{{sg.name}}</p>
				</div>
				<div class="extra">
					<button class="ui right floated primary tiny basic button edit-btn strategy-switch-group-btn">
						修改
						<i class="edit icon"></i>
					</button>
				</div>
			</div>
		</div>
		<div class="item">
			<div class="middle aligned content">
				<div class="header"><i class="wait icon"></i>开始时间*</div>
				<div class="description">
					<p>{{strategyDetail.strategyStartAt}}</p>
				</div>
				<div class="extra">
					<button class="ui right floated primary tiny basic button edit-btn strategy-time-from-btn">
						修改
						<i class="edit icon"></i>
					</button>
				</div>
			</div>
		</div>
		<div class="item">
			<div class="middle aligned content">
				<div class="header"><i class="wait icon"></i>持续时长(只能填写整数)*</div>
				<div class="description">
					<p>{{strategyDetail.continueMin}}分钟</p>
				</div>
				<div class="extra">
					<button class="ui right floated primary tiny basic button edit-btn strategy-continue-to-btn">
						修改
						<i class="edit icon"></i>
					</button>
				</div>
			</div>
		</div>
		<%--<div class="item">--%>
			<%--<div class="middle aligned content">--%>
				<%--<div class="header"><i class="repeat icon"></i> 重复(重复间隔0表示，只运行一次)*</div>--%>
				<%--<div class="description">--%>
					<%--<p ng-if="strategyDetail.repeatGapMin !== 0">本次执行结束以后，间隔{{strategyDetail.repeatGapMin}}分钟再次执行</p>--%>
					<%--<p ng-if="strategyDetail.repeatGapMin === 0">只执行一次</p>--%>
				<%--</div>--%>
				<%--<div class="extra">--%>
					<%--<button class="ui right floated primary tiny basic button edit-btn strategy-repeat-btn">--%>
						<%--修改--%>
						<%--<i class="edit icon"></i>--%>
					<%--</button>--%>
				<%--</div>--%>
			<%--</div>--%>
		<%--</div>--%>

	</div>

</div>

<div class="ui modal strategy-switch-group-modal">
	<i class="close icon"></i>
	<div class="header">
		请选择开关组
	</div>
	<div class="ui content input">

		<button class="ui green button"
				ng-repeat="switchGroup in allSwitchGroupd"
				ng-class="{'basic': !switchGroup.selected}"
				ng-click="selectSwitchGroup(switchGroup)">{{switchGroup.name}}</button>

	</div>
	<div class="actions">
		<div class="ui cancel button">Cancel</div>
		<div class="ui positive button">OK</div>
	</div>
</div>
<div class="ui modal strategy-name-modal">
	<i class="close icon"></i>
	<div class="header">
		输入策略名称
	</div>
	<div class="ui content input">
		<input type="text" placeholder="策略名" ng-model="strategyDetail.name" style="width: 100%">
	</div>
	<div class="actions">
		<div class="ui cancel button">Cancel</div>
		<div class="ui positive button">OK</div>
	</div>
</div>

<div class="ui modal strategy-desc-modal">
	<i class="close icon"></i>
	<div class="header">
		输入策略描述
	</div>
	<div class="content">
		<div class="ui form">
			<div class="field">
				<textarea rows="2" ng-model="strategyDetail.desc"></textarea>
			</div>
		</div>
	</div>
	<div class="actions">
		<div class="ui cancel button">Cancel</div>
		<div class="ui positive button">OK</div>
	</div>
</div>


<div class="ui modal strategy-continue-to-modal">
	<i class="close icon"></i>
	<div class="header">
		持续时间长度(单位：分钟)
	</div>
	<div class="content">
		<div class="ui form">
			<div class="ui labeled input" style="margin-left: 3em">
				<div class="ui label">
					分
				</div>
				<input type="text" size="1" placeholder="Amount" ng-model="strategyDetail.continueMin">
			</div>
		</div>

	</div>
	<div class="actions">
		<div class="ui cancel button">Cancel</div>
		<div class="ui positive button">OK</div>
	</div>
</div>

<%--<div class="ui modal strategy-repeat-modal">--%>
	<%--<i class="close icon"></i>--%>
	<%--<div class="header">--%>
		<%--重复间隔(重复间隔0表示，只运行一次)--%>
	<%--</div>--%>
	<%--<div class="ui content input">--%>
		<%--<input type="text" placeholder="24" ng-model="strategyDetail.repeatGapMin">--%>
		<%--<label>小时</label>--%>
	<%--</div>--%>
	<%--<div class="actions">--%>
		<%--<div class="ui cancel button">Cancel</div>--%>
		<%--<div class="ui positive button">OK</div>--%>
	<%--</div>--%>
<%--</div>--%>
