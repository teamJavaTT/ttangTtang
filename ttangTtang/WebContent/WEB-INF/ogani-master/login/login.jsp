<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype HTML>
<head>
<meta charset="UTF-8">
<title>TTang TTang 로그인</title>
<link rel="stylesheet" type="text/css" href="/ttangTtang/css/login/main.css">
<script src="https://kit.fontawesome.com/51db22a717.js" crossorigin="anonymous"></script>
<script src="/ttangTtang/js/jquery-3.3.1.min.js"></script>
<script src="/ttangTtang/js/login/login.js"></script>
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

				<div class="logo-wrap">
					<a href="index.do">
						<img src="/ttangTtang/img/logo_red.png" style="height: auto;">
					</a>
				</div>
			</header>
			<section class="login-input-section-wrap">
				<form action="login.do" method="post" name="loginForm">
					<c:if test="${errors.idNotMatch}">
						<script>
							alert("아이디를 다시 확인하세요.");
						</script>
					</c:if>
					<c:if test="${errors.pwdNotMatch}">
						<script>
							alert("비밀번호를 다시 확인하세요.");
						</script>
					</c:if>
					<div class="login-input-wrap">
						<input placeholder="아이디를 입력하세요." name="userid" type="text" value="${param.userid}"></input>
					</div>
					<div class="login-input-wrap password-wrap">
						<input placeholder="비밀번호를 입력하세요." name="upw" type="password"></input>
					</div>
				</form>
				<div class="login-button-wrap">
					<button id="btnLogin"  onclick="loginFunc()" >로그인</button>
				</div>

				<!-- <div class="login-stay-sign-in">
	<i class="far fa-check-circle"></i>
	<span>로그인 상태 유지</span>
</div> 
	로그인 상태 유지 버튼 구현 어려워 주석 처리함-->

				<br>
				<div class="text-right p-t-13 p-b-23">
					<span class="txt1"> </span> <a href="idFind.do" class="txt2">아이디찾기</a> / <a href="passwordFind.do" class="txt2">비밀번호 찾기 </a>
				</div>

				<div class="flex-col-c p-t-170 p-b-40">
					<span class="txt1 p-b-9"> 계정이 없으십니까? </span> <a href="join.do"
						class="txt3"> 회원가입 </a>
				</div>
			</section>

			<footer>
				<div class="copyright-wrap">
					<span> <img src="/ttangTtang/img/logo_red.png">
						Copyright © TTang TTang Corp. All Rights Reserved.
					</span>
				</div>
			</footer>
		</div>
	</div>
</body>


