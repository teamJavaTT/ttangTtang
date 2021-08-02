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
					<h2>Q&A</h2>
				</section>
				<section class="content">
					<form action="qnawrite" method="post">
					<input type="hidden" name="userid" value="${memberUser.userid}">
						<table border="1">
							<thead>
								<tr>
									<th colspan="4">Q&A 글쓰기 양식</th>
								</tr>
							</thead>
							</tbody>
								<tr>
									<td colspan="4"><input type="text" class="title" placeholder="글 제목" name="qtit" maxlength="200"></td>
								</tr>
								<tr>
									<td colspan="4"><textarea rows="10" cols="100%" placeholder="내용" name="qtext"></textarea></td>
								</tr>
								<tr>
									<td colspan="4"><input type="password" class="title" placeholder="비밀번호" name="qpw" maxlength="200"></td>
								</tr>
								<tr>
									<td><input type="submit" value="글 등록"></td>
								</tr>
							</tbody>
						</table>
					</form>
				</section>
			</div>
		</div>
	</div>
</section>



<%@ include file="../include/footer.jsp"%>
