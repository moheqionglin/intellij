<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
	.strategy{
		margin-top: 10px;
		height: 80% ;
		margin-bottom: 60px !important;
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
<div class="strategy">
	<div class="nav-segment">
		<div class="nav-desc" style="font-size: 1.5em; font-weight: 300">策略管理</div>
		<div class="nav-icon" >
			<a href="#/strategyDetail/new"><i class="plus icon" style="font-weight: 300; color: #40b77d; font-size: 1.5em; "></i></a>
		</div>
	</div>

	<div class="ui unstackable items">
		<div class="item" ng-repeat="item in items" style="border-radius: 0.9em; background-color: #fff">
			<div class="middle aligned image" >
				<div class="middle aligne  " style="border: solid 1px #f1f1f1; width: 60px; height: 60px; border-radius: 0.5em; margin:7% 25% ">
					<%--<img ng-src="{{item.image}}"  style="width: 50%; margin: auto">--%>
					<a href="javascript:void(0)" ng-click="switch(item)"  ><img src="/app/images/strategy/strategy.png"  style="width: 70%; margin: 13% 13%; "></a>
				</div>
			</div>

			<div class="middle aligned content">
				{{item.name}}
				<div class="meta">
					<span>{{item.desc}}&nbsp;&nbsp;|&nbsp;&nbsp;{{item.switchGroup.name}}</span>
				</div>
			</div>
			<div style="margin: auto; width: 35px;" ng-click="editSwitch(item)">
				<div class="extra">
					<div class="ui right floated compact">
						<div class="ui fitted toggle checkbox">
							<input type="checkbox">
							<label></label>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>



