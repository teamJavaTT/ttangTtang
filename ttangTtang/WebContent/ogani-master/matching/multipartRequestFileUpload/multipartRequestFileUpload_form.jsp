<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
파일 업로드<br/>
<form action="multipartRequestFileUpload_action.jsp" enctype="multipart/form-data" method="post">

	<input type="file" name="image" size="30">
	<br/>
	<input type="submit" value="파일 전송">
</form>
</body>
</html>