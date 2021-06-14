<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../include/header.jsp"%>
<%@ include file="../../include/adminheader.jsp"%>

<script type="text/javascript" src="http://code.jquery.com/jquery-3.2.1.min.js"></script>

			<div class="col-lg-9">
				<section class="content-header">
					<h2>사용자 회원정보 관리</h2>
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
