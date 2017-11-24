<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>

	.switchControl{
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
<div class="ui fluid container switchControl">
	<div class="ui three cards">
		<div class="card" ng-repeat="item in items">
			<div class="image" ng-click="toDetailPage()" style="">
				<img ng-src="{{item.image}}">
			</div>
			<div class="center aligned  extra">
				<a href="#/shedDetail">{{item.name}}</a></div>
		</div>
	</div>

</div>
