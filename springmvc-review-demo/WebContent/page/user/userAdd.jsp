<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ADD USER</title>
	<script type="text/javascript">
		function addUser(){
			var form = document.forms[0];
			form.action="/springmvc-review-demo/user/addUserPar";
			form.method="post";
			form.submit();
		}
	</script>
</head>
<body>
	<h>添加用户</h>
	<form name="userForm" action="">
		姓名：<input type="text" name="name">
		年龄：<input type="text" name="age">
		薪资：<input type="text" name="salary">
		电话：<input type="text" name="phone">
		身高：<input type="text" name="height">
		<input type="button" value="添加" onclick="addUser()">
	</form>
</body>
</html>