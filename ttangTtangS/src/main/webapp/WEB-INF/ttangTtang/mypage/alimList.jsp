<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<link rel="stylesheet" href="/resources/css/mypage/mypagemain.css">

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
				<h3 style="margin-bottom: 30px;">알림내역</h3>
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
												<th>내용</th>
												<th>알림시간</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="alimList" items="${alimAll}">
												<c:if test="${alimList.alimchk eq 'N'}">
													<tr style="height: 50px;">
														<td  style="height:100px;">
															<img class="preview" style="width: 100px; height: aucto;cursor:pointer;" src="${alimList.imageface1}" data-setbg="${alimList.imageface1}"
															onclick="location.href='/product/productDetail?ino=${alimList.ino}&aucChk=Y'">
														</td>
														<td style="font-size: 1.1em;"><b><a href="/product/productDetail?ino=${alimList.ino}&aucChk=Y">${alimList.ltext}</a></b></td>
														<td><b><fmt:formatDate value="${alimList.ldate}" pattern="yyyy-MM-dd HH:mm" /></b></td>
													</tr>
												</c:if>
												<c:if test="${alimList.alimchk eq 'Y'}">
													<tr style="height: 50px;">
														<td  style="height:100px;">
															<img class="preview" style="width: 100px; height: aucto;cursor:pointer;" src="${alimList.imageface1}" data-setbg="${alimList.imageface1}"
															onclick="location.href='/product/productDetail?ino=${alimList.ino}&aucChk=Y'">
														</td>
														<td><a href="/product/productDetail?ino=${alimList.ino}&aucChk=Y">${alimList.ltext}</a></td>
														<td><fmt:formatDate value="${alimList.ldate}" pattern="yyyy-MM-dd HH:mm" /></td>
													</tr>
												</c:if>
											</c:forEach>
											<tr>
												<td colspan="6">
													<ul class="pageMaker" style="text-align: center;">
														<c:if test="${pageMaker.prev}">
															<li><a
																href="/mypage/alimList?page=${pageMaker.startPage - 1}">이전</a></li>
														</c:if>

														<c:forEach begin="${pageMaker.startPage}"
															end="${pageMaker.endPage}" var="idx">
															<li><a
																href="/mypage/alimList?page=${(idx)}&sellChk=${param.sellChk}">${idx}</a></li>
														</c:forEach>

														<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
															<li><a
																href="/mypage/alimList?page=${pageMaker.endPage + 1}">다음</a></li>
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
