<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<%@ include file="../include/mypageheader.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="col-lg-9">
	<form action="sellcheck.do" method="post">
		<!-- Content Header (Page header) -->
		<section class="content-header">
			<h2>판매 내역</h2>

		</section>
		<!-- list -->
		<section class="content">
			<div class="limiter">
				<div class="wrap-table100">
					<div class="table100">
						<div class="box">
							<div style="float: right;">
								<select name="sellChk">
									<option value="A">전체리스트</option>
									<option value="N">신고리스트</option>
									<option value="Y">차단리스트</option>
								</select>&nbsp;<input type="submit" class="button" value="보기">
							</div>
							<table>
								<thead>
									<tr>
										<th>아이디</th><!-- USERID -->
										<th>종류</th><!-- CNAMe -->
										<th>설명</th><!-- REASON -->
										<th>등록날짜</th><!-- DATE  -->
										
									</tr>
								</thead>
								<tbody><%-- sellCehckData.product.userId --%>
									<c:forEach var="product" items="${sellCheckPage.product}">
									<c:if test="${memberUser.userid eq product.userId}">
										<tr>
											<!-- 아이디 -->
											<td>${list.iNo}</td>
											<!-- 신고/차단 -->
											<td>${list.auctionCheck eq 'N'? '신고' : '차단'}</td>
											<!-- 설명 -->
											<td>${list.cCode}</td>
											<!-- 상품명 -->
											<td><c:out value="${product.iName}" />
											</td>
											<!-- 등록날짜 -->
											<td>${product.pDate}</td>
											
										</tr>
									</c:if>
									</c:forEach>
									<tr>
										<td colspan="5"><c:if
												test="${sellCheckPage.startPage > 10}">
												<a
													href="sellcheck.do?pageNo=${listPage.startPage - 10}">[이전]</a>
											</c:if> <c:forEach var="pNo" begin="${sellCheckPage.startPage}"
												end="${listCheckPage.endPage}">
												<a href="sellcheck.do?pageNo=${pNo}">[${pNo}]</a>
											</c:forEach> <c:if
												test="${listCheckPage.endPage < listPage.totalPages}">
												<a
													href="DeclarationAndBlock.do?pageNo=${listPage.startPage + 10}">[다음]</a>
											</c:if></td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
			<!-- /.box -->
		</section>
		<!-- /.content -->
	</form>
</div>
</div>
</div>
<!-- /.content-wrapper -->
</section>
<!-- Hero Section End -->

<%@ include file="../include/footer.jsp"%>
