<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>

<title>상품 등록</title>
<link rel="stylesheet" href="/resources/css/product/product.css">

<div class="featured__controls">
	<ul>
		<li onclick="fnOpen('normal')" class="btn btn-outline-danger">판매하기</li>
		<li onclick="fnOpen('auction')" class="btn btn-outline-danger">경매하기</li>
	</ul>
</div>
<!-- 상품 등록 section begin -->
<div id="productWriteDiv">
	<div class="normal">
		<h3 style="text-align: center;">일반 상품 등록</h3>
	</div>
	<div class="auction">
		<h3 style="text-align: center;">경매 상품 등록</h3>
	</div>
	<div class="container">
		<form id="InsertForm" name="InsertForm" action="productWrite"
			method="post" style="margin-top: 20px; margin-bottom: 10px;">
			<input type="hidden" name="imageface1" id="imageface1" /> <input
				type="hidden" name="imageface2" id="imageface2" /> <input
				type="hidden" name="imageface3" id="imageface3" /> <input
				type="hidden" name="imageface4" id="imageface4" /> <input
				type="hidden" name="auctioncheck" id="auctioncheck" />
			<!-- 파일업로드를 위해 추가하는 타입 -->
			<table class="proWriteTbl">
				<tr>
					<td style="width: 25%;">상품명</td>
					<td colspan="2"><input name="iname" id="iname"
						class="form-control"></td>
				</tr>
				<tr>
					<td>카테고리</td>

					<td><select name="ccode">
							<c:forEach var="category" items="${category}">
								<c:choose>
									<c:when test="${category.ccode ne norPro.ccode}">
										<option value="${category.ccode}">${category.cname}</option>
									</c:when>
									<c:when test="${category.ccode eq norPro.ccode}">
										<option selected value="${category.ccode}">${category.cname}</option>
									</c:when>
								</c:choose>
							</c:forEach>
					</select></td>
				</tr>
				<tr class="normal">
					<td>가격</td>
					<td><input name="price" class="form-control"></td>
				</tr>
				<tr class="auction">
					<td>최소가격</td>
					<td colspan="2"><input name="minPrice" class="form-control"></td>
				</tr>
				<tr class="auction">
					<td>최대가격</td>
					<td colspan="2"><input name="maxPrice" class="form-control"></td>
				</tr>
				<tr>
					<td>판매지역</td>
					<td colspan="2"><c:if test="${!empty address[1]}">
							<input type="radio" name="uad" value="${address[1]}" checked>
							<span>${address[1]}</span>
						</c:if></td>
				</tr>
				<tr>
					<td></td>
					<td colspan="2"><c:if test="${!empty address[2]}">
							<input type="radio" name="uad" value="${address[2]}">
							<span>${address[2]}</span>
						</c:if></td>
				</tr>
				<tr>
					<td></td>
					<td colspan="2"><c:if test="${!empty address[3]}">
							<input type="radio" name="uad" value="${address[3]}">
							<span>${address[3]}</span>
						</c:if></td>
				</tr>

				<tr class="auction">
					<td>경매기간</td>
					<td style="width: 122px;"><select name="endDay" id="endDay">
							<option value="0">0일</option>
							<option value="24">1일</option>
							<option value="48">2일</option>
							<option value="72">3일</option>
							<option value="96">4일</option>
							<option value="120">5일</option>
							<option value="144">6일</option>
					</select></td>
					<td><select name="endTime" id="endTime">
							<option value=0>0시간</option>
							<option value=1>1시간</option>
							<option value=2>2시간</option>
							<option value=3>3시간</option>
							<option value=4>4시간</option>
							<option value=5>5시간</option>
							<option value=6>6시간</option>
							<option value=7>7시간</option>
							<option value=8>8시간</option>
							<option value=9>9시간</option>
							<option value=10>10시간</option>
							<option value=11>11시간</option>
							<option value=12>12시간</option>
							<option value=13>13시간</option>
							<option value=14>14시간</option>
							<option value=15>15시간</option>
							<option value=16>16시간</option>
							<option value=17>17시간</option>
							<option value=18>18시간</option>
							<option value=19>19시간</option>
							<option value=20>20시간</option>
							<option value=21>21시간</option>
							<option value=22>22시간</option>
							<option value=23>23시간</option>
					</select></td>
				</tr>
				<tr class="auction">
					<td></td>
					<td colspan="2" id="timeMent"></td>
				</tr>

				<tr>
					<td style="float: left;">상품설명</td>
					<td colspan="2"><textarea class="form-control" name="priceText"
							id="priceText" style="resize: none;" rows="5"></textarea></td>
				</tr>
			</table>
		</form>
		<div class="filebox">
			<table id="imageTbl" class="proWriteTbl">
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
							<ul></ul>
						</div> 
					</td>
				</tr>
				<tr>
					<td align="center"><input type="button"
						class="btn btn-outline-secondary" value="등록"
						onclick="productWrite()"> <!-- "등록" 버튼을 누르면 위쪽에 있는 스크립트문에서 product_write()함수가 호출되서 실행되 insert.do페이지로 자료를 전송한다. -->
						<input type="button" class="btn btn-outline-secondary" value="목록"
						onclick="location.href='/'"> <!-- "목록 버튼을 누르면 list.do페이지로 이동" -->
					</td>
				</tr>
			</table>
		</div>
	</div>
</div>


<script src="/resources/js/product/productWrite.js"></script>
<%@ include file="../include/footer.jsp"%>