<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>

<!-- Hero Section Begin -->
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
						<li><a href="#">공지사항</a></li>
						<li><a href="#">Q&A</a></li>
						<li><a href="#">FAQ</a></li>
						<li><a href="#">고객의 소리</a></li>
						<li><a href="#">사용자 게시글 관리</a></li>
						<li><a href="#">사용자 회원정보 관리</a></li>
						<li><a href="#">고객센터</a></li>
						<li><a href="#">블랙리스트관리</a></li>
						<li><a href="#">신고 관리</a></li>
						<li><a href="#">탈퇴회원 관리</a></li>
					</ul>
				</div>
			</div>
			<!-- admin list end -->
			<div class="hero">
				
				<h1>공지사항</h1>

				<div class="box">
					<table border="1" width="100%">
						<tr>
							<td>번호</td>
							<td>
								<%-- ${articleData.article.number} --%>
							</td>
						</tr>
						<tr>
							<td>작성자</td>
							<td>
								<%-- ${articleData.article.writer.name} --%>
							</td>
						</tr>
						<tr>
							<td>제목</td>
							<td>
								<%-- <c:out value='${articleData.article.title}' /> --%>
							</td>
						</tr>
						<tr>
							<td>내용</td>
							<td>
								<%-- <u:pre value='${articleData.content}' /> --%>
							</td>
						</tr>
						<%-- <tr>
					<td colspan="2"><c:set var="pageNo"
							value="${empty param.pageNo ? '1' : param.pageNo}" /> <a
						href="list.do?pageNo=${pageNo}">[목록]</a> <c:if
							test="${authUser.id == articleData.article.writer.id}">
							<a href="modify.do?no=${articleData.article.number}">[게시글수정]</a>
							<a href="delete.do?no=${articleData.article.number}">[게시글삭제]</a>
						</c:if></td>
				</tr> --%>
					</table>
				</div>
			</div>
		</div>
	</div>
</section>
<!-- Hero Section End -->



<%@ include file="../include/footer.jsp"%>
