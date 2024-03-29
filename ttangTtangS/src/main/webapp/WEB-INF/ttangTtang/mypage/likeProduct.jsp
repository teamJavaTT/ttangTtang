<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<link rel="stylesheet" href="/resources/css/mypage/mypagemain.css">
<style>
</style>
<!-- Hero Section Begin -->
<section class="hero">
	<div class="container">
		<div class="row">
			<!-- admin list -->
			<div class="col-lg-3">
				<div class="hero__categories">
					<ul><%@ include file="mypageMenuList.jsp"%></ul>
				</div>
			</div>
			<div class="col-lg-9" id=likeProduct>
				<h3 style="margin-bottom: 30px;">관심상품</h3>
				<!-- Content Header (Page header) -->
				<section class="content-header"></section>
				<!-- list -->
				<section class="content">
					<div class="limiter">
						<div class="wrap-table100">
							<div class="table100">
								<div class="box">
									<table>
										<thead>
											<tr>
												<th>상품</th>
												<th>관심상품</th>
												<th>가격</th>
												<th>경매 종료시간</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="likeProduct" items="${likeProduct}">
												<tr>

											<td style="height:100px;"><img class="preview" style="width: aucto;height: 100px;cursor: pointer;"
															src="${likeProduct.imageface1}"
															data-setbg="${likeProduct.imageface1}"
															onclick="location.href='/product/productDetail?ino=${likeProduct.ino}&aucChk=${likeProduct.auctioncheck}'">
														</td>
													<td>${likeProduct.iname}</td>
													<c:if test="${likeProduct.auctioncheck=='N' }">
														<td>${likeProduct.price}</td>
													</c:if>
													<c:if test="${likeProduct.auctioncheck=='Y' }">
														<td>${likeProduct.apricenow}</td>
													</c:if>
													<td><fmt:formatDate value="${likeProduct.endtime}"
															pattern="yyyy-MM-dd HH:mm" /></td>
												</tr>
											</c:forEach>
											<tr>
												<td colspan="5">
													<ul class="pageMaker">
														<c:if test="${pageMaker.prev}">
															<li><a
																href="likeProduct?page=${pageMaker.startPage - 1}">이전</a></li>
														</c:if>

														<c:forEach begin="${pageMaker.startPage}"
															end="${pageMaker.endPage}" var="idx">
															<li><a
																href="likeProduct?page=${(idx)}">${idx}</a></li>
														</c:forEach>

														<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
															<li><a
																href="likeProduct?page=${pageMaker.endPage + 1}">다음</a></li>
														</c:if>
													</ul>
												</td>
											</tr>
										</tbody>
									</table>
								</div>
							</div>
						</div>
					</div>
					<!-- /.box -->
				</section>
				<!-- /.content -->
			</div>
		</div>
	</div>
	<!-- /.content-wrapper -->
</section>
<!-- Hero Section End -->

<%@ include file="../include/footer.jsp"%>
