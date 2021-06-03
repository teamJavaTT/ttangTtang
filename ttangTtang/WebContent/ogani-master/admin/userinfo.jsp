<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>

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
						<li><a href="/ttangTtang/ogani-master/admin/notice.jsp">공지사항</a></li>
                        <li><a href="/ttangTtang/ogani-master/admin/qna.jsp">Q&A</a></li>
						<li><a href="/ttangTtang/ogani-master/admin/faq.jsp">FAQ</a></li>
						<li><a href="/ttangTtang/ogani-master/admin/customersound.jsp">고객의 소리</a></li>
						<li><a href="/ttangTtang/ogani-master/admin/userlist.jsp">사용자 게시글 관리</a></li>
						<li><a href="/ttangTtang/ogani-master/admin/userinfo.jsp">사용자 회원정보 관리</a></li>
						<li><a href="/ttangTtang/ogani-master/admin/service.jsp">고객센터</a></li>
						<li><a href="/ttangTtang/ogani-master/admin/blacklist.jsp">블랙리스트관리</a></li>
						<li><a href="/ttangTtang/ogani-master/admin/declaration.jsp">신고 관리</a></li>
						<li><a href="/ttangTtang/ogani-master/admin/outuser.jsp">탈퇴회원 관리</a></li>
					</ul>
				</div>
			</div>
			<!-- admin list end -->


			<div class="col-lg-9">
				<!-- Content Header (Page header) -->
				<section class="content-header">
					<h2>사용자 게시글 관리</h2>
					<p>
				</section>
				<!-- list -->
				<section class="content">
					<div class="col-lg-9">
						<!-- Default box -->
						<div class="box">
							<table border="1">
								<tr>
									<td>번호</td>
									<td>사용자</td>
									<td>사용자 정보</td>
									<td>작성자</td>
									<td>조회수</td>
								</tr>
								<c:if test="${articlePage.hasNoArticles()}">
									<tr>
										<td colspan="5">게시글이 없습니다.</td>
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
										<td>${article.readCount}</td>
									</tr>
								</c:forEach>
								<c:if test="${articlePage.hasArticles()}">
									<tr>
										<td colspan="5"><c:if test="${articlePage.startPage > 5}">
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



<%@ include file="../include/footer.jsp"%>
