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
               <%@ include file="list.jsp"%>
               </ul>
            </div>
         </div>
			<div class="col-lg-9">
				<section class="content-header">
					<h2>Q&A</h2>
				</section>
				<section class="content">
					<form action="qnamodify" method="post">
						<table border="1">
							<thead>
								<tr>
									<th colspan="4" style="text-align: center;">Q&A 글수정 양식</th>
								</tr>
							</thead>
							</tbody>
							<c:forEach var="qna" items="${qna}">
								<input type="hidden" name="userid" value="${qna.userid}">
								<input type="hidden" name="qno" value="${qna.qno}">
								<tr>
									<td colspan="4" style="text-align: left;">
									<input class="title" type="text" placeholder="글 제목" name="qtit" value="${qna.qtit}" maxlength="200"></td>
								</tr>
								<tr>
									<td colspan="4" style="text-align: left;"><textarea
											rows="10" cols="100%" placeholder="내용" name="qtext">${qna.qtext}</textarea></td>
								</tr>
								<tr>
									<td colspan="4">
									<input type="password" class="title" placeholder="비밀번호" name="qpw" value="${qna.qpw}" maxlength="200"></td>
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
