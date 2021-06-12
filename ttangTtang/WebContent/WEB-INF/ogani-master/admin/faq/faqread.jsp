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
					<h2>FAQ</h2>
				</section>
				<section class="content">
					<div class="limiter">
						<div class="wrap-table100">
							<div class="table100">
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
													번호 : ${faqData.faq.fno}
												</td>
												<td style="text-align: left;">
													작성일자 : ${faqData.faq.fdate}
												</td>
											</tr>
											<tr style="border-bottom: 1px solid #444444;">
												<td colspan="4" style="text-align: left; font-weight: bold; font-size: 20px">
													제목 : ${faqData.faq.ftit}
												</td>
											</tr>
											<tr style="border-bottom: 1px solid #444444;">
												<td style="text-align: left;">
													내용 : ${faqData.faq.ftext}
												</td>
											</tr>
										</tbody>
										<tr>
											<td colspan="2" style="padding-left: 0px;"><c:set var="pageNo"
												value="${empty param.pageNo ? '1' : param.pageNo}" />
												<input type="button" value="목록" onclick="location.href='faqlist.do?pageNo=${pageNo}'">
												<input type="button" value="게시글수정" onclick="location.href='faqmodify.do?no=${faqData.faq.fno}'">
												<input type="hidden" value="${faqData.faq.fno}" id="delNo">
												<input type="button" value="게시글삭제" id="faqDel">
											</td>
										</tr>
									</table>
								</div>
							</div>
						</div>
					</div>
				</section>
			</div>
		</div>
	</div>
</section>

<script src="/ttangTtang/js/admin/main.js"></script>

<%@ include file="../../include/footer.jsp"%>
