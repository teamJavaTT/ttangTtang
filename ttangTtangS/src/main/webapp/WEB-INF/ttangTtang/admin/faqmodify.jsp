<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
				<section class="content-header">
					<h2>FAQ</h2>
				</section>
				<section class="content">
					<form action="faqmodify" method="post">
						<table border="1">
							<thead>
								<tr>
									<th colspan="4">FAQ 글수정 양식</th>
								</tr>
							</thead>
							</tbody>
							<c:forEach var="faq" items="${faq}">
							<tr>
								<td style="text-align:left;" colspan="4">
								번호 : <input style="border:0px;" type="text" placeholder="번호" name="fno" value="${faq.fno}" maxlength="200" readonly></td>
							</tr>
							<tr>
								<td class="contents" colspan="4">
								<input class="title" type="text" placeholder="글 제목" name="ftit" value="${faq.ftit}" maxlength="200"></td>
							</tr>
							<tr>
								<td class="contents" colspan="4"><textarea
										rows="10" cols="100%" placeholder="내용" name="ftext">${faq.ftext}</textarea></td>
							</tr>
							<tr>
								<td class="column4"><input type="submit" value="글 등록"></td>
							</tr>
							</c:forEach>
							</tbody>
						</table>
					</form>
				</section>
			</div>
		</div>
	</div>
</section>



<%@ include file="../include/footer.jsp"%>
