<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>
<%@ include file="../include/middle_header.jsp" %>

    <!-- Featured Section Begin -->
    <section class="featured spad" style="padding-top: 0px;">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="section-title">
						<c:forEach var="category" items="${category}">
							<c:if test="${category.ccode eq param.categories}">
								<h2>${category.cname}</h2>
							</c:if>
						</c:forEach>
                    </div>
                    <div class="featured__controls">
                        <ul>
                        	<c:forEach var="categories" items="${param.categories}">
                            	<c:if test="${categories != 'BUY'}">
	                            	<li data-filter=".allProduct" class="active">전체</li>
		                            <li data-filter=".norProduct">일반거래</li>
		                            <li data-filter=".aucProduct">경매</li>
	                            </c:if>
                            </c:forEach>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="row featured__filter">
				<c:forEach var="allProduct" items="${categoryProduct}">
	    			<div class="col-lg-3 col-md-4 col-sm-6 mix allProduct">
	                    <div class="featured__item">
	                        <div class="featured__item__pic set-bg" data-setbg="${allProduct.imageface}">
	                            <ul class="featured__item__pic__hover">
	                                <li><a href="#"><i class="fa fa-heart"></i></a></li>
	                                <!-- <li><a href="#"><i class="fa fa-retweet"></i></a></li> -->
	                                <li><a href="#"><i class="fa fa-shopping-cart"></i></a></li>
	                            </ul>
	                        </div>
	                        <div class="featured__item__text">
	                            <h6><a href="#">${allProduct.iname}</a></h6>
	                            <c:choose>
	                            	<c:when test="${allProduct.auctioncheck == 'B'}">
		                            	<h5>${allProduct.price}원</h5>
		                            </c:when>
		                            <c:when test="${allProduct.auctioncheck == 'N'}">
		                            	<h5>${allProduct.price}원</h5>
		                            </c:when>
		                            <c:when test="${allProduct.auctioncheck == 'Y'}">
		                            	<h5>${allProduct.minprice}원</h5>
		                            </c:when>
	                            </c:choose>
	                        </div>
	                    </div>
	                </div>
				</c:forEach>
				<c:forEach var="norProduct" items="${categoryProduct}">
	                <c:if test="${norProduct.auctioncheck == 'N'}">
		    			<div class="col-lg-3 col-md-4 col-sm-6 mix norProduct" style="display: none;">
		                    <div class="featured__item">
		                        <div class="featured__item__pic set-bg" data-setbg="${norProduct.imageface}">
		                            <ul class="featured__item__pic__hover">
		                                <li><a href="#"><i class="fa fa-heart"></i></a></li>
		                                <!-- <li><a href="#"><i class="fa fa-retweet"></i></a></li> -->
		                                <li><a href="#"><i class="fa fa-shopping-cart"></i></a></li>
		                            </ul>
		                        </div>
		                        <div class="featured__item__text">
		                            <h6><a href="#">${norProduct.iname}</a></h6>
		                            <h5>${norProduct.price}원</h5>
		                        </div>
		                    </div>
		                </div>
	                </c:if>
				</c:forEach>
				<c:forEach var="aucProduct" items="${categoryProduct}">
	                <c:if test="${aucProduct.auctioncheck == 'Y'}">
		    			<div class="col-lg-3 col-md-4 col-sm-6 mix aucProduct" style="display: none;">
		                    <div class="featured__item">
		                        <div class="featured__item__pic set-bg" data-setbg="${aucProduct.imageface}">
		                            <ul class="featured__item__pic__hover">
		                                <li><a href="#"><i class="fa fa-heart"></i></a></li>
		                                <!-- <li><a href="#"><i class="fa fa-retweet"></i></a></li> -->
		                                <li><a href="#"><i class="fa fa-shopping-cart"></i></a></li>
		                            </ul>
		                        </div>
		                        <div class="featured__item__text">
		                            <h6><a href="#">${aucProduct.iname}</a></h6>
		                            <h5>${aucProduct.minprice}원</h5>
		                        </div>
		                    </div>
		                </div>
	                </c:if>
				</c:forEach>
				<c:forEach var="buyProduct" items="${categoryProduct}">
	                <c:if test="${buyProduct.auctioncheck == 'B'}">
		    			<div class="col-lg-3 col-md-4 col-sm-6 mix buyProduct" style="display: none;">
		                    <div class="featured__item">
		                        <div class="featured__item__pic set-bg" data-setbg="${buyProduct.imageface}">
		                            <ul class="featured__item__pic__hover">
		                                <li><a href="#"><i class="fa fa-heart"></i></a></li>
		                                <!-- <li><a href="#"><i class="fa fa-retweet"></i></a></li> -->
		                                <li><a href="#"><i class="fa fa-shopping-cart"></i></a></li>
		                            </ul>
		                        </div>
		                        <div class="featured__item__text">
		                            <h6><a href="#">${buyProduct.iname}</a></h6>
		                            <h5>${buyProduct.price}원</h5>
		                        </div>
		                    </div>
		                </div>
	                </c:if>
				</c:forEach>
            </div>
        </div>
    </section>
    <!-- Featured Section End -->
    
<%@ include file="../include/footer.jsp" %>
