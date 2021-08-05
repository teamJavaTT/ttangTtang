<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="zxx">
<head>
<meta charset="UTF-8">
<meta name="description" content="Ogani Template">
<meta name="keywords" content="Ogani, unica, creative, html">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>누구나 쉬운 경매, 땅땅마켓</title>

<!-- Google Font -->
<link
	href="https://fonts.googleapis.com/css2?family=Cairo:wght@200;300;400;600;900&display=swap"
	rel="stylesheet">

<!-- Css Styles -->
<link rel="stylesheet" href="/resources/css/bootstrap.min.css"
	type="text/css">
<link rel="stylesheet" href="/resources/css/font-awesome.min.css"
	type="text/css">
<link rel="stylesheet" href="/resources/css/elegant-icons.css"
	type="text/css">
<link rel="stylesheet" href="/resources/css/nice-select.css"
	type="text/css">
<link rel="stylesheet" href="/resources/css/jquery-ui.min.css"
	type="text/css">
<link rel="stylesheet" href="/resources/css/owl.carousel.min.css"
	type="text/css">
<link rel="stylesheet" href="/resources/css/slicknav.min.css"
	type="text/css">
<link rel="stylesheet" href="/resources/css/style.css" type="text/css">

<script src="/resources/js/jquery-3.3.1.min.js"></script>
</head>
<script>
	const sessionUser = ${!empty memberUser};
</script>
<body>
	<!-- Page Preloder -->
	<div id="preloder">
		<div class="loader"></div>
	</div>

	<!-- Humberger Begin -->
	<div class="humberger__menu__overlay"></div>
	<div class="humberger__menu__wrapper">
		<div class="humberger__menu__logo">
			<a href="#"><img src="/resources/img/logo_red.png" alt=""></a>
		</div>
		<div class="humberger__menu__cart">
			<ul>
				<li><a href="/mypage/likeProduct"><i class="fa fa-heart"></i>
					<c:if test="${!empty memberUser.uname}">
						<span>${likeCount}</span>
					</c:if></a></li>
				<li><a href="/mypage/alimList"><i class="fa fa-bell"></i>
					<c:if test="${!empty alim}">
						<span>+</span>
					</c:if></a></li>
				<!-- <li><a href="#"><i class="fa fa-shopping-bag"></i> <span>3</span></a></li> -->

			</ul>
			<div class="header__top__right__auth" style="float: right;">
				<a href="/member/login"><i class="fa fa-user"></i> 로그인</a>
			</div>
		</div>
		<nav class="humberger__menu__nav mobile-menu">
			<ul>
				<li class="active"><a href="/">Home</a></li>
				<li><a href="/mypage/mypageMain">MYPAGE</a></li>
				<li><a href="/admin/adminmain"">Service</a></li>
			</ul>
		</nav>
		<div id="mobile-menu-wrap"></div>
	</div>
	<!-- Humberger End -->

	<!-- Header Section Begin -->
	<header class="header">
		<div class="header__top">
			<div class="container">
				<div class="row">
					<div class="col-lg-6 col-md-6"></div>
					<div class="col-lg-6 col-md-6">
						<div class="header__top__right">
							<div class="header__top__right__auth" style="display: flex;">
								<c:choose>
									<c:when test="${empty memberUser.uname}">
										<a href="/member/login" style="flex: 1;"><i
											class="fa fa-user"></i> 로그인</a>
									</c:when>
									<c:when test="${!empty memberUser.uname}">
										<a href="/mypage/mypageMain"
											style="flex: 1; margin-right: 15px;">${memberUser.uname}님
										</a>
										<a href="/member/logout"><i class="fa fa-user"></i>로그아웃</a>
									</c:when>
								</c:choose>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="container">
			<div class="row">
				<div class="col-lg-3">
					<div class="header__logo">
						<a href="/"><img src="/resources/img/logo_red.png" alt=""></a>
					</div>
				</div>
				<div class="col-lg-4">
					<nav class="header__menu">
						<ul>
							<li class="active"><a href="/">Home</a></li>
							<li><a href="/mypage/mypageMain">MYPAGE</a></li>
							<li><a href="/admin/adminmain">Service</a></li>
						</ul>
					</nav>
				</div>
				<div class="col-lg-5">
					<div class="header__cart">
						<ul>
							<li><a href="/product/productWrite"><i
									class="fa fa-buysellads"></i> 판매하기</a></li>
							<!-- onclick="sessionCheck()" -->
							<li><a href="/mypage/likeProduct"><i class="fa fa-heart"></i>
									<c:if test="${!empty memberUser.uname}">
										<span>${likeCount}</span>
									</c:if> </a></li>
							<li><a href="/mypage/alimList"><i class="fa fa-bell"></i>
									<c:if test="${!empty alim}">
										<span>+</span>
									</c:if> </a></li>
							<!-- <li><a href="#"><i class="fa fa-shopping-bag"></i> <span>3</span></a></li> -->
						</ul>
					</div>
				</div>
			</div>
			<div class="humberger__open">
				<i class="fa fa-bars"></i>
			</div>
		</div>
	</header>
	<!-- Header Section End -->
	<!-- Hero Section Begin -->
	<section class="hero hero-normal">
		<div class="container">
			<div class="row">
				<div class="col-lg-3">
					<div class="hero__categories">
						<div class="hero__categories__all">
							<i class="fa fa-bars"></i> <span>카테고리</span>
						</div>
						<ul>
							<c:forEach var="category" items="${category}">
								<li><a href="/categories/${category.ccode}">${category.cname}</a></li>
							</c:forEach>
						</ul>
					</div>
				</div>
				<div class="col-lg-9">
					<div class="hero__search">
						<div class="hero__search__form">
							<form action="/search">
								<input type="text" placeholder="상품명,지역명 입력" name="searchName"
									value="${param.searchName}">
								<button type="submit" class="site-btn">검색</button>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- Hero Section End -->