<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
	.ui.label {
		margin-top: 0.5em;
	}

	.switchControl{
		margin-top: 10px;
		height: 80% ;
	}
	.ui.segment{
		box-shadow: none;
		border: none;
	}
	.dapeng-item .img-content, .ui.segments .segment .img-content, .ui.segment .img-content{
		font-size: 45px;
	}

</style>
<div class="ui fluid container switchControl">
	<div class="ui three cards">
		<div class="card" ng-repeat="item in items">
			<div class="image">
				<img ng-src="{{item.image}}">
			</div>
			<div class="extra">
				<a href="#/shedDetail">{{item.name}}</a></div>
		</div>

</div>
</div>
