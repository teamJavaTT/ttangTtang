<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
  <head>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <title>비밀번호 찾기</title>
<link rel="stylesheet" type="text/css"
	href="/resources/css/login/find.css">
  </head>
   
  <body cellpadding="0" cellspacing="0" width="100%" height="100%" align="center">

	<div class="card align-middle" style="width:25rem;">
		<div class="card-title">
			<h2 class="card-title" style="color:#f58b34; text-align: center;"><img src="/resources/img/logo_red.png" width="100%" alt=""/></h2>
		</div>
		<div class="card-body">
			<form action="/member/passwordfind" class="form-signin" method="POST">
				<c:choose>
					<c:when test="${userExist == 'Y'}">
						<input type="hidden" name="userid" value="${param.userid}">
						<input type="password" name="upw" id="pwd" class="form-control" placeholder="새 비밀번호" value="${param.upw}" required><br>
						<input type="password" name="upw2" id="pwd2" class="form-control" placeholder="새 비밀번호 확인" required><br>
						<c:if test="${upwSame == 'N'}">
							<p class="check" >비밀번호가 일치하지 않습니다.</p><br/>
						</c:if>
						<button id="btn-Yes" name="findChange" value="change" class="btn btn-lg btn-primary btn-block" type="submit">비밀번호 변경</button>
					</c:when>
					<c:otherwise>
						<input type="text" name="userid" id="userid" class="form-control" placeholder="아이디" value="${param.userid}" required><br>
						<input type="text" name="uname" id="uname" class="form-control" placeholder="이름" value="${param.uname}" required><BR>
						<input type="email" name="uemail" id="uemail" class="form-control" placeholder="이메일"  value="${param.uemail}" required><br>
						<c:if test="${userExist == 'N'}">
							<p class="check" >존재하지 않는 사용자 이거나 정보를 확인하세요.</p><br/>
						</c:if>
						<button id="btn-Yes" name="findChange" value="find" class="btn btn-lg btn-primary btn-block" type="submit">비밀번호 찾기</button>
					</c:otherwise>
				</c:choose>
			</form>
      
		</div>
        <div class="links">
            <a href="/member/idfind">아이디 찾기</a> | <a href="/member/login">로그인</a> | <a href="/member/join">회원가입</a>

        </div>
	</div>
  
  </body>
    <script type="text/javascript">

	
	  	//아이디 정규식
		var idJ = /^[a-z0-9]{5,20}$/;
		var pw1 = document.querySelector('#pwd');
		var pwMsg = document.querySelector('#alertTxt');
		var pwImg1 = document.querySelector('#pswd1_img1');
		var pw2 = document.querySelector('#pwd2');
		var pwImg2 = document.querySelector('#pswd2_img1');
		var pwMsgArea = document.querySelector('.int_pass');
		
		pw1.addEventListener("focusout", checkPw);
		pw2.addEventListener("focusout", comparePw);
		
  		$("#userid").focusout(function(){
	     if($('#userid').val() == ""){
	   		$('#checks').text('아이디를 입력해주세요.');
	   	  	$('#checks').css('color', 'red');
	     }
	     });
  		
  		$("#member_id").focusout(function(){
  			if(!idJ.test($(this).val())){
  			$('#checks').text('5~20자의 영문 소문자, 숫자만 사용가능합니다');
  			$('#checks').css('color', 'red');
  		}
  		 });
  		
  		$("#uname").focusout(function(){
	     if($('#uname').val() == ""){
	   		$('#checks').text('이름을 입력해주세요.');
	   	  	$('#checks').css('color', 'red');
	     }
	     });
	     
  		$("#uemail").focusout(function(){
	     if($('#uemail').val() == ""){
	   		$('#checks').text('이메일을 입력해주세요');
	   	  	$('#checks').css('color', 'red');
	     }
	     $("#upw").focusout(function(){
		     if($('#upw').val() == ""){
		   		$('#checks').text('비밀번호를 입력하세요');
		   	  	$('#checks').css('color', 'red');
		     }
		     $("#upw2").focusout(function(){
			     if($('#upw2').val() == ""){
			   		$('#checks').text('비밀번호를 입력하세요');
			   	  	$('#checks').css('color', 'red');
			     }
	     });
  
  </script>
</html>