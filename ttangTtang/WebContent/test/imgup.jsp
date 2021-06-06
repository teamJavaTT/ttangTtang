<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="ko">
<head>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="com.oreilly.servlet.MultipartRequest,com.oreilly.servlet.multipart.DefaultFileRenamePolicy,java.util.*,java.io.*" %>
<%@ page import="java.sql.*"%>
<% request.setCharacterEncoding("utf-8");

//파일이 저장되는 경로
String path = "C:/dev/workspace/git/ttangTtang/ttangTtang/WebContent/file";

int size = 1024 * 1024 * 10;//파일 용량 10M
String file = "";//업로드 한 파일의 이름
String originalFile = "";//이름이 변경되기 전 파일이름

try {
	MultipartRequest multi = new MultipartRequest(request, path, size, "utf-8", new DefaultFileRenamePolicy());
	
	Enumeration files = multi.getFileNames();
	String str = (String) files.nextElement();//파일 이름을 받아와 String으로 저장
	
	file = multi.getFilesystemName(str);//업로드 된 파일 이름 가져옴
	originalFile = multi.getOriginalFileName(str);//원래의 파일 이름 가져옴
	
} catch (Exception e) {
	e.printStackTrace();
}

String fullpath = path + "\\" + file;
%>
<title>Insert title here</title>
</head>
<body>
</body>
</html>
