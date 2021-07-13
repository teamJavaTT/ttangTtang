<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../include/adminheader.jsp"%>

			<div class="col-lg-9">
				<!-- Content Header (Page header) -->
				<section class="content-header">
					<h2>탈퇴회원 관리</h2>
				</section>
				<!-- list -->
				<section class="content">
					<div class="limiter">
						<div class="wrap-table100">
							<div class="table100">
								<div class="box">
									<form action="outuserlist.do" method="post">
										<table border="1">
											<thead>
												<tr class="table100-head">
													<td>번호</td>
													<td colspan="2">사용자</td>
													<td>탈퇴일자</td>
												</tr>
											</thead>
											<tbody>
											<c:forEach var="outuser" items="${outuserPage.outuser}">
												<tr>
													<!-- 사용자 -->
													<td style="padding-left: 0px;">${outuser.sNo}</td>
													<!-- 차단된 사용자 -->
													<td colspan="2"><a href="outuserread.do?no=${outuser.sNo}">
													<c:out value="${outuser.userId}" /></a></td>
													<!--  작성일자  -->
													<td>${outuser.sDate}</td>
												</tr>
											</c:forEach>
												<tr>
													<td colspan="4">
														<c:if test="${outuserPage.startPage > 10}">
															<a href="outuserlist.do?pageNo=${outuserPage.startPage - 10}">[이전]</a>
														</c:if>
														<c:forEach var="pNo" begin="${outuserPage.startPage}" end="${outuserPage.endPage}">
															<a href="outuserlist.do?pageNo=${pNo}">[${pNo}]</a>
														</c:forEach>
														<c:if test="${outuserPage.endPage < outuserPage.totalPages}">
															<a href="outuserlist.do?pageNo=${outuserPage.startPage + 10}">[다음]</a>
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


<%@ include file="../../include/footer.jsp"%>
