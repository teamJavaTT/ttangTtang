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

input,
label {
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
<script>
	//상품을 추가하기위한 정보를 담아 insert.do로 보내는 자바스크립트 함수
	function product_write() {

		var product_name = document.form1.product_name.value; // document는 웹페이지에 접근하기위한 객체.. form1에 있는 상품이름을 반환해서 name에 저장함
		var category = document.form1.categry.value; 
		var max_price = document.form1.max_price.value; 
		var min_price = document.form1.min_price.value; // document는 웹페이지에 접근하기위한 객체.. form1에 있는 상품의 값을 반환해서 price에 저장함
		var description = document.form1.description.value; // document는 웹페이지에 접근하기위한 객체.. form1에 있는 상품의 정보를 반환해서 description에 저장함
	
	
		//document.form.은 폼페이지에 있는 값을 반환한다는 뜻.

		if (product_name == "") { //상품 이름이 입력되어 있지 않으면
			alert("상품명을 입력하세요");
			document.form1.product_name.focus(); //form1페이지에 있는 "상품명을 입력하세요" 에 커서를 올려둔다.
			return;
			}
		if (category == "") { //상품가격이 입력되어 있지 않으면
			alert("카테고리를 선택하세요");
			document.form1.category.focus(); //form1페이지에 있는 "가격을 입력하세요" 에 커서를 올려둔다.
			return;
		
		}
		if (max_price == "") { //상품가격이 입력되어 있지 않으면
			alert("최대가격을 입력하세요");
			document.form1.max_price.focus(); //form1페이지에 있는 "가격을 입력하세요" 에 커서를 올려둔다.
			return;
		}
		if (min_price == "") { //상품가격이 입력되어 있지 않으면
			alert("최소가격을 입력하세요");
			document.form1.min_price.focus(); //form1페이지에 있는 "가격을 입력하세요" 에 커서를 올려둔다.
			return;
		}
		if (end_time == "") { //상품설명이 입력되어 있지 않으면
			alert("경매 종료 시간을 입력하세요");
			document.form1.end_time.focus(); //form1페이지에 있는 "상품설명을 입력하세요" 에 커서를 올려둔다.
			return;
		}
		if (description == "") { //상품설명이 입력되어 있지 않으면
			alert("상품설명을 입력하세요");
			document.form1.description.focus(); //form1페이지에 있는 "상품설명을 입력하세요" 에 커서를 올려둔다.
			return;
		}
		// input 태그를 마우스로 클릭하여 입력상태로 만든것을 포커스를 얻었다고 한다.
		// 그리고 입력상태를 떠난 것을 포커스가 벗어났다고 한다.

		document.form1.action = "${path}/shop/product/insert.do"; //insert.do 페이지로 form1에 저장된 자료를 전송함
		document.form1.submit();
	};
	
	$(document).ready(
		    function() {
		        // 태그에 onchange를 부여한다.
		        $('#ex_filename').change(function() {
		                addPreview($(this)); //preview form 추가하기
		        });
		    });
		 
		    // image preview 기능 구현
		    // input = file object[]
		    function addPreview(input) {
		        if (input[0].files) {
		            //파일 선택이 여러개였을 시의 대응
		            for (var fileIndex = 0 ; fileIndex < input[0].files.length ; fileIndex++) {
		                var file = input[0].files[fileIndex];
		                var reader = new FileReader();
		 
		                reader.onload = function (img) {
		                    //div id="preview" 내에 동적코드추가.
		                    //이 부분을 수정해서 이미지 링크 외 파일명, 사이즈 등의 부가설명을 할 수 있을 것이다.
		                    $("#preview").append(
		                        "<img src=\"" + img.target.result + "\"\/>"
		                    );
		                };
		                
		                reader.readAsDataURL(file);
		            }
		        } else alert('invalid file input'); // 첨부클릭 후 취소시의 대응책은 세우지 않았다.
		    }
		 
	
</script>
</head>

<!-- 상품 등록 section begin -->
<section>
	<h3 style="text-align: center;">경매 상품 등록</h3>
<div class="container">
	<form id="form1" name="form1" action="aucProductWrite.do"  method="post"
		enctype="multipart/form-data" style=margin-left:420px;margin-top:20px;margin-bottom:10px;>
		<!-- 파일업로드를 위해 추가하는 타입 -->

		<table>
			<tr>
				<td>상품명:</td>
				<td><input name="product_name"></td>
			</tr>
			<tr>
				<td>카테고리:</td>
					<td>
					<select name="category">
                        <c:forEach var="category" items="${category}">
                       <option val="${category.ccode}">${category.cname}</option>
						</c:forEach>
					</select>
				</td>
			</tr>

			<tr>
				<td>최대가격:</td>
				<td><input name="max_price"></td>
			</tr>
			
			<tr>
				<td>최소가격:</td>
				<td><input name="min_price"></td>
			</tr>
			<tr>
				<td>경매기간:</td>
				<td>
				<select name="end_time">
						<option value="1">1일</option>	
						<option value="2">2일</option>
						<option value="3">3일</option>
						<option value="4">4일</option>
						<option value="5">5일</option>
						<option value="6">6일</option>	
								</select>
			
					<select name="end_day">
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
						<option value="24">24시간</option>
					</select>
					
				</td>
			</tr>
			<tr>
				<td style="float: left;">상품설명:</td>
				<td><textarea name="description" id="description" style="resize: none;width: 306px;height: 176px;"></textarea></td>
			</tr>
		</table>
			<div class="filebox">
			<table>
			<tr><span style="opacity: 0.6" ; font-size=12px>(최대
					10개의 이미지를 선택하실 수 있습니다.※정면,측면,후면 필수!)</span></tr>

				<tr>
				<td><input class="upload-name" value="파일선택" disabled="disabled" multiple/>
				<label for="ex_filename">업로드</label> <input type="file"  name="imageface"
					id="ex_filename" class="upload-hidden">
					</td>
					</tr>	
					 <div id="preview"></div>
			<tr>

				<td colspan="2" align="center">
					<input type="submit" value="등록"> <!-- "등록" 버튼을 누르면 위쪽에 있는 스크립트문에서 product_write()함수가 호출되서 실행되 insert.do페이지로 자료를 전송한다. -->
					<input type="button" value="목록"
					onclick="location.href='${path}/../index.do'"> <!-- "목록 버튼을 누르면 list.do페이지로 이동" -->
				</td>
			</tr>
			</table> 	
			</div>
	</form>
	</div>
</section>

<%@ include file="../include/footer.jsp"%>