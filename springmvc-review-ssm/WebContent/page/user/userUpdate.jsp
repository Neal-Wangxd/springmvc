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
<title>USER UPDATE</title>
<script type="text/javascript">
	function userUpdate(){
		var form = document.forms[0];
		form.action="/springmvc-review-ssm/user/updateUser";
		form.method="post";
		form.submit();
	}
</script>
<style type="text/css">
	div{
		position: absolute;
		left: 50%;
		top: 50%;
		width:750px;
		height: 500px;
		margin-left:-325px;
		margin-top:-200px;
	}
	small {
		color: red;
	}
</style>
</head>
<body>
	<div>
		<h4>USER UPDATE</h4>
		<form action="">
			<table>
				<tr>
					<td>
						<span>用户名：</span>
					</td>
					<td>
						<input type="hidden" name="id" value="${userInfo.id}">
						<input type="text" name="username" value="${errorMsgList.usernameMsg != null ? '' : userInfo.username}"  placeholder="输入至少2位字符"><small>${errorMsgList.usernameMsg}</small>
					</td>
				</tr>
				<tr>
					<td>
						<span>手机号：</span>
					</td>
					<td>
						<input type="tel" name="phone" value="${errorMsgList.phoneMsg != null ? '' :userInfo.phone}" placeholder="输入正确手机号"><small>${errorMsgList.phoneMsg}</small>
					</td>
				</tr>
				<tr>
					<td>
						<span>薪&nbsp;资：</span>
					</td>
					<td>
						<input type="number" name="salary" value="${errorMsgList.salarydMsg != null ? '' :userInfo.salary}" placeholder="输入正确的薪资格式"><small>${errorMsgList.salaryMsg}</small>
					</td>
				</tr>
				<tr>
					<td>
						<span>年&nbsp;龄：</span>
					</td>
					<td>
						<input type="number" name="age" value="${errorMsgList.ageMsg != null ? '' :userInfo.age}" placeholder="输入正确的年龄"><small>${errorMsgList.ageMsg}</small>
					</td>
				</tr>
				<tr>
					<td>
						<span>身&nbsp;高：</span>
					</td>
					<td>
						<input type="number" name="hight" value="${errorMsgList.hightMsg != null ? '' :userInfo.hight}" placeholder="输入正确的身高">
						<small>${errorMsgList.hightMsg}</small>
					</td>
				</tr>
				<tr>
					<td>
						<span>出生日期：</span>
					</td>
					<td>
					 	<input type="text" name="birthday" value="<fmt:formatDate value='${userInfo.birthday}' pattern='yyyy-MM-dd  HH:mm:ss'/>" placeholder="输入正确的日期格式"><small>${errorMsgList.birthdayMsg}</small>
					 </td>
				</tr>
				<tr>
					<td><input type="button" value="提交" onclick="userUpdate()"></td>
					<td><input type="reset" value="取消"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>