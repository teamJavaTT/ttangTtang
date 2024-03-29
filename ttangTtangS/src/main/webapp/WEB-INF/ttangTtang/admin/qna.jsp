<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<link rel="stylesheet" href="/resources/css/admin/adminmain.css">
<script type="text/javascript" src="http://code.jquery.com/jquery-3.2.1.min.js"></script>
		<c:if test="${pwdNo eq 'no'}">
			<script>alert("비밀번호가 틀렸습니다.");</script>
		</c:if>
		
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
					<h2>Q&A</h2>
				</section>
				<!-- list -->
				<section class="content">
					<div class="limiter">
						<div class="wrap-table100">
							<div class="table100">							
								<div class="box">
									<table border="1">
										<thead>
											<tr>
												<td>번호</td>
												<td>작성자</td>
												<td>제목</td>
												<td>작성일자</td>
											</tr>
										</thead>
										<tbody>
										<c:forEach var="qna" items="${qnaPage}">
											<tr>
												<!-- 번호 -->
												<td>${qna.qno}</td>
												<!-- 작성자 -->
												<td>${qna.userid}</td>
												<!-- 내용 -->
												<td>
													<form action ="qnaread?no=${qna.qno}" id="pwdForm" method="post">
														<a <c:if test="${qna.qpw ne null}">class="qnaRead"</c:if><c:if test="${qna.qpw eq null || memberUser.userid eq 'admin'}">href="qnaread?no=${qna.qno}"</c:if>>${qna.qpw eq null || memberUser.userid eq 'admin' ? qna.qtit : '비밀글 입니다.'}</a>
														<input type="password" name="qnaPwd" style="display:none">
														<input type="submit" value="확인" style="display:none">
													</form>
												</td>
												<!--  작성일자  -->
												<td><fmt:formatDate value="${qna.qdate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
											</tr>
										</c:forEach>
											<tr>
												<td colspan="4">
													<ul class="pageMaker">
														<c:if test="${pageMaker.prev}">
														   <li><a href="qna?page=${pageMaker.startPage - 1}">이전</a></li>
														  </c:if> 
														  
														  <c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="idx">
														   <li><a href="qna?page=${(idx)}">${idx}</a></li>
														  </c:forEach>
														    
														  <c:if test="${pageMaker.next && pageMaker.endPage > 0}">
														   <li><a href="qna?page=${pageMaker.endPage + 1}">다음</a></li>
														  </c:if>
													</ul> 
												</td>
											</tr>
										</tbody>
									</table>
									<table>
										<tr>
											<td><a href="qnawrite">[게시글쓰기]</a></td>
										</tr>
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

<script src="/resources/js/admin/main.js"></script>

<%@ include file="../include/footer.jsp"%>
