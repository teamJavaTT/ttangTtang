<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/adminheader.jsp"%>

			<div class="col-lg-9">
				<!-- Content Header (Page header) -->
				<section class="content-header">
					<h2>블랙리스트 관리</h2>
				</section>
				<!-- list -->
				<section class="content">
					<div class="limiter">
						<div class="wrap-table100">
							<div class="table100">
								<div class="box">
									<form action="blacklist.do" method="post">
										<table border="1">
											<thead>
												<tr class="table100-head">
													<td>사용자</td>
													<td>차단된 사용자</td>
													<td>작성일자</td>
												</tr>
											</thead>
											<tbody>
											<c:forEach var="blacklist" items="${blacklistPage.blacklist}">
												<tr>
													<!-- 사용자 -->
													<td>${blacklist.userId}</td>
													<!-- 차단된 사용자 -->
													<td><a href="blacklistread.do?no=${blacklist.bNo}">
													<c:out value="${blacklist.bId}" /></a></td>
													<!--  작성일자  -->
													<td>${blacklist.bDate}</td>
												</tr>
											</c:forEach>
												<tr>
													<td colspan="3">
														<c:if test="${blacklistPage.startPage > 10}">
															<a href="blacklist.do?pageNo=${blacklistPage.startPage - 10}">[이전]</a>
														</c:if>
														<c:forEach var="pNo" begin="${blacklistPage.startPage}" end="${blacklistPage.endPage}">
															<a href="blacklist.do?pageNo=${pNo}">[${pNo}]</a>
														</c:forEach>
														<c:if test="${blacklistPage.endPage < blacklistPage.totalPages}">
															<a href="blacklist.do?pageNo=${blacklistPage.startPage + 10}">[다음]</a>
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



<%@ include file="../include/footer.jsp"%>
