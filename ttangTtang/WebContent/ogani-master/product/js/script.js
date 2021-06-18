
/******************  guest/productlist.jsp ******************/



function productDetail(no){

	document.detailFrm.no.value=no;

	document.detailFrm.submit();

}





/******************  admin/product_insert, product_update ******************/

//이미지 프리뷰 를 위한 처리(ajax)
var xhr;
function filePreview() {
	//form 전체를 formData 객체로 전환
	var form = document.productFrm;
	var formData = new FormData(form);
	//formData.append("upload_file",file);
	
	//xhr 객체 생성
	xhr = new XMLHttpRequest();
	
	//데이터를 전달할 타겟 설정
	xhr.open("post", "product_Image_Preview.jsp", true);
	
	//데이터가 정상적으로 전달 됐을 때  결과값을 받아왔을때의 실행내용
	xhr.onreadystatechange = function() { //폴백
		if (xhr.readyState == 4) {
			if (xhr.status == 200) { //200은 잘넘어왔단 것이다.
				previewProcess(form);
			} else {
				alert("요청오류 : " + xhr.status);
			}
		}
	}
	//데이터 전송
	xhr.send(formData); 
}
//비동기 방식으로 받아온 데이터를 처리
function previewProcess(form){
	//결과값은 저장된 preview 파일 이름
	var data = xhr.responseText;
	var previewName = data.trim();
	
	//preview image에 preview 폴더에 들어간 파일을 가져와서 뿌려줌
	form.preview.src = "../images/preview/"+previewName;
}

/******************  countdown ******************/

