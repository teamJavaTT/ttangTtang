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
<title>TTang TTang Market : 사용자 차단</title>
<link rel="stylesheet" type="text/css"
	href="/resources/css/mypage/deleteForm.css">

</head>
<body>
	<!-- header -->
	<div id="header">
		<a href="http://localhost:8082"><img
			src="/resources/img/logo_red.png" width="500" height="172" alt=""></a>
	</div>

	<!-- wrapper -->
	<div id="wrapper">


		<!-- content-->
		<div id="content">
			<section class="content">
				<c:if test="${idBlockOk == 0}">
					<script>
						alert("없는 사용자입니다")
					</script>
				</c:if>
				<c:if test="${idBlockOk == 2}">
					<script>
						alert("자기 자신은 차단할 수 없습니다")
					</script>
				</c:if>
				<c:if test="${idBlockOk == 3}">
					<script>
						alert("이미 차단된 사용자입니다.")
					</script>
				</c:if>
				<form action="blockUser?no=1" method="post">
					<h4>사용자 차단</h4>
					<input type="text" class="title" placeholder="차단 대상" name="blockid"
						id="blockid" value="${param.blockid}"> <input
						type="submit" value="아이디 확인" name="chkIdBnt">
				</form>
				<c:if test="${idBlockOk == 1}">
					<form action="blockUser?no=2" method="post">
						<input type="hidden" value="${param.blockid}" name="blockid2">
						<h4>차단 사유</h4>
						<textarea rows="10" cols="100%" placeholder="차단사유를 입력해주세요"
							name="btext" id="btext"></textarea>
						<!-- deleteFrom-->
						<div class="btn_area">
							<button type="submit" id="btnDelete" name="btnDelete">차단</button>
						</div>
					</form>
				</c:if>
				<div class="btn_area">
					<a href="mypage"> <input type="button" id="btnNo" value="취소하기">
					</a>
				</div>
			</section>
		</div>
	</div>
	<!-- wrapper -->
	<script src="/resources/js/mypage/accoundDeclaration.js"></script>
</body>
</html>




