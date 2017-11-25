<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
	.shedDetail{
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
</style>
<div class="shedDetail">
	<div class="ui unstackable items">
		<div class="item" ng-repeat="item in items" style="border-radius: 0.9em; background-color: #fff">
			<div class="middle aligned image" >
				<div class="middle aligne  " style="border: solid 1px #f1f1f1; width: 60px; height: 60px; border-radius: 0.5em; margin:7% 25% ">
					<%--<img ng-src="{{item.image}}"  style="width: 50%; margin: auto">--%>
					<a href="javascript:void(0)" ng-click="switch(item)"  ><img src="/app/images/switchControl/active.png"  ng-show="item.active" style="width: 70%; margin: 13% 13%; "></a>
					<a href="javascript:void(0)" ng-click="switch(item)"  >	<img src="/app/images/switchControl/inactive.png"  ng-hide="item.active" style="width: 70%; margin: 13% 13%; "></a>
				</div>
			</div>

			<div class="middle aligned content">
				<span ng-hide="item.edit">{{item.name}}</span>
				<input ng-show="item.edit" class="switch-input" id="switch-{{item.id}}" ng-model="item.name" ng-blur="saveSwitch(item)">
				<div class="meta">
					<span>[大棚{{item.shed}}]&nbsp;{{item.desc}}</span>
				</div>
			</div>
			<div style="margin: auto; width: 35px;" ng-click="editSwitch(item)">
				<i class="write icon" style="color: #666"></i>
			</div>
		</div>
	</div>

</div>
