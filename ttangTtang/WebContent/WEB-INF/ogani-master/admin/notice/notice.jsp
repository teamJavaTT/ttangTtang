<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../include/header.jsp"%>
<%@ include file="../../include/adminheader.jsp"%>


<div class="col-lg-9">
	<section class="content-header">
		<h2>공지사항</h2>
	</section>
	<section class="content">
		<div class="limiter">
			<div class="wrap-table100">
				<div class="table100">
					<div class="box">
						<form action="noticelist.do" method="post">
							<table border="1">
								<thead>
									<tr>
										<td>번호</td>
										<td>제목</td>
										<td>작성일자</td>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="notice" items="${noticePage.notice}">
										<tr>
											<!-- 번호 -->
											<td>${notice.mno}</td>
											<!-- 내용 -->
											<td><a
												href="noticeread.do?no=${notice.mno}">
													<c:out value="${notice.mtit}" />
											</a></td>
											<!--  작성일자  -->
											<td>${notice.mdate}</td>
										</tr>
									</c:forEach>
									<tr>
										<td colspan="3"><c:if
												test="${noticePage.startPage > 10}">
												<a href="noticelist.do?pageNo=${noticePage.startPage - 10}">[이전]</a>
											</c:if> <c:forEach var="pNo" begin="${noticePage.startPage}"
												end="${noticePage.endPage}">
												<a href="noticelist.do?pageNo=${pNo}">[${pNo}]</a>
											</c:forEach> <c:if test="${noticePage.endPage < noticePage.totalPages}">
												<a href="noticelist.do?pageNo=${noticePage.startPage + 10}">[다음]</a>
											</c:if></td>
									</tr>
								</tbody>
							</table>
							<c:if test="${memberUser.userid eq 'admin'}">
								<table>
									<tr>
										<td colspan="1"><a href="noticewrite.do">[게시글쓰기]</a></td>
									</tr>
								</table>
							</c:if>
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
