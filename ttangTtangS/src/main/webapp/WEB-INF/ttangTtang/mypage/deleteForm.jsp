<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>TTang TTang Market : 회원탈퇴</title>
<link rel="stylesheet" type="text/css"
	href="/resources/css/mypage/deleteForm.css">
<script src="/resources/js/jquery-3.3.1.min.js"></script>

</head>
<body>

	<c:if test="${pwdNotMatch}">
		<script>
			alert("비밀번호가 일치하지 않습니다.");
		</script>
	</c:if>

	<!-- header -->
	<div id="header">
		<a href="index"><img src="/resources/img/logo_red.png" width="500"
			height="172" alt=""></a>
	</div>

	<!-- wrapper -->
	<div id="wrapper">


		<!-- content-->
		<div id="content">
			<section class="content">
				<form action="deleteForm" method="post" name="deleteForm">


					<h4>회원 탈퇴 사유</h4>


					<textarea rows="10" cols="100%" placeholder="탈퇴사유를 입력해주세요"
						name="stext" id="stext">${param.stext}</textarea>



					<!-- PW1 -->
					<div>
						<h4 class="join_title">
							<label for="pswd1">비밀번호</label>
						</h4>
						<span class="box int_pass"> <input type="password"
							id="pswd1" name="upw" class="int" maxlength="20"> <span
							id="alertTxt">사용불가</span> <img
							src="/resources/img/login/m_icon_pass.png" id="pswd1_img1"
							class="pswdImg">
						</span> <span class="error_next_box"></span>
					</div>


					<!-- deleteFrom-->
					<div class="btn_area">

						<button type="button" id="btnDelete" name="btnDelete">회원
							탈퇴</button>

					</div>
					<div class="btn_area">
						<a href="mypageMain"> <input type="button" id="btnNo"
							value="취소하기">
						</a>
					</div>

					<!-- content-->
				</form>
			</section>
		</div>
	</div>
	<!-- wrapper -->
	<script src="/resources/js/mypage/deleteForm.js"></script>
</body>
</html>




