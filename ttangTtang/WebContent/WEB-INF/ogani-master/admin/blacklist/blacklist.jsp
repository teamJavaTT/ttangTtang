<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../include/header.jsp"%>
<%@ include file="../../include/adminheader.jsp"%>

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
													<td class="column5" style="padding-left: 0px;">사용자</td>
													<td class="column1" colspan="2" style="padding-left: 0px;">차단된 사용자</td>
													<td class="column5" style="padding-left: 0px;">작성일자</td>
												</tr>
											</thead>
											<tbody>
											<c:forEach var="blacklist" items="${blacklistPage.blacklist}">
												<tr>
													<!-- 사용자 -->
													<td style="padding-left: 0px;">${blacklist.userId}</td>
													<!-- 차단된 사용자 -->
													<td colspan="2" style="padding-left: 0px;"><a href="blacklistread.do?no=${blacklist.bNo}">
													<c:out value="${blacklist.bId}" /></a></td>
													<!--  작성일자  -->
													<td style="padding-left: 0px;">${blacklist.bDate}</td>
												</tr>
											</c:forEach>
												<tr>
													<td colspan="5" style="padding-left: 0px;">
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
<!-- Hero Section End -->



<%@ include file="../../include/footer.jsp"%>
