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
						<li><a href="/ttangTtang/ogani-master/admin/userversion/uvnotice.jsp">공지사항</a></li>
                        <li><a href="/ttangTtang/ogani-master/admin/userversion/uvqna.jsp">Q&A</a></li>
						<li><a href="/ttangTtang/ogani-master/admin/userversion/uvfaq.jsp">FAQ</a></li>
						<li><a href="/ttangTtang/ogani-master/admin/userversion/uvusersound.jsp">고객의 소리</a></li>
						<li><a href="/ttangTtang/ogani-master/admin/userversion/uvservice.jsp">고객센터</a></li>
					</ul>
				</div>
			</div>
			<!-- admin list end -->


			<div class="col-lg-9">
				<!-- Content Header (Page header) -->
				<section class="content-header">
					<h2>FAQ</h2>
					<p>
				</section>
				<!-- list -->
				<section class="content">
					<div class="col-lg-9">
						<!-- Default box -->
						<div class="box">
							<table border="1">
								<tr>
									<td colspan="4"><a href="write.do">[게시글쓰기]</a></td>
								</tr>
								<tr>
									<td>번호</td>
									<td>제목</td>
									<td>작성자</td>
									<td>조회수</td>
								</tr>
								<c:if test="${articlePage.hasNoArticles()}">
									<tr>
										<td colspan="4">게시글이 없습니다.</td>
									</tr>
								</c:if>
								<c:forEach var="article" items="${articlePage.content}">
									<tr>
										<td>${article.number}</td>
										<td><a
											href="read.do?no=${article.number}&pageNo=${articlePage.currentPage}">
												<c:out value="${article.title}" />
										</a></td>
										<td>${article.writer.name}</td>
										<td>${article.readCount}</td>
									</tr>
								</c:forEach>
								<c:if test="${articlePage.hasArticles()}">
									<tr>
										<td colspan="4"><c:if test="${articlePage.startPage > 5}">
												<a href="list.do?pageNo=${articlePage.startPage - 5}">[이전]</a>
											</c:if> <c:forEach var="pNo" begin="${articlePage.startPage}"
												end="${articlePage.endPage}">
												<a href="list.do?pageNo=${pNo}">[${pNo}]</a>
											</c:forEach> <c:if test="${articlePage.endPage < articlePage.totalPages}">
												<a href="list.do?pageNo=${articlePage.startPage + 5}">[다음]</a>
											</c:if></td>
									</tr>
								</c:if>
							</table>
						</div>
						<!-- /.box -->
					</div>
				</section>
				<!-- /.content -->
			</div>
		</div>
	</div>
	<!-- /.content-wrapper -->
</section>
<!-- Hero Section End -->



<%@ include file="../../include/footer.jsp"%>
