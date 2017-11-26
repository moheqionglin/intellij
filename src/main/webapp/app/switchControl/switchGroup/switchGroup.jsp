<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
	.switchGroup{
		margin-top: 10px;
		height: 80% ;
	}
</style>
<div class="switchGroup">

	<div class="ui divided items">
		<div class="item">
			<div class="middle aligned content">
				<div class="header"><i class="id badge icon"></i>未命名开关组-1</div>
				<div class="description">
					<p>策略1</p>
				</div>
				<div class="extra">
					<button class="ui right floated primary tiny basic button edit-btn switch-group-btn">
						修改
						<i class="edit icon"></i>
					</button>
				</div>
			</div>
		</div>
		<div class="item">
			<div class="middle aligned content">
				<div class="header"><i class="id badge icon"></i>开关列表</div>
				<div class="description">
					<p>请添加开关列表</p>
				</div>
				<div class="extra">
					<button class="ui right floated primary tiny basic button edit-btn add-switch-btn">
						添加
						<i class="plus icon"></i>
					</button>
				</div>
			</div>
		</div>

		<div class="ui middle aligned divided list">
			<div class="item">
				<div class="right floated content">
					<div class="ui button">删除</div>
				</div>
				<i class="id badge icon"></i>
				<div class="content">
					[大棚1] &nbsp;&nbsp;开关1
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
