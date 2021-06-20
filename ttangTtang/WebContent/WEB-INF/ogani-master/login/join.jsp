<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>TTang TTang Market : 회원가입</title>
<link rel="stylesheet" type="text/css"
	href="/ttangTtang/css/login/joinmain.css">
	<script src="/ttangTtang/js/jquery-3.3.1.min.js"></script>
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
				<form name="joinform" action="join.do" method="post">
				
					<input type="hidden" name="idCheck" id="idCheck">
					<!-- ID -->
					<div>
						<h3 class="join_title">
							<label for="id">아이디</label>
						</h3>
						<span class="box int_id"> <input type="text" id="id" name="userid" class="int" maxlength="20">
							<button type="button" id="idCheckBnt" style="position: absolute;right: 10px;top: 13px;display:none" onclick="idCheckFunc()">아이디 중복</button>
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

					<!-- EMAIL -->
					<div>
						<h3 class="join_title">
							<label for="email">이메일<span class="optional"></span></label>
						</h3>
						<span class="box int_email"> <input type="text" id="email"
							name="uemail" class="int" maxlength="100">
						</span> <span class="error_next_box"></span>
					</div>

					<!-- NAME -->
					<div>
						<h3 class="join_title">
							<label for="name">이름</label>
						</h3>
						<span class="box int_name"> <input type="text" id="name"
							name="uname" class="int" maxlength="20">
						</span> <span class="error_next_box"></span>
					</div>

					<!-- MOBILE -->
					<div>
						<h3 class="join_title">
							<label for="phoneNo">휴대전화</label>
						</h3>
						<span class="box int_mobile"> <input type="tel" id="mobile"
							name="phone" class="int" maxlength="16" placeholder="전화번호 입력">
						</span> <span class="error_next_box"></span>
					</div>

					<!-- GENDER -->
					<div>
						<h3 class="join_title">
							<label for="gender">성별</label>
						</h3>
						<span class="box gender_code"> <select id="gender"
							name="sex" class="sel">
								<option>성별</option>
								<option value="M">남자</option>
								<option value="F">여자</option>
						</select>
						</span> <span class="error_next_box">필수 정보입니다.</span>
					</div>
					<!-- JOIN BTN-->
					<div class="btn_area">
						<button type="button" id="btnJoin" onclick="joinFunc()">가입하기</button>
					</div>
				</form>
			</section>
		</div>
		<!-- content-->

	</div>

	<!-- wrapper -->
	<script src="/ttangTtang/js/login/joinmain.js"></script>
</body>
</html>









