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

	<h2>상품 정보 편집</h2>
	<!--   <form id="form1" name="form1" method="post"
        enctype="multipart/form-data"> -->
	<!-- 파일 업로드를 하기위한 타입, 필수로 작성해야 한다.-->
	<table>
		<!-- 관리자로그인을 한 후에 들어갈 수 있는 상품정보 편집정보 -->
		<!-- 해당되는 자료들은 dto에서 가져와서 보여준다. -->
			<tr>
	       <tr><td><input type="file" name="file1" multiple accept="image/*"/ ></td></tr>	
			<td>이미지<input name="image" id="image" placeholder="정면"
				 onchange="filePreview()"></td>
		<tr>
			<td><input name="image" id="image" placeholder="후면" 
				onchange="filePreview()" style="margin-left: 48px;">
		</tr>
		</td>
		<tr>
			<td><input name="image" id="image" placeholder="측면" 
				onchange="filePreview()" style="margin-left: 48px;">
		</tr>
		</td>
		<tr>
			<td><input name="image" id="image" placeholder="추가" 
				onchange="filePreview()" style="margin-left: 48px;">
		</tr>
		</td>
		<!-- 	<img name="preview" src="#" style="width:100%"> -->
	</tr>
		<tr>
			<td>상품명</td>
			<td><input name="product_name" value="${dto.product_name}"></td>
		</tr>

		<tr>
			<td>가격</td>
			<td><input name="price" type="number" value="${dto.price }"></td>
		</tr>

		<tr>
			<td>상품설명</td>
			<td><textarea rows="5" cols="60" name="description"
					id="description">${dto.description }</textarea></td>
		</tr>
	</table>
	</form>
	<%@ include file="../include/footer.jsp"%>