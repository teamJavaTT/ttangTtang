<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zxx">

<head>
<meta charset="utf-8">
<meta name="description" content="Ogani Template">
<meta name="keywords" content="Ogani, unica, creative, html">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">

<title>Matching</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/meyer-re	set/2.0/reset.min.css" />
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
<style>
.chat_wrap {
	border: 1px solid #999;
	width: 550px;
	padding: 5px;
	font-size: 13px;
	color: #333
}

.chat_wrap .inner {
	background-color: tomato;
	border-radius: 5px;
	padding: 10px;
	overflow-y: scroll;
	height: 400px;
	background-image: url("../img/logo_hammer.png");
	background-size: 200px;
	background-repeat: no-repeat;
	background-width: 3000px;
	background-height: 160px;
	background-border: 2px solid;
}

.chat_wrap .item {
	margin-top: 15px
}

.chat_wrap .item:first-child {
	margin-top: 0
}

.chat_wrap .item .box {
	display: inline-block;
	max-width: 180px;
	position: relative
}

.chat_wrap .item .box:before {
	content: "";
	position: absolute;
	left: -8px;
	top: 9px;
	border-top: 0px solid transparent;
	border-bottom: 8px solid transparent;
	border-right: 8px solid #fff;
}

.chat_wrap .item .box .msg {
	background: #fff;
	border-radius: 10px;
	padding: 8px;
	text-align: left
}

.chat_wrap .item .box .time {
	font-size: 11px;
	color: #999;
	position: absolute;
	right: -75px;
	bottom: 0;
	width: 70px
}

.chat_wrap .item.mymsg {
	text-align: right
}

.chat_wrap .item.mymsg .box:before {
	left: auto;
	right: -8px;
	border-left: 8px solid #fee600;
	border-right: 0
}

.chat_wrap .item.mymsg .box .time {
	right: auto;
	left: -75px
}

.chat_wrap .item.mymsg .box .msg {
	background: #fee600;
}

.chat_wrap .item .box {
	transition: all .3s ease-out;
	margin: 0 0 0 20px;
	opacity: 0
}

.chat_wrap .item.mymsg .box {
	margin: 0 20px 0 0;
}

.chat_wrap .item.on .box {
	margin: 0;
	opacity: 1
}

input[type="text"] {
	border: 0;
	align: right;
	width: 100%;
	background: #ddd;
	border-radius: 5px;
	height: 30px;
	padding-left: 5px;
	box-sizing: border-box;
	margin-top: 5px;
}

input[type="text"]::placeholder {
	color: #999
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

<!-- 땅땅로고 -->
<a href="/ttangTtang/ogani-master/index.jsp"><img
	src="/ttangTtang/img/logo_red.png" alt=""></a>



<br>
<!-- text보내기창 함수 -->
<script>
	$(function() {
		$("input[type='text']").keypress(
				function(e) {
					if (e.keyCode == 13 && $(this).val().length) {
						var _val = $(this).val();
						var _class = $(this).attr("class");
						$(this).val('');
						var _tar = $(".chat_wrap .inner")
								.append(
										'<div class="item '+_class+'"><div class="box"><p class="msg">'
												+ _val
												+ '</p><span class="time">'
												+ currentTime()
												+ '</span></div></div>');
					}

					setTimeout(function() {
						$(".chat_wrap .inner").find(".item:last")
								.addClass("on");
					}, 10)

					$(".chat_wrap .inner").stop().animate({
						scrollTop : $(".chat_wrap .inner").height()
					}, 500);

				})
	});

	var currentTime = function() {
		var date = new Date();
		var hh = date.getHours();
		var mm = date.getMinutes();
		var apm = hh > 12 ? "오후" : "오전";
		var ct = apm + " " + hh + ":" + mm + "";
		return ct;
	};

	

	$(document).ready(function() {
		// 태그에 onchange를 부여한다.
		$('#imagepre').change(function() {
			addPreview($(this)); //preview form 추가하기
		});
	});

	// image preview 기능 구현
	// input = file object[]
	function addPreview(input) {
		if (input[0].files) {
			//파일 선택이 여러개였을 시의 대응
			for (var fileIndex = 0; fileIndex < input[0].files.length; fileIndex++) {
				var file = input[0].files[fileIndex];
				var reader = new FileReader();

				reader.onload = function(img) {
					//div id="preview" 내에 동적코드추가.
					//이 부분을 수정해서 이미지 링크 외 파일명, 사이즈 등의 부가설명을 할 수 있을 것이다.
					$("#preview").append(
							"<img src=\"" + img.target.result + "\"\/>");
				};

				reader.readAsDataURL(file);
			}
		} else
			alert('invalid file input'); // 첨부클릭 후 취소시의 대응책은 세우지 않았다.
	}

	
</script>

</head>
<body>

	<div class="chat_wrap">
		<div class="inner"
			style="background-position-x: center; background-position-y: center;  cols:15;">

			<div class="item on">
				<div class="box">
					<p class="msg">놀아줘요</p>
					<span class="time ">오전 10:05</span>
				</div>

			</div>


		</div>


		<td>
			<!-- <form name="fileForm" action="requestupload2" method="post"
				enctype="multipart/form-data">
				<input multiple="multiple" type="file" name="file" style="width: 500px;">
				
				<input class="item mymsg" type="submit" value="전송" >
			</form>  --> 
			
			<input class="item mymsg" ; type="text"
			placeholder="내용 입력" style="margin-top: 10px;">



<!-- 사진첨부 -->
			<form
				action="multipartRequestFileUpload/multipartRequestFileUpload_action.jsp"
				enctype="multipart/form-data" method="post"
				style="margin-top: 10px; margin-bottom: 4px;">

<!-- 파일전송 -->

				<input type="file" id="imagepre" name="image" size="30"
					style="width: 470px;"> <input type="submit" value="파일 전송"
					style="cursor: pointer;">

				<div id="preview"></div>
				
<!-- 창닫기 -->

			</form> <input type="button" id="matchingout" value="창닫기"
			style="margin-left: 491px; margin-top: 10px; cursor: pointer;">





			</ul>
	</div>


</body>
<script src="/ttangTtang/js/matching/matching.js">
	
</script>


</html>



