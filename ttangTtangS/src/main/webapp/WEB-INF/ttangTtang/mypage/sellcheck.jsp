<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<%@ include file="../include/mypageheader.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="col-lg-9">
	<form action="sellcheck" method="post">
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
									<option value="A">전체판매내역</option>
									<option value="N">판매중인내역</option>
									<option value="Y">판매완료내역</option>
								</select>&nbsp;<input type="submit" class="button" value="보기">
							</div>
							<table>
								<thead>
									<tr>
										<th>상품번호</th><!-- INO -->
										<th>카테고리</th><!-- CNAMe -->
										<th>경매/일반</th><!-- auctioncheck  -->
										<th>상품명</th><!-- INAME -->
										<th>등록날짜</th><!-- pdate  -->
										<th>판매여부</th><!-- pdate  -->
									</tr>
								</thead>
								<tbody><%-- sellCehckData.product.userId --%>
									<c:forEach var="product" items="${sellCheckPage.product}">
									<c:if test="${memberUser.userid eq product.userId}">
										<tr>
											<!-- 상품번호 -->
											<td>${product.iNo}</td>
											<!-- 카테고리 -->
											<td>${product.cCode}</td>
											<!-- 경매/일반 -->
											<td>${product.auctionCheck eq 'N'? '일반' : '경매'}</td>
											<!-- 상품명 -->
											<td><a href="productDetail?ino=${product.iNo}&aucChk=${product.auctionCheck}"><c:out value="${product.iName}" /></a>
											</td>
											<!-- 등록날짜 -->
											<td>${product.pDate}</td>
											<!-- 판매여부 -->
											<td>${product.sellCheck eq 'N'? '판매중' : '판매완료'}</td>
										</tr>
									</c:if>
									</c:forEach>
									<tr>
										<td colspan="5"><c:if
												test="${sellCheckPage.startPage > 10}">
												<a
													href="sellcheck?pageNo=${sellCheckPage.startPage - 10}">[이전]</a>
											</c:if> <c:forEach var="pNo" begin="${sellCheckPage.startPage}"
												end="${sellCheckPage.endPage}">
												<a href="sellcheck?pageNo=${pNo}">[${pNo}]</a>
											</c:forEach> <c:if
												test="${sellCheckPage.endPage < sellCheckPage.totalPages}">
												<a
													href="sellcheck?pageNo=${sellCheckPage.startPage + 10}">[다음]</a>
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
