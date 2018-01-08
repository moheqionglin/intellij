<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="login-page" style="margin-top: 50px">
	<script type="text/javascript">
		//在此拿到jsAPI权限验证配置所需要的信息
		var _config = <%= com.dingding.AuthHelper.getConfig(request) %>;
	</script>
	<h3>正在免登陆钉钉..., 获取设备列表...</h3>
	<h1 ng-show="error">获取用户信息失败，请刷新或者重新进入应用重试。</h1>
</div>
