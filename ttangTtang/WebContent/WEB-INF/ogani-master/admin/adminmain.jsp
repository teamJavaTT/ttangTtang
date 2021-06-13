<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>

    <!-- Hero Section Begin -->
    <section class="hero">
        <div class="container">
            <div class="row">
                <div class="col-lg-3">
                    <div class="hero__categories">
                        <div class="hero__categories__all">
                            <i class="fa fa-bars"></i>
                            <span>All departments</span>
                        </div>
                        <ul>
                            <li><a href="noticelist.do">공지사항</a></li>
							<li><a href="qnalist.do">Q&A</a></li>
							<li><a href="faqlist.do">FAQ</a></li>
							<li><a href="/ttangTtang/ogani-master/admin/usersound.jsp">고객의 소리</a></li>
							<li><a href="/ttangTtang/ogani-master/admin/userlist.jsp">사용자 게시글 관리</a></li>
							<li><a href="/ttangTtang/ogani-master/admin/userinfo.jsp">사용자 회원정보 관리</a></li>
							<li><a href="/ttangTtang/ogani-master/admin/blacklist.jsp">블랙리스트관리</a></li>
							<li><a href="/ttangTtang/ogani-master/admin/declaration.jsp">신고 관리</a></li>
							<li><a href="/ttangTtang/ogani-master/admin/outuser.jsp">탈퇴회원 관리</a></li>
                        </ul>
                    </div>
                </div>
                <div class="col-lg-9">
	                <h1>Services</h1>
	                <div style="text-align : center;">
	                	<img src="/ttangTtang/ogani-master/img/logo_red.png" width="50%" alt="">
	                	<p>고객센터에서 궁금하신점을 찾아보세요.</p>
	                	<p>궁금하신 점 또는 상품에 대한 질문내용을 입력해주시면상세히 안내해드립니다.</p>
	                </div>
	                <div style="text-align : center;">
	                	<a href="noticelist.do"><img src="/ttangTtang/img/admin/noticeicon.png" width="30%" alt=""></a>
	                	<a href="qnalist.do"><img src="/ttangTtang/img/admin/qnaicon.png" width="30%" alt=""></a>
	                	<a href="faqlist.do"><img src="/ttangTtang/img/admin/faqicon.png" width="30%" alt=""></a>
	                </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Hero Section End -->

   
    
<%@ include file="../include/footer.jsp" %>
