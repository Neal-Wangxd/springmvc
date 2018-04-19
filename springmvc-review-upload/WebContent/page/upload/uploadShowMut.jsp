<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
request.setAttribute("basePath", basePath);  
%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="icon" type="image/x-icon" href="../img/myico_16.ico"/>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>UPLOAD SHOW</title>
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
		img{
			height:400px;
			width:650px ;
		}
	</style>
</head>
<body>
	<div>
		<c:forEach items="${imagesPathList}" var="image">
		 <img alt="${image.key}" src="${basePath}${image.value}"></br>
		</c:forEach>
	</div>
	
</body>
</html>