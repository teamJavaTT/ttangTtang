function getFileUpload(fileUpload) {
	
	var form = $(fileUpload)[0];
	var formData = new FormData(form);

	$.ajax({
		url: "/ttangTtang/ImageServlet",
		type: "POST",
		data: formData,
		contentType: false,
		processData: false,
		success: function(data) {
			if(fileUpload == "#fileUploadAuc"){
				document.aucForm.imagefaceNameAuc.value = data;
				document.aucForm.submit();
			}else if(fileUpload == "#fileUploadNor"){
				document.norForm.imagefaceNameNor.value = data;
				document.norForm.submit();
			}
		}, error: function() {
			alert("사진업로드 에러발생");
		}
	});
}

function productWriteNor() {
	var productName = document.norForm.productNameNor.value;
	var category = document.norForm.categoryNor.value;
	var price = document.norForm.price.value;
	var priceText = document.norForm.priceTextNor.value;

	if (productName == "") {
		alert("상품명을 입력하세요");
		document.norForm.productName.focus();
		return;
	}
	if (category == "") { 
		alert("카테고리를 선택하세요");
		document.norForm.categoryNor.focus();
		return;

	}
	if (price == "") {
		alert("가격을 입력하세요");
		document.norForm.price.focus();
		return;
	}
	if (priceText == "") { 
		alert("상품설명을 입력하세요");
		document.norForm.priceTextNor.focus();
		return;
	}

	if(document.fileUploadNor.imagefaceNor.value == null || document.fileUploadNor.imagefaceNor.value == ""){
		document.norForm.submit();
	}else{
		getFileUpload("#fileUploadNor");
	}
	
};

function productWriteAuc() {
	var productName = document.aucForm.productNameAuc.value; // document는 웹페이지에 접근하기위한 객체.. form1에 있는 상품이름을 반환해서 name에 저장함
	var category = document.aucForm.categoryAuc.value;
	var maxPrice = document.aucForm.maxPrice.value;
	var minPrice = document.aucForm.minPrice.value; // document는 웹페이지에 접근하기위한 객체.. form1에 있는 상품의 값을 반환해서 price에 저장함
	var endDay = document.aucForm.endDay.value;
	var endTime = document.aucForm.endTime.value;
	var priceText = document.aucForm.priceTextAuc.value; // document는 웹페이지에 접근하기위한 객체.. form1에 있는 상품의 정보를 반환해서 description에 저장함

	//document.form.은 폼페이지에 있는 값을 반환한다는 뜻.

	if (productName == "") { //상품 이름이 입력되어 있지 않으면
		alert("상품명을 입력하세요");
		document.aucForm.productName.focus(); //form1페이지에 있는 "상품명을 입력하세요" 에 커서를 올려둔다.
		return;
	}
	if (category == "") { //상품가격이 입력되어 있지 않으면
		alert("카테고리를 선택하세요");
		document.aucForm.category.focus(); //form1페이지에 있는 "가격을 입력하세요" 에 커서를 올려둔다.
		return;

	}
	if (maxPrice == "") { //상품가격이 입력되어 있지 않으면
		alert("최대가격을 입력하세요");
		document.aucForm.maxPrice.focus(); //form1페이지에 있는 "가격을 입력하세요" 에 커서를 올려둔다.
		return;
	}
	if (minPrice == "") { //상품가격이 입력되어 있지 않으면
		alert("최소가격을 입력하세요");
		document.aucForm.minPrice.focus(); //form1페이지에 있는 "가격을 입력하세요" 에 커서를 올려둔다.
		return;
	}
	if (endDay == "0" && endTime == "0") { //상품설명이 입력되어 있지 않으면
		alert("경매시간을 설정하세요");
		return;
	}
	if (priceText == "") { //상품설명이 입력되어 있지 않으면
		alert("상품설명을 입력하세요");
		document.aucForm.priceText.focus(); //form1페이지에 있는 "상품설명을 입력하세요" 에 커서를 올려둔다.
		return;
	}
	// input 태그를 마우스로 클릭하여 입력상태로 만든것을 포커스를 얻었다고 한다.
	// 그리고 입력상태를 떠난 것을 포커스가 벗어났다고 한다.
	
	//이미지 첨부 안했을때 바로 insert
	if(document.fileUploadAuc.imagefaceAuc.value == null || document.fileUploadAuc.imagefaceAuc.value == ""){
		document.aucForm.submit();
	}else{// 이미지 첨부가 있으면 파일 등록 후 insert
		getFileUpload("#fileUploadAuc");
	}
	
};

$(document).ready(function() {
	// 태그에 onchange를 부여한다.
	$('#imagefaceNor').change(function() {
		addPreview($(this), 1); //preview form 추가하기
	});
	$('#imagefaceAuc').change(function() {
		addPreview($(this), 2); //preview form 추가하기
	});
});

// image preview 기능 구현
// input = file object[]
function addPreview(input, num) {
	if (input[0].files) {
		//파일 선택이 여러개였을 시의 대응
		for (var fileIndex = 0; fileIndex < input[0].files.length; fileIndex++) {
			var file = input[0].files[fileIndex];
			var reader = new FileReader();

			reader.onload = function(img) {
				//div id="preview" 내에 동적코드추가.
				//이 부분을 수정해서 이미지 링크 외 파일명, 사이즈 등의 부가설명을 할 수 있을 것이다.
				if(num == 1) $("#previewNor").append("<img src=\"" + img.target.result + "\"\/>");
				else $("#previewAuc").append("<img src=\"" + img.target.result + "\"\/>");
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
//******************상품 삭제******************//
function productDel() {
	$("#productDel").on('click', function() {
		var ino = $("delIno").val();
		var result = confirm("상품을 삭제 하시겠습니까 ?");
		if (result) {
			location.herf = 'productDelte.do?no ='+mno;
		} else {
			alert("취소 되었습니다.")
		}
	});
}