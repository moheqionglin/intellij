<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
	.shedDetail{
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
</style>
<div class="shedDetail">
	<div class="ui unstackable items">
		<div class="item" ng-repeat="item in items" style="border-radius: 0.9em; background-color: #fff">
			<div class="middle aligned image" style="padding: 5px 25px">
				<div class="middle aligne  " style="border: solid 1px #f1f1f1; width: 60px; height: 60px; border-radius: 0.5em; ">
					<%--<img ng-src="{{item.image}}"  style="width: 50%; margin: auto">--%>
					<a href="javascript:void(0)" ng-click="switch(item)"  ><img src="/app/images/switchControl/active.png"  ng-show="item.active" style="width: 70%; margin: 13% 13%; "></a>
					<a href="javascript:void(0)" ng-click="switch(item)"  >	<img src="/app/images/switchControl/inactive.png"  ng-hide="item.active" style="width: 70%; margin: 13% 13%; "></a>
				</div>
			</div>

			<div class="middle aligned content">
				<span ng-hide="item.edit">{{item.name}}</span>
				<input ng-show="item.edit" style="width: 90%" class="switch-input" id="switch-{{item.id}}" ng-model="item.name" ng-blur="saveSwitch(item)">
				<i class="write icon" style="color: #666; float:right;" ng-click="editSwitch(item)"></i>
				<div class="meta">
					<span>[大棚{{item.shed}}]&nbsp;{{item.desc}}</span>
				</div>
			</div>

		</div>
	</div>

</div>
