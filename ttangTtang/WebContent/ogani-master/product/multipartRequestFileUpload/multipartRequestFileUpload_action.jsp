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
	location.href="multipartRequestFileUpload_form.jsp";
</script>
<% 
}
%>
