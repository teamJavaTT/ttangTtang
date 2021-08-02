<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<link rel="stylesheet" href="/resources/css/mypage/mypagemain.css">

<!-- Hero Section Begin -->
<section class="hero">
	<div class="container">
		<div class="row">
			<!-- admin list -->
			<div class="col-lg-3">
				<div class="hero__categories">
					<ul><%@ include file="mypageMenuList.jsp"%></ul>
				</div>
			</div>
			<div class="col-lg-9" id=likeProduct>
				<h3 style="margin-bottom: 30px;">알림내역</h3>
				<section class="content-header"></section>
				<!-- list -->
				<section class="content">
					<div class="limiter">
						<div class="wrap-table100">
							<div class="table100">
								<div class="box">
									<table>
										<tbody>
											<c:forEach var="alimList" items="${alimAll}">
												<c:if test="${alimList.alimchk eq 'N'}">
													<tr style="height: 50px;">
														<td><b><fmt:formatDate value="${alimList.ldate}" pattern="yyyy-MM-dd HH:mm:ss" /></b></td>
														<td style="font-size: 1.1em;"><b>${alimList.ltext}</b></td>
													</tr>
												</c:if>
												<c:if test="${alimList.alimchk eq 'Y'}">
													<tr style="height: 50px;">
														<td>${alimList.ldate}</td>
														<td>${alimList.ltext}</td>
													</tr>
												</c:if>
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
