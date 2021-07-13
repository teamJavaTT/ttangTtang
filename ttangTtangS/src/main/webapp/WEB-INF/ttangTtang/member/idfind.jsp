<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      
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
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous"
   >
    <title>아이디 찾기</title>
    <link rel="stylesheet" type="text/css"
	href="/ttangTtang/css/login/find.css">
    
    
  </head>

  <body cellpadding="0" cellspacing="0" width="100%" height="100%" align="">

	<div class="card align-middle" style="width:25rem;">
		<div class="card-title" >
            
			<h2 class="card-title" style="color:#f58b34; text-align: center;"><img src="/ttangTtang/img/logo_red.png" width="100%" alt=""/></h2>
		</div>
        
		<div class="card-body">
      <form action="idFind.do" class="form-signin" method="POST">
  		 <p class="text2"> ${findid2}</p>
        <input type="text" name="uname" id="uname" class="form-control" placeholder="이름" required autofocus><BR>
        <input type="email" name="uemail" id="uemail" class="form-control" placeholder="이메일" required><br>
        	<p class="check" id="check">아이디 : ${idfind}</p><br/>
        <button id="btn-Yes" class="btn btn-lg btn-primary btn-block" type="submit">아 이 디 찾 기</button>
      
      </form>
        
		</div>
        <div class="links">
            <a href="passwordFind.do">비밀번호 찾기</a> | <a href="login.do">로그인</a> | <a href="join.do">회원가입</a>
        </div>
	</div>
   
  </body>
  <script type="text/javascript">
		
  		
  
  		$("#name").focusout(function(){
  			
	     if($('#name').val() == ""){
	   		$('#check').text('이름을 입력해주세요.');
	   	  	$('#check').css('color', 'red');
	   
	     }else{
	    	 $('#check').hide();
	     }
	     });
	     
  		$("#email").focusout(function(){
	     if($('#email').val() == ""){
	   		$('#check').text('이메일을 입력해주세요');
	   	  	$('#check').css('color', 'red');
	     }else{
	    	 $('#check').hide();
	     }
	     });
  
  </script>
</html>