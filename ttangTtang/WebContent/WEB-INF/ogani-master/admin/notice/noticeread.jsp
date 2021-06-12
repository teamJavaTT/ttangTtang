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
													번호 : ${noticeData.notice.mno}
												</td>
												<td style="text-align: left;">
													작성일자 : ${noticeData.notice.mdate}
												</td>
											</tr>
											<tr style="border-bottom: 1px solid #444444;">
												<td colspan="4" style="text-align: left; font-weight: bold; font-size: 20px">
													제목 : ${noticeData.notice.mtit}
												</td>
											</tr>
											<tr style="border-bottom: 1px solid #444444;">
												<td style="text-align: left;">
													내용 : ${noticeData.notice.mtext}
												</td>
											</tr>
										</tbody>
										<tr>
											<td colspan="2" style="padding-left: 0px;"><c:set var="pageNo"
												value="${empty param.pageNo ? '1' : param.pageNo}" />
												<input type="button" value="목록" onclick="location.href='noticelist.do?pageNo=${pageNo}'">
												<c:if test="${authUser.id == articleData.article.writer.id}">
													<input type="button" value="게시글수정" onclick="location.href='noticemodify.do?no=${noticeData.notice.mno}'">
													<input type="hidden" value="${noticeData.notice.mno}" id="delNo">
													<input type="button" value="게시글삭제" id="noticeDel">
												</c:if>
											</td>
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
