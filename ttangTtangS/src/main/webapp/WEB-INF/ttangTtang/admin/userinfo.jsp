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
	<form action="userinfo" method="post">
		<!-- Content Header (Page header) -->
		<section class="content-header">
			<h2>사용자 회원정보 관리</h2>

		</section>
		<!-- list -->
		<section class="content">
			<div class="limiter">
				<div class="wrap-table100">
					<div class="table100">
						<div class="box">
							<div style="float: right;">
								<select id="check" name="check">
									<option value="0"
										<c:if test="${param.check == 0}">seleted</c:if>>전체회원</option>
									<option value="1"
										<c:if test="${param.check == 1}">seleted</c:if>>정규회원</option>
									<option value="2"
										<c:if test="${param.check == 2}">seleted</c:if>>탈퇴회원</option>
								</select>&nbsp;<input type="submit" class="button" value="보기">
							</div>
							<table border="1">
								<thead>
									<tr>
										<td>사용자</td>
										<td>이름</td>
										<td>가입일자</td>
										<td>회원구분</td>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="userinfo" items="${userInfoPage}">
										<tr>
											<!-- 사용자 ID -->
											<td><a href="userinforead?id=${userinfo.userid}">
													<c:out value="${userinfo.userid}" />
											</a></td>
											<!-- 이름 -->
											<td>${userinfo.uname}</td>
											<!-- 가입일자 -->
											<td><fmt:formatDate value="${userinfo.datetime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
											<!--  회원구분  -->
											<td>${userinfo.memberchk}</td>
										</tr>
									</c:forEach>
									<tr>
										<td colspan="5">
											<ul class="pageMaker">
												<c:if test="${pageMaker.prev}">
												 	<li><a href="userinfo?page=${pageMaker.startPage - 1}">이전</a></li>
												</c:if> 
														  
												<c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="idx">
													<li><a href="userinfo?page=${(idx)}">${idx}</a></li>
												</c:forEach>
														    
												<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
													<li><a href="userinfo?page=${pageMaker.endPage + 1}">다음</a></li>
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
