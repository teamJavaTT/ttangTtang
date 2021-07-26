<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 확인</title>
<script src="/resources/js/jquery-3.3.1.min.js"></script>
<script>
function checkId() {// 아이디 중복에서 하는 체크
	var id = $('#id').val();
	var idPattern = /[a-zA-Z0-9_-]{5,20}/;
	if (id == "" || id == null) {
		$('.error_next_box').text("필수 정보입니다.");
		$('.error_next_box').css("display", "block");
	}
	else if (!idPattern.test(id)) {
		$('.error_next_box').text("5~20자의 영문 소문자, 숫자와 특수기호(_),(-)만 사용 가능합니다.");
		$('.error_next_box').css("display", "block");
	}else{
		document.idChkform.submit();
	}
}
</script>
</head>
<body>
	<c:if test="${idCheck != 0}">
		<div align="center"> 
			<c:if test="${empty idCheck}">
				아이디를 입력하세요.
			</c:if>
			<c:if test="${idCheck == 1}">
				사용중인 아이디입니다.
			</c:if>
			<form action="/member/idCheck" method="post" name="idChkform">
				<input type="text" name="userid" id="id"/>
				<span class="error_next_box"></span>
				<input type="button" onclick="checkId()" value="확인"/>
			</form>
		</div>
	</c:if>
	<c:if test="${idCheck == 0}">
		<div align="center"> 
			사용 가능한 아이디입니다.
		</div>
		<script type="text/javascript">
			opener.joinform.userid.value="${param.userid}";
			opener.joinform.idCheck.value="idCheck";
		</script>	
	</c:if>
	
	<div align="center">
		<a href="javascript:self.close();">닫기</a>
	</div>
</body>
</html>