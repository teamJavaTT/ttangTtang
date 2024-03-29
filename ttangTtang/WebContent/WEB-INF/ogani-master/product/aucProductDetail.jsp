<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<%@ include file="../include/middle_header.jsp"%>

<!-- Breadcrumb Section Begin -->
<section class="breadcrumb-section set-bg"
	data-setbg="/ttangTtang/img/breadcrumb.jpg">
	<div class="container">
		<div class="row">
			<div class="col-lg-12 text-center">
				<div class="breadcrumb__text">
				<c:forEach var="aucProduct" items="${aucPro}">
					<h2>${aucProduct.cname}</h2>
					<div class="breadcrumb__option">
						<a href="/ttangTtang/ogani-master/index.jsp">Home</a> 
				 <span>경매 상품</span> 
					</div>
					</c:forEach>
				</div>
			</div>
		</div>
	</div>
	
</section>
<!-- Breadcrumb Section End -->

<!-- Product Details Section Begin -->
<section class="product-details spad">
	<div class="container">
		<div class="row">
			<c:forEach var="aucProduct" items="${aucPro}">
			<div class="col-lg-6 col-md-6">
				<div class="product__details__pic" >
					<div class="product__details__pic__item" >
						<img class="product__details__pic__item--large"
							src="${aucProduct.imageface}"> 
					</div>
					<div
						class="product__details__pic__slider owl-carousel owl-loaded owl-drag">




						<div class="owl-stage-outer">
							<div class="owl-stage"
								style="transform: translate3d(-822px, 0px, 0px); transition: all 1.2s ease 0s; width: 1410px;">
								<div class="owl-item cloned"
									style="width: 97.5px; margin-right: 20px;">
									<img
										data-imgbigurl="/ttangTtang/ogani-master/img/product/details/product-details-2.jpg"
										src="/ttangTtang/ogani-master/img/product/details/thumb-1.jpg"
										alt="">
								</div>
								<div class="owl-item cloned"
									style="width: 97.5px; margin-right: 20px;">
									<img
										data-imgbigurl="/ttangTtang/ogani-master/img/product/details/product-details-3.jpg"
										src="/ttangTtang/ogani-master/img/product/details/thumb-2.jpg"
										alt="">
								</div>
								<div class="owl-item cloned"
									style="width: 97.5px; margin-right: 20px;">
									<img
										data-imgbigurl="/ttangTtang/ogani-master/img/product/details/product-details-5.jpg"
										src="/ttangTtang/ogani-master/img/product/details/thumb-3.jpg"
										alt="">
								</div>
								<div class="owl-item cloned"
									style="width: 97.5px; margin-right: 20px;">
									<img
										data-imgbigurl="/ttangTtang/ogani-master/img/product/details/product-details-4.jpg"
										src="/ttangTtang/ogani-master/img/product/details/thumb-4.jpg"
										alt="">
								</div>
								<div class="owl-item" style="width: 97.5px; margin-right: 20px;">
									<img
										data-imgbigurl="/ttangTtang/ogani-master/img/product/details/product-details-2.jpg"
										src="/ttangTtang/ogani-master/img/product/details/thumb-1.jpg"
										alt="">
								</div>
								<div class="owl-item" style="width: 97.5px; margin-right: 20px;">
									<img
										data-imgbigurl="/ttangTtang/ogani-master/img/product/details/product-details-3.jpg"
										src="/ttangTtang/ogani-master/img/product/details/thumb-2.jpg"
										alt="">
								</div>
								<div class="owl-item" style="width: 97.5px; margin-right: 20px;">
									<img
										data-imgbigurl="/ttangTtang/ogani-master/img/product/details/product-details-5.jpg"
										src="/ttangTtang/ogani-master/img/product/details/thumb-3.jpg"
										alt="">
								</div>
								<div class="owl-item active"
									style="width: 97.5px; margin-right: 20px;">
									<img
										data-imgbigurl="/ttangTtang/ogani-master/img/product/details/product-details-4.jpg"
										src="/ttangTtang/ogani-master/img/product/details/thumb-4.jpg"
										alt="">
								</div>
								<div class="owl-item cloned active"
									style="width: 97.5px; margin-right: 20px;">
									<img
										data-imgbigurl="/ttangTtang/ogani-master/img/product/details/product-details-2.jpg"
										src="/ttangTtang/ogani-master/img/product/details/thumb-1.jpg"
										alt="">
								</div>
								<div class="owl-item cloned active"
									style="width: 97.5px; margin-right: 20px;">
									<img
										data-imgbigurl="/ttangTtang/ogani-master/img/product/details/product-details-3.jpg"
										src="/ttangTtang/ogani-master/img/product/details/thumb-2.jpg"
										alt="">
								</div>
								<div class="owl-item cloned active"
									style="width: 97.5px; margin-right: 20px;">
									<img
										data-imgbigurl="/ttangTtang/ogani-master/img/product/details/product-details-5.jpg"
										src="/ttangTtang/ogani-master/img/product/details/thumb-3.jpg"
										alt="">
								</div>
								<div class="owl-item cloned"
									style="width: 97.5px; margin-right: 20px;">
									<img
										data-imgbigurl="/ttangTtang/ogani-master/img/product/details/product-details-4.jpg"
										src="/ttangTtang/ogani-master/img/product/details/thumb-4.jpg"
										alt="">
								</div>
							</div>
						</div>
						<div class="owl-nav disabled">
							<button type="button" role="presentation" class="owl-prev">
								<span aria-label="Previous">‹</span>
							</button>
							<button type="button" role="presentation" class="owl-next">
								<span aria-label="Next">›</span>
							</button>
						</div>
						<div class="owl-dots disabled">
							<button role="button" class="owl-dot active">
								<span></span>
							</button>
						</div>
					</div>
				</div>
			</div>
			</c:forEach>
			<div class="col-lg-6 col-md-6">
			<c:forEach var="aucProduct" items="${aucPro}">
				 <c:if test="${aucProduct.auctioncheck == 'Y'}">
				<div class="product__details__text">
					<h3>${aucProduct.iname }</h3>
					<div class="product__details__price" id="now_price">${aucProduct.apricenow}</div>
					<p>${aucProduct.pricetext}</p>
					<div class="product__details__quantity">
						가격제시 <input type="text"><input type="button" value="등록">
					</div>
					<a href="#" class="heart-icon"><span class="icon_heart_alt"></span></a>
					<ul>
					
						<li><b>시작가격</b> <span id="minprice">${aucProduct.minprice}</span></li>
						<li><b>남은시간</b> <span id="endtime">${aucProduct.endtime }</span></li>
						<li><b>판매자</b> <span>${aucProduct.userid}</span></li>
						<li><b>공유</b>
							<div class="share">
								<a href="#"><i class="fa fa-link"></i></a>
							</div></li>
						<li><b>조회수</b>
							<div id="view_count">
								<!--  -->
							</div></li>
					</ul>
				</div>
			</c:if>
			</c:forEach>
			</div>
			<div class="col-lg-12">
				<div class="product__details__tab">
					<ul class="nav nav-tabs" role="tablist">
						<li class="nav-item"><a class="nav-link active"
							data-toggle="tab" href="#tabs-1" role="tab" aria-selected="true">상세설명</a>
						</li>

					</ul>
					<div class="tab-content">
						<div class="tab-pane active" id="tabs-1" role="tabpanel">
							<div class="product__details__tab__desc">
								<h6>Products Infomation</h6>
								<p>제품 설명</p>
							</div>
						</div>
						<div class="tab-pane" id="tabs-2" role="tabpanel">
							<div class="product__details__tab__desc">
								<h6>Products Infomation</h6>
								<p>제품 설명</p>
							</div>
						</div>
						<div class="tab-pane" id="tabs-3" role="tabpanel">
							<div class="product__details__tab__desc">
								<h6>Products Infomation</h6>
								<p>제품 설명</p>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>
<!-- Product Details Section End -->

<!-- Related Product Section Begin -->
<section class="related-product">
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<div class="section-title related__product__title">
					<h2>판매자의 다른 판매 상품</h2>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-lg-3 col-md-4 col-sm-6">
				<div class="product__item">
					<div class="product__item__pic set-bg"
						data-setbg="img/product/product-1.jpg">
						<ul class="product__item__pic__hover">
							<li><a href="#"><i class="fa fa-heart"></i></a></li>
							<li><a href="#"><i class="fa fa-shopping-cart"></i></a></li>
						</ul>
					</div>
					<div class="product__item__text">
						<h6>
							<a href="#">Crab Pool Security</a>
						</h6>
						<h5>$30.00</h5>
					</div>
				</div>
			</div>
			<div class="col-lg-3 col-md-4 col-sm-6">
				<div class="product__item">
					<div class="product__item__pic set-bg"
						data-setbg="img/product/product-2.jpg">
						<ul class="product__item__pic__hover">
							<li><a href="#"><i class="fa fa-heart"></i></a></li>
							<li><a href="#"><i class="fa fa-shopping-cart"></i></a></li>
						</ul>
					</div>
					<div class="product__item__text">
						<h6>
							<a href="#">Crab Pool Security</a>
						</h6>
						<h5>$30.00</h5>
					</div>
				</div>
			</div>
			<div class="col-lg-3 col-md-4 col-sm-6">
				<div class="product__item">
					<div class="product__item__pic set-bg"
						data-setbg="img/product/product-3.jpg">
						<ul class="product__item__pic__hover">
							<li><a href="#"><i class="fa fa-heart"></i></a></li>
							<li><a href="#"><i class="fa fa-retweet"></i></a></li>
							<li><a href="#"><i class="fa fa-shopping-cart"></i></a></li>
						</ul>
					</div>
					<div class="product__item__text">
						<h6>
							<a href="#">Crab Pool Security</a>
						</h6>
						<h5>$30.00</h5>
					</div>
				</div>
			</div>
			<div class="col-lg-3 col-md-4 col-sm-6">
				<div class="product__item">
					<div class="product__item__pic set-bg"
						data-setbg="img/product/product-7.jpg">
						<ul class="product__item__pic__hover">
							<li><a href="#"><i class="fa fa-heart"></i></a></li>
							<li><a href="#"><i class="fa fa-retweet"></i></a></li>
							<li><a href="#"><i class="fa fa-shopping-cart"></i></a></li>
						</ul>
					</div>
					<div class="product__item__text">
						<h6>
							<a href="#">Crab Pool Security</a>
						</h6>
						<h5>$30.00</h5>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>
<!-- Related Product Section End -->

<%@ include file="../include/footer.jsp"%>