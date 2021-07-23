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
									<form action="blacklist" method="post">
										<table border="1">
											<thead>
												<tr class="table100-head">
													<td>사용자</td>
													<td>차단된 사용자</td>
													<td>작성일자</td>
												</tr>
											</thead>
											<tbody>
											<c:forEach var="blacklist" items="${blacklistPage}">
												<tr>
													<!-- 사용자 -->
													<td>${blacklist.userid}</td>
													<!-- 차단된 사용자 -->
													<td><a href="blacklistread?no=${blacklist.bno}">
													<c:out value="${blacklist.bid}" /></a></td>
													<!--  작성일자  -->
													<td><fmt:formatDate value="${blacklist.bdate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
												</tr>
											</c:forEach>
												<tr>
													<td colspan="3">
														<ul style="text-align:center;">
															<c:if test="${pageMaker.prev}">
															 	<li style="display:inline;"><a href="blacklist?page=${pageMaker.startPage - 1}">이전</a></li>
															</c:if> 
																	  
															<c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="idx">
																<li style="display:inline;"><a href="blacklist?page=${(idx)}">${idx}</a></li>
															</c:forEach>
																	    
															<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
																<li style="display:inline;"><a href="blacklist?page=${pageMaker.endPage + 1}">다음</a></li>
															</c:if>
														</ul>
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
