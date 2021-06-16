function getFileUpload() {
	var form = $('#fileUpload')[0];
	var formData = new FormData(form);

	$.ajax({
		url: "/ttangTtang/ImageServlet",
		type: "POST",
		data: formData,
		contentType: false,
		processData: false,
		success: function(data) {
			document.form1.imagefaceName.value = data;
			document.form1.submit();
		}, error: function() {
			alert("사진업로드 에러발생");
		}
	});
}

function product_write() {

	var productName = document.form1.productName.value; // document는 웹페이지에 접근하기위한 객체.. form1에 있는 상품이름을 반환해서 name에 저장함
	var category = document.form1.category.value;
	var maxPrice = document.form1.maxPrice.value;
	var minPrice = document.form1.minPrice.value; // document는 웹페이지에 접근하기위한 객체.. form1에 있는 상품의 값을 반환해서 price에 저장함
	var endDay = document.form1.endDay.value;
	var endTime = document.form1.endTime.value;
	var priceText = document.form1.priceText.value; // document는 웹페이지에 접근하기위한 객체.. form1에 있는 상품의 정보를 반환해서 description에 저장함

	//document.form.은 폼페이지에 있는 값을 반환한다는 뜻.

	if (productName == "") { //상품 이름이 입력되어 있지 않으면
		alert("상품명을 입력하세요");
		document.form1.productName.focus(); //form1페이지에 있는 "상품명을 입력하세요" 에 커서를 올려둔다.
		return;
	}
	if (category == "") { //상품가격이 입력되어 있지 않으면
		alert("카테고리를 선택하세요");
		document.form1.category.focus(); //form1페이지에 있는 "가격을 입력하세요" 에 커서를 올려둔다.
		return;

	}
	if (maxPrice == "") { //상품가격이 입력되어 있지 않으면
		alert("최대가격을 입력하세요");
		document.form1.maxPrice.focus(); //form1페이지에 있는 "가격을 입력하세요" 에 커서를 올려둔다.
		return;
	}
	if (minPrice == "") { //상품가격이 입력되어 있지 않으면
		alert("최소가격을 입력하세요");
		document.form1.minPrice.focus(); //form1페이지에 있는 "가격을 입력하세요" 에 커서를 올려둔다.
		return;
	}
	if (endDay == "0" && endTime == "0") { //상품설명이 입력되어 있지 않으면
		alert("경매시간을 설정하세요");
		return;
	}
	if (priceText == "") { //상품설명이 입력되어 있지 않으면
		alert("상품설명을 입력하세요");
		document.form1.priceText.focus(); //form1페이지에 있는 "상품설명을 입력하세요" 에 커서를 올려둔다.
		return;
	}
	// input 태그를 마우스로 클릭하여 입력상태로 만든것을 포커스를 얻었다고 한다.
	// 그리고 입력상태를 떠난 것을 포커스가 벗어났다고 한다.
	
	//이미지 첨부 안했을때 바로 insert
	if(document.fileUpload.imageface.value == null || document.fileUpload.imageface.value == ""){
		document.form1.submit();
	}else{// 이미지 첨부가 있으면 파일 등록 후 insert
		getFileUpload();
	}
	
};

$(document).ready(function() {
	// 태그에 onchange를 부여한다.
	$('#ex_filename').change(function() {
		addPreview($(this)); //preview form 추가하기
	});
});

// image preview 기능 구현
// input = file object[]
function addPreview(input) {
	if (input[0].files) {
		//파일 선택이 여러개였을 시의 대응
		for (var fileIndex = 0; fileIndex < input[0].files.length; fileIndex++) {
			var file = input[0].files[fileIndex];
			var reader = new FileReader();

			reader.onload = function(img) {
				//div id="preview" 내에 동적코드추가.
				//이 부분을 수정해서 이미지 링크 외 파일명, 사이즈 등의 부가설명을 할 수 있을 것이다.
				$("#preview").append("<img src=\"" + img.target.result + "\"\/>");
			};

			reader.readAsDataURL(file);
		}
	} else
		alert('invalid file input'); // 첨부클릭 후 취소시의 대응책은 세우지 않았다.
}

function fnOpen(open) {
	$('section.productInsert').hide();
	$(open).show();
}

