<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/adminheader.jsp"%>

			<div class="col-lg-9">
				<section class="content-header">
					<h2>FAQ</h2>
				</section>
				<section class="content">
					<form action="faqwrite.do" method="post">
						<table>
							<thead>
								<tr>
									<th colspan="4">FAQ 글쓰기 양식</th>
								</tr>
							</thead>
							</tbody>
							<tr>
								<td>
									<input type="text" class="title" placeholder="글 제목" name="title" maxlength="200">
								</td>
							</tr>
							<tr>
								<td>
									<textarea rows="10" cols="100%" placeholder="내용" name="content"></textarea>
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
