<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../include/header.jsp"%>

<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->
<link rel="icon" type="image/png" href="images/icons/favicon.ico" />
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="vendor/select2/select2.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="vendor/perfect-scrollbar/perfect-scrollbar.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css" href="css/util.css">
<link rel="stylesheet" type="text/css" href="css/main.css">
<!--===============================================================================================-->

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
						<li><a href="/ttangTtang/ogani-master/admin/qna.jsp">Q&A</a></li>
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
				<!-- Content Header (Page header) -->
				<section class="content-header">
					<h2>FAQ</h2>
				</section>
				<!-- list -->
				<section class="content">
					<div class="limiter">
						<div class="wrap-table100">
							<div class="table100">
								<!-- Default box -->
								<div class="box">
								<form action="faqlist.do" method="post">
									<table border="1">
										<thead>
											<tr class="table100-head">
												<td class="column5" style="padding-left: 0px;">번호</td>
												<td class="column1" colspan="2" style="padding-left: 0px;">제목</td>
												<td class="column5" style="padding-left: 0px;">작성일자</td>
												<!-- <td class="column5">조회수</td> -->
											</tr>
										</thead>
										<tbody>
										<c:forEach var="faq" items="${faqPage.faq}">
											<tr>
													<!-- 번호 -->
													<td style="padding-left: 0px;">${faq.fno}</td>
													<!-- 내용 -->
													<td colspan="2" style="padding-left: 0px;"><a href="faqread.do?no=${faq.fno}">
													<c:out value="${faq.ftit}" /></a></td>
													<!--  작성일자  -->
													<td style="padding-left: 0px;">${faq.fdate}</td>
													<%-- <td>${article.readCount}</td> --%>
												</tr>
										</c:forEach>
											<tr>
													<td colspan="4" style="padding-left: 0px;">
														<c:if test="${faqPage.startPage > 10}">
															<a href="faqlist.do?pageNo=${faqPage.startPage - 10}">[이전]</a>
														</c:if>
														<c:forEach var="pNo" begin="${faqPage.startPage}" end="${faqPage.endPage}">
															<a href="faqlist.do?pageNo=${pNo}">[${pNo}]</a>
														</c:forEach>
														<c:if test="${faqPage.endPage < faqPage.totalPages}">
															<a href="faqlist.do?pageNo=${faqPage.startPage + 10}">[다음]</a>
														</c:if>
													</td>
												</tr>
											</tbody>
										</table>
										<table style="text-align: center;">
											<tr>
												<td class="column4" colspan="1"><a href="faqwrite.do">[게시글쓰기]</a></td>
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
