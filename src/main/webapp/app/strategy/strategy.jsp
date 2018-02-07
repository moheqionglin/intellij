<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
	.strategy{
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
<div class="strategy">
	<div style="padding: 2em 0em 0em 0em;position: relative;">
		<h4 class="ui header" style="font-size: 1.2em;">策略管理</h4>
		<a href="#/strategyDetail/new" class="strategy-add-icon">
			<i class="plus icon" style="font-weight: 300; color: #21ba45; font-size: 1.1em; "></i>
		</a>
	</div>

	<div class="ui unstackable items">
		<div class="item" ng-repeat="item in items" style="border-radius: 0.9em; background-color: #fff">
			<div class="middle aligned image"  style="padding: 5px 25px">
				<div class="middle aligne  " style="border: solid 1px #f1f1f1; width: 60px; height: 60px; border-radius: 0.5em;  ">
					<a href="#/strategyDetail/{{item.id}}" ><img src="/app/images/strategy/strategy.png"  style="width: 70%; margin: 13% 13%; "></a>
				</div>
			</div>

			<div class="middle aligned content">
				<a href="#/strategyDetail/{{item.id}}" >{{item.name}}</a>
					<div class="ui fitted toggle checkbox" style="float:right;" ng-click="editSwitch(item)">
						<input type="checkbox" ng-checked="item.enable" ng-model="item.enable">
						<label></label>
					</div>
				<div class="meta">
					<span>{{item.desc}}&nbsp;&nbsp;</span>
				</div>
			</div>
		</div>
	</div>
</div>



