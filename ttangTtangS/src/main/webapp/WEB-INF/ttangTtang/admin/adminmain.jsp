<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
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
				<h2>Services</h2>
				<div style="text-align: center;">
					<img src="/resources/img/logo_red.png" width="50%" alt="">
					<p>고객센터에서 궁금하신점을 찾아보세요.</p>
					<p>궁금하신 점 또는 상품에 대한 질문내용을 입력해주시면상세히 안내해드립니다.</p>
				</div>
				<div style="text-align: center;">
					<a href="notice"><img src="/resources/img/admin/noticeicon.png"	width="30%" alt=""></a>
					<a href="qna"><img src="/resources/img/admin/qnaicon.png" width="30%" alt=""></a>
					<a href="faq"><img src="/resources/img/admin/faqicon.png" width="30%" alt=""></a>
				</div>
			</div>
		</div>
	</div>
</section>

<%@ include file="../include/footer.jsp"%>
