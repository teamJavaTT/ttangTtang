<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>TTang TTang Market : 회원가입</title>
<link rel="stylesheet" type="text/css" href="css/deleteFrommain.css">
</head>
<body>
	<!-- header -->
	<div id="header">
		<a href="#"><img src="../img/logo_red.png" width="500"
			height="172" alt=""></a>
	</div>


	<!-- wrapper -->
	<div id="wrapper">

		<!-- content-->
		<div id="content">

			<!-- ID -->
			<div>
				<h3 class="join_title">
					<label for="id">아이디</label>
				</h3>
				<span class="box int_id"> <input type="text" id="id"
					class="int" maxlength="20">

				</span> <span class="error_next_box"></span>
			</div>

			<!-- PW1 -->
			<div>
				<h3 class="join_title">
					<label for="pswd1">비밀번호</label>
				</h3>
				<span class="box int_pass"> <input type="text" id="pswd1"
					class="int" maxlength="20"> <span id="alertTxt">사용불가</span>
					<img src="../login/images/m_icon_pass.png" id="pswd1_img1"
					class="pswdImg">
				</span> <span class="error_next_box"></span>
			</div>

			<!-- PW2 -->
			<div>
				<h3 class="join_title">
					<label for="pswd2">비밀번호 재확인</label>
				</h3>
				<span class="box int_pass_check"> <input type="text"
					id="pswd2" class="int" maxlength="20"> <img
					src="../login/images/m_icon_check_disable.png" id="pswd2_img1"
					class="pswdImg">
				</span> <span class="error_next_box"></span>
			</div>




			<!-- WITHDRAWAL BTN-->
			<a href="/ttangTtang/ogani-master/index.jsp">
				<div class="btn_area">
					<button type="button" id="btnJoin">
						<span>회원탈퇴</span>
					</button>
				</div>
			</a>
			
			
			<!-- WITHDRAWAL BTN-->
			<a href="/ttangTtang/ogani-master/mypage/mypage.jsp">
				<div class="btn_area">
					<button type="button" id="btnJoin" onclick="goBack()">
						<span>취소</span>
					</button>
				</div>
			</a>
		</div>
		<!-- content-->

	</div>
	<!-- wrapper -->
	<script src="js/joinmain.js"></script>
</body>
</html>









