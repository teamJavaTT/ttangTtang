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
<title>TTang TTang Market : 사용자 신고</title>
<link rel="stylesheet" type="text/css"
	href="/ttangTtang/css/mypage/deleteForm.css">

</head>
<body>
	<!-- header -->
	<div id="header">
		<a href="index.do"><img src="/ttangTtang/img/logo_red.png"
			width="500" height="172" alt=""></a>
	</div>

	<!-- wrapper -->
	<div id="wrapper">


		<!-- content-->
		<div id="content">
			<section class="content">
				<c:if test="${idChkOk == 0}">
					<script>
						alert("없는 사용자입니다")
					</script>
				</c:if>
				<c:if test="${idChkOk == 2}">
					<script>
						alert("자기 자신은 신고할 수 없습니다")
					</script>
				</c:if>
				<form action="accountDeclaration.do?no=1" method="post">
					<h4>사용자 신고</h4>
					<input type="text" class="title" placeholder="신고 대상" name="badid"
						id="badid" value="${param.badid}"> 
						<input type="submit" value="아이디 확인" name="chkIdBnt">
				</form>
				<c:if test="${idChkOk == 1}">
					<form action="accountDeclaration.do?no=2" method="post">
						<input type="hidden" value="${param.badid}" name="declId">
						<h4>신고 사유</h4>
						<textarea rows="10" cols="100%" placeholder="신고사유를 입력해주세요"
							name="dtext" id="dtext"></textarea>
						<!-- deleteFrom-->
						<div class="btn_area">
							<button type="submit" id="btnDelete" name="btnDelete">신고</button>
						</div>
					</form>
				</c:if>
				<div class="btn_area">
					<a href="mypage.do"> <input type="button" id="btnNo"
						value="취소하기">
					</a>
				</div>
			</section>
		</div>
	</div>
	<!-- wrapper -->
	<script src="/ttangTtang/js/mypage/accoundDeclaration.js"></script>
</body>
</html>




