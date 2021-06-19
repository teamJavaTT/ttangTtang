<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("UTF-8");%>

<link rel="stylesheet" href="/ttangTtang/css/admin/adminmain.css">

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
                  <li><a href="noticelist.do">공지사항</a></li>
                  <li><a href="qnalist.do">Q&A</a></li>
                  <li><a href="faqlist.do">FAQ</a></li>
                  <c:if test="${memberUser.userid eq 'admin'}">
                  <li><a href="userinfolist.do">사용자 회원정보 관리</a></li>
                  <li><a href="blacklist.do">블랙리스트관리</a></li>
                  <li><a href="declarationlist.do">신고 관리</a></li>
                  <li><a href="outuserlist.do">탈퇴회원 관리</a></li>
                  </c:if>
               </ul>
            </div>
         </div>
         <!-- admin list end -->