<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../include/adminheader.jsp"%>

			<div class="col-lg-9">
				<section class="content-header">
					<h2>Q&A</h2>
				</section>
				<section class="content">
					<form action="qnawrite.do" method="post">
					<input type="hidden" name="userid" value="${memberUser.userid}">
						<table border="1">
							<thead>
								<tr>
									<th colspan="4">Q&A 글쓰기 양식</th>
								</tr>
							</thead>
							</tbody>
								<tr>
									<td colspan="4"><input type="text" class="title" placeholder="글 제목" name="title" maxlength="200"></td>
								</tr>
								<tr>
									<td colspan="4"><textarea rows="10" cols="100%" placeholder="내용" name="content"></textarea></td>
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



<%@ include file="../../include/footer.jsp"%>
