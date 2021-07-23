<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/adminheader.jsp"%>

			<div class="col-lg-9">
				<section class="content-header">
					<h2>탈퇴회원 관리</h2>
				</section>
				<section class="content">
					<div class="limiter">
						<div class="wrap-table100">
							<div class="table100">
								<div class="box">
									<table border="1">
										<thead>
											<tr>
												<th colspan="4">게시물</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="outuser" items="${outuser}">
												<tr>
													<td colspan="4" style="text-align: left;">
														번호 : ${outuser.sno}
													</td>
												</tr>
												<tr>
													<td colspan="2" style="text-align: left;">
														탈퇴신청일자 : ${outuser.sdate}
													</td>
												
													<td colspan="2" style="text-align: left;">
														탈퇴확정일자 : ${outuser.scdate}
													</td>
												</tr>
												<tr>
													<td colspan="4" style="text-align: left; font-weight: bold; font-size: 20px">
														탈퇴한 사용자 : ${outuser.userid}
													</td>
												</tr>
												<tr>
													<td colspan="4" style="text-align: left;">
														내용 : ${outuser.stext}
													</td>
												</tr>
											</c:forEach>
										</tbody>
										<tr>
											<td colspan="4">
												<input type="button" value="목록" onclick="location.href='outuser'">
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



<%@ include file="../include/footer.jsp"%>
