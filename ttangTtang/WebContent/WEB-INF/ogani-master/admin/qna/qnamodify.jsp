<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../include/header.jsp"%>

<section class="hero">
	<div class="container">
		<div class="row">

			<!-- admin list -->
			<div class="col-lg-3">
				<div class="hero__categories">
					<div class="hero__categories__all">
						<i class="fa fa-bars"></i> <span>All departments</span>
					</div>
					<ul>
						<li><a href="noticelist.do">공지사항</a></li>
						<li><a href="qnalist.do">Q&A</a></li>
						<li><a href="faqlist.do">FAQ</a></li>
						<li><a href="/ttangTtang/ogani-master/admin/usersound.jsp">고객의
								소리</a></li>
						<li><a href="/ttangTtang/ogani-master/admin/userlist.jsp">사용자
								게시글 관리</a></li>
						<li><a href="/ttangTtang/ogani-master/admin/userinfo.jsp">사용자
								회원정보 관리</a></li>
						<li><a href="/ttangTtang/ogani-master/admin/blacklist.jsp">블랙리스트관리</a></li>
						<li><a href="/ttangTtang/ogani-master/admin/declaration.jsp">신고
								관리</a></li>
						<li><a href="/ttangTtang/ogani-master/admin/outuser.jsp">탈퇴회원
								관리</a></li>
					</ul>
				</div>
			</div>
			<!-- admin list end -->


			<div class="col-lg-9">
				<section class="content-header">
					<h2>Q&A</h2>
				</section>
				<section class="content">
					<form action="qnamodify.do" method="post">
						<table>
							<thead>
								<tr>
									<th colspan="4" style="text-align: center;">Q&A 글수정 양식</th>
								</tr>
							</thead>
							</tbody>
								<tr>
									<td class="contents" colspan="4" style="padding-left: 0px;">
									아이디 : <input style="border:0px;" type="text" placeholder="아이디" name="id" value="${qnaData.qna.userid}" maxlength="200" readonly></td>
								</tr>
								<tr>
									<td class="contents" colspan="4" style="padding-left: 0px;">
									번호 : <input style="border:0px;" type="text" placeholder="번호" name="no" value="${qnaData.qna.qno}" maxlength="200" readonly></td>
								</tr>
								<tr>
									<td class="contents" colspan="4" style="padding-left: 0px;">
									<input type="text" placeholder="글 제목" name="title" value="${qnaData.qna.qtit}" maxlength="200"></td>
								</tr>
								<tr>
									<td class="contents" colspan="4" style="padding-left: 0px;"><textarea
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