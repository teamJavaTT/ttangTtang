<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../include/adminheader.jsp"%>

<script type="text/javascript" src="http://code.jquery.com/jquery-3.2.1.min.js"></script>
		<c:if test="${pwdNo eq 'no'}">
			<script>alert("비밀번호가 틀렸습니다.");</script>
		</c:if>
			<div class="col-lg-9">
				<!-- Content Header (Page header) -->
				<section class="content-header">
					<h2>Q&A</h2>
				</section>
				<!-- list -->
				<section class="content">
					<div class="limiter">
						<div class="wrap-table100">
							<div class="table100">							
								<div class="box">
									<table border="1">
										<thead>
											<tr>
												<td>번호</td>
												<td>작성자</td>
												<td>제목</td>
												<td>작성일자</td>
											</tr>
										</thead>
										<tbody>
										<c:forEach var="qna" items="${qnaPage.qna}">
											<tr>
												<!-- 번호 -->
												<td>${qna.qno}</td>
												<!-- 작성자 -->
												<td>${qna.userId}</td>
												<!-- 내용 -->
												<td>
													<form action ="qnaread.do?no=${qna.qno}" id="pwdForm" method="post">
														<a <c:if test="${qna.qpw ne null}">class="qnaRead"</c:if><c:if test="${qna.qpw eq null}">href="qnaread.do?no=${qna.qno}"</c:if>>${qna.qpw eq null ? qna.qtit : '비밀글 입니다.'}</a>
														<input type="password"  name="qnaPwd${qna.qno}" style="display:none">
														<input type="submit" value="확인" style="display:none">
													</form>
												</td>
												<!--  작성일자  -->
												<td>${qna.qdate}</td>
											</tr>
										</c:forEach>
											<tr>
												<td colspan="4">
													<c:if test="${qnaPage.startPage > 10}">
														<a href="qnalist.do?pageNo=${qnaPage.startPage - 10}">[이전]</a>
													</c:if>
													<c:forEach var="pNo" begin="${qnaPage.startPage}" end="${qnaPage.endPage}">
														<a href="qnalist.do?pageNo=${pNo}">[${pNo}]</a>
													</c:forEach>
													<c:if test="${qnaPage.endPage < qnaPage.totalPages}">
														<a href="qnalist.do?pageNo=${qnaPage.startPage + 10}">[다음]</a>
													</c:if>
												</td>
											</tr>
										</tbody>
									</table>
									<table>
										<tr>
											<td><a href="qnawrite.do">[게시글쓰기]</a></td>
										</tr>
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

<script src="/ttangTtang/js/admin/main.js"></script>

<%@ include file="../../include/footer.jsp"%>
