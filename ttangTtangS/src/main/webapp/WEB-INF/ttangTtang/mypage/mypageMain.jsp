<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<link rel="stylesheet" href="/resources/css/mypage/mypagemain.css">

<!-- Hero Section Begin -->
<section class="hero">
	<div class="container">
		<div class="row">
			<!-- admin list -->
			<div class="col-lg-3">
				<div class="hero__categories">
					<ul><%@ include file="mypageMenuList.jsp"%></ul>
				</div>
			</div>

			<div class="col-lg-9">
				<h2>Mypage</h2>
				<div style="text-align: center;">
					<img src="/resources/ogani-master/img/logo_red.png" width="50%"
						alt="">
					<p>마이페이지에 오신것을 환영합니다!!</p>

				</div>
				<div style="text-align: center;">
					<div style="text-align: center; margin-bottom: 100px;">

						<input type="button" value="회원정보 수정" class="primary-btn"
							onclick="location.href='/member/memberEdit'"> <input
							type="button" value="관심상품" class="primary-btn"
							onclick="location.href='likeProduct'"> <input
							type="button" value="내 판매 내역" class="primary-btn"
							onclick="location.href='sellcheck'"> <input type="button"
							value="사용자 신고" class="primary-btn"
							onclick="location.href='accountDeclaration'"> <br> <br>
						<input type="button" value="사용자 차단" class="primary-btn"
							onclick="location.href='blockUser'"> <input type="button"
							value="신고 및 차단 리스트" class="primary-btn"
							onclick="location.href='declarationAndBlockList'"> <input
							type="button" value="고객 센터" class="primary-btn"
							onclick="location.href='adminmain'"> <input type="button"
							value="회원탈퇴" class="primary-btn"
							onclick="location.href='deleteForm'">


					</div>

				</div>
			</div>
		</div>
	</div>
</section>

<script src="/resources/js/mypage/deleteFrom.js"></script>
<%@ include file="../include/footer.jsp"%>