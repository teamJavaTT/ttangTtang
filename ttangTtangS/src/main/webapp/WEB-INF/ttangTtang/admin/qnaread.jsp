<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="../include/header.jsp"%>
<link rel="stylesheet" href="/resources/css/admin/adminmain.css">
<script type="text/javascript" src="http://code.jquery.com/jquery-3.2.1.min.js"></script>

<section class="hero">
   <div class="container">
      <div class="row">
         <!-- admin list -->
         <div class="col-lg-3">
            <div class="hero__categories">
               <ul>
               <%@ include file="list.jsp"%>
               </ul>
            </div>
         </div>
			<div class="col-lg-9">
				<section class="content-header">
					<h2>Q&A</h2>
				</section>
				<section class="content">
					<div class="limiter">
						<div class="wrap-table100">
							<div class="table100">
								<!-- Default box -->
								<div class="box">
									<table border="1">
										<thead>
											<tr>
												<th colspan="4">게시물</th>
											</tr>
										</thead>
										<tbody>
										<c:forEach var="qna" items="${qna}">
											<tr>
												<td style="text-align: left;">번호 : ${qna.qno}</td>
												<td style="text-align: left;">작성일자 : <fmt:formatDate value="${qna.qdate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
											</tr>
											<tr>
												<td colspan="4"
													style="text-align: left; font-weight: bold; font-size: 20px">
													${qna.qtit}</td>
											</tr>
											<tr>
												<td colspan="4" style="text-align: left;">${qna.qtext}</td>
											</tr>
											<tr>
												<td colspan="2"><c:set var="pageNo" value="${empty param.pageNo ? '1' : param.pageNo}" /> 
												<input type="button" value="목록" onclick="location.href='qna'">
													<c:if test="${memberUser.userid eq qna.userid}">
														<input type="button" value="게시글수정" onclick="location.href='qnamodify?no=${qna.qno}'">
														<input type="hidden" value="${qna.qno}" id="delNo">
														<input type="button" value="게시글삭제" id="qnaDel">
													</c:if>
												</td>
											</tr>
											</c:forEach>
										</tbody>
									</table>
									<p>
										<!-- 댓글 테이블 -->
									<form action="qnaAnswer" method="post">
											<table border="1" width="100%" id="answerTbl">
												<c:forEach var="qna" items="${qna}">
												<input type="hidden" name="qno" value="${qna.qno}">
												<input type="hidden" name="patext" value="${qna.patext}">
												<!-- 댓글들 -->
												<c:if test="${qna.patext eq 'Y'}">
													<tr>
														<td colspan="2" style="text-align: left;">댓글나오는곳</td>
													</tr>
													<!-- 댓글 불러오기 -->
													<tr style="padding: 10px;">
														<td align="center">${qna.qstext}</td>
														<c:if test="${memberUser.userid eq 'admin'}">
														<td align="center">
															<input type="submit" value="수정">
														</td>
														</c:if>
													</tr>
												</c:if>
													<!-- 댓글달기 -->
												<c:if test="${memberUser.userid eq 'admin'}">
													<c:if test="${qna.patext eq 'N'}">
														<tr style="padding: 10px;">
															<td align="center">
																<textarea rows="1" style="height:300px" cols="100%" placeholder="댓글달기" name="qstext">${qna.qstext}</textarea>
															</td>
															<td align="center">
																<input type="submit" value="댓글달기"></input>
															</td>
														</tr>
													</c:if>
												</c:if>
												</c:forEach>
											</table>
										</form>
								</div>
							</div>
						</div>
					</div>
					<!-- /.box -->
				</section>
			</div>
		</div>
	</div>
</section>


<script src="/resources/js/admin/main.js"></script>

<%@ include file="../include/footer.jsp"%>
