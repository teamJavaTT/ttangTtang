<%@ page language="java" contentType="text/html; charset=UTF-8"
     pageEncoding="UTF-8"%>
 <%@ include file="../include/header.jsp"%>
 <%@ include file="../include/middle_header.jsp" %>

<%@page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
//request.setAttribute("goodsList", goodsList);
List goodsList=(List)request.getAttribute("goodsList");
%>
<h1>상품목록</h1>
<h3><a href="./BasketList.ba">장바구니</a></h3>
<h3><a href="./OrderList.or">주문목록</a></h3>
<table border="1">
<tr><td><a href="./GoodsList.go">대분류</a></td>
<td><a href="./GoodsList.go?item=best">여성의류</a></td>
<td><a href="./GoodsList.go?item=outwear">남성의류</a></td>
<td><a href="./GoodsList.go?item=fulldress">생활용품</a></td>
<td><a href="./GoodsList.go?item=Tshirts">전자기기</a></td>
<td><a href="./GoodsList.go?item=shirts">가전제품</a></td>
<td><a href="./GoodsList.go?item=pants">반려동물</a></td>
<td><a href="./GoodsList.go?item=shoes">도서/취미</a></td>
</table>
<table border="1">
<tr>
<%-- <%
	for(int i=0;i<goodsList.size();i++){
	ProductBean goodsbean=(ProductBean)goodsList.get(i);
%>
<td><img src="./upload/<%=goodsbean.getImage().split(",")[0] %>" width="130" height="130"><br>
    <a href="./GoodsDetail.go?num=<%=goodsbean.getNum()%>"><%=goodsbean.getName() %></a><br>
    <%=goodsbean.getPrice() %>원
</td>	 --%>
	<%
/* } */
%>
</tr>
</table>
</body>
</html>

 <%@ include file="../include/footer.jsp"%>

