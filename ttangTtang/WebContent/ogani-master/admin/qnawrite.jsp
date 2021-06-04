<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>

<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->
<link rel="icon" type="image/png" href="images/icons/favicon.ico" />
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="vendor/select2/select2.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="vendor/perfect-scrollbar/perfect-scrollbar.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css" href="css/util.css">
<link rel="stylesheet" type="text/css" href="css/main.css">
<!--===============================================================================================-->


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
						<li><a href="/ttangTtang/ogani-master/admin/notice.jsp">공지사항</a></li>
						<li><a href="/ttangTtang/ogani-master/admin/qna.jsp">Q&A</a></li>
						<li><a href="/ttangTtang/ogani-master/admin/faq.jsp">FAQ</a></li>
						<li><a href="/ttangTtang/ogani-master/admin/usersound.jsp">고객의 소리</a></li>
						<li><a href="/ttangTtang/ogani-master/admin/userlist.jsp">사용자 게시글 관리</a></li>
						<li><a href="/ttangTtang/ogani-master/admin/userinfo.jsp">사용자 회원정보 관리</a></li>
						<li><a href="/ttangTtang/ogani-master/admin/blacklist.jsp">블랙리스트관리</a></li>
						<li><a href="/ttangTtang/ogani-master/admin/declaration.jsp">신고 관리</a></li>
						<li><a href="/ttangTtang/ogani-master/admin/outuser.jsp">탈퇴회원 관리</a></li>
					</ul>
				</div>
			</div>
			<!-- admin list end -->


			<div class="col-lg-9">
				<section class="content-header">
					<h2>Q&A</h2>
				</section>
				<section class="content">
					<table>
						<thead>
							<tr>
								<th colspan="4" style="text-align: center;">Q&A 글쓰기 양식</th>
							</tr>
						</thead>
						</tbody>
							<tr>
								<td class="contents" colspan="4" style="padding-left: 0px;"><input type="text" placeholder="아이디" name="title" maxlength="200"></td>
							</tr>
							<tr>
								<td class="contents" colspan="4" style="padding-left: 0px;"><input type="text" placeholder="글 제목" name="title" maxlength="200"></td>
							</tr>
							<tr>
								<td class="contents" colspan="4" style="padding-left: 0px;"><textarea rows="10" cols="100%" placeholder="내용" name="content"></textarea></td>
							</tr>
							<tr>
								<td class="column4"><a href="#">[글 올리기]</a></td>
							</tr>
						</tbody>
					</table>
				</section>
			</div>
		</div>
	</div>
</section>



<%@ include file="../include/footer.jsp"%>
