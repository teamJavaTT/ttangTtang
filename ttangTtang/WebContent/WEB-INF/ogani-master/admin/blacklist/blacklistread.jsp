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
				<section class="content-header">
					<h2>블랙리스트 관리</h2>
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
													번호 : ${blacklistData.blacklist.bNo}
												</td>
												<td style="text-align: left;">
													작성일자 : ${blacklistData.blacklist.bDate}
												</td>
											</tr>
											<tr style="border-bottom: 1px solid #444444;">
												<td colspan="4" style="text-align: left;">
													사용자 : ${blacklistData.blacklist.userId}
												</td>
											</tr>
											<tr style="border-bottom: 1px solid #444444;">
												<td colspan="4" style="text-align: left; font-weight: bold; font-size: 20px">
													차단된 사용자 : ${blacklistData.blacklist.bId}
												</td>
											</tr>
											<tr style="border-bottom: 1px solid #444444;">
												<td colspan="4" style="text-align: left;">
													내용 : ${blacklistData.blacklist.bText}
												</td>
											</tr>
										</tbody>
										<tr>
											<td colspan="2" style="padding-left: 0px;"><c:set var="pageNo"
												value="${empty param.pageNo ? '1' : param.pageNo}" />
												<input type="button" value="목록" onclick="location.href='blacklist.do?pageNo=${pageNo}'">
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


<%@ include file="../../include/footer.jsp"%>
