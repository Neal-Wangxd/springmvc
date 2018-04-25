<%@ page language="java" contentType="text/html; charset=UTF-8" isErrorPage="true"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="icon" type="image/x-icon" href="../img/myico_16.ico"/>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>400</title>
	<style type="text/css">
		div{
			position: absolute;
			left: 50%;
			top: 50%;
			width:650px;
			height: 400px;
			margin-left:-325px;
			margin-top:-200px;
		}
	</style>
</head>
<body>
	<div>
		<img alt="400" src="<%=basePath%>/img/400.jpg">
	</div>
</body>
</html>