<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="ui container">

	<div class="ui divided items">
		<div class="item">
			<div class="middle aligned content">
				<div class="header"><i class="wait icon"></i>开始时间</div>
				<div class="description">
					<p>16：00</p>
				</div>
				<div class="extra">
					<button class="ui right floated primary tiny basic button edit-btn strategy-time-from-btn">
						修改
						<i class="edit icon"></i>
					</button>
				</div>
			</div>
		</div>
		<div class="item">
			<div class="middle aligned content">
				<div class="header"><i class="wait icon"></i>结束时间</div>
				<div class="description">
					<p>16：30</p>
				</div>
				<div class="extra">
					<button class="ui right floated primary tiny basic button edit-btn strategy-time-to-btn">
						修改
						<i class="edit icon"></i>
					</button>
				</div>
			</div>
		</div>
		<div class="item">
			<div class="middle aligned content">
				<div class="header"><i class="repeat icon"></i> 重复</div>
				<div class="description">
					<p>周一， 周二</p>
				</div>
				<div class="extra">
					<button class="ui right floated primary tiny basic button edit-btn strategy-repeat-btn">
						修改
						<i class="edit icon"></i>
					</button>
				</div>
			</div>
		</div>
		<div class="item">
			<div class="middle aligned content">
				<div class="header"><i class="id badge icon"></i> 策略名字</div>
				<div class="description">
					<p>策略1</p>
				</div>
				<div class="extra">
					<button class="ui right floated primary tiny basic button edit-btn strategy-name-btn">
						修改
						<i class="edit icon"></i>
					</button>
				</div>
			</div>
		</div>
		<div class="item">
			<div class="middle aligned content">
				<div class="header"><i class="id card icon"></i> 策略描述</div>
				<div class="description">
					<p>中午十二点打开左侧遮阳板1小时</p>
				</div>
				<div class="extra">
					<button class="ui right floated primary tiny basic button edit-btn strategy-desc-btn">
						修改
						<i class="edit icon"></i>
					</button>
				</div>
			</div>
		</div>
		<div class="item">
			<div class="ui two bottom attached buttons">
				 <button class="ui button"><i class="trash outline icon"></i>删除策略</button>
				<button class="ui positive button"><i class="add square icon"></i>保存策略</button>
			</div>

		</div>
	</div>

</div>

<div class="ui modal strategy-name-modal">
	<i class="close icon"></i>
	<div class="header">
		输入策略名称
	</div>
	<div class="ui content input">
		<input type="text" placeholder="策略名--改成anglar">
	</div>
	<div class="actions">
		<div class="ui button">Cancel</div>
		<div class="ui positive button">OK</div>
	</div>
</div>

<div class="ui modal strategy-desc-modal">
	<i class="close icon"></i>
	<div class="header">
		输入策略描述
	</div>
	<div class="content">
		<div class="ui form">
			<div class="field">
				<textarea rows="2"></textarea>
			</div>
		</div>
	</div>
	<div class="actions">
		<div class="ui button">Cancel</div>
		<div class="ui positive button">OK</div>
	</div>
</div>


<div class="ui modal strategy-repeat-modal">
	<i class="close icon"></i>
	<div class="header">
		重复
	</div>
	<div class="content">
		<div class="ui form">
			<div class="ui relaxed divided list">
				<div class="item">
					<div class="ui content checkbox">
						<label>周一</label>
						<input type="checkbox" tabindex="0" class="hidden">
					</div>
				</div>
				<div class="item">
					<div class="ui content checkbox">
						<label>周二</label>
						<input type="checkbox" tabindex="0" class="hidden">
					</div>
				</div>
				<div class="item">
					<div class="ui content checkbox">
						<label>周三</label>
						<input type="checkbox" tabindex="0" class="hidden">
					</div>
				</div>
				<div class="item">
					<div class="ui content checkbox">
						<label>周四</label>
						<input type="checkbox" tabindex="0" class="hidden">
					</div>
				</div>
				<div class="item">
					<div class="ui content checkbox">
						<label>周五</label>
						<input type="checkbox" tabindex="0" class="hidden">
					</div>
				</div>
				<div class="item">
					<div class="ui content checkbox">
						<label>周六</label>
						<input type="checkbox" tabindex="0" class="hidden">
					</div>
				</div>
				<div class="item">
					<div class="ui content checkbox">
						<label>周日</label>
						<input type="checkbox" tabindex="0" class="hidden">
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="actions">
		<div class="ui button">Cancel</div>
		<div class="ui positive button">OK</div>
	</div>
</div>

<!--delete start-->
<div class="ui modal strategy-time-from-modal">
	<i class="close icon"></i>
	<div class="header">
		开始时间(24小时格式)
	</div>
	<div class="content">
		<div class="ui form">
				<div class="ui labeled input">
					<div class="ui label">
						时
					</div>
					<input type="text" size="1" placeholder="Amount">
				</div>
				<label>:</label>
				<div class="ui labeled input" style="margin-left: 3em">
					<div class="ui label">
						分
					</div>
					<input type="text" size="1" placeholder="Amount">
				</div>
		</div>

	</div>
	<div class="actions">
		<div class="ui button">Cancel</div>
		<div class="ui positive button">OK</div>
	</div>
</div>


<div class="ui modal strategy-time-to-modal">
	<i class="close icon"></i>
	<div class="header">
		结束时间(24小时格式)
	</div>
	<div class="content">
		<div class="ui form">
			<div class="ui labeled input">
				<div class="ui label">
					时
				</div>
				<input type="text" size="1" placeholder="Amount">
			</div>
			<label>:</label>
			<div class="ui labeled input" style="margin-left: 3em">
				<div class="ui label">
					分
				</div>
				<input type="text" size="1" placeholder="Amount">
			</div>
		</div>

	</div>
	<div class="actions">
		<div class="ui button">Cancel</div>
		<div class="ui positive button">OK</div>
	</div>
</div>
<!--delete end-->
