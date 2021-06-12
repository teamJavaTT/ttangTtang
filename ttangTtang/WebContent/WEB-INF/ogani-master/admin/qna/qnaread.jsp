<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../include/header.jsp"%>

<script type="text/javascript" src="http://code.jquery.com/jquery-3.2.1.min.js"></script>

<!-- Hero Section Begin -->
<section class="hero">
	<div class="container">
		<div class="row">

			<!-- admin list -->
			<div class="col-lg-3">
				<div class="hero__categories">
					<div class="hero__categories__all">
						<i class="fa fa-bars"></i> <span>All departments</span>
					</div>
					<ul>
						<li><a href="noticelist.do">공지사항</a></li>
						<li><a href="qnalist.do">Q&A</a></li>
						<li><a href="faqlist.do">FAQ</a></li>
						<li><a href="/ttangTtang/ogani-master/admin/usersound.jsp">고객의
								소리</a></li>
						<li><a href="/ttangTtang/ogani-master/admin/userlist.jsp">사용자
								게시글 관리</a></li>
						<li><a href="/ttangTtang/ogani-master/admin/userinfo.jsp">사용자
								회원정보 관리</a></li>
						<li><a href="/ttangTtang/ogani-master/admin/blacklist.jsp">블랙리스트관리</a></li>
						<li><a href="/ttangTtang/ogani-master/admin/declaration.jsp">신고
								관리</a></li>
						<li><a href="/ttangTtang/ogani-master/admin/outuser.jsp">탈퇴회원
								관리</a></li>
					</ul>
				</div>
			</div>
			<!-- admin list end -->

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
									<table border="1" width="100%">
										<thead>
											<tr>
												<th colspan="4"	style="text-align: center; padding-left: 0px;">게시물</th>
											</tr>
										</thead>
										<tbody>
											<tr>
												<td>번호 : ${qnaData.qna.qno}</td>
												<td>작성일자 : ${qnaData.qna.qdate}</td>
											</tr>
											<tr>
												<td colspan="4"	style="text-align: left; font-weight: bold; font-size: 20px"> ${qnaData.qna.qtit}</td>
											</tr>
											<tr>
												<td colspan="4" style="text-align: left;">${qnaData.qna.qtext}</td>
											</tr>
										</tbody>
									</table>
									<p>
									<!-- 댓글 테이블 -->
									<table border="1" width="100%">
										<%-- <c:forEach var="qna" items="${articlePage.content}"> --%>
											<!-- 댓글들 -->
											<tr>
												<td style="text-align: left;">댓글나오는곳<%-- <a
													href="read.do?no=${article.number}&pageNo=${articlePage.currentPage}"><c:out
															value="${article.title}" /></a> --%></td>
												<td align="center"><input type="submit" value="수정"></input></td>
											</tr>
										<%-- </c:forEach>	 --%>									
										<!-- 댓글달기 -->
										<tr style="padding: 10px;">
											<td align="center"><textarea rows="1" cols="100%" placeholder="댓글달기" name="content"></textarea></td>
											<td align="center"><input type="submit" value="댓글달기"></input></td>
										</tr>
										
										<tr>
											<td align="center" colspan="2"><c:set
													var="pageNo"
													value="${empty param.pageNo ? '1' : param.pageNo}" /> <input
												type="button" value="목록"
												onclick="location.href='qnalist.do?pageNo=${pageNo}'">
												<c:if test="${authUser.id == articleData.article.writer.id}">
													<input type="button" value="게시글수정"
														onclick="location.href='qnamodify.do?no=${qnaData.qna.qno}'">
													<input type="hidden" value="${qnaData.qna.qno}" id="delNo">
													<input type="button" value="게시글삭제" id="qnaDel">
												</c:if></td>
										</tr>
									</table>
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


<script src="/ttangTtang/js/admin/main.js" ></script>

<%@ include file="../../include/footer.jsp"%>
