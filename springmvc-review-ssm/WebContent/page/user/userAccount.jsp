<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>USER ADD</title>
<script type="text/javascript">
	function userAccount(){
		var form = document.forms[0];
		form.action="/springmvc-review-ssm/user/userAccount";
		form.method="post";
		form.submit();
	}
</script>
<style type="text/css">
	small {
		color: red;
	}
	div{
		position: absolute;
		left: 50%;
		top: 50%;
		width:750px;
		height: 500px;
		margin-left:-325px;
		margin-top:-200px;
	}
</style>
</head>
<body>

	<div>
		<h4>USER ACCOUNT</h4>
		<form action="">
			<table>
				<tr>
					<td>
						<span>转出ID：</span>
					</td>
					<td>
						<input type="number" name="lessId" placeholder="输入转出用户ID">
					</td>
				</tr>
				<tr>
					<td>
						<span>转入ID：</span>
					</td>
					<td>
						<input type="number" name="addId" placeholder="输入转入用户ID">
					</td>
				</tr>
				<tr>
					<td>
						<span>转账额度：</span>
					</td>
					<td>
						<input type="number" name="money" placeholder="输入转账金额">
					</td>
				</tr>
				<tr>
					<td><input type="button" value="提交" onclick="userAccount()"></td>
					<td><input type="reset" value="取消"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>