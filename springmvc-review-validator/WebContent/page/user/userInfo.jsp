<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>USER INFO</title>
</head>
<body>
	<h2> Hello ${userInfo.username}</h2>
	<h4>用户名 ：${userInfo.username}</h4>
	<h4>手机号 ：${userInfo.phone}</h4>
	<h4>密码：${userInfo.password}</h4>
	<h4>邮箱：${userInfo.email}</h4>
	<h4>年龄：${userInfo.age}</h4>
</body>
</html>