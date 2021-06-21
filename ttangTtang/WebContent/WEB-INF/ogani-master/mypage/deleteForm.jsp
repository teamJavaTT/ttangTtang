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
	href="/ttangTtang/css/mypage/deleteForm.css">

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
				<form action="deleteForm.do" method="post">


					<h4>회원 탈퇴 사유</h4>


					<textarea rows="10" cols="100%" placeholder="탈퇴사유를 입력해주세요"
						name="stext" id="stext"></textarea>



					<!-- PW1 -->
					<div>
						<h4 class="join_title">
							<label for="pswd1">비밀번호</label>
						</h4>
						<span class="box int_pass"> <input type="password"
							id="pswd1" name="upw" class="int" maxlength="20"> <span
							id="alertTxt">사용불가</span> <img
							src="/ttangTtang/img/login/m_icon_pass.png" id="pswd1_img1"
							class="pswdImg">
						</span> <span class="error_next_box"></span>
					</div>


					<!-- deleteFrom-->
					<div class="btn_area">
						<a href="/ttangTtang/index.do">
							<button type="submit" id="btnDelete" name="btnDelete">회원
								탈퇴</button>
						</a>
					</div>
					<div class="btn_area">
						<a href="/ttangTtang/ogani-master/mypage/mypage.jsp">
							<button type="submit" id="btnNo">취소하기</button>
						</a>
					</div>
					<!-- content-->
				</form>
			</section>
		</div>
	</div>
	<!-- wrapper -->
	<script src="/ttangTtang/js/mypage/deleteForm.js"></script>
</body>
</html>




