<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>USER LIST</title>
	<style type="text/css">
		div{
			position: absolute;
			left: 50%;
			top: 50%;
			width:750px;
			height: 500px;
			margin-left:-325px;
			margin-top:-200px;
			overflow: auto;
		}
	</style>
	<script type="text/javascript">
		function toAddUser(){
			window.location.href="<%=basePath%>/user/toAddUser";
		}
		function updateUser(id){
			window.location.href="<%=basePath%>/user/getOne?id=" +id;
		}
		function removeUser(id){
			window.location.href="<%=basePath%>/user/removeUser?id=" +id;
		}
	</script>
</head>
<body>
	<div>
		<h4>USER LIST</h4>
		<button onclick="toAddUser()">添加</button>
		<table border="1">
			<thead>
				<td>序号</td>
				<td>名称</td>
				<td>手机号</td>
				<td>薪资</td>
				<td>年龄</td>
				<td>身高</td>
				<td>出生日期</td>
				<td>操作</td>
			</thead>
			<c:forEach items="${userList}" var="user">
				<tr>
					<td>${user.id}</td>
					<td>${user.username}</td>
					<td>${user.phone}</td>
					<td>${user.salary}</td>
					<td>${user.age}</td>
					<td>${user.hight}</td>
					<td><fmt:formatDate value="${user.birthday}" pattern="yyyy-MM-dd  HH:mm:ss"/></td>
					<td>
						<button onclick="updateUser(${user.id})">修改</button>
						<button onclick="removeUser(${user.id})">删除</button>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>