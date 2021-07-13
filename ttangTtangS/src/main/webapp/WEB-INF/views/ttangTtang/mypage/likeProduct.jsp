<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<%@ include file="../include/mypageheader.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="col-lg-9" id=likeProduct>
	
		<h3 style="margin-bottom: 30px;">관심상품</h3>
	



	<!-- Content Header (Page header) -->
	<section class="content-header"></section>
	<!-- list -->
	<section class="content">
		<div class="limiter">
			<div class="wrap-table100">
				<div class="table100">
					<div class="box">
						<table>
							<thead>
								<tr>

									<th>번호</th>
									<th>관심상품</th>
									<th>가격</th>
									<th>경매 종료시간</th>


								</tr>
							</thead>
							<tbody>
								<c:forEach var="likeProduct" items="${likeProduct}">
									<tr>


										<%-- <!-- 신고/차단 -->
											<td>${declaration.auctionCheck eq 'N'? '신고' : '차단'}</td> --%>
										<!-- 신고 아이디 -->
										<td>${likeProduct.ino}</td>
										<td>${likeProduct.iname}</td>
										<c:if test="${likeProduct.auctioncheck=='N' }">
											<td>${likeProduct.price}</td>
										</c:if>
										<c:if test="${likeProduct.auctioncheck=='Y' }">
											<td>${likeProduct.apricenow}</td>
										</c:if>
										<td>${likeProduct.endtime}</td>


									</tr>
								</c:forEach>


							</tbody>
						</table>
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

<%@ include file="../include/footer.jsp"%>
