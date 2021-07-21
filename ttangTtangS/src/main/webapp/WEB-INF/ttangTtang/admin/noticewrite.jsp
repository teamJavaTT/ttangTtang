<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/adminheader.jsp"%>
			<div class="col-lg-9">
				<section class="content-header">
					<h2>공지사항</h2>
				</section>
				<section class="content">
					<form action="noticewrite" method="post">
						<table border="1">
							<thead>
								<tr>
									<th>공지사항 글쓰기 양식</th>
								</tr>
							</thead>
							</tbody>
							<tr>
								<td>
									<input type="text" class="title" placeholder="글 제목" name="mtit" maxlength="200">
								</td>
							</tr>
							<tr>
								<td>
									<textarea rows="10" cols="100%" placeholder="내용" name="mtext"></textarea>
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
