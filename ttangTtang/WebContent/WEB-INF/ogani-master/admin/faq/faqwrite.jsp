<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../include/header.jsp"%>
<%@ include file="../../include/adminheader.jsp"%>

			<div class="col-lg-9">
				<section class="content-header">
					<h2>공지사항</h2>
				</section>
				<section class="content">
					<form action="faqwrite.do" method="post">
						<table>
							<thead>
								<tr>
									<th colspan="4" style="text-align: center;">FAQ 글쓰기 양식</th>
								</tr>
							</thead>
							</tbody>
							<tr>
								<td class="contents" colspan="4" style="padding-left: 0px;">
									<input type="text" placeholder="글 제목" name="title" maxlength="200">
								</td>
							</tr>
							<tr>
								<td class="contents" colspan="4" style="padding-left: 0px;">
									<textarea rows="10" cols="100%" placeholder="내용" name="content"></textarea>
								</td>
							</tr>
							<tr>
								<td class="column4"><input type="submit" value="글 등록"></td>
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
