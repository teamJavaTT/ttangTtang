<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<%@ include file="../include/middle_header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 수정</title>

<script>
    //상품을 갱신하는 함수
    //컨트롤러의 update.do로 맵핑된다.
    function product_update() {
        document.form1.action = "${path}/shop/product/update.do";
        document.form1.submit();
    }
 
    //상품을 삭제하는 함수
    //컨트롤러의 delete.do로 맵핑된다.
    function product_delete() {
        if (confirm("삭제하시겠습니까?")) {
            document.form1.action = "${path}/shop/product/delete.do";
            document.form1.submit();
        }
    }
</script>
</head>
<body>

	
	<%@ include file="../include/footer.jsp"%>