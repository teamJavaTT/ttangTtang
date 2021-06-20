<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../include/adminheader.jsp"%>

			<div class="col-lg-9">
				<!-- Content Header (Page header) -->
				<section class="content-header">
					<h2>신고 관리</h2>
				</section>
				<!-- list -->
				<section class="content">
					<div class="limiter">
						<div class="wrap-table100">
							<div class="table100">
								<div class="box">
									<form action="declarationlist.do" method="post">
										<table border="1">
											<thead>
												<tr class="table100-head">
													<td>사용자</td>
													<td colspan="2">신고된 사용자</td>
													<td>작성일자</td>
												</tr>
											</thead>
											<tbody>
											<c:forEach var="declaration" items="${declarationPage.declaration}">
												<tr>
													<!-- 사용자 -->
													<td>${declaration.userId}</td>
													<!-- 차단된 사용자 -->
													<td colspan="2"><a href="declarationread.do?no=${declaration.dNo}">
													<c:out value="${declaration.duId}" /></a></td>
													<!--  작성일자  -->
													<td>${declaration.dDate}</td>
												</tr>
											</c:forEach>
												<tr>
													<td colspan="4" style="padding-left: 0px;">
														<c:if test="${declarationPage.startPage > 10}">
															<a href="declarationlist.do?pageNo=${declarationPage.startPage - 10}">[이전]</a>
														</c:if>
														<c:forEach var="pNo" begin="${declarationPage.startPage}" end="${declarationPage.endPage}">
															<a href="declarationlist.do?pageNo=${pNo}">[${pNo}]</a>
														</c:forEach>
														<c:if test="${declarationPage.endPage < declarationPage.totalPages}">
															<a href="declarationlist.do?pageNo=${declarationPage.startPage + 10}">[다음]</a>
														</c:if>
													</td>
												</tr>
											</tbody>
										</table>
									</form>
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



<%@ include file="../../include/footer.jsp"%>
