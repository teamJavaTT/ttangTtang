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
				<h2>FAQ</h2>
			</section>
			<!-- list -->
			<section class="content">
				<div class="limiter">
					<div class="wrap-table100">
						<div class="table100">
							<!-- Default box -->
							<div class="box">
								<form action="faq" method="post">
									<table border="1">
										<thead>
											<tr class="table100-head">
												<td>번호</td>
												<td colspan="2">제목</td>
												<td>작성일자</td>
												<!-- <td class="column5">조회수</td> -->
											</tr>
										</thead>
										<tbody>
											<c:forEach var="faq" items="${faqPage}">
												<tr>
													<!-- 번호 -->
													<td>${faq.fno}</td>
													<!-- 내용 -->
													<td colspan="2">
														<a href="faqread?no=${faq.fno}"><c:out value="${faq.ftit}" /></a>
													</td>
													<!--  작성일자  -->
													<td><fmt:formatDate value="${faq.fdate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
												</tr>
											</c:forEach>
											<tr>
												<td colspan="4">
													<ul class="pageMaker">
														<c:if test="${pageMaker.prev}">
														 	<li><a href="faq?page=${pageMaker.startPage - 1}">이전</a></li>
														</c:if> 
																  
														<c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="idx">
															<li><a href="faq?page=${(idx)}">${idx}</a></li>
														</c:forEach>
																    
														<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
															<li><a href="faq?page=${pageMaker.endPage + 1}">다음</a></li>
														</c:if>
													</ul>
												</td>
											</tr>
										</tbody>
									</table>
									<c:if test="${memberUser.userid eq 'admin'}">
										<table>
											<tr>
												<td colspan="1"><a href="faqwrite">[게시글쓰기]</a></td>
											</tr>
										</table>
									</c:if>
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
