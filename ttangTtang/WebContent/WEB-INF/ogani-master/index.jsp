<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="include/header.jsp"%>
<%@ include file="include/middle_header.jsp"%>
<script>
	var iNoArr = new Array();
	var endTimeArr = new Array();
	<c:forEach var="aucProduct" items="${mainPage.product}">
	<c:if test="${aucProduct.auctioncheck == 'Y'}">
	iNoArr.push("<c:out value='${aucProduct.ino}'/>");
	endTimeArr.push("<c:out value='${aucProduct.endtime}'/>");
	</c:if>
	</c:forEach>
</script>
<style>
.aucTimer {
	font-size: 15px;
}
</style>

<!-- Categories Section Begin -->
<section class="categories">
	<div class="container">
		<div class="row">
			<div class="categories__slider owl-carousel">
				<c:forEach var="productToday" items="${mainPage.productToday}">
					<div class="col-lg-3">
						<div class="categories__item set-bg"
							data-setbg="${productToday.imageface}" onclick="location.href='productDetail.do?ino=${productToday.ino}&aucChk=${productToday.auctioncheck}'">
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
			<c:forEach var="allProduct" items="${mainPage.product}">
				<div class="col-lg-3 col-md-4 col-sm-6 mix allProduct">
					<div class="featured__item"
						onclick="location.href='productDetail.do?ino=${allProduct.ino}&aucChk=${allProduct.auctioncheck}'">
						<div class="featured__item__pic set-bg"
							data-setbg="${allProduct.imageface}">
							<ul class="featured__item__pic__hover">
								<c:if test="${allProduct.auctioncheck == 'Y'}">
									<h3 class="aucTimer" id="all${allProduct.ino}"style="background-color: white;"></h3>
								</c:if>
								<li><a href="#"><i class="fa fa-heart"></i></a></li>
								<!-- <li><a href="#"><i class="fa fa-retweet"></i></a></li> 
								<li><a href="#"><i class="fa fa-shopping-cart"></i></a></li>-->
							</ul>
						</div>
						<div class="featured__item__text">
							<h6>
								<a href="#">${allProduct.iname}</a>
							</h6>
							<c:choose>
								<c:when test="${allProduct.auctioncheck != 'Y'}">
									<h5>${allProduct.price}원</h5>
								</c:when>
								<c:when test="${allProduct.auctioncheck == 'Y'}">
									<h5>현재가 ${allProduct.apricenow}원</h5>
								</c:when>
							</c:choose>
						</div>
					</div>
				</div>
			</c:forEach>
			<c:forEach var="norProduct" items="${mainPage.product}">
				<c:if test="${norProduct.auctioncheck == 'N'}">
					<div class="col-lg-3 col-md-4 col-sm-6 mix norProduct"
						style="display: none;">
						<div class="featured__item"
							onclick="location.href='productDetail.do?ino=${norProduct.ino}&aucChk=${norProduct.auctioncheck}'">
							<div class="featured__item__pic set-bg"
								data-setbg="${norProduct.imageface}">

								<ul class="featured__item__pic__hover">
									<li><a href="#"><i class="fa fa-heart"></i></a></li>
									<!-- <li><a href="#"><i class="fa fa-retweet"></i></a></li>
									<li><a href="#"><i class="fa fa-shopping-cart"></i></a></li> -->
								</ul>
							</div>
							<div class="featured__item__text">
								<h6>
									<a href="productDetail.do?ino=${norProduct.ino}">${norProduct.iname}</a>
								</h6>
								<h5>${norProduct.price}원</h5>
							</div>
						</div>
					</div>
				</c:if>
			</c:forEach>
			<c:forEach var="aucProduct" items="${mainPage.product}">
				<c:if test="${aucProduct.auctioncheck == 'Y'}">
					<div class="col-lg-3 col-md-4 col-sm-6 mix aucProduct"
						style="display: none;">
						<div class="featured__item"
							onclick="location.href='productDetail.do?ino=${aucProduct.ino}&aucChk=${aucProduct.auctioncheck}'">
							<div class="featured__item__pic set-bg"
								data-setbg="${aucProduct.imageface}">
								<ul class="featured__item__pic__hover">
									<h2 class="aucTimer" id="auc${aucProduct.ino}"style="background-color: white;"></h2>
									<li><a href="#"><i class="fa fa-heart"></i></a></li>
									<!-- <li><a href="#"><i class="fa fa-retweet"></i></a></li> 
									<li><a href="#"><i class="fa fa-shopping-cart"></i></a></li>-->
								</ul>
							</div>
							<div class="featured__item__text">
								<h6>
									<a href="productDetail.do?ino=${aucProduct.ino}">${aucProduct.iname}</a>
								</h6>
								<h5>현재가 ${aucProduct.apricenow}원</h5>
							</div>
						</div>
					</div>
				</c:if>
			</c:forEach>
			<c:forEach var="buyProduct" items="${mainPage.product}">
				<c:if test="${buyProduct.auctioncheck == 'B'}">
					<div class="col-lg-3 col-md-4 col-sm-6 mix buyProduct"
						style="display: none;">
						<div class="featured__item"
							onclick="location.href='productDetail.do?ino=${buyProduct.ino}'">
							<div class="featured__item__pic set-bg"
								data-setbg="${buyProduct.imageface}">
								<ul class="featured__item__pic__hover">
									<li><a href="#"><i class="fa fa-heart"></i></a></li>
									<!-- <li><a href="#"><i class="fa fa-retweet"></i></a></li> 
									<li><a href="#"><i class="fa fa-shopping-cart"></i></a></li>-->
								</ul>
							</div>
							<div class="featured__item__text">
								<h6>
									<a href="#">${buyProduct.iname}</a>
								</h6>
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

<script src="/ttangTtang/js/product/index.js"></script>
<%@ include file="include/footer.jsp"%>
