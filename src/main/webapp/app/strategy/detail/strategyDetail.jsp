<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="ui divided items">
	<div class="item">
		<div class="middle aligned content">
			<div class="header">开始时间</div>
			<div class="description">
				<p>12:00 AM</p>
			</div>
			<div class="extra">
				<strategy-modal-directive title="开始时间"></strategy-modal-directive>
				<%--<div class="ui right floated primary tiny basic button">--%>
					<%--修改--%>
					<%--<i class="edit icon"></i>--%>
				<%--</div>--%>
			</div>
		</div>
	</div>
	<div class="item">
		<div class="middle aligned content">
			<div class="header">持续时长</div>
			<div class="description">
				<p>1小时</p>
			</div>
			<div class="extra">
				<strategy-modal-directive title="持续时长"></strategy-modal-directive>
			</div>
		</div>
	</div>
	<div class="item">
		<div class="middle aligned content">
			<div class="header">重复</div>
			<div class="description">
				<p>每天</p>
			</div>
			<div class="extra">
				<strategy-modal-directive title="重复"></strategy-modal-directive>
			</div>
		</div>
	</div>
	<div class="item">
		<div class="middle aligned content">
			<div class="header">策略名字</div>
			<div class="description">
				<p>策略1</p>
			</div>
			<div class="extra">
				<strategy-modal-directive title="策略名字"></strategy-modal-directive>
			</div>
		</div>
	</div>
	<div class="item">
		<div class="middle aligned content">
			<div class="header">策略描述</div>
			<div class="description">
				<p>中午十二点打开左侧遮阳板1小时</p>
			</div>
			<div class="extra">
				<strategy-modal-directive title="策略描述"></strategy-modal-directive>
			</div>
		</div>
	</div>
	<div class="item">
		<button class="ui fluid active negative basic button" style="margin-bottom: 45px;">
			<i class="trash outline icon"></i>
			删除策略
		</button>
	</div>
</div>


<div class="ui modal">
	<i class="close icon"></i>
	<div class="header">
		Modal Title
	</div>
	<div class="image content">
		<div class="image">
			An image can appear on left or an icon
		</div>
		<div class="description">
			A description can appear on the right
		</div>
	</div>
	<div class="actions">
		<div class="ui button">Cancel</div>
		<div class="ui button">OK</div>
	</div>
</div>

