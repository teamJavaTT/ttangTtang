<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>

<link rel="stylesheet" href="css/style.css" type="text/css">
<!-- Hero Section Begin -->
<section class="hero hero-normal">
	<div class="container">
		<div class="row">
			<div class="col-lg-3">
				<div class="hero__categories">
					<div class="hero__categories__all">
						<i class="fa fa-bars"></i> <span>All departments</span>
					</div>
					<ul>
						<li><a href="#">Fresh Meat</a></li>
						<li><a href="#">Vegetables</a></li>
						<li><a href="#">Fruit & Nut Gifts</a></li>
						<li><a href="#">Fresh Berries</a></li>
						<li><a href="#">Ocean Foods</a></li>
						<li><a href="#">Butter & Eggs</a></li>
						<li><a href="#">Fastfood</a></li>
						<li><a href="#">Fresh Onion</a></li>
						<li><a href="#">Papayaya & Crisps</a></li>
						<li><a href="#">Oatmeal</a></li>
						<li><a href="#">Fresh Bananas</a></li>
					</ul>
				</div>
			</div>
			<div class="col-lg-9">
				<div class="hero__search">
					<div class="hero__search__form">
						<form action="#">
							<div class="hero__search__categories">
								All Categories <span class="arrow_carrot-down"></span>
							</div>
							<input type="text" placeholder="What do yo u need?">
							<button type="submit" class="site-btn">SEARCH</button>
						</form>
					</div>

					<div class="hero__search__phone">
						<div class="hero__search__phone__icon">
							<i class="fa fa-phone"></i>
						</div>
						<div class="hero__search__phone__text">
							<h5>+65 11.188.888</h5>
							<span>support 24/7 time</span>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>



</section>


<!-- Hero Section End -->

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

#preview img {
	width: 100px;
	height: 100px;
}

#preview p {
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
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
</head>

<!-- 상품 등록 section begin -->
<section>
	<h3 style="text-align: center;">경매 상품 등록</h3>
	<div class="container">
		<form id="form1" name="form1" action="aucProductWrite.do" method="post" style="margin-left: 420px; margin-top: 20px; margin-bottom: 10px;">
			<input type="hidden" name="imagefaceName"/>
			<!-- 파일업로드를 위해 추가하는 타입 -->
			<table>
				<tr>
					<td>상품명:</td>
					<td><input type="text" name="productName"></td>
				</tr>
				<tr>
					<td>카테고리:</td>
					<td><select id="category" name="category">
							<c:forEach var="category" items="${category}">
								<option value="${category.ccode}">${category.cname}</option>
							</c:forEach>
					</select></td>
				</tr>

				<tr>
					<td>최대가격:</td>
					<td><input name="maxPrice"></td>
				</tr>

				<tr>
					<td>최소가격:</td>
					<td><input name="minPrice"></td>
				</tr>
				<tr>
					<td>경매기간:</td>
					<td><select name="endDay">
							<option value="0">0일</option>
							<option value="24">1일</option>
							<option value="48">2일</option>
							<option value="72">3일</option>
							<option value="96">4일</option>
							<option value="120">5일</option>
							<option value="144">6일</option>
					</select>
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
					</select></td>
				</tr>
				<tr>
					<td style="float: left;">상품설명:</td>
					<td>
						<textarea name="priceText" id="priceText" style="resize: none; width: 306px; height: 176px;"></textarea>
					</td>
				</tr>
			</table>
		</form>
		
		<div class="filebox">
			<table>
				<tr>
					<td><span style=" opacity: 0.6; font-size: 12px;">(최대 10개의 이미지를 선택하실 수 있습니다.※정면,측면,후면 필수!)</span></td>
				</tr>
				<tr>
					<td>
						<div id="preview"></div>
						<input class="upload-name" value="파일선택" disabled="disabled" multiple /> <label for="ex_filename">업로드</label>
						<form id="fileUpload" name="fileUpload"  method="post" enctype="multipart/form-data">
							<input type="file" name="imageface" id="ex_filename" class="upload-hidden">
						</form>
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="button" value="등록" onclick="product_write();"> <!-- "등록" 버튼을 누르면 위쪽에 있는 스크립트문에서 product_write()함수가 호출되서 실행되 insert.do페이지로 자료를 전송한다. -->
						<input type="button" value="목록" onclick="location.href='index.do'"> <!-- "목록 버튼을 누르면 list.do페이지로 이동" -->
					</td>
				</tr>
			</table>
		</div>
	</div>
</section>

<script src="/ttangTtang/js/product/aucProductWrite.js"></script>
<%@ include file="../include/footer.jsp"%>