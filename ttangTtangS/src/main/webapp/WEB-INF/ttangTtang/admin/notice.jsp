<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/adminheader.jsp"%>


<div class="col-lg-9">
	<section class="content-header">
		<h2>공지사항</h2>
	</section>
	<section class="content">
		<div class="limiter">
			<div class="wrap-table100">
				<div class="table100">
					<div class="box">
						<form action="notice" method="post">
							<table border="1">
								<thead>
									<tr>
										<td>번호</td>
										<td>제목</td>
										<td>작성일자</td>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="notice" items="${noticePage}">
										<tr>
											<!-- 번호 -->
											<td>${notice.mno}</td>
											<!-- 내용 -->
											<td><a
												href="noticeread?no=${notice.mno}">
													<c:out value="${notice.mtit}" />
											</a></td>
											<!--  작성일자  -->
											<td>${notice.mdate}</td>
										</tr>
									</c:forEach>
									<tr>
										<td colspan="3">
											<ul style="text-align:center;">
												<c:if test="${pageMaker.prev}">
												 	<li style="display:inline;"><a href="notice?page=${pageMaker.startPage - 1}">이전</a></li>
												</c:if> 
														  
												<c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="idx">
													<li style="display:inline;"><a href="notice?page=${(idx)}">${idx}</a></li>
												</c:forEach>
														    
												<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
													<li style="display:inline;"><a href="notice?page=${pageMaker.endPage + 1}">다음</a></li>
												</c:if>
											</ul>
										</td>
									</tr>
								</tbody>
							</table>
							<c:if test="${memberUser.userid eq 'admin'}">
								<table>
									<tr>
										<td colspan="1"><a href="noticewrite">[게시글쓰기]</a></td>
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



<%@ include file="../include/footer.jsp"%>
