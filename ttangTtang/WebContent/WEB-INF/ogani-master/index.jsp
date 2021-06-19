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
							data-setbg="${productToday.imageface}">
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
						onclick="location.href='productDetail.do?ino=${allProduct.ino}'">
						<div class="featured__item__pic set-bg"
							data-setbg="${allProduct.imageface}">
							<ul class="featured__item__pic__hover">
								<c:if test="${allProduct.auctioncheck == 'Y'}">
									<h2 class="aucTimer" id="all${allProduct.ino}"></h2>
								</c:if>
								<li><a href="#"><i class="fa fa-heart"></i></a></li>
								<!-- <li><a href="#"><i class="fa fa-retweet"></i></a></li> -->
								<li><a href="#"><i class="fa fa-shopping-cart"></i></a></li>
							</ul>
						</div>
						<div class="featured__item__text">
							<h6>
								<a href="#">${allProduct.iname}</a>
							</h6>
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
			<c:forEach var="norProduct" items="${mainPage.product}">
				<c:if test="${norProduct.auctioncheck == 'N'}">
					<div class="col-lg-3 col-md-4 col-sm-6 mix norProduct"
						style="display: none;">
					<div class="featured__item"
						onclick="location.href='productDetail.do?ino=${norProduct.ino}'">
							<div class="featured__item__pic set-bg"
								data-setbg="${norProduct.imageface}">

								<ul class="featured__item__pic__hover">
									<li><a href="#"><i class="fa fa-heart"></i></a></li>
									<!-- <li><a href="#"><i class="fa fa-retweet"></i></a></li> -->
									<li><a href="#"><i class="fa fa-shopping-cart"></i></a></li>
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
						onclick="location.href='productDetail.do?ino=${aucProduct.ino}'">
							<div class="featured__item__pic set-bg"
								data-setbg="${aucProduct.imageface}">
								<ul class="featured__item__pic__hover">
									<h2 class="aucTimer" id="auc${aucProduct.ino}"></h2>
									<li><a href="#"><i class="fa fa-heart"></i></a></li>
									<!-- <li><a href="#"><i class="fa fa-retweet"></i></a></li> -->
									<li><a href="#"><i class="fa fa-shopping-cart"></i></a></li>
								</ul>
							</div>
							<div class="featured__item__text">
								<h6>
									<a href="productDetail.do?ino=${aucProduct.ino}">${aucProduct.iname}</a>
								</h6>
								<h5>${aucProduct.minprice}원</h5>
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
									<!-- <li><a href="#"><i class="fa fa-retweet"></i></a></li> -->
									<li><a href="#"><i class="fa fa-shopping-cart"></i></a></li>
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

<!-- Banner Begin -->
<div class="banner">
	<div class="container">
		<div class="row">
			<div class="col-lg-6 col-md-6 col-sm-6">
				<div class="banner__pic">
					<img src="/ttangTtang/img/banner/banner-1.jpg" alt="">
				</div>
			</div>
			<div class="col-lg-6 col-md-6 col-sm-6">
				<div class="banner__pic">
					<img src="/ttangTtang/img/banner/banner-2.jpg" alt="">
				</div>
			</div>
		</div>
	</div>
</div>
<!-- Banner End -->

<!-- Latest Product Section Begin -->
<section class="latest-product spad">
	<div class="container">
		<div class="row">
			<div class="col-lg-4 col-md-6">
				<div class="latest-product__text">
					<h4>Latest Products</h4>
					<div class="latest-product__slider owl-carousel">
						<div class="latest-prdouct__slider__item">
							<a href="#" class="latest-product__item">
								<div class="latest-product__item__pic">
									<img src="/ttangTtang/img/latest-product/lp-1.jpg" alt="">
								</div>
								<div class="latest-product__item__text">
									<h6>Crab Pool Security</h6>
									<span>$30.00</span>
								</div>
							</a> <a href="#" class="latest-product__item">
								<div class="latest-product__item__pic">
									<img src="/ttangTtang/img/latest-product/lp-2.jpg" alt="">
								</div>
								<div class="latest-product__item__text">
									<h6>Crab Pool Security</h6>
									<span>$30.00</span>
								</div>
							</a> <a href="#" class="latest-product__item">
								<div class="latest-product__item__pic">
									<img src="/ttangTtang/img/latest-product/lp-3.jpg" alt="">
								</div>
								<div class="latest-product__item__text">
									<h6>Crab Pool Security</h6>
									<span>$30.00</span>
								</div>
							</a>
						</div>
						<div class="latest-prdouct__slider__item">
							<a href="#" class="latest-product__item">
								<div class="latest-product__item__pic">
									<img src="/ttangTtang/img/latest-product/lp-1.jpg" alt="">
								</div>
								<div class="latest-product__item__text">
									<h6>Crab Pool Security</h6>
									<span>$30.00</span>
								</div>
							</a> <a href="#" class="latest-product__item">
								<div class="latest-product__item__pic">
									<img src="/ttangTtang/img/latest-product/lp-2.jpg" alt="">
								</div>
								<div class="latest-product__item__text">
									<h6>Crab Pool Security</h6>
									<span>$30.00</span>
								</div>
							</a> <a href="#" class="latest-product__item">
								<div class="latest-product__item__pic">
									<img src="/ttangTtang/img/latest-product/lp-3.jpg" alt="">
								</div>
								<div class="latest-product__item__text">
									<h6>Crab Pool Security</h6>
									<span>$30.00</span>
								</div>
							</a>
						</div>
					</div>
				</div>
			</div>
			<div class="col-lg-4 col-md-6">
				<div class="latest-product__text">
					<h4>Top Rated Products</h4>
					<div class="latest-product__slider owl-carousel">
						<div class="latest-prdouct__slider__item">
							<a href="#" class="latest-product__item">
								<div class="latest-product__item__pic">
									<img src="/ttangTtang/img/latest-product/lp-1.jpg" alt="">
								</div>
								<div class="latest-product__item__text">
									<h6>Crab Pool Security</h6>
									<span>$30.00</span>
								</div>
							</a> <a href="#" class="latest-product__item">
								<div class="latest-product__item__pic">
									<img src="/ttangTtang/img/latest-product/lp-2.jpg" alt="">
								</div>
								<div class="latest-product__item__text">
									<h6>Crab Pool Security</h6>
									<span>$30.00</span>
								</div>
							</a> <a href="#" class="latest-product__item">
								<div class="latest-product__item__pic">
									<img src="/ttangTtang/img/latest-product/lp-3.jpg" alt="">
								</div>
								<div class="latest-product__item__text">
									<h6>Crab Pool Security</h6>
									<span>$30.00</span>
								</div>
							</a>
						</div>
						<div class="latest-prdouct__slider__item">
							<a href="#" class="latest-product__item">
								<div class="latest-product__item__pic">
									<img src="/ttangTtang/img/latest-product/lp-1.jpg" alt="">
								</div>
								<div class="latest-product__item__text">
									<h6>Crab Pool Security</h6>
									<span>$30.00</span>
								</div>
							</a> <a href="#" class="latest-product__item">
								<div class="latest-product__item__pic">
									<img src="/ttangTtang/img/latest-product/lp-2.jpg" alt="">
								</div>
								<div class="latest-product__item__text">
									<h6>Crab Pool Security</h6>
									<span>$30.00</span>
								</div>
							</a> <a href="#" class="latest-product__item">
								<div class="latest-product__item__pic">
									<img src="/ttangTtang/img/latest-product/lp-3.jpg" alt="">
								</div>
								<div class="latest-product__item__text">
									<h6>Crab Pool Security</h6>
									<span>$30.00</span>
								</div>
							</a>
						</div>
					</div>
				</div>
			</div>
			<div class="col-lg-4 col-md-6">
				<div class="latest-product__text">
					<h4>Review Products</h4>
					<div class="latest-product__slider owl-carousel">
						<div class="latest-prdouct__slider__item">
							<a href="#" class="latest-product__item">
								<div class="latest-product__item__pic">
									<img src="/ttangTtang/img/latest-product/lp-1.jpg" alt="">
								</div>
								<div class="latest-product__item__text">
									<h6>Crab Pool Security</h6>
									<span>$30.00</span>
								</div>
							</a> <a href="#" class="latest-product__item">
								<div class="latest-product__item__pic">
									<img src="/ttangTtang/img/latest-product/lp-2.jpg" alt="">
								</div>
								<div class="latest-product__item__text">
									<h6>Crab Pool Security</h6>
									<span>$30.00</span>
								</div>
							</a> <a href="#" class="latest-product__item">
								<div class="latest-product__item__pic">
									<img src="/ttangTtang/img/latest-product/lp-3.jpg" alt="">
								</div>
								<div class="latest-product__item__text">
									<h6>Crab Pool Security</h6>
									<span>$30.00</span>
								</div>
							</a>
						</div>
						<div class="latest-prdouct__slider__item">
							<a href="#" class="latest-product__item">
								<div class="latest-product__item__pic">
									<img src="/ttangTtang/img/latest-product/lp-1.jpg" alt="">
								</div>
								<div class="latest-product__item__text">
									<h6>Crab Pool Security</h6>
									<span>$30.00</span>
								</div>
							</a> <a href="#" class="latest-product__item">
								<div class="latest-product__item__pic">
									<img src="/ttangTtang/img/latest-product/lp-2.jpg" alt="">
								</div>
								<div class="latest-product__item__text">
									<h6>Crab Pool Security</h6>
									<span>$30.00</span>
								</div>
							</a> <a href="#" class="latest-product__item">
								<div class="latest-product__item__pic">
									<img src="/ttangTtang/img/latest-product/lp-3.jpg" alt="">
								</div>
								<div class="latest-product__item__text">
									<h6>Crab Pool Security</h6>
									<span>$30.00</span>
								</div>
							</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>
<!-- Latest Product Section End -->

<!-- Blog Section Begin -->
<section class="from-blog spad">
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<div class="section-title from-blog__title">
					<h2>From The Blog</h2>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-lg-4 col-md-4 col-sm-6">
				<div class="blog__item">
					<div class="blog__item__pic">
						<img src="/ttangTtang/img/blog/blog-1.jpg" alt="">
					</div>
					<div class="blog__item__text">
						<ul>
							<li><i class="fa fa-calendar-o"></i> May 4,2019</li>
							<li><i class="fa fa-comment-o"></i> 5</li>
						</ul>
						<h5>
							<a href="#">Cooking tips make cooking simple</a>
						</h5>
						<p>Sed quia non numquam modi tempora indunt ut labore et
							dolore magnam aliquam quaerat</p>
					</div>
				</div>
			</div>
			<div class="col-lg-4 col-md-4 col-sm-6">
				<div class="blog__item">
					<div class="blog__item__pic">
						<img src="/ttangTtang/img/blog/blog-2.jpg" alt="">
					</div>
					<div class="blog__item__text">
						<ul>
							<li><i class="fa fa-calendar-o"></i> May 4,2019</li>
							<li><i class="fa fa-comment-o"></i> 5</li>
						</ul>
						<h5>
							<a href="#">6 ways to prepare breakfast for 30</a>
						</h5>
						<p>Sed quia non numquam modi tempora indunt ut labore et
							dolore magnam aliquam quaerat</p>
					</div>
				</div>
			</div>
			<div class="col-lg-4 col-md-4 col-sm-6">
				<div class="blog__item">
					<div class="blog__item__pic">
						<img src="/ttangTtang/img/blog/blog-3.jpg" alt="">
					</div>
					<div class="blog__item__text">
						<ul>
							<li><i class="fa fa-calendar-o"></i> May 4,2019</li>
							<li><i class="fa fa-comment-o"></i> 5</li>
						</ul>
						<h5>
							<a href="#">Visit the clean farm in the US</a>
						</h5>
						<p>Sed quia non numquam modi tempora indunt ut labore et
							dolore magnam aliquam quaerat</p>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>
<!-- Blog Section End -->
<script src="/ttangTtang/js/product/index.js"></script>
<%@ include file="include/footer.jsp"%>
