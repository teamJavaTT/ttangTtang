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
						<li><a href="/ttangTtang/ogani-master/admin/faq.jsp">FAQ</a></li>
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
					<h2>공지사항</h2>
				</section>
				<!-- list -->
				<section class="content">
					<div class="limiter">
						<div class="wrap-table100">
							<div class="table100">
								<!-- Default box -->
								<div class="box">
									<table border="1" width="100%">
										<thead>
											<tr>
												<th colspan="4" style="text-align: center; padding-left: 0px;">게시물</th>
											</tr>
										</thead>
										<tbody>
											<tr style="border-bottom: 1px solid #444444;">
												<td style="text-align: left;">
													번호 : ${notice.mno}
												</td>
												<td style="text-align: left;">
													작성일자 : ${notice.mdate}
												</td>
											</tr>
											<tr style="border-bottom: 1px solid #444444;">
												<td colspan="4" style="text-align: left; font-weight: bold; font-size: 20px">
													제목 : ${notice.mtit}
												</td>
											</tr>
											<tr style="border-bottom: 1px solid #444444;">
												<td style="text-align: left;">
													내용 : ${notice.mtext}
												</td>
											</tr>
										</tbody>
										
										
										<%-- <tr>
											<td colspan="1">번호</td>
											<td>${articleData.article.number}</td>
										</tr>
										<tr>
											<td colspan="1">작성자</td>
											<td>${articleData.article.writer.name}</td>
										</tr>
										<tr>
											<td colspan="1">제목</td>
											<td><c:out value='${articleData.article.title}' /></td>
										</tr>
										<tr>
											<td colspan="1">내용</td>
											<td><u:pre value='${articleData.content}' /></td>
										</tr> --%>
										<tr>
											<td colspan="2" style="padding-left: 0px;"><c:set var="pageNo"
													value="${empty param.pageNo ? '1' : param.pageNo}" /> <a
												href="list.do?pageNo=${pageNo}">[목록]</a> <c:if
													test="${authUser.id == articleData.article.writer.id}">
													<a href="modify.do?no=${articleData.article.number}">[게시글수정]</a>
													<a href="/ttangTtang/ogani-master/admin/noticedelete.jsp<%-- delete.do?no=${articleData.article.number} --%>">[게시글삭제]</a>
												</c:if></td>
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



<%@ include file="../../include/footer.jsp"%>
