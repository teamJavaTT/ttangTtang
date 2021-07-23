<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/adminheader.jsp"%>

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
									<table border="1">
										<thead>
											<tr>
												<th colspan="4">회원 정보</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="userinfo" items="${userInfo}">
												<tr>
													<td style="text-align: left;">
														이름 : ${userinfo.uname}
													</td>
												</tr>
												<tr>
													<td style="text-align: left;">
														아이디 : ${userinfo.userid}
													</td>
												</tr>
												<tr>
													<td style="text-align: left;">
														이메일 : ${userinfo.uemail}
													</td>
												</tr>
												<tr>
													<td style="text-align: left;">
														성별 : ${userinfo.sex}
													</td>
												</tr>
												<tr>
													<td style="text-align: left;">
														전화번호 : ${userinfo.phone}
													</td>
												</tr>
												<tr>
													<td style="text-align: left;">
														주소 : ${userinfo.uemail}
													</td>
												</tr>
												<tr>
													<td style="text-align: left;">
														가입일자 : ${userinfo.datetime}
													</td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
									<table>
										<tr>
											<td colspan="2">
												<input type="button" value="목록" onclick="location.href='userinfo'">
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

<%@ include file="../include/footer.jsp"%>
