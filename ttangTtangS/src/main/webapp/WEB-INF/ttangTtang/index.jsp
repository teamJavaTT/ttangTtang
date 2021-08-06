<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="include/header.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script>
	var likeproductArr = new Array();
	<c:forEach var="likeproduct" items="${likeproduct}">
		likeproductArr.push("<c:out value='${likeproduct}'/>");
	</c:forEach>
	
	var iNoArr = new Array();
	var endTimeArr = new Array();
	<c:forEach var="aucProduct" items="${product}">
		<c:if test="${aucProduct.auctioncheck == 'Y'}">
			iNoArr.push("<c:out value='${aucProduct.ino}'/>");
			endTimeArr.push("<fmt:formatDate value='${aucProduct.endtime}' pattern='yyyy-MM-dd HH:mm:ss'/>");
		</c:if>
	</c:forEach>
</script>

<!-- Categories Section Begin -->
<section class="categories">
	<div class="container">
		<div class="row">
			<div class="categories__slider owl-carousel">
				<c:forEach var="productToday" items="${productToday}">
					<div class="col-lg-3">
						<div class="categories__item set-bg"
							data-setbg="${productToday.imageface1}"
							onclick="location.href='/product/productDetail?ino=${productToday.ino}&aucChk=${productToday.auctioncheck}'">
							<h5>
								<a href="#">${productToday.iname}</a>
							</h5>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
</section>
<!-- Categories Section End -->

<!-- Featured Section Begin -->
<section class="featured spad">
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<div class="section-title">
					<h2>상품보기</h2>
				</div>
				<div class="featured__controls">
					<ul>
						<li data-filter=".allProduct" class="active">전체</li>
						<li data-filter=".norProduct">일반거래</li>
						<li data-filter=".aucProduct">경매</li>
						<li data-filter=".buyProduct">삽니다</li>
					</ul>
				</div>
			</div>
		</div>
		<div class="row featured__filter">
			<c:forEach var="allProduct" items="${product}">
				<div class="col-lg-3 col-md-4 col-sm-6 mix allProduct">
					<div class="featured__item" onclick="location.href='/product/productDetail?ino=${allProduct.ino}&aucChk=${allProduct.auctioncheck}'">
						<div class="featured__item__pic set-bg" data-setbg="${allProduct.imageface1}">
							<c:if test="${allProduct.auctioncheck == 'Y'}">
								<h3 class="aucTimer" id="all${allProduct.ino}"></h3>
							</c:if>
							<ul class="featured__item__pic__hover">
								<c:if test="${memberUser.userid ne allProduct.userid}">
									<li class="like${allProduct.ino}" onclick="likeProductFunc(${allProduct.ino})"><a href="#"><i class="fa fa-heart"></i></a></li>
								</c:if>
							</ul>
						</div>
						<div class="featured__item__text">
							<h6>
								<a href="#">${allProduct.iname}</a>
							</h6>
							<c:choose>
								<c:when test="${allProduct.auctioncheck != 'Y'}">
									<h5>
										<fmt:formatNumber pattern="#,###" value="${allProduct.price}" />원
									</h5>
								</c:when>
								<c:when test="${allProduct.auctioncheck == 'Y'}">
									<h5>
										현재가 <fmt:formatNumber pattern="#,###" value="${allProduct.apricenow}" />원
									</h5>
								</c:when>
							</c:choose>
						</div>
					</div>
				</div>
			</c:forEach>
			<c:forEach var="norProduct" items="${product}">
				<c:if test="${norProduct.auctioncheck == 'N'}">
					<div class="col-lg-3 col-md-4 col-sm-6 mix norProduct"
						style="display: none;">
						<div class="featured__item"
							onclick="location.href='/product/productDetail?ino=${norProduct.ino}&aucChk=${norProduct.auctioncheck}'">
							<div class="featured__item__pic set-bg" data-setbg="${norProduct.imageface1}">
								<ul class="featured__item__pic__hover">
									<c:if test="${memberUser.userid ne norProduct.userid}">
										<li class="like${norProduct.ino}" onclick="likeProductFunc(${norProduct.ino})"><a href="#"><i class="fa fa-heart"></i></a></li>
									</c:if>
								</ul>
							</div>
							<div class="featured__item__text">
								<h6>
									<a href="productDetail?ino=${norProduct.ino}">${norProduct.iname}</a>
								</h6>
								<h5>
									<fmt:formatNumber pattern="#,###" value="${norProduct.price}" />원
								</h5>
							</div>
						</div>
					</div>
				</c:if>
			</c:forEach>
			<c:forEach var="aucProduct" items="${product}">
				<c:if test="${aucProduct.auctioncheck == 'Y'}">
					<div class="col-lg-3 col-md-4 col-sm-6 mix aucProduct"
						style="display: none;">
						<div class="featured__item"
							onclick="location.href='/product/productDetail?ino=${aucProduct.ino}&aucChk=${aucProduct.auctioncheck}'">
							<div class="featured__item__pic set-bg" data-setbg="${aucProduct.imageface1}">
								<h3 class="aucTimer" id="auc${aucProduct.ino}"></h3>
								<ul class="featured__item__pic__hover">
									<c:if test="${memberUser.userid ne aucProduct.userid}">
										<li class="like${aucProduct.ino}" onclick="likeProductFunc(${aucProduct.ino})"><a href="#"><i class="fa fa-heart"></i></a></li>
									</c:if>
								</ul>
							</div>
							<div class="featured__item__text">
								<h6>
									<a href="/product/productDetail?ino=${aucProduct.ino}">${aucProduct.iname}</a>
								</h6>
								<h5>
									현재가 <fmt:formatNumber pattern="#,###" value="${aucProduct.apricenow}" />원
								</h5>
							</div>
						</div>
					</div>
				</c:if>
			</c:forEach>
			<c:forEach var="buyProduct" items="${product}">
				<c:if test="${buyProduct.auctioncheck == 'B'}">
					<div class="col-lg-3 col-md-4 col-sm-6 mix buyProduct"
						style="display: none;">
						<div class="featured__item"
							onclick="location.href='/product/productDetail?ino=${buyProduct.ino}'">
							<div class="featured__item__pic set-bg"
								data-setbg="${buyProduct.imageface1}">
								<ul class="featured__item__pic__hover">
									<c:if test="${memberUser.userid ne buyProduct.userid}">
										<li class="like${buyProduct.ino}" onclick="likeProductFunc(${buyProduct.ino})"><a href="#"><i class="fa fa-heart"></i></a></li>
									</c:if>
								</ul>
							</div>
							<div class="featured__item__text">
								<h6>
									<a href="#">${buyProduct.iname}</a>
								</h6>
								<h5>
									<fmt:formatNumber pattern="#,###" value="${buyProduct.price}" />원
								</h5>
							</div>
						</div>
					</div>
				</c:if>
			</c:forEach>
		</div>
	</div>
</section>
<!-- Featured Section End -->

<script src="/resources/js/product/index.js"></script>
<%@ include file="include/footer.jsp"%>
