<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div>
	<button class="ui right floated primary tiny basic button edit-btn">
		修改
		<i class="edit icon"></i>
	</button>
	<div class="ui modal">
		<i class="close icon"></i>
		<div class="header">
			{{title}}
		</div>
		<div class=" content">
			<div class="ui form">
				<div class="grouped fields">
					<div class="field">
						<div class="ui radio checkbox">
							<input type="radio" name="example2" checked="checked">
							<label>只运行一次</label>
						</div>
					</div>
					<div class="field">
						<div class="ui radio checkbox">
							<input type="radio" name="example2">
							<label>每天</label>
						</div>
					</div>
					<div class="field">
						<div class="ui radio checkbox">
							<input type="radio" name="example2">
							<label>间隔一天</label>
						</div>
					</div>
					<div class="field">
						<div class="ui radio checkbox">
							<input type="radio" name="example2">
							<label>自定义</label>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="actions">
			<div class="ui black deny button">
				取消
			</div>
			<div class="ui positive right labeled icon button">
				确认
				<i class="checkmark icon"></i>
			</div>
		</div>
	</div>
</div>
