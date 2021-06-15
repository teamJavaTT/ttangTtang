<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../include/header.jsp"%>
<%@ include file="../../include/adminheader.jsp"%>

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
													번호 : ${outuserData.outuser.sNo}
												</td>
											</tr>
											<tr style="border-bottom: 1px solid #444444;">
												<td colspan="2" style="text-align: left;">
													탈퇴신청일자 : ${outuserData.outuser.sDate}
												</td>
											
												<td colspan="2" style="text-align: left;">
													탈퇴확정일자 : ${outuserData.outuser.scDate}
												</td>
											</tr>
											<tr style="border-bottom: 1px solid #444444;">
												<td colspan="4" style="text-align: left; font-weight: bold; font-size: 20px">
													탈퇴한 사용자 : ${outuserData.outuser.userId}
												</td>
											</tr>
											<tr style="border-bottom: 1px solid #444444;">
												<td colspan="4" style="text-align: left;">
													내용 : ${outuserData.outuser.sText}
												</td>
											</tr>
										</tbody>
										<tr>
											<td colspan="2" style="padding-left: 0px;"><c:set var="pageNo"
												value="${empty param.pageNo ? '1' : param.pageNo}" />
												<input type="button" value="목록" onclick="location.href='outuserlist.do?pageNo=${pageNo}'">
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
