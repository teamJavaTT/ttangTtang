<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="../include/header.jsp"%>
<script type="text/javascript" src="http://code.jquery.com/jquery-3.2.1.min.js"></script>

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
		<h2>공지사항</h2>
	</section>
	<!-- list -->
	<section class="content">
		<div class="limiter">
			<div class="wrap-table100">
				<div class="table100">
					<!-- Default box -->
					<div class="box">
						<table border="1">
							<thead>
								<tr>
									<th colspan="4">게시물</th>
								</tr>
							</thead>
							<tbody>
							<c:forEach var="notice" items="${notice}">
								<tr>
									<td style="text-align: left;">번호 :	${notice.mno}</td>
									<td style="text-align: left;">작성일자 : <fmt:formatDate value="${notice.mdate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
								</tr>
								<tr>
									<td colspan="4" style="text-align: left; font-weight: bold; font-size: 20px">${notice.mtit}</td>
								</tr>
								<tr style="height: 100px;">
									<td colspan="4" style="text-align: left;">${notice.mtext}</td>
								</tr>
							
							<tr>
								<td colspan="2">
								<c:set var="pageNo" value="${empty param.pageNo ? '1' : param.pageNo}" /> 
												<input type="button" value="목록" onclick="location.href='notice'">
													<c:if test="${memberUser.userid eq 'admin'}">
														<input type="button" value="게시글수정" onclick="location.href='noticemodify?no=${notice.mno}'">
														<input type="hidden" value="${notice.mno}" id="delNo">
														<input type="button" value="게시글삭제" id="noticeDel">
													</c:if>
												</td>
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

<script src="/ttangTtang/js/admin/main.js"></script>

<%@ include file="../include/footer.jsp"%>
