<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<%@ include file="../include/mypageheader.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
									<c:if test="${alimList.alimChk eq 'N'}">
										<tr style="height:50px;">
											<td><b>${alimList.lDate}</b></td>
											<td style="font-size: 1.1em;"><b>${alimList.lText}</b></td>
										</tr>
									</c:if>
									<c:if test="${alimList.alimChk eq 'Y'}">
									<tr style="height:50px;">
										<td>${alimList.lDate}</td>
										<td>${alimList.lText}</td>
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
