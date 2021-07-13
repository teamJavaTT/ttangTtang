<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<script>
		var result = prompt("비밀번호를 입력하세요");
		if (result == ${qnaPage.qna.qpw}) {
			location.href = 'qnaread.do?no=' + ${qnaPage.qna.qno}
		} else {
			alert("비밀번호가 틀렸습니다.");
			location.href = 'qnalist.do'
		}
</script>