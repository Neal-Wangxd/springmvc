<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User Register</title>
<script type="text/javascript">
	function register(){
		var form = document.forms[0];
		form.action="/springmvc-review-validator/validator/doRegister";
		form.method="post";
		form.submit();
	}
</script>
<style type="text/css">
	small {
		color: red;
	}
</style>
</head>
<body>
		<form action="">
			<table>
				<tr>
					<td>
						<span>昵称：</span>
					</td>
					<td>
						<input type="text" name="username" value="${userInfo.username}"  placeholder="输入至少6位字符"><small>${errorMsgList.usernameMsg}</small>
					</td>
				</tr>
				<tr>
					<td>
						<span>密码：</span>
					</td>
					<td>
						<input type="password" name="password" value="${userInfo.password}" placeholder="输入至少8位字符"><small>${errorMsgList.passwordMsg}</small>
					</td>
				</tr>
				<tr>
					<td>
						<span>手机号：</span>
					</td>
					<td>
						<input type="tel" name="phone" value="${userInfo.phone}" placeholder="输入正确手机号"><small>${errorMsgList.phoneMsg}</small>
					</td>
				</tr>
				<tr>
					<td>
						<span>邮箱：</span>
					</td>
					<td>
						<input type="email" name="email" value="${userInfo.email}" placeholder="输入正确的邮箱格式"><small>${errorMsgList.emailMsg}</small>
					</td>
				</tr>
				<tr>
					<td>
						<span>年龄：</span>
					</td>
					<td>
						<input type="number" name="age" value="${userInfo.age}" placeholder="输入正确的年龄"><small>${errorMsgList.ageMsg}</small>
					</td>
				</tr>
				<tr>
					<td><input type="button" value="提交" onclick="register()"></td>
					<td><input type="reset" value="取消"></td>
				</tr>
			</table>
		</form>
</body>
</html>