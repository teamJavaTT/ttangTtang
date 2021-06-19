<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 확인</title>
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
			<form action="idCheck.do" method="post">
				<input type="text" name="userid"/>
				<input type="submit" value="확인"/>
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