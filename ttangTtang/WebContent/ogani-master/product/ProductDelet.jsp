<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<script>
	var delpost = confirm("삭제하겠습니까?");
	if (delpost == true){
		alert("삭제했습니다.");
		location.href = "list.do"
	}else if(delpost == false){
		alert("삭제를 취소했습니다.");
		history.back();
	}
</script>