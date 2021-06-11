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
<
<title>Matching</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css" />
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
<style>
.chat_wrap {
	border: 1px solid #999;
	width: 300px;
	padding: 5px;
	font-size: 13px;
	color: #333
}

.chat_wrap .inner {
	background-color: #acc2d2;
	border-radius: 5px;
	padding: 10px;
	overflow-y: scroll;
	height: 400px
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
	border-left: 8px solid #FF6347;
	border-right: 0
}

.chat_wrap .item.mymsg .box .time {
	right: auto;
	left: -75px
}

.chat_wrap .item.mymsg .box .msg {
	background: #FF6347;
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
	width: 100%;
	background: #ddd;
	border-radius: 5px;
	height: 30px;
	padding-left: 5px;
	box-sizing: border-box;
	margin-top: 5px
}

input[type="text"]::placeholder {
	color: #999
}
</style>

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
	 $(".chat").on({
	        "click" : function() {
	            if ($(this).attr("src") == "./img/chat.png") {
	                $(".chat").attr("src", "./img/chathide.png");
	                $("#_chatbox").css("display", "block");
	            } else if ($(this).attr("src") == "./img/chathide.png") {
	                $(".chat").attr("src", "./img/chat.png");
	                $("#_chatbox").css("display", "none");
	            }
	        }
	    });

	var currentTime = function() {
		var date = new Date();
		var hh = date.getHours();
		var mm = date.getMinutes();
		var apm = hh > 12 ? "오후" : "오전";
		var ct = apm + " " + hh + ":" + mm + "";
		return ct;
	};
</script>

</head>
<body>
	<div class="chat_wrap">
		<div class="inner">

			<div class="item on">
				<div class="box">
					<p class="msg">안녕하세요</p>
					<span class="time ">오전 10:05</span>
				</div>


			</div>
		</div>
		<input class="item mymsg" ; type="text" class placeholder="내용 입력">

	</div>
	
	<div class="navbar-header">
			<button type="button" class="navbar-toggle cooapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expanded="false">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="matching4.jsp">채팅창</a>
			
			
			
			
			<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li class="active"><a href="../index.jsp">메인</a>
			</ul>
			
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expand="false">접속하기<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="../login/login.jsp">로그인</a>
						<li><a href="../login/join.jsp">회원가입</a>
					</ul></li>
			</ul>
			
			</div>
</body>
</html>










