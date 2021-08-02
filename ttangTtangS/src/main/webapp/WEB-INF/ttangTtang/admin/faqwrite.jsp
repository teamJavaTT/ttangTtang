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
					<form action="faqwrite" method="post">
						<table>
							<thead>
								<tr>
									<th colspan="4">FAQ 글쓰기 양식</th>
								</tr>
							</thead>
							</tbody>
							<tr>
								<td>
									<input type="text" class="title" placeholder="글 제목" name="ftit" maxlength="200">
								</td>
							</tr>
							<tr>
								<td>
									<textarea rows="10" cols="100%" placeholder="내용" name="ftext"></textarea>
								</td>
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
