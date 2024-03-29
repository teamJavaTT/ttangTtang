<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../include/adminheader.jsp"%>

<script type="text/javascript" src="http://code.jquery.com/jquery-3.2.1.min.js"></script>

			<div class="col-lg-9">
				<section class="content-header">
					<h2>Q&A</h2>
				</section>
				<section class="content">
					<div class="limiter">
						<div class="wrap-table100">
							<div class="table100">
								<!-- Default box -->
								<div class="box">
									<table border="1">
										<thead>
											<tr>
												<th colspan="4">게시물</th>
											</tr>
										</thead>
										<tbody>
											<tr>
												<td style="text-align: left;">번호 : ${qnaData.qna.qno}</td>
												<td style="text-align: left;">작성일자 : ${qnaData.qna.qdate}</td>
											</tr>
											<tr>
												<td colspan="4"
													style="text-align: left; font-weight: bold; font-size: 20px">
													${qnaData.qna.qtit}</td>
											</tr>
											<tr>
												<td colspan="4" style="text-align: left;">${qnaData.qna.qtext}</td>
											</tr>
											<tr>
												<td colspan="2"><c:set var="pageNo" value="${empty param.pageNo ? '1' : param.pageNo}" /> 
												<input type="button" value="목록" onclick="location.href='qnalist.do?pageNo=${pageNo}'">
													<c:if test="${memberUser.userid eq qnaData.qna.userId}">
														<input type="button" value="게시글수정" onclick="location.href='qnamodify.do?no=${qnaData.qna.qno}'">
														<input type="hidden" value="${qnaData.qna.qno}" id="delNo">
														<input type="button" value="게시글삭제" id="qnaDel">
													</c:if>
												</td>
											</tr>
										</tbody>
									</table>
									<p>
										<!-- 댓글 테이블 -->
									<form action="qnaAnswer.do" method="post">
										<input type="hidden" name="qno" value="${qnaData.qna.qno}">
										<input type="hidden" name="patext" value="${qnaData.qna.patext}">
											<table border="1" width="100%" id="answerTbl">
												<%-- <c:forEach var="qna" items="${articlePage.content}"> --%>
												<!-- 댓글들 -->
												<c:if test="${qnaData.qna.patext eq 'Y'}">
													<tr>
														<td colspan="2" style="text-align: left;">댓글나오는곳</td>
													</tr>
													<!-- 댓글 불러오기 -->
													<tr style="padding: 10px;">
														<td align="center">${qnaData.qna.qstext}</td>
														<c:if test="${memberUser.userid eq 'admin'}">
														<td align="center">
															<input type="submit" value="수정">
														</td>
														</c:if>
													</tr>
												</c:if>
													<!-- 댓글달기 -->
												<c:if test="${memberUser.userid eq 'admin'}">
													<c:if test="${qnaData.qna.patext eq 'N'}">
														<tr style="padding: 10px;">
															<td align="center">
																<textarea rows="1" style="height:300px" cols="100%" placeholder="댓글달기" name="answerContent">${qnaData.qna.qstext}</textarea>
															</td>
															<td align="center">
																<input type="submit" value="댓글달기"></input>
															</td>
														</tr>
													</c:if>
												</c:if>
											</table>
										</form>
								</div>
							</div>
						</div>
					</div>
					<!-- /.box -->
				</section>
			</div>
		</div>
	</div>
</section>


<script src="/ttangTtang/js/admin/main.js"></script>

<%@ include file="../../include/footer.jsp"%>
