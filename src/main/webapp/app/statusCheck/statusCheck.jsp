<%@page contentType="text/html" pageEncoding="UTF-8" %>


<div class="ui container " >
	<div class="ui middle aligned center aligned grid">
		<div class="column">
			<circle-progress class="ui aligned center " last-value="value"></circle-progress>
		</div>
	</div>
	<div class="ui middle aligned center aligned grid">
		<div class="column">
			<button class="ui basic button" ng-click="stop()"><h4 class="ui blue header">一键检测</h4> </button>
		</div>
	</div>
	<div class="ui middle grid">
		<div class="ui unstackable divided items column">

			<div class="item">
				<div class="content">
					<div class="meta">
						<span class="ui header">大棚状态</span><br>
						<small>2个大棚有故障开关</small>
					</div>
				</div>
				<div class="">
					<i class="chevron right icon"></i>
				</div>
			</div>
			<div class="item">
				<div class="content">
					<div class="meta">
						<span class="ui header">开关状态</span><br>
						<small>公有3个开关出现故障</small>
					</div>
				</div>
				<div class="">
					<i class="chevron right icon"></i>
				</div>
			</div>
		</div>
	</div>
</div>
