<%@page import="multipartUpload.MultipartRequestFileUpload"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8");%>
<%
MultipartRequestFileUpload upload = new MultipartRequestFileUpload();
if(upload.fileUpload(request)){
%>
<script>
	alert("저장성공");
	location.href="http://localhost:8082/ttangTtang/ogani-master/matching/matching4.jsp";
</script>
<% 
}
%>