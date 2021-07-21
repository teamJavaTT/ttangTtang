<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/adminheader.jsp"%>

<script type="text/javascript" src="http://code.jquery.com/jquery-3.2.1.min.js"></script>

<div class="col-lg-9">
	<section class="content-header">
		<h2>FAQ</h2>
	</section>
	<section class="content">
		<div class="limiter">
			<div class="wrap-table100">
				<div class="table100">
					<div class="box">
						<table border="1">
							<thead>
								<tr>
									<th colspan="4">게시물</th>
								</tr>
							</thead>
							<tbody>
							<c:forEach var="faq" items="${faq}">
								<tr>
									<td style="text-align: left;">번호 : ${faq.fno}</td>
									<td style="text-align: left;">작성일자 : ${faq.fdate}
									</td>
								</tr>
								<tr>
									<td colspan="4"
										style="text-align: left; font-weight: bold; font-size: 20px">
										${faq.ftit}</td>
								</tr>
								<tr>
									<td colspan="4" style="text-align: left;">${faq.ftext}</td>
								</tr>
							<tr>
								<td colspan="2">
									<c:set var="pageNo" value="${empty param.pageNo ? '1' : param.pageNo}" /> 
												<input type="button" value="목록" onclick="location.href='faq'">
													<c:if test="${memberUser.userid eq 'admin'}">
														<input type="button" value="게시글수정" onclick="location.href='faqmodify?no=${faq.fno}'">
														<input type="hidden" value="${faq.fno}" id="delNo">
														<input type="button" value="게시글삭제" id="faqDel">
													</c:if>
												</td>
											</tr>
								</td>
							</tr>
							</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</section>
</div>
</div>
</div>
</section>

<script src="/ttangTtang/js/admin/main.js"></script>

<%@ include file="../include/footer.jsp"%>
