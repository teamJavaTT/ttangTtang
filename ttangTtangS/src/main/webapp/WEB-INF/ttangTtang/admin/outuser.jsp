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
               <%@ include file="adminMenuList.jsp"%>
               </ul>
            </div>
         </div>
			<div class="col-lg-9">
				<!-- Content Header (Page header) -->
				<section class="content-header">
					<h2>탈퇴회원 관리</h2>
				</section>
				<!-- list -->
				<section class="content">
					<div class="limiter">
						<div class="wrap-table100">
							<div class="table100">
								<div class="box">
									<form action="outuser" method="post">
										<table border="1">
											<thead>
												<tr class="table100-head">
													<td>번호</td>
													<td colspan="2">사용자</td>
													<td>탈퇴일자</td>
												</tr>
											</thead>
											<tbody>
											<c:forEach var="outuser" items="${outuserPage}">
												<tr>
													<!-- 번호 -->
													<td style="padding-left: 0px;">${outuser.sno}</td>
													<!-- 탈퇴 사용자 -->
													<td colspan="2"><a href="outuserread?no=${outuser.sno}">
													<c:out value="${outuser.userid}" /></a></td>
													<!--  탈퇴일자  -->
													<td><fmt:formatDate value="${outuser.sdate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
												</tr>
											</c:forEach>
												<tr>
													<td colspan="4">
														<ul style="text-align:center;">
															<c:if test="${pageMaker.prev}">
															 	<li style="display:inline;"><a href="outuser?page=${pageMaker.startPage - 1}">이전</a></li>
															</c:if> 
																	  
															<c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="idx">
																<li style="display:inline;"><a href="outuser?page=${(idx)}">${idx}</a></li>
															</c:forEach>
																	    
															<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
																<li style="display:inline;"><a href="outuser?page=${pageMaker.endPage + 1}">다음</a></li>
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


<%@ include file="../include/footer.jsp"%>
