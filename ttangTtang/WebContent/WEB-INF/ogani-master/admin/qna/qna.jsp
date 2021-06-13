<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../include/header.jsp"%>

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
						<li><a href="userinfolist.do">사용자 회원정보 관리</a></li>
						<li><a href="blacklist.do">블랙리스트관리</a></li>
						<li><a href="declarationlist.do">신고	관리</a></li>
						<li><a href="outuserlist.do">탈퇴회원 관리</a></li>
					</ul>
				</div>
			</div>
			<!-- admin list end -->


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
									<form action="qnalist.do" method="post">
										<table border="1">
											<thead>
												<tr class="table100-head">
													<td class="column5" style="padding-left: 0px;">번호</td>
													<td class="column5" style="padding-left: 0px;">작성자</td>
													<td class="column1" colspan="2" style="padding-left: 0px;">제목</td>
													<td class="column5" style="padding-left: 0px;">작성일자</td>
												</tr>
											</thead>
											<tbody>
											<c:forEach var="qna" items="${qnaPage.qna}">
												<tr>
													<!-- 번호 -->
													<td style="padding-left: 0px;">${qna.qno}</td>
													<!-- 작성자 -->
													<td style="padding-left: 0px;">${qna.userId}</td>
													<!-- 내용 -->
													<td colspan="2" style="padding-left: 0px;"><a href="qnaread.do?no=${qna.qno}<%-- &pageNo=${noticePage.currentPage} --%>">
													<c:out value="${qna.qtit}" /></a></td>
													<!--  작성일자  -->
													<td style="padding-left: 0px;">${qna.qdate}</td>
													<%-- <td>${article.readCount}</td> --%>
												</tr>
											</c:forEach>
												<tr>
													<td colspan="5" style="padding-left: 0px;">
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
										<table style="text-align: center;">
											<tr>
												<td class="column4" colspan="1"><a href="qnawrite.do">[게시글쓰기]</a></td>
											</tr>
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
