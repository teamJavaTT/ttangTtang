<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>

<title>상품 수정</title>
<link rel="stylesheet" href="/resources/css/product/product.css">

<!-- 상품 등록 section begin -->
<div id="productModiDiv">

	<c:if test="${allPro.auctioncheck=='N'}">
		<div>
			<h3 style="text-align: center;">일반 상품 수정</h3>
		</div>
	</c:if>
	<c:if test="${allPro.auctioncheck=='Y'}">
		<div class="auction">
			<h3 style="text-align: center;">경매 상품 수정</h3>
		</div>
	</c:if>
	<div class="container">
		<form id="InsertForm" name="InsertForm" action="productModify"
			method="post" style="margin-top: 20px; margin-bottom: 10px;">
			<input type="hidden" name="ino" value="${allPro.ino}" /> <input
				type="hidden" name="imageface1" id="imageface1" value="${allPro.imageface1}"> <input
				type="hidden" name="imageface2" id="imageface2" value="${allPro.imageface2}"> <input
				type="hidden" name="imageface3" id="imageface3" value="${allPro.imageface3}"> <input
				type="hidden" name="imageface4" id="imageface4" value="${allPro.imageface4}"> <input
				type="hidden" name="auctioncheck" value="${allPro.auctioncheck}" />
			<!-- 파일업로드를 위해 추가하는 타입 -->
			<table>
				<tr>
					<td>상품명:</td>
					<td colspan="2"><input type="text" class="form-control"
						name="iname" value="${allPro.iname}"></td>
				</tr>
				<tr>
					<td>카테고리:</td>
					<td><select name="ccode">
							<c:forEach var="category" items="${category}">
								<c:choose>
									<c:when test="${category.ccode ne allPro.ccode}">
										<option value="${category.ccode}">${category.cname}</option>
									</c:when>
									<c:when test="${category.ccode eq allPro.ccode}">
										<option selected value="${category.ccode}">${category.cname}</option>
									</c:when>
								</c:choose>
							</c:forEach>
					</select></td>
				</tr>
				<c:choose>
					<c:when
						test="${allPro.auctioncheck eq 'N'||allPro.auctioncheck eq 'B' }">
						<tr class="normal">
							<td>가격:</td>
							<td><input name="price" class="form-control"
								value="${allPro.price}"></td>
						</tr>
					</c:when>
					<c:when test="${allPro.auctioncheck eq 'Y'}">
						<tr class="auction">
							<td>최소가격:</td>
							<td colspan="2"><input name="minPrice" class="form-control"
								value="${allPro.minprice}"></td>
						</tr>
						<tr class="auction">
							<td>최대가격:</td>

							<td colspan="2"><input name="maxPrice" class="form-control"
								value="${allPro.maxprice}" readonly><span
								style="font-color: 0.6; font-size: 15px; color: tomato;">(최대
									가격은 수정이 불가 합니다.)</span></td>
						</tr>
					</c:when>
				</c:choose>

				<tr>
					<td>판매지역:</td>
					<td colspan="2"><c:if test="${!empty address[1]}">
							<input type="radio" name="uad" value="${address[1]}"<c:if test="${address[1]eq allPro.uad}">checked="checked"</c:if> />
							<span>${address[1]}</span>
						</c:if></td>
				</tr>
				<tr>
					<td></td>
					<td colspan="2"><c:if test="${!empty address[2]}">
							<input type="radio" name="uad" value="${address[2]}"<c:if test="${address[2]eq allPro.uad}">checked="checked"</c:if>/>
							<span>${address[2]}</span>
						</c:if></td>
				</tr>
				<tr>
					<td></td>
					<td colspan="2"><c:if test="${!empty address[3]}">
							<input type="radio" name="uad" value="${address[3]}"<c:if test="${address[3]eq allPro.uad}">checked="checked"</c:if>/>
							<span>${address[3]}</span>
						</c:if></td>
				</tr>


				<tr>
					<td style="float: left;">상품설명:</td>
					<td><textarea name="priceText" id="priceText"
							class="form-control" style="resize: none;" rows="5">${allPro.pricetext}</textarea></td>
				</tr>
			</table>
		</form>
		<div class="filebox">
			<table id="imageTbl">
				<tr>
					<td><span>상품이미지<small>(0/4)</small></span></td>
				</tr>
				<tr>
					<td>
						<form id="fileUpload" name="fileUpload" enctype="multipart/form-data">
							<input type="file" accept="image/jpg, image/jpeg, image/png" name="imageFile" id="imageFile" class="upload-hidden">
						</form>
						<label id="imageLabel" for="imageFile">이미지 등록</label>

						<div id="preview" class="preview">
							<ul>
								<c:if test="${!empty allPro.imageface1}">
									<li>
										<img src="${allPro.imageface1}">
										<button type="button" class="fa fa-close" onclick="deletePreview($(this),1)"></button>
									</li>
								</c:if>
								<c:if test="${!empty allPro.imageface2}">
									<li>
										<img src="${allPro.imageface2}">
										<button type="button" class="fa fa-close" onclick="deletePreview($(this),1)"></button>
									</li>
								</c:if>
								<c:if test="${!empty allPro.imageface3}">
									<li>
										<img src="${allPro.imageface3}">
										<button type="button" class="fa fa-close" onclick="deletePreview($(this),1)"></button>
									</li>
								</c:if>
								<c:if test="${!empty allPro.imageface4}">
									<li>
										<img src="${allPro.imageface4}">
										<button type="button" class="fa fa-close" onclick="deletePreview($(this),1)"></button>
									</li>
								</c:if>
							</ul>
						</div>
					</td>
				</tr>
				<tr>
					<td align="center"><input type="button"
						class="btn btn-outline-secondary" value="등록"
						onclick=" productUpdate();"> <!-- "등록" 버튼을 누르면 위쪽에 있는 스크립트문에서 product_write()함수가 호출되서 실행되 insert.do페이지로 자료를 전송한다. -->
						<input type="button" class="btn btn-outline-secondary" value="취소"
						onclick="history.back(-1);"> <!-- "목록 버튼을 누르면 list.do페이지로 이동" --></td>
				</tr>
			</table>
		</div>
	</div>

</div>
<script src="/resources/js/product/productEdit.js"></script>
<%@ include file="../include/footer.jsp"%>