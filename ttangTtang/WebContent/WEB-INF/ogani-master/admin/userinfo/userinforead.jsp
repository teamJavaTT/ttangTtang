<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
									<table>
										<thead>
											<tr>
												<th colspan="4">회원 정보</th>
											</tr>
										</thead>
										<tbody>
											<tr>
												<td style="text-align: left;">
													이름 : ${userinfoData.userinfo.uName}
												</td>
											</tr>
											<tr>
												<td style="text-align: left;">
													아이디 : ${userinfoData.userinfo.userId}
												</td>
											</tr>
											<tr>
												<td style="text-align: left;">
													이메일 : ${userinfoData.userinfo.uEmail}
												</td>
											</tr>
											<tr>
												<td style="text-align: left;">
													성별 : ${userinfoData.userinfo.sex}
												</td>
											</tr>
											<tr>
												<td style="text-align: left;">
													전화번호 : ${userinfoData.userinfo.phone}
												</td>
											</tr>
											<tr>
												<td style="text-align: left;">
													주소 : ${userinfoData.userinfo.uEmail}
												</td>
											</tr>
											<tr>
												<td style="text-align: left;">
													가입일자 : ${userinfoData.userinfo.dateTime}
												</td>
											</tr>
										</tbody>
									</table>
									<table>
										<tr>
											<td colspan="2"><c:set var="pageNo"
												value="${empty param.pageNo ? '1' : param.pageNo}" />
												<input type="button" value="목록" onclick="location.href='userinfolist.do?pageNo=${pageNo}'">
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
