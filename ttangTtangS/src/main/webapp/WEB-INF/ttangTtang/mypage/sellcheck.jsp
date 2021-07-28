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
									<option value="A" <c:if test="${param.sellChk eq 'A'}">selected</c:if>>전체판매내역</option>
									<option value="N" <c:if test="${param.sellChk eq 'N'}">selected</c:if>>판매중인내역</option>
									<option value="Y" <c:if test="${param.sellChk eq 'Y'}">selected</c:if>>판매완료내역</option>
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
									<c:forEach var="product" items="${sellList}">
										<tr>
											<!-- 상품번호 -->
											<td>${product.ino}</td>
											<!-- 카테고리 -->
											<td>${product.ccode}</td>
											<!-- 경매/일반 -->
											<td>${product.auctioncheck eq 'N'? '일반' : '경매'}</td>
											<!-- 상품명 -->
											<td><a href="productDetail?ino=${product.ino}&aucChk=${product.auctioncheck}"><c:out value="${product.iname}" /></a>
											</td>
											<!-- 등록날짜 -->
											<td>${product.pdate}</td>
											<!-- 판매여부 -->
											<td>${product.sellcheck eq 'N'? '판매중' : '판매완료'}</td>
										</tr>
									</c:forEach>
									<tr>
										<td colspan="5">
											<ul style="text-align:center;">
												<c:if test="${pageMaker.prev}">
												 	<li style="display:inline;"><a href="sellcheck?page=${pageMaker.startPage - 1}">이전</a></li>
												</c:if> 
														  
												<c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="idx">
													<li style="display:inline;"><a href="sellcheck?page=${(idx)}&sellChk=${param.sellChk}">${idx}</a></li>
												</c:forEach>
														    
												<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
													<li style="display:inline;"><a href="sellcheck?page=${pageMaker.endPage + 1}">다음</a></li>
												</c:if>
											</ul>
										</td>
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
