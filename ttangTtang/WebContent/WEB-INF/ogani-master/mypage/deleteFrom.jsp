<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>TTang TTang Market : 회원탈퇴</title>
<link rel="stylesheet" type="text/css"
	href="/ttangTtang/css/login/deleteFrom.css">

</head>
<body>
	<!-- header -->
	<div id="header">
		<a href="#"><img src="/ttangTtang/img/logo_red.png" width="500"
			height="172" alt=""></a>
	</div>

	<!-- wrapper -->
	<div id="wrapper">

		<!-- content-->
		<div id="content">
			<section class="content">
				<form action="/ttangTtang/deleteFrom.do" method="post">

					<!-- ID -->
					<div>
						<h3 class="join_title">
							<label for="id">아이디</label>
						</h3>
						<span class="box int_id"> <input type="text" id="id"
							name="userid" class="int" maxlength="20">

						</span> <span class="error_next_box"></span>
					</div>

					<!-- PW1 -->
					<div>
						<h3 class="join_title">
							<label for="pswd1">비밀번호</label>
						</h3>
						<span class="box int_pass"> <input type="password"
							id="pswd1" name="upw" class="int" maxlength="20"> <span
							id="alertTxt">사용불가</span> <img
							src="/ttangTtang/img/login/m_icon_pass.png" id="pswd1_img1"
							class="pswdImg">
						</span> <span class="error_next_box"></span>
					</div>

					<!-- PW2 -->
					<div>
						<h3 class="join_title">
							<label for="pswd2">비밀번호 재확인</label>
						</h3>
						<span class="box int_pass_check"> <input type="password"
							id="pswd2" name="upw2" class="int" maxlength="20"> <img
							src="/ttangTtang/img/login/m_icon_check_disable.png"
							id="pswd2_img1" class="pswdImg">
						</span> <span class="error_next_box"></span>
					</div>

					<!-- deleteFrom-->
					
						<div class="btn_area">
							<button type="submit" id="btnJoin">회원 탈퇴</button> 
						</div>
					 <a href="/ttangTtang/ogani-master/mypage/mypage.do">
						<div class="btn_area">
							<button type="submit" id="btnJoin">취소하기</button>
						</div>
					</a>
					<!-- content-->
		</div>
	</div>
	<!-- wrapper -->
	<script src="/ttangTtang/js/mypage/deleteFrom.js"></script>
</body>
</html>









