<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script>
	var xhr;
	function filePreview() {
		//form 전체를 formData 객체러 전환
		var form = document.fileform;
		var formData = new FormData(form);
		//formData.append("upload_file",file);
		
		//xhr 객체 생성
		xhr = new XMLHttpRequest();
		
		//데이터를 전달할 타겟 설정
		xhr.open("post", "multipart_preview_test_action.jsp", true);
		
		//데이터가 정상적으로 전달 됐을 때  결과값을 받아왔을때의 실행내용
		xhr.onreadystatechange = function() { //폴백
			if (xhr.readyState == 4) {
				if (xhr.status == 200) { //200은 잘넘어왔단 것이다.
					process();
				} else {
					alert("요청오류 : " + xhr.status);
				}
			}
		}
		//데이터 전송
		xhr.send(formData); 
	}
	
	function process(){
		//결과값은 저장된 preview 파일 이름
		var data = xhr.responseText;
		var previewName = data.trim();
		
		//preview image에 preview 폴더에 들어간 파일을 가져와서 뿌려줌
		document.fileform.preview.src = "preview/"+previewName;
	}
	
</script>
<body>
	<!-- 파일을 전송하기 위한 enctype -->
	<form name="fileform" action="multipart_preview_test_action.jsp" enctype="multipart/form-data" method="post">
		<img name="preview" src="../noimage.jpg"><br/>
		<input type="file" name="image" size="30" onchange="filePreview()">
	</form>
</body>
</html>