<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../include/header.jsp"%>
<%@ include file="../../include/adminheader.jsp"%>

			<div class="col-lg-9">
				<!-- Content Header (Page header) -->
				<section class="content-header">
					<h2>사용자 회원정보 관리</h2>
				</section>
				<!-- list -->
				<section class="content">
					<div class="limiter">
						<div class="wrap-table100">
							<div class="table100">
								<div class="box">
									<form action="userinfolist.do" method="post">
										<table border="1">
											<thead>
												<tr class="table100-head">
													<td class="column5" style="padding-left: 0px;">사용자</td>
													<td class="column5" style="padding-left: 0px;">이름</td>
													<td class="column5" style="padding-left: 0px;">가입일자</td>
													<td class="column5" style="padding-left: 0px;">회원구분</td>
												</tr>
											</thead>
											<tbody>
											<c:forEach var="userinfo" items="${userinfoPage.userinfo}">
												<tr>
													<!-- 사용자 ID -->
													<td style="padding-left: 0px;"><a href="userinforead.do?id=${userinfo.userId}">
													<c:out value="${userinfo.userId}"/></a></td>
													<!-- 이름 -->
													<td style="padding-left: 0px;">${userinfo.uName}</td>
													<!-- 가입일자 -->
													<td style="padding-left: 0px;">${userinfo.dateTime}</td>
													<!--  회원구분  -->
													<td style="padding-left: 0px;">${userinfo.memberChk}</td>
												</tr>
											</c:forEach>
												<tr>
													<td colspan="5" style="padding-left: 0px;">
														<c:if test="${userinfoPage.startPage > 10}">
															<a href="userinfolist.do?pageNo=${userinfoPage.startPage - 10}">[이전]</a>
														</c:if>
														<c:forEach var="pNo" begin="${userinfoPage.startPage}" end="${userinfoPage.endPage}">
															<a href="userinfolist.do?pageNo=${pNo}">[${pNo}]</a>
														</c:forEach>
														<c:if test="${userinfoPage.endPage < userinfoPage.totalPages}">
															<a href="userinfolist.do?pageNo=${userinfoPage.startPage + 10}">[다음]</a>
														</c:if>
													</td>
												</tr>
												
												<tr>
													<td colspan="5">
														<select name="memberChk">
															<option value="0" <c:if test="${param.memberChk == 0}">seleted</c:if>>전체회원</option>
															<option value="1" <c:if test="${param.memberChk == 1}">seleted</c:if>>정규회원</option>
															<option value="2" <c:if test="${param.memberChk == 2}">seleted</c:if>>탈퇴회원</option>														
														</select>
														<input type = "submit" value ="보기">
													</td>
												</tr>
											</tbody>
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
