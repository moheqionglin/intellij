<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
	.ui.label {
		margin-top: 0.5em;
	}
</style>
<div class="ui container">
	<div id="context2">
		<div class="ui green three item menu">
			<a class="item select-shed-btn" data-tab="fourth" >选择大棚 <i class="caret down icon"></i></a>
			<a class="item select-switch-btn" data-tab="fifth">选择开关<i class="caret down icon"></i></a>
			<a class="item select-history-btn" data-tab="fifth">操作记录<i class="caret down icon"></i></a>
		</div>
		<div class="ui segments">
			<div class="ui segment">
				<i class="codepen icon"></i>已选大棚
				<div class="ui container">
					<a class="ui small label">
						1号鹏
						<i class="delete icon"></i>
					</a>
					<a class="ui small label">
						2号鹏
						<i class="delete icon"></i>
					</a>
					<a class="ui small label">
						3号鹏
						<i class="delete icon"></i>
					</a>
					<a class="ui small label">
						4号鹏
						<i class="delete icon"></i>
					</a>
				</div>
			</div>
			<div class="ui segment">
				<i class="plug icon"></i>已选开关
				<div class="ui container">
					<a class="ui small label">
						1号鹏
						<i class="delete icon"></i>
					</a>
					<a class="ui small label">
						2号鹏
						<i class="delete icon"></i>
					</a>
					<a class="ui small label">
						3号鹏
						<i class="delete icon"></i>
					</a>
					<a class="ui small label">
						4号鹏
						<i class="delete icon"></i>
					</a>
				</div>
			</div>
		</div>
	</div>

	<div class="ui bottom aligned center aligned grid" style="margin-top: 2em">
		<div class="column">
			<button class="circular ui massive green basic icon button switch-btn" style="font-size:2rem">
				<i class="power icon"></i>
			</button><br><br>
			打开开关
		</div>
	</div>

</div>
<div class="ui modal shed-modal">
	<i class="close icon"></i>
	<div class="header">
		选择大棚
	</div>
	<div class="image content">
		<div class="ui five column padded grid">
			<a class="ui small label column">
				1号鹏
			</a>
			<a class="ui small label column">
				2号鹏
			</a>
			<a class="ui small label column">
				3号鹏
			</a>
			<a class="ui small label column">
				4号鹏
			</a>
			<a class="ui small label column">
				5号鹏
			</a>
			<a class="ui small label column">
				6号鹏
			</a>
		</div>
	</div>
	<div class="actions">
		<button class="ui button">Cancel</button>
		<button class="ui positive button">OK</button>
	</div>
</div>
<div class="ui modal switch-modal">
	<i class="close icon"></i>
	<div class="header">
		选择开关
	</div>
	<div class="image content">
		<div class="ui five column padded grid">
			<a class="ui small label column">
				1号
			</a>
			<a class="ui small label column">
				2号
			</a>
			<a class="ui small label column">
				3号
			</a>
			<a class="ui small label column">
				4号
			</a>
			<a class="ui small label column">
				5号
			</a>
			<a class="ui small label column">
				6号
			</a>
		</div>
	</div>
	<div class="actions">
		<button class="ui button">Cancel</button>
		<button class="ui positive button">OK</button>
	</div>
</div>
<div class="ui basic modal">
	<div class="ui icon header">
		<i class="info icon"></i>
		打开开关
	</div>
	<div class="content">
		<p>您正在打开 大棚：1号大棚 中的 1号开关， 请确认操作？</p>
	</div>
	<div class="actions">
		<div class="ui red basic cancel inverted button">
			<i class="remove icon"></i>
			取消
		</div>
		<div class="ui green ok inverted button">
			<i class="checkmark icon"></i>
			打开
		</div>
	</div>
</div>
