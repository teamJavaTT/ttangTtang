<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>

<link rel="stylesheet" href="/ttangTtang/css/mypage/mypagemain.css">

<!-- Hero Section Begin -->
<section class="hero">
	<div class="container">
		<div class="row">

			<!-- admin list -->
			<div class="col-lg-3">
				<div class="hero__categories">
					<div class="hero__categories__all">
						<i class="fa fa-bars"></i> <span>All departments</span>
					</div>
					<ul>
						<li><a href="memberEdit.do">회원정보 수정</a></li>
						<li><a href="likeProduct.do">관심상품</a></li>
						<li><a href="alimList.do">알림내역</a></li>
						<li><a href="sellcheck.do">내 판매 내역</a></li>
						<li><a href="accountDeclaration.do">사용자 신고</a></li>
						<li><a href="blockUser.do">사용자 차단</a></li>
						<li><a href="declarationAndBlockList.do">신고 및 차단 리스트</a></li>
						<li><a href="adminmain.do">고객 센터</a></li>
						<li><a href="deleteForm.do">회원탈퇴</a></li>
						
							
					</ul>
				</div>
			</div>

