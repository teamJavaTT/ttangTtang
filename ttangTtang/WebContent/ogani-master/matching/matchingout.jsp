<%@page import="ttangTtang/organi-master/matching.matching4"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8");%>

<script>	
var delpost = confirm("나가시겠습니까?");
if (delpost == true) {
	alert("나가기.");
	location.href = "/ttangTtang/ogani-master/index.jsp"
} else if (delpost == false) {
	alert("취소.");
	history.back();
} 
</script>
