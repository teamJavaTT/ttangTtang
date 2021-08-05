const imageArrData = [];
var previewLang;

$(document).ready(function() {
	previewLang = $('#preview ul li').length;
	$('#imageTbl small').empty().append("(" + previewLang + "/4)");
	
	// 태그에 onchange를 부여한다.
	$('#imageFile').change(function() {
		previewLang = $('#preview ul li').length;
		if (previewLang >= 4) {
			alert("사진 첨부는 최대 4장까지 가능합니다.");
			return false;
		} else {
			addPreview($(this)); //preview form 추가하기
		}
	});

});

function addPreview(input) {
	if (input[0].files) {
		//파일 선택이 여러개였을 시의 대응
		for (var fileIndex = 0; fileIndex < input[0].files.length; fileIndex++) {
			imageArrData.push($('#imageFile')[0].files[fileIndex]);
			
			var file = input[0].files[fileIndex];
			var reader = new FileReader();

			reader.onload = function(img) {
				//div id="preview" 내에 동적코드추가.
				//이 부분을 수정해서 이미지 링크 외 파일명, 사이즈 등의 부가설명을 할 수 있을 것이다.
				$("#preview ul").append("<li><img src=\"" + img.target.result + "\"\/><button type='button' class='fa fa-close' onclick='deletePreview($(this), 0)'></button></li>");
				previewLang = $('#preview ul li').length;
				$('#imageTbl small').empty().append("(" + previewLang + "/4)");
			};
			reader.readAsDataURL(file);
		}
	} else
		alert('invalid file input'); // 첨부클릭 후 취소시의 대응책은 세우지 않았다.
}

function getFileUpload() {
	var formData = new FormData();
	imageArrData.forEach(f => {
		formData.append('imageFile', f, f.name);
	});

	$.ajax({
		url: "/uploadImage",
		type: "POST",
		data: formData,
		contentType: false,
		processData: false,
		success: function(data) {
			const imageArr = data.split(",");
			var name = "";
			var nameArr = [];
			for (var i = 0; i < 4; i++) {
				name = "#imageface" + (i + 1);
				if($(name).val() == ""){
					nameArr.push(name);
				}
			}
			for (var j = 0; j < imageArr.length; j++) {
				$(nameArr[j]).val("/resources/file/" + imageArr[j]);
			}
			document.InsertForm.submit();
		}, error: function() {
			alert("사진업로드 에러발생");
		}
	});
}


function productUpdate() {

	var iname = document.InsertForm.iname.value;
	var ccode = document.InsertForm.ccode.value;
	/*	var price = document.InsertForm.price.value;*/
	/*	var minPrice = document.InsertForm.minPrice.value;*/ // document는 웹페이지에 접근하기위한 객체.. form1에 있는 상품의 값을 반환해서 price에 저장함
	var auctioncheck = document.InsertForm.auctioncheck.value;
	var priceText = document.InsertForm.priceText.value;

	if (iname == "") {
		alert("상품명을 입력하세요");
		document.InsertForm.iname.focus();
		return;
	}
	if (ccode == "") {
		alert("카테고리를 선택하세요");
		document.InsertForm.ccode.focus();
		return;

	}
	/*	if (price == "" && auctioncheck == "N") {
			alert("가격을 입력하세요");
			document.InsertForm.price.focus();
			return;
		}
	*/
	/*if (minPrice == "" && auctioncheck == "Y") { //상품가격이 입력되어 있지 않으면
		alert("최소가격을 입력하세요");
		document.InsertForm.minPrice.focus(); //form1페이지에 있는 "가격을 입력하세요" 에 커서를 올려둔다.
		return;
	}
	*/
	if (priceText == "") {
		alert("상품설명을 입력하세요");
		document.InsertForm.priceText.focus();
		return;
	}


	if (document.fileUpload.imageFile.value == null || document.fileUpload.imageFile.value == "") {
		document.InsertForm.submit();
	} else {
		getFileUpload();
	}
};

function deletePreview(input, chk) {
	if(chk == 0){
		imageArrData.splice($(input).parent('li').index(), 1)
	}else{
		var imageNum = $(input).parent('li').index();
		if(imageNum == 0){
			$('#imageface1').val($('#imageface2').val());
			$('#imageface2').val($('#imageface3').val());
			$('#imageface3').val($('#imageface4').val());
			$('#imageface4').val("");
		}else if(imageNum == 1){
			$('#imageface2').val($('#imageface3').val());
			$('#imageface3').val($('#imageface4').val());
			$('#imageface4').val("");
		}else if(imageNum == 2){
			$('#imageface3').val($('#imageface4').val());
			$('#imageface4').val("");
		}else{
			$('#imageface4').val("");
		}
	}
	$(input).parent('li').remove();
	
	previewLang = $('#preview ul li').length;
	$('#imageTbl small').empty().append("(" + previewLang + "/4)");
	
}
