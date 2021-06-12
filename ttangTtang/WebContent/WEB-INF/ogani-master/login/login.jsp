<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype HTML>
<head>
	<meta charset="UTF-8">
	<title>TTang TTang 로그인</title>
	<link rel="stylesheet" type="text/css"  href="/ttangTtang/css/login/main.css">
	<script src="https://kit.fontawesome.com/51db22a717.js" crossorigin="anonymous"></script>
</head>
<body>
	<div class="main-container">
		<div class="main-wrap">
		<header>
			<div class="sel-lang-wrap">
				<select class="lang-select">
					<option>한국어</option>
					<option>English</option>
				</select>
			</div>
			
			<div class="logo-wrap" >
				<img src="/ttangTtang/img/logo_red.png" >
			</div>
		</header> 
		<section class="login-input-section-wrap">
			<form action="login.do" method="post">
				<div class="login-input-wrap">
					<input placeholder="아이디를 입력하세요." name="userid" type="text"></input>
				</div>
				<div class="login-input-wrap password-wrap">	
					<input placeholder="비밀번호를 입력하세요." name="upw" type="password"></input>
				</div>
	
				<div class="login-button-wrap">
					<button type="submit"><span>로그인</span></button>
				</div>
			</form>
<!-- <div class="login-stay-sign-in">
	<i class="far fa-check-circle"></i>
	<span>로그인 상태 유지</span>
</div> 
	로그인 상태 유지 버튼 구현 어려워 주석 처리함--> 

			<br>
			<div class="text-right p-t-13 p-b-23" >
				<span class="txt1"> </span> <a href="idfind.jsp" class="txt2">아이디 찾기 / 비밀번호 찾기 </a>
			</div>

			<div class="flex-col-c p-t-170 p-b-40">
				<span class="txt1 p-b-9"> 계정이 없으십니까? </span>
				<a href="join.do" class="txt3"> 회원가입 </a>
			</div>
		</section>
		
		<footer>
			<div class="copyright-wrap">
				<span>
					<img src="/ttangTtang/img/logo_red.png" > Copyright © TTang TTang Corp. All Rights Reserved.
				</span>
			</div>
		</footer>
		</div>
	</div>
</body>