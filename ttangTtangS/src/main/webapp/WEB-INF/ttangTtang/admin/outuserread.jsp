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
				<section class="content-header">
					<h2>탈퇴회원 관리</h2>
				</section>
				<section class="content">
					<div class="limiter">
						<div class="wrap-table100">
							<div class="table100">
								<div class="box">
									<table border="1">
										<thead>
											<tr>
												<th colspan="4">게시물</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="outuser" items="${outuser}">
												<tr>
													<td colspan="4" style="text-align: left;">
														번호 : ${outuser.sno}
													</td>
												</tr>
												<tr>
													<td colspan="2" style="text-align: left;">
														탈퇴신청일자 : <fmt:formatDate value="${outuser.sdate}" pattern="yyyy-MM-dd HH:mm:ss"/>
													</td>
												
													<td colspan="2" style="text-align: left;">
														탈퇴확정일자 : <fmt:formatDate value="${outuser.scdate}" pattern="yyyy-MM-dd HH:mm:ss"/>
													</td>
												</tr>
												<tr>
													<td colspan="4" style="text-align: left; font-weight: bold; font-size: 20px">
														탈퇴한 사용자 : ${outuser.userid}
													</td>
												</tr>
												<tr>
													<td colspan="4" style="text-align: left;">
														내용 : ${outuser.stext}
													</td>
												</tr>
											</c:forEach>
										</tbody>
										<tr>
											<td colspan="4">
												<input type="button" value="목록" onclick="location.href='outuser'">
											</td>
										</tr>
									</table>
								</div>
							</div>
						</div>
					</div>
				</section>
			</div>
		</div>
	</div>
</section>



<%@ include file="../include/footer.jsp"%>
