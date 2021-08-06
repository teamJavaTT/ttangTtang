<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script>
	var auctionChk = "${allPro.auctioncheck}";
	var date = "<fmt:formatDate value='${allPro.endtime}' pattern='yyyy-MM-dd HH:mm:ss'/>";
</script>
<style>
div.product__details__pic__item {
	position: relative;
	overflow: hidden;
	height: 550px;
}

div.product__details__pic__item img {
	position: absolute;
	width: 100%;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
}

div.product__details__pic__item span {
    position: absolute;
    height: 100%;
    width: 100%;
    font-size: 3em;
    color: white;
    text-align: center;
    padding-top: 43%;
    z-index: 9999;
    background-color: rgba(0,0,0,0.3);
}

div.owl-item {
	position: relative;
	overflow: hidden;
	height: 125px;
	margin-right: 20px;
}

div.owl-item img {
	position: absolute;
	width: 100%;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
}

div#detailMenu{
	position: relative;
}

div#detailMenu ul{
    position: absolute;
    right: 0;
}

div#detailMenu ul li{
	float:left;
	margin-right: 10px;
	list-style: none;
}
</style>

<!-- Breadcrumb Section Begin -->

<section class="breadcrumb-section set-bg"
	data-setbg="/resources/img/breadcrumb.jpg">
	<div class="container">
		<div class="row">
			<div class="col-lg-12 text-center">
				<div class="breadcrumb__text">
					<h2>
						<a style="color: white;" href="/categories/${allPro.ccode}">${allPro.cname}</a>
					</h2>
				</div>
			</div>
		</div>
	</div>
</section>
<!-- Breadcrumb Section End -->
<c:if test="${aucOk eq false}">
	<script>
		alert("현재가보다 높은 금액만 제시할 수 있습니다.");
	</script>
</c:if>
<c:if test="${aucOk eq true}">
	<script>
		alert("가격 제시 성공!");
	</script>
</c:if>
<!-- Product Details Section Begin -->
<section class="product-details spad">
	<div class="container">
		<div class="row">
			<div class="col-lg-6 col-md-6">
				<div class="product__details__pic">
					<div class="product__details__pic__item">
						<img class="product__details__pic__item--large" src="${allPro.imageface1}">
						<c:if test="${allPro.sellcheck=='Y'}">
							<span style="position: absolute;">판매완료</span>
						</c:if>
					</div>
					<div class="product__details__pic__slider owl-carousel owl-loaded">
						<div class="owl-stage-outer">
							<div class="owl-stage">
								<c:if test="${!empty allPro.imageface1}">
									<div class="owl-item">
										<img data-imgbigurl="${allPro.imageface1}"
											src="${allPro.imageface1}" alt="">
									</div>
								</c:if>
								<c:if test="${!empty allPro.imageface2}">
									<div class="owl-item">
										<img data-imgbigurl="${allPro.imageface2}"
											src="${allPro.imageface2}" alt="">
									</div>
								</c:if>
								<c:if test="${!empty allPro.imageface3}">
									<div class="owl-item">
										<img data-imgbigurl="${allPro.imageface3}"
											src="${allPro.imageface3}" alt="">
									</div>
								</c:if>
								<c:if test="${!empty allPro.imageface4}">
									<div class="owl-item">
										<img data-imgbigurl="${allPro.imageface4}"
											src="${allPro.imageface4}" alt="">
									</div>
								</c:if>
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

			<div class="col-lg-6 col-md-6">
				<div class="product__details__text">
					<h3>${allPro.iname }</h3>
					<div class="product__details__price">
						<c:choose>
							<c:when test="${allPro.auctioncheck=='Y'}">
								<span style="font-size: 50px;" id="now_price"><fmt:formatNumber value="${allPro.apricenow}" pattern="#,###" /></span>&nbsp;원
							</c:when>
							<c:when test="${allPro.auctioncheck=='N'}">
								<span style="font-size: 50px;"><fmt:formatNumber pattern="#,###" value="${allPro.price}" /></span>&nbsp;원
							</c:when>
						</c:choose>
					</div>
					<div>
						<c:if test="${memberUser.userid ne allPro.userid}">
							<button type="button" id="likeBtn"class="btn btn-outline-danger <c:if test="${iNo!= 0}">active</c:if>" 
							onclick="likeProductFunc(${allPro.ino})" style="float:left;margin-right:15px;margin-bottom: 10px;">
								<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-heart" viewBox="0 0 16 16">
									<path d="m8 2.748-.717-.737C5.6.281 2.514.878 1.4 3.053c-.523 1.023-.641 2.5.314 4.385.92 1.815 2.834 3.989 6.286 6.357 3.452-2.368 5.365-4.542 6.286-6.357.955-1.886.838-3.362.314-4.385C13.486.878 10.4.28 8.717 2.01L8 2.748zM8 15C-7.333 4.868 3.279-3.04 7.824 1.143c.06.055.119.112.176.171a3.12 3.12 0 0 1 .176-.17C12.72-3.042 23.333 4.867 8 15z"></path>
								</svg>
								&nbsp;찜&nbsp;<span class="likeCount">${allPro.likecount}</span>
							</button>
						</c:if>
						<form action="/product/auctionPart" name="auctionPart" method="post">
							<div class="product__details__quantity">
								<c:if test="${user ne null}">
									<c:choose>
										<c:when test="${allPro.auctioncheck=='Y'}">
											<input type="hidden" name="aucIno" value="${allPro.ino}">
											<c:if test="${allPro.userid ne memberUser.userid}">
												<c:if test="${allPro.sellcheck eq 'N'}">
													<input type="text" name="oPrice" id="oPrice" style=" height: 38px;">
													<input type="submit" class="btn btn-outline-dark" value="입찰">
												</c:if>
											</c:if>	
										</c:when>
										<%-- <c:when test="${allPro.auctioncheck == 'N'}">
											<input type="button" value="판매자와 연락하기" class="primary-btn"
												onclick="matchingwindow()" />
										</c:when> --%>
									</c:choose>
								</c:if>
							</div>
						</form>
					</div>
					<ul id="detailList">
						<c:if test="${allPro.auctioncheck=='Y' }">
							<li><b>시작가격</b> <span id="minprice"><fmt:formatNumber
										value="${allPro.minprice}" pattern="#,###" /></span>원</li>
							<li><b>남은시간</b><span class="aucTimer" id="aucTimer"></span></li>
						</c:if>
						<li><b>판매자</b><span>${allPro.userid}</span></li>
						<li><b>판매 지역</b><span>${allPro.uad}</span></li>
						<li><b>조회수</b><i class="fa fa-eye"></i>&nbsp;&nbsp;<span
							id="view_count">${allPro.viewcount}</span></li>
						<li><b>찜한 수</b><i class="fa fa-heart"></i>&nbsp;&nbsp;<span
							class="likeCount">${allPro.likecount}</span></li>
					</ul>
					<c:if test="${memberUser.userid eq allPro.userid}">
						<input type="hidden" value="${allPro.ino}" id="delNo">
					</c:if>
				</div>
				<div id="detailMenu">
					<ul>
						<li><input type="button" class="btn btn-outline-dark" value="상품수정" onclick="location.href='/product/productModify?ino=${allPro.ino}&aucChk=${allPro.auctioncheck}'"></li>
						<li><input type="button" class="btn btn-outline-dark" value="판매완료" onclick="location.href='/product/updateSellChk?ino=${allPro.ino}'"></li>
						<li><input type="button" class="btn btn-outline-danger" value="삭제" onclick="productDel()" id="productDel"></li>
					</ul>
				</div>
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
							<p style="margin-top: 20px; font-size: 20px;">${allPro.pricetext}</p>
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
					<div class="product__item"
						onclick="location.href='/product/productDetail?ino=${productUser.ino}&aucChk=${productUser.auctioncheck}'">
						<div class="product__item__pic set-bg"
							data-setbg="${productUser.imageface1}">
						</div>
						<div class="product__item__text">
							<h6>
								<a href="#">${productUser.iname}</a>
							</h6>
							<c:choose>
								<c:when test="${productUser.auctioncheck != 'Y'}">
									<h5>
										<fmt:formatNumber pattern="#,###" value="${productUser.price}" />원
									</h5>
								</c:when>
								<c:when test="${productUser.auctioncheck == 'Y'}">
									<h5>
										현재가 <fmt:formatNumber pattern="#,###" value="${productUser.apricenow}" />원
									</h5>
								</c:when>
							</c:choose>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
</section>
<!-- Related Product Section End -->
<script src="/resources/js/product/productDetail.js"></script>

<%@ include file="../include/footer.jsp"%>