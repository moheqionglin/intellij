<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div>
	<div class="ui two item menu">
		<a class="item shed-btn">选择大棚<i class="dropdown icon"></i></a>
		<a class="active item switch-btn">选择开关<i class="dropdown icon"></i></a>
	</div>

	<div class="ui fluid popup bottom left transition hidden shed-detail"
		 style="top: 555px; left: 1px; bottom: auto; right: auto; width: 652px;">
		<div class="ui relaxed grid">
			<div class="four wide column"  ng-repeat="btn in shedData">
				<button class="ui button">{{btn.name}}</button>
			</div>

		</div>
	</div>




</div>
