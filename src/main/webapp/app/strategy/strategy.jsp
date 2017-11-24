<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
	.statusCheck-container{
		margin-top: 50px;
	}
</style>
<div class="ui divided items">
	<div class="item">
		<div class="middle aligned content">
			<div class="header">
				<a href="#/strategyDetail/1">策略1-名字</a>
			</div>
			<div class="description">
				<p>中午十二点打开左侧遮阳板1小时</p>
			</div>
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
	<div class="item">
		<div class="middle aligned content">
			<div class="header">
				<a href="#/strategyDetail/2">策略1-名字</a>
			</div>
			<div class="description">
				<p>日落前关闭所有</p>
			</div>
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
	<div class="item">
		<div class="middle aligned content">
			<div class="header">
				<a href="#/strategyDetail/3">策略1-名字</a>
			</div>
			<div class="description">
				<p>早上日出的时候</p>
			</div>
			<div class="extra">
				<div class="ui right floated compact">
					<div class="ui fitted toggle checkbox">
						<input type="checkbox" checked>
						<label></label>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="item">
		<div class="middle aligned content">
			<div class="ui right floated compact">
				<button class="ui active labeled green icon button" ng-click="addStrategy()">
					<i class="plus icon"></i>
					新增策略
				</button>
			</div>
		</div>
	</div>
</div>



