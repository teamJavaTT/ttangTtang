<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<%@ include file="../include/mypageheader.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="col-lg-9">
	<form action="declarationAndBlockList.do" method="post">
		<!-- Content Header (Page header) -->
		<section class="content-header">
		<c:if test="${param.sellChk eq 'D' || emptparam.sellChk}">
			<h3>신고 내역</h3>
		</c:if>
		<c:if test="${param.sellChk eq 'B'}">
			<h3>차단 내역</h3>
		</c:if>
		</section>
		<!-- list -->
		<section class="content">
			<div class="limiter">
				<div class="wrap-table100">
					<div class="table100">
						<div class="box">
							<div style="float: right;">
								<input type="radio" name="sellChk" value="D">신고리스트
								<input type="radio" name="sellChk" value="B">차단리스트
								<input type="submit" class="button" value="보기">
							</div>

							<table>
								<thead>
									<tr>
										
										<th>아이디</th>
										<!-- CNAMe -->
										<th>종류</th>
										<!-- REASON -->
										<th>날짜</th>
										<!-- DATE  -->

									</tr>
								</thead>
								<tbody>
									<c:if test="${key eq 'D'}">
										<c:forEach var="declaration" items="${listPage.declaration}">
											<tr>
												
												
												<%-- <!-- 신고/차단 -->
											<td>${declaration.auctionCheck eq 'N'? '신고' : '차단'}</td> --%>
												<!-- 신고 아이디 -->
												<td>${declaration.duid}</td>
												<!-- 상품명 -->
												<td><c:out value="${declaration.dtext}" /></td>
												<!-- 등록날짜 -->
												<td>${declaration.ddate}</td>

											</tr>
										</c:forEach>
									</c:if>
									<c:if test="${key eq 'B'}">
										<c:forEach var="block" items="${listPage.block}">
											<tr>
												
												<%-- <!-- 신고/차단 -->
											<td>${declaration.auctionCheck eq 'N'? '신고' : '차단'}</td> --%>
												<!-- 차단 아이디 -->
												<td>${block.bid}</td>
												<!-- 상품명 -->
												<td><c:out value="${block.btext}" /></td>
												<!-- 등록날짜 -->
												<td>${block.bdate}</td>

											</tr>
										</c:forEach>
									</c:if>
									<tr>
										<td colspan="5"><c:if test="${listPage.startPage > 10}">
												<a
													href="declarationAndBlock.do?pageNo=${listPage.startPage - 10}">[이전]</a>
											</c:if> <c:forEach var="pNo" begin="${listPage.startPage}"
												end="${listPage.endPage}">
												<a href="declarationAndBlock.do?pageNo=${pNo}">[${pNo}]</a>
											</c:forEach> <c:if test="${listPage.endPage < listPage.totalPages}">
												<a
													href="declarationAndBlock.do?pageNo=${listPage.startPage + 10}">[다음]</a>
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
