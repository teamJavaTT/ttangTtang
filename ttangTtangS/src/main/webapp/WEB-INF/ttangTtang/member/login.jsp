<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype HTML>
<head>
<meta charset="UTF-8">
<title>TTang TTang 로그인</title>
<link rel="stylesheet" type="text/css"
	href="/resources/css/login/main.css">
<script src="https://kit.fontawesome.com/51db22a717.js"
	crossorigin="anonymous"></script>
<script src="/resources/js/jquery-3.3.1.min.js"></script>
<script src="/resources/js/login/login.js"></script>
</head>
<body>
	<div class="main-container">
		<div class="main-wrap">
			<c:if test="${memberChk == 2 || memberChk eq 2}">
				<script>
					alert("탈퇴 처리된 회원입니다.");
				</script>
			</c:if>
			<header>
				<div class="sel-lang-wrap">
					<select class="lang-select">
						<option>한국어</option>
						<option>English</option>
					</select>
				</div>

				<div class="logo-wrap">
					<a href="index.do"> <img src="/resources/img/logo_red.png"
						style="height: auto;">
					</a>
				</div>
			</header>
			<section class="login-input-section-wrap">
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
				<%--  <c:if test="${login eq false}">--%>
					<form action="login.do" method="post" name="loginForm">
						<div class="login-input-wrap">
							<input placeholder="아이디를 입력하세요." name="userid" type="text"
								value="${param.userid}"></input>
						</div>
						<div class="login-input-wrap password-wrap">
							<input placeholder="비밀번호를 입력하세요." name="upw" type="password"></input>
						</div>
					</form>
					<div class="login-button-wrap">
						<button id="btnLogin" onclick="loginFunc()">로그인</button>
					</div>
					<br>
					<div class="text-right p-t-13 p-b-23">
						<span class="txt1"> </span> <a href="/member/idfind" class="txt2">아이디찾기</a>
						/ <a href="/member/passwordfind" class="txt2">비밀번호 찾기 </a>
					</div>

					<div class="flex-col-c p-t-170 p-b-40">
						<span class="txt1 p-b-9"> 계정이 없으십니까? </span> <a href="/member/join"
							class="txt3"> 회원가입 </a>
					</div>
			<%-- 	</c:if>--%>
				<c:if test="${login eq true}">
				 <h1>로그인 상태입니다.</h1><br>
				 <div class="login-button-wrap">
						<button onclick="location.href='index.do'">메인으로 바로가기</button>
					</div>
				</c:if>
			</section>

			<footer>
				<div class="copyright-wrap">
					<span> <img src="/resources/img/logo_red.png">
						Copyright © TTang TTang Corp. All Rights Reserved.
					</span>
				</div>
			</footer>
		</div>
	</div>
</body>


