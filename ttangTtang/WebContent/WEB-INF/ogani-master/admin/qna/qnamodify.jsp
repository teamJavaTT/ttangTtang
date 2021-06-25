<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../include/adminheader.jsp"%>

			<div class="col-lg-9">
				<section class="content-header">
					<h2>Q&A</h2>
				</section>
				<section class="content">
					<form action="qnamodify.do" method="post">
						<table border="1">
							<thead>
								<tr>
									<th colspan="4" style="text-align: center;">Q&A 글수정 양식</th>
								</tr>
							</thead>
							</tbody>
								<tr>
									<td colspan="4" style="padding-left: 0px;">
									아이디 : <input style="border:0px;" type="text" placeholder="아이디" name="id" value="${qnaData.qna.userid}" maxlength="200" readonly></td>
								</tr>
								<tr>
									<td colspan="4" style="padding-left: 0px;">
									번호 : <input style="border:0px;" type="text" placeholder="번호" name="no" value="${qnaData.qna.qno}" maxlength="200" readonly></td>
								</tr>
								<tr>
									<td colspan="4" style="padding-left: 0px;">
									<input class="title" type="text" placeholder="글 제목" name="title" value="${qnaData.qna.qtit}" maxlength="200"></td>
								</tr>
								<tr>
									<td colspan="4" style="padding-left: 0px;"><textarea
											rows="10" cols="100%" placeholder="내용" name="content">${qnaData.qna.qtext}</textarea></td>
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
