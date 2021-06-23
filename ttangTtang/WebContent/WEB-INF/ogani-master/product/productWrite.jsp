<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<%@ include file="../include/middle_header.jsp"%>

<title>상품 등록</title>
<style>
#test textarea {
	width: 200px;
	height: 100px;
	border: 3px solid #ff0000;
}

label {
	display: block;
	font: 1rem 'Fira Sans', sans-serif;
}

input, label {
	margin: .4rem 0;
}

.preview img {
	width: 100px;
	height: 100px;
}

.preview p {
	text-overflow: ellipsis;
	overflow: hidden;
}

preview-box {
	border: 1px solid;
	padding: 5px;
	border-radius: 2px;
	margin-bottom: 10px;
}
</style>

<div class="featured__controls">
    <ul>
        <li onclick="fnOpen('#normal')">판매하기</li>
        <li onclick="fnOpen('#auction')">경매하기</li>
    </ul>
</div>
<!-- 상품 등록 section begin -->
<section id="normal" class="productInsert" style="display:none">
	<h3 style="text-align: center;">일반 상품 등록</h3>
	<div class="container" style="padding-left: 34%;">
		<form id="norForm" name="norForm" action="productWrite.do" method="post" style="margin-top: 20px; margin-bottom: 10px;">
			<input type="hidden" name="aucChk" value="N"/>
			<input type="hidden" name="imagefaceNameNor"/>
			<!-- 파일업로드를 위해 추가하는 타입 -->
			<table>
				<tr>
					<td>상품명:</td>
					<td><input name="productNameNor"></td>
				</tr>
				<tr>
					<td>카테고리:</td>
					<td>
						<select name="categoryNor">
							<c:forEach var="category" items="${category}">
								<option value="${category.ccode}">${category.cname}</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td>가격:</td>
					<td><input name="price"></td>
				</tr>
				<tr>
					<td style="float: left;">상품설명:</td>
					<td>
						<textarea name="priceTextNor" id="priceTextNor" style="resize: none; width: 306px; height: 176px;"></textarea>
					</td>
				</tr>
			</table>
		</form>
		<div class="filebox">
			<table id="norImageTbl">
				<tr>
					<td><span>상품이미지<small>(0/4)</small></span></td>
				</tr>
				<tr>
					<td>
						<div id="previewNor" class="preview"><ul></ul></div>
						<input class="upload-name" value="이미지 등록" disabled="disabled" /> <label for="imagefaceNor">업로드</label>
						<form id="fileUploadNor" name="fileUploadNor"  method="post" enctype="multipart/form-data">
							<input type="file" accept="image/jpg, image/jpeg, image/png" name="imagefaceNor" id="imagefaceNor" class="upload-hidden" multiple>
						</form>
					</td>
				</tr>
				<tr>
					<td align="center">
						<input type="button" value="등록" onclick="productWriteNor();"> <!-- "등록" 버튼을 누르면 위쪽에 있는 스크립트문에서 product_write()함수가 호출되서 실행되 insert.do페이지로 자료를 전송한다. -->
						<input type="button" value="목록" onclick="location.href='index.do'"> <!-- "목록 버튼을 누르면 list.do페이지로 이동" -->
					</td>
				</tr>
			</table>
		</div>		
	</div>
</section>
<section id="auction" class="productInsert" style="display:none">
	<h3 style="text-align: center;">경매 상품 등록</h3>
	<div class="container" style="padding-left: 34%;">
		<form id="aucForm" name="aucForm" action="productWrite.do" method="post" style="margin-top: 20px; margin-bottom: 10px;">
			<input type="hidden" name="aucChk" value="Y"/>
			<input type="hidden" name="imagefaceNameAuc"/>
			<!-- 파일업로드를 위해 추가하는 타입 -->
			<table>
				<tr>
					<td>상품명:</td>
					<td colspan="2"><input type="text" name="productNameAuc"></td>
				</tr>
				<tr>
					<td>카테고리:</td>
					<td colspan="2">
						<select id="categoryAuc" name="categoryAuc">
							<c:forEach var="category" items="${category}">
								<c:if test="${category.ccode != 'BUY'}">
									<option value="${category.ccode}">${category.cname}</option>
								</c:if>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td>최소가격:</td>
					<td colspan="2"><input name="minPrice"></td>
				</tr>
				<tr>
					<td>최대가격:</td>
					<td colspan="2"><input name="maxPrice"></td>
				</tr>
				<tr>
					<td>경매기간:</td>
					<td style="width: 74px;">
						<select name="endDay">
								<option value="0">0일</option>
								<option value="24">1일</option>
								<option value="48">2일</option>
								<option value="72">3일</option>
								<option value="96">4일</option>
								<option value="120">5일</option>
								<option value="144">6일</option>
						</select>
						</td><td>
						<select name="endTime">
								<option value="0">0시간</option>
								<option value="1">1시간</option>
								<option value="2">2시간</option>
								<option value="3">3시간</option>
								<option value="4">4시간</option>
								<option value="5">5시간</option>
								<option value="6">6시간</option>
								<option value="7">7시간</option>
								<option value="8">8시간</option>
								<option value="9">9시간</option>
								<option value="10">10시간</option>
								<option value="11">11시간</option>
								<option value="12">12시간</option>
								<option value="13">13시간</option>
								<option value="14">14시간</option>
								<option value="15">15시간</option>
								<option value="16">16시간</option>
								<option value="17">17시간</option>
								<option value="18">18시간</option>
								<option value="19">19시간</option>
								<option value="20">20시간</option>
								<option value="21">21시간</option>
								<option value="22">22시간</option>
								<option value="23">23시간</option>
						</select>
					</td>
				</tr>
				<tr>
					<td style="float: left;">상품설명:</td>
					<td colspan="2">
						<textarea name="priceTextAuc" id="priceTextAuc" style="resize: none; width: 306px; height: 176px;"></textarea>
					</td>
				</tr>
			</table>
		</form>
		
		<div class="filebox">
			<table id="aucImageTbl">
				<tr>
					<td><span>상품이미지<small>(0/4)</small></span></td>
				</tr>
				<tr>
					<td>
						<div id="previewAuc" class="preview"><ul></ul></div>
						<input class="upload-name" value="이미지 등록" disabled="disabled" /> <label for="imagefaceAuc">업로드</label>
						<form id="fileUploadAuc" name="fileUploadAuc"  method="post" enctype="multipart/form-data">
							<input type="file" accept="image/jpg, image/jpeg, image/png" name="imagefaceAuc" id="imagefaceAuc" class="upload-hidden" multiple>
						</form>
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="button" value="등록" onclick="productWriteAuc();"> <!-- "등록" 버튼을 누르면 위쪽에 있는 스크립트문에서 product_write()함수가 호출되서 실행되 insert.do페이지로 자료를 전송한다. -->
						<input type="button" value="목록" onclick="location.href='index.do'"> <!-- "목록 버튼을 누르면 list.do페이지로 이동" -->
					</td>
				</tr>
			</table>
		</div>
	</div>
</section>

<script src="/ttangTtang/js/product/productWrite.js"></script>
<%@ include file="../include/footer.jsp"%>