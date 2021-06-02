<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>

    <!-- Hero Section Begin -->
    <section class="hero">
        <div class="container">
            <div class="row">
                <div class="col-lg-3">
                    <div class="hero__categories">
                        <div class="hero__categories__all">
                            <i class="fa fa-bars"></i>
                            <span>All departments</span>
                        </div>
                        <ul>
                            <li><a href="/ttangTtang/ogani-master/admin/notice.jsp">공지사항</a></li>
                        	<li><a href="/ttangTtang/ogani-master/admin/qna.jsp">Q&A</a></li>
							<li><a href="/ttangTtang/ogani-master/admin/faq.jsp">FAQ</a></li>
							<li><a href="/ttangTtang/ogani-master/admin/usersound.jsp">고객의 소리</a></li>
							<li><a href="/ttangTtang/ogani-master/admin/userlist">사용자 게시글 관리</a></li>
							<li><a href="/ttangTtang/ogani-master/admin/userinfo">사용자 회원정보 관리</a></li>
							<li><a href="/ttangTtang/ogani-master/admin/service">고객센터</a></li>
							<li><a href="/ttangTtang/ogani-master/admin/blacklist">블랙리스트관리</a></li>
							<li><a href="/ttangTtang/ogani-master/admin/declaration">신고 관리</a></li>
							<li><a href="/ttangTtang/ogani-master/admin/outuser">탈퇴회원 관리</a></li>
                        </ul>
                    </div>
                </div>
                <div class="col-lg-9">
                    <div class="hero__search">
                        <div class="hero__search__form">
                            <form action="#">
                                <div class="hero__search__categories">
                                    All Categories
                                    <span class="arrow_carrot-down"></span>
                                </div>
                                <input type="text" placeholder="What do yo u need?">
                                <button type="submit" class="site-btn">SEARCH</button>
                            </form>
                        </div>
                        <div class="hero__search__phone">
                            <div class="hero__search__phone__icon">
                                <i class="fa fa-phone"></i>
                            </div>
                            <div class="hero__search__phone__text">
                                <h5>+65 11.188.888</h5>
                                <span>support 24/7 time</span>
                            </div>
                        </div>
                    </div>
                    
                    <div class="hero__item set-bg" data-setbg="/ttangTtang/ogani-master/img/hero/banner.jpg">
                        <div class="hero__text">
                            <span>FRUIT FRESH</span>
                            <h2>Vegetable <br />100% Organic</h2>
                            <p>Free Pickup and Delivery Available</p>
                            <a href="#" class="primary-btn">SHOP NOW</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Hero Section End -->

   
    
<%@ include file="../include/footer.jsp" %>
