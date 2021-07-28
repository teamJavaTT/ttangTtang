<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="../include/header.jsp"%>
<link rel="stylesheet" href="/resources/css/admin/adminmain.css">
<section class="hero">
   <div class="container">
      <div class="row">
         <!-- admin list -->
         <div class="col-lg-3">
            <div class="hero__categories">
               <ul>
               <%@ include file="list.jsp"%>
               </ul>
            </div>
         </div>
			<div class="col-lg-9">
				<!-- Content Header (Page header) -->
				<section class="content-header">
					<h2>신고 관리</h2>
				</section>
				<!-- list -->
				<section class="content">
					<div class="limiter">
						<div class="wrap-table100">
							<div class="table100">
								<div class="box">
									<form action="declaration" method="post">
										<table border="1">
											<thead>
												<tr class="table100-head">
													<td>사용자</td>
													<td colspan="2">신고된 사용자</td>
													<td>작성일자</td>
												</tr>
											</thead>
											<tbody>
											<c:forEach var="declaration" items="${declarationPage}">
												<tr>
													<!-- 사용자 -->
													<td>${declaration.userid}</td>
													<!-- 차단된 사용자 -->
													<td colspan="2"><a href="declarationread?no=${declaration.dno}">
													<c:out value="${declaration.duid}" /></a></td>
													<!--  작성일자  -->
													<td><fmt:formatDate value="${declaration.ddate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
												</tr>
											</c:forEach>
												<tr>
													<td colspan="4" style="padding-left: 0px;">
														<ul style="text-align:center;">
															<c:if test="${pageMaker.prev}">
															 	<li style="display:inline;"><a href="declaration?page=${pageMaker.startPage - 1}">이전</a></li>
															</c:if> 
																	  
															<c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="idx">
																<li style="display:inline;"><a href="declaration?page=${(idx)}">${idx}</a></li>
															</c:forEach>
																	    
															<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
																<li style="display:inline;"><a href="declaration?page=${pageMaker.endPage + 1}">다음</a></li>
															</c:if>
														</ul>
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



<%@ include file="../include/footer.jsp"%>
