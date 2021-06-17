<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8");%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zxx">

<head>
    <meta charset="UTF-8">
    <meta name="description" content="Ogani Template">
    <meta name="keywords" content="Ogani, unica, creative, html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Ogani | Template</title>

    <!-- Google Font -->
    <link href="https://fonts.googleapis.com/css2?family=Cairo:wght@200;300;400;600;900&display=swap" rel="stylesheet">

    <!-- Css Styles -->
    <link rel="stylesheet" href="/ttangTtang/css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="/ttangTtang/css/font-awesome.min.css" type="text/css">
    <link rel="stylesheet" href="/ttangTtang/css/elegant-icons.css" type="text/css">
    <link rel="stylesheet" href="/ttangTtang/css/nice-select.css" type="text/css">
    <link rel="stylesheet" href="/ttangTtang/css/jquery-ui.min.css" type="text/css">
    <link rel="stylesheet" href="/ttangTtang/css/owl.carousel.min.css" type="text/css">
    <link rel="stylesheet" href="/ttangTtang/css/slicknav.min.css" type="text/css">
    <link rel="stylesheet" href="/ttangTtang/css/style.css" type="text/css">
    
    <script src="/ttangTtang/js/jquery-3.3.1.min.js"></script>
</head>

<body>
    <!-- Page Preloder -->
    <div id="preloder">
        <div class="loader"></div>
    </div>

    <!-- Humberger Begin -->
    <div class="humberger__menu__overlay"></div>
    <div class="humberger__menu__wrapper">
        <div class="humberger__menu__logo">
            <a href="#"><img src="/ttangTtang/img/logo_red.png" alt=""></a>
        </div>
        <div class="humberger__menu__cart">
            <ul>
                <li><a href="#"><i class="fa fa-heart"></i> <span>1</span></a></li>
                <li><a href="#"><i class="fa fa-shopping-bag"></i> <span>3</span></a></li>
               
            </ul>


            <div class="header__cart__price">item: <span>$150.00</span></div>


        </div>
        <div class="humberger__menu__widget">
            <div class="header__top__right__language">
                <img src="/ttangTtang/img/language.png" alt="">
                <div>English</div>
                <span class="arrow_carrot-down"></span>
                <ul>
                    <li><a href="#">Spanis</a></li>
                    <li><a href="#">English</a></li>
                </ul>
            </div>
            <div class="header__top__right__auth">
                <a href="#"><i class="fa fa-user"></i> 로그인</a>
            </div>
        </div>
        <nav class="humberger__menu__nav mobile-menu">
            <ul>
                <li class="active"><a href="index.do">Home</a></li>
                <li><a href="/ttangTtang/ogani-master/mypage/mypage.jsp">MYPAGE</a></li>
                <li><a href="adminmain.do"">Service</a></li>
            </ul>
        </nav>
        <div id="mobile-menu-wrap"></div>
        <div class="header__top__right__social">
            <a href="#"><i class="fa fa-facebook"></i></a>
            <a href="#"><i class="fa fa-twitter"></i></a>
            <a href="#"><i class="fa fa-linkedin"></i></a>
            <a href="#"><i class="fa fa-pinterest-p"></i></a>
        </div>
        <div class="humberger__menu__contact">
            <ul>
                <li><i class="fa fa-envelope"></i> hello@colorlib.com</li>
                <li>Free Shipping for all Order of $99</li>
            </ul>
        </div>
    </div>
    <!-- Humberger End -->

    <!-- Header Section Begin -->
    <header class="header">
        <div class="header__top">
            <div class="container">
                <div class="row">
                    <div class="col-lg-6 col-md-6">
                        <div class="header__top__left">
                            <ul>
                                <li><i class="fa fa-envelope"></i> hello@colorlib.com</li>
                                <li>Free Shipping for all Order of $99</li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-lg-6 col-md-6">
                        <div class="header__top__right">
                            <div class="header__top__right__auth">
                            	<c:choose>
	                            	<c:when test="${empty memberUser.uname}">
		                                <a href="login.do"><i class="fa fa-user"></i> 로그인</a>
	                                </c:when>
	                                <c:when test="${!empty memberUser.uname}">
	                                	<a href="memberEdit.do">${memberUser.uname}님 </a><a href="logout.do"><i class="fa fa-user"></i> 로그아웃</a>
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
                        <a href="index.do"><img src="/ttangTtang/img/logo_red.png" alt=""></a>
                    </div>
                </div>
                <div class="col-lg-4">
                    <nav class="header__menu">
                        <ul>
                            <li class="active"><a href="index.do">Home</a></li>
                            <li><a href="/ttangTtang/ogani-master/mypage/mypage.jsp">MYPAGE</a></li>
              				<li><a href="adminmain.do">Service</a></li>
                        </ul>
                    </nav>
                </div>
                <div class="col-lg-5">
                    <div class="header__cart">
                        <ul>
                        	<li><a href="aucProductWrite.do" style="color: black;"><i class="fa fa-buysellads"></i> 판매하기</a></li>
                            <li><a href="#"><i class="fa fa-heart"></i> <span>1</span></a></li>
                            <li><a href="#"><i class="fa fa-shopping-bag"></i> <span>3</span></a></li>
                            
                        </ul>
                    
                        <div class="header__cart__price">item: <span>$150.00</span></div>
                        	
                    </div>
                </div>
            </div>
            <div class="humberger__open">
                <i class="fa fa-bars"></i>
            </div>
        </div>
    </header>
    <!-- Header Section End -->
