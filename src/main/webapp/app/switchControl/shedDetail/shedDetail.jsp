<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
	.shedDetail{
		margin-top: 10px;
		height: 80% ;
	}
	.ui.cards > .card, .ui.card{
		box-shadow: none;
	}
	.ui.cards > .card > .extra, .ui.card > .extra{
		padding: 0;
	}
	.ui.four.cards > .card{
		margin-left: 0.15em;
		margin-right: 0.15em;
    }
    .ui.cards > .card{
        margin: 0.475em 0.2em;
    }
	.ui.cards > .card > .image, .ui.card > .image{
		padding: 0.4em 0;
	}

</style>
<div class="ui fluid container shedDetail">
	<div class="ui four cards">
		<div class="card" ng-repeat="item in items">
			<div class="center aligned image" >
				<%--<img ng-src="{{item.image}}"  style="width: 50%; margin: auto">--%>
				<a href="javascript:void(0)" ng-click="switch(item)" style="font-size: 9px"><img src="/app/images/switchControl/active.png"  ng-show="item.active" style="width: 50%; margin: auto"></a>
				<a href="javascript:void(0)" ng-click="switch(item)" style="font-size: 9px">	<img src="/app/images/switchControl/inactive.png"  ng-hide="item.active" style="width: 50%; margin: auto"></a>
			</div>
			<div class="center aligned  extra">
				<a href="javascript:void(0)" ng-click="switch(item)" style="font-size: 9px">{{item.name}}</a></div>
		</div>
	</div>

</div>
