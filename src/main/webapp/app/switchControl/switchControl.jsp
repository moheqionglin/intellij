<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>

	.switch-control{
		margin-top: 10px;
		height: 80% ;
		margin-bottom: 60px !important;
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
	.nav-segment{
		display: flex;
		flex-direction: row;
		justify-content: space-between;
	}

	.ui.segments .segment, .ui.segment{
		display: flex;
		flex-direction: row;
		justify-content: space-between;

	}
	.nav-desc{

	}

</style>
<div class="switch-control">
	<%--<div class="ui clearing segment">--%>
	<div class="nav-segment">
		<div class="nav-desc" style="font-size: 1.5em; font-weight: 300">大棚/卡管组列表管理</div>
		<div class="nav-icon" >
			<a href="#/switchGroup/new"><i class="plus icon" style="font-weight: 300; color: #40b77d; font-size: 1.5em; "></i></a>
		</div>
	</div>

	<div class="ui divided unstackable items">
		<div class="item" ng-repeat="item in items" ng-click="toDetailPage(item)">
			<div class="image" >
				<img ng-src="{{item.image}}">
			</div>
			<div class="middle aligned content">
				<a class="header" href="#/shedDetail/{{item.type}}/{{item.id}}">{{item.name}}</a>
				<div class="meta">
					<span>[{{item.typeDesc}}]&nbsp;{{item.desc}}</span>
				</div>
				<%--<div class="description">--%>
					<%--<p></p>--%>
				<%--</div>--%>
				<%--<div class="extra">--%>
					<%--Additional Details--%>
				<%--</div>--%>
			</div>
			<div style="margin: auto; width: 35px;" ng-if="item.type === 'GROUP'">
				<a href="#/switchGroup/{{item.id}}"><i class="write icon" style="color: #666"></i></a>
			</div>
		</div>
	</div>
</div>
