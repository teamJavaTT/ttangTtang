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
         </div>			<div class="col-lg-9">
				<section class="content-header">
					<h2>블랙리스트 관리</h2>
				</section>
				<section class="content">
					<div class="limiter">
						<div class="wrap-table100">
							<div class="table100">
								<div class="box">
									<table border="1">
										<thead>
											<tr>
												<th colspan="4" style="text-align: center; padding-left: 0px;">게시물</th>
											</tr>
										</thead>
										<tbody>
										<c:forEach var="blacklist" items="${blacklist}">
											<tr>
												<td style="text-align: left;">
													번호 : ${blacklist.bno}
												</td>
												<td style="text-align: left;">
													작성일자 : <fmt:formatDate value="${blacklist.bdate}" pattern="yyyy-MM-dd HH:mm:ss"/>
												</td>
											</tr>
											<tr>
												<td colspan="4" style="text-align: left;">
													사용자 : ${blacklist.userid}
												</td>
											</tr>
											<tr>
												<td colspan="4" style="text-align: left; font-weight: bold; font-size: 20px">
													차단된 사용자 : ${blacklist.bid}
												</td>
											</tr>
											<tr>
												<td colspan="4" style="text-align: left;">
													내용 : ${blacklist.btext}
												</td>
											</tr>
										</c:forEach>
										</tbody>
										<tr>
											<td colspan="4">
												<input type="button" value="목록" onclick="location.href='blacklist'">
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
