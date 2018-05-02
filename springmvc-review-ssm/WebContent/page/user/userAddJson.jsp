<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>USER ADD JSON</title>
<script type="text/javascript" src="<%=basePath%>js/jquery-3.3.1.js"></script>
<script type="text/javascript" src="<%=basePath%>js/jquery.serialize-object.js"></script>
<script type="text/javascript">
	function userAddJsonParam(){
		$.ajax({
            url: '<%=basePath%>user/addUserJsonParam',
            async: false,
            type: 'POST',
            contentType: 'application/x-www-form-urlencoded',
            dataType: 'json',
            data: JSON.parse($('#myform').serializeJSON()),
            success: function (rdata) {
            	alert("success");
                alert(JSON.stringify(rdata));  
            },
            error: function(textStatus) {
            	alert("error");
            	console.log(textStatus);
                alert(textStatus);
            }
        });
	}
	
	function userAddJsonBody(){
		console.log($('#myform').serializeJSON());
		$.ajax({
            url: '<%=basePath%>user/addUserJsonBody',
            async: false,
            type: 'POST',
            dataType: 'json',
            contentType: 'application/json;charset=utf-8',
            data: $('#myform').serializeJSON(),
            success: function (rdata) {
            	alert("success");
                alert(JSON.stringify(rdata));  
            },
            error: function(textStatus) {
            	alert("error");
            	console.log(textStatus);
                alert(textStatus);
            }
        });
	}
	
	function getUserJson(){
		$.ajax({
            url: '<%=basePath%>user/getOneJson',
            async: false, 
            type: 'POST',
            dataType: 'json',
            data : {'id':'45'},
            contentType: 'application/x-www-form-urlencoded',
            success: function (rdata) {
                alert("success");
                alert(JSON.stringify(rdata));  
            },
            error: function(textStatus) {
            	alert("error");
            	console.log(textStatus);
                alert(textStatus);
            }
        });
		
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
		<h4>USER ADD JSON</h4>
		<form action="#" method="post" id="myform">
			<table>
				<tr>
					<td>
						<span>用户名：</span>
					</td>
					<td>
						<input type="hidden" name="id" value="0">
						<input type="text" name="username" value="${userInfo.username}"  placeholder="输入至少2位字符">
					</td>
				</tr>
				<tr>
					<td>
						<span>手机号：</span>
					</td>
					<td>
						<input type="tel" name="phone" value="${userInfo.phone}" placeholder="输入正确手机号">
					</td>
				</tr>
				<tr>
					<td>
						<span>薪&nbsp;资：</span>
					</td>
					<td>
						<input type="number" name="salary" value="${userInfo.salary}" placeholder="输入正确的薪资格式">
					</td>
				</tr>
				<tr>
					<td>
						<span>年&nbsp;龄：</span>
					</td>
					<td>
						<input type="number" name="age" value="${userInfo.age}" placeholder="输入正确的年龄">
					</td>
				</tr>
				<tr>
					<td>
						<span>身&nbsp;高：</span>
					</td>
					<td>
						<input type="number" name="hight" value="${userInfo.hight}" placeholder="输入正确的身高">
					</td>
				</tr>
				<tr>
					<td>
						<span>出生日期：</span>
					</td>
					<td>
						<input type="text" name="birthday" value="${userInfo.birthday}" placeholder="输入正确的日期格式">
					</td>
				</tr>
				<tr>
					<td colspan="2">
					    <input type="button" value="提交Param" onclick="userAddJsonParam()"/>
					    <input type="button" value="提交Body" onclick="userAddJsonBody()"/>
					    <input type="button" value="获取" onclick="getUserJson()">
						<input type="reset" value="取消"/>
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>