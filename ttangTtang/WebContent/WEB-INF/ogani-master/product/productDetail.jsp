<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../include/header.jsp"%>
<%@ include file="../include/middle_header.jsp"%>
<!-- Breadcrumb Section Begin -->

<section class="breadcrumb-section set-bg"
	data-setbg="/ttangTtang/ogani-master/img/breadcrumb.jpg">
	<div class="container">
		<div class="row">
			<div class="col-lg-12 text-center">
				<div class="breadcrumb__text">

					<h2>${allPro.cname}</h2>
					<div class="breadcrumb__option">
						<a href="/ttangTtang/ogani-master/index.jsp">Home</a>
					</div>

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
			<div class="col-lg-6 col-md-6">
				<div class="product__details__pic">
					<div class="product__details__pic__item">
						<img class="product__details__pic__item--large" src="${allPro.imageface}" style="height:500px;">
					</div>
				</div>
			</div>
			<div class="col-lg-6 col-md-6">
				<div class="product__details__text">
					<h3>${allPro.iname }</h3>
					<c:choose>
						<c:when test="${allPro.auctioncheck=='Y'}">
							<div class="product__details__price"><span id="now_price">${allPro.apricenow}</span>&nbsp;원</div>
						</c:when>
						<c:when test="${allPro.auctioncheck=='N'}">
							<div class="product__details__price">
								<span>${allPro.price}원</span>
							</div>
						</c:when>
					</c:choose>
					<div class="product__details__quantity">
						<div class="quantity"></div>
					</div>

					<c:if test="${aucOk == 1}">
						<script>
							alert("가격 제시 성공");
						</script>
					</c:if>
					<c:if test="${user ne null}">
						<c:choose>
							<c:when test="${allPro.auctioncheck=='Y'}">
								<form action="auctionPart.do" name="auctionPart" method="post">
									<input type="hidden" name="aucIno" value="${allPro.ino}">
									<c:if test="${allPro.userid ne memberUser.userid}">
									<c:if test="${allPro.sellcheck eq 'N'}">
										<div class="product__details__quantity"> 가격제시
										<input type="text" name="oPrice" id="oPrice"> 
										<input type="button" class="btn btn-outline-dark" onclick="aucPricePart()" value="등록">
										</div>
										</c:if>
									</c:if>
								</form>
							</c:when>
							<c:when test="${allPro.auctioncheck == 'N'}">
								<input type="button" value="판매자와 연락하기" class="primary-btn"
									onclick="matchingwindow()" />
							</c:when>
						</c:choose>
						<button type="button" class="btn btn-outline-danger <c:if test="${iNo != 0}">active</c:if>"
							onclick="location.href='likeCount.do?ino=${allPro.ino}&aucChk=${allPro.auctioncheck}'">
							<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-heart" viewBox="0 0 16 16">
								<path d="m8 2.748-.717-.737C5.6.281 2.514.878 1.4 3.053c-.523 1.023-.641 2.5.314 4.385.92 1.815 2.834 3.989 6.286 6.357 3.452-2.368 5.365-4.542 6.286-6.357.955-1.886.838-3.362.314-4.385C13.486.878 10.4.28 8.717 2.01L8 2.748zM8 15C-7.333 4.868 3.279-3.04 7.824 1.143c.06.055.119.112.176.171a3.12 3.12 0 0 1 .176-.17C12.72-3.042 23.333 4.867 8 15z"></path>
							</svg>
							&nbsp;찜&nbsp;${allPro.likecount}
						</button>
					</c:if>
					<ul>
						<c:if test="${allPro.auctioncheck=='Y' }">
							<li><b>시작가격</b> <span id="minprice">${allPro.minprice}원</span></li>
							<li><b>남은시간</b> <span id="endtime">${allPro.endtime}</span></li>
						</c:if>
						<li><b>판매자</b><span>${allPro.userid}</span></li>
						<li><b>판매 지역</b><span>${allPro.uad}</span></li>
						<li><b>공유</b>
							<div class="share">
								<a href="#"><i class="fa fa-link"></i></a>
							</div></li>
						<li><b>조회수</b> <span id="view_count">${allPro.viewcount}</span>
						</li>
						<li><b>찜한 수</b><i class="fa fa-heart"></i>${allPro.likecount}</li>
					</ul>
					<c:if test="${memberUser.userid eq allPro.userid}">
						<input type="button" class="btn btn-outline-dark" value="상품수정"
							onclick="location.href='productModify.do?ino=${allPro.ino}&aucChk=${allPro.auctioncheck}'">

						<input type="hidden" value="${allPro.ino}" id="delNo">
						<input type="button" class="btn btn-outline-danger" value="삭제"
							onclick="productDel()" id="productDel" style="float: right;">
					</c:if>

				</div>

			</div>
			<div class="col-lg-12">
				<div class="product__details__tab">
					<ul class="nav nav-tabs" role="tablist">
						<li class="nav-item">
							<h3>상세설명</h3>
						</li>
					</ul>
					<div class="tab-content">
						<div class="tab-pane active" id="tabs-1" role="tabpanel">
							<div class="product__details__tab__desc">
								<h6>제품 설명</h6>
								<p>${allPro.pricetext}</p>
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
			<c:forEach var="productUser" items="${productUser}">
				<div class="col-lg-3 col-md-4 col-sm-6">
					<div class="product__item" onclick="location.href='productDetail.do?ino=${productUser.ino}&aucChk=${productUser.auctioncheck}'">
						<div class="product__item__pic set-bg" 
							data-setbg="${productUser.imageface}">
							<ul class="product__item__pic__hover">
								<li><a href="#"><i class="fa fa-heart"></i></a></li>
							</ul>
						</div>
						<div class="product__item__text">
							<h6>
								<a href="#">${productUser.iname}</a>
							</h6>
							<c:if test="${productUser.auctioncheck eq 'Y'}">
								<h5>${productUser.apricenow}원</h5>
							</c:if>
							<c:if test="${productUser.auctioncheck ne 'Y'}">
								<h5>${productUser.price}원</h5>
							</c:if>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
</section>
<!-- Related Product Section End -->
<script src="/ttangTtang/js/product/productDetail.js"></script>

<%@ include file="../include/footer.jsp"%>