<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../include/header.jsp"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="../js/script.js?ver=0.2"></script>
</head>
<body>
	
	<!-- 파일을 전송하기 위한 enctype -->
	<form name="productFrm" action="product_process.jsp?flag=modify" enctype="multipart/form-data" method="post">
		<table style="width: 80%">
			<tr>
				<th colspan="2">** 상품 수정 **</th>
			</tr>
			<tr>
				<td style="width:20%">상품명</td>
				<td><input type="text" name="name" value="${ }"></td>
			</tr>
			<tr>
				<td>가격</td>
				<td><input type="text" name="price" value="<%=dto.getPrice()%>"></td>
			</tr>
			<tr>
				<td>설 명</td>
				<td><textarea name="detail" rows="3" cols="30"><%=dto.getDetail()%></textarea></td>
			</tr>
			<tr>
				<td>재고량</td>
				<td><input type="text" name="stock" value="<%=dto.getStock()%>"></td>
			</tr>
			<tr>
				<td>이미지</td>
				<td>
					<input type="hidden" id="imagePath" value="" >
					<img name="preview" src="../images/product/<%=dto.getImage() %>" style="width:100%">
					<br/><input type="file" name="image" size="30" onchange="filePreview()">
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<br/>
					<input type="submit" value="상품 수정">
					<input type="reset" value="새로 입력" onclick="resetInsertData()">
				</td>
			</tr>
		</table>
		<input type="hidden" name="no" value="<%=dao.getNo()%>">
	</form>
	
</body>
</html>
<%@ include file="../include/footer.jsp"%>