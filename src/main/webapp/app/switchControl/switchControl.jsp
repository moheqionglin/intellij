<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>

	.switch-control{
		margin-top: 10px;
		height: 80% ;
	}
	/*.ui.items > .item > .image:not(.ui){*/
		/*width: 175px;*/
	/*}*/
	.ui.items > .item > .content > .header{
		font-size: 1.1em !important;
		font-weight: 500 !important;
		color: #000;
	}
	.ui.items > .item .meta{
		font-size: 0.9em;
		font-weight: 300;
	}

	.ui.segments .segment, .ui.segment{
		display: flex;
		flex-direction: row;
		justify-content: space-between;

	}
	.strategy-add-icon  {
		cursor: pointer;
		position: absolute;
		top: 2rem;
		right: 0rem;
		margin: 0;
		opacity: 0.5;
		font-size: 20px;
		color: #000000;
	}

</style>
<div class="switch-control">
	<div style="padding: 2em 0em 0em 0em;position: relative;">
		<h4 class="ui header" style="font-size: 1.2em;">大棚/卡管组列表管理</h4>
		<a href="#/switchGroup/new" class="strategy-add-icon" >
			<i class="plus icon" style="font-weight: 300; color: #21ba45; font-size: 1.1em; "></i>
		</a>
	</div>

	<div class="ui divided unstackable items">
		<div class="item" ng-repeat="item in items" ng-click="toDetailPage(item)">
			<div class="image" >
				<img ng-src="{{item.image}}">
			</div>
			<div class="middle aligned content">
				<a class="header" href="#/shedDetail/{{item.type}}/{{item.id}}">{{item.name}}</a>
				<div class="meta">
					<span ng-if = "item.type === 'SHED'">[大棚] </span>
					<span ng-if = "item.type === 'GROUP'">[开关组] </span>
				</div>
			</div>

		</div>
	</div>
</div>
