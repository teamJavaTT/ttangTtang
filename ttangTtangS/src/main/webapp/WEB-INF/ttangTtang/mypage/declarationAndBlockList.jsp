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
			<div class="col-lg-9">
				<form action="declarationAndBlockList" method="post">
					<!-- Content Header (Page header) -->
					<section class="content-header">
						<c:choose>
							<c:when test="${param.blockChk eq 'B'}">
								<h3>차단 내역</h3>
							</c:when>
							<c:otherwise>
								<h3>신고 내역</h3>
							</c:otherwise>
						</c:choose>
					</section>
					<!-- list -->
					<section class="content">
						<div class="limiter">
							<div class="wrap-table100">
								<div class="table100">
									<div class="box">
										<div style="float: right;">
											<select name="blockChk">
												<c:choose>
													<c:when test="${param.blockChk eq 'B'}">
														<option value="D">신고리스트</option>
														<option value="B" selected>차단리스트</option>
													</c:when>
													<c:otherwise>
														<option value="D" selected>신고리스트</option>
														<option value="B">차단리스트</option>
													</c:otherwise>
												</c:choose>
											</select> <input type="submit" class="button" value="보기">
										</div>

										<table>
											<thead>
												<tr>

													<th>아이디</th>
													<!-- CNAMe -->
													<th>종류</th>
													<!-- REASON -->
													<th>날짜</th>
													<!-- DATE  -->

												</tr>
											</thead>
											<tbody>

												<c:forEach var="declaration" items="${accountDeclaration}">
													<tr>


														<%-- <!-- 신고/차단 -->
											<td>${declaration.auctionCheck eq 'N'? '신고' : '차단'}</td> --%>
														<!-- 신고 아이디 -->
														<td>${declaration.duid}</td>
														<!-- 상품명 -->
														<td><c:out value="${declaration.dtext}" /></td>
														<!-- 등록날짜 -->
														<td><fmt:formatDate value="${declaration.ddate}" pattern="yyyy-MM-dd HH:mm"/></td>

													</tr>
												</c:forEach>


												<c:forEach var="block" items="${blockUser}">
													<tr>

														<%-- <!-- 신고/차단 -->
											<td>${declaration.auctionCheck eq 'N'? '신고' : '차단'}</td> --%>
														<!-- 차단 아이디 -->
														<td>${block.bid}</td>
														<!-- 상품명 -->
														<td><c:out value="${block.btext}" /></td>
														<!-- 등록날짜 -->
														<td>${block.bdate}</td>

													</tr>
												</c:forEach>
												<tr>
													<td colspan="5">
														<ul class="pageMaker">
															<c:if test="${pageMaker.prev}">
																<li><a
																	href="declarationAndBlockList?page=${pageMaker.startPage - 1}">이전</a></li>
															</c:if>

															<c:forEach begin="${pageMaker.startPage}"
																end="${pageMaker.endPage}" var="idx">
																<li><a
																	href="declarationAndBlockList?page=${(idx)}&blockChk=${param.blockChk}">${idx}</a></li>
															</c:forEach>

															<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
																<li><a
																	href="declarationAndBlockList?page=${pageMaker.endPage + 1}">다음</a></li>
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
				</form>
			</div>
		</div>
	</div>
	<!-- /.content-wrapper -->
</section>
<!-- Hero Section End -->

<%@ include file="../include/footer.jsp"%>
