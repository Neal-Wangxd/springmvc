<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="icon" type="image/x-icon" href="../img/myico_16.ico"/>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>UPLOAD</title>
	<script type="text/javascript">
		function upload(){
			var form = document.forms[0];
			form.action="/springmvc-review-upload/upload/testUploadMut";
			form.method="post";
			form.submit();
		}
	</script>
</head>
<body>
	<h>文件上传</h>
	<form action="" method="post"  enctype="multipart/form-data">
		选择文件：<input type="file" name="fileA">
		选择文件：<input type="file" name="fileB">
		选择文件：<input type="file" name="fileC">
		<input type="button" value="上传" onclick="upload()">
	</form>
</body>
</html>