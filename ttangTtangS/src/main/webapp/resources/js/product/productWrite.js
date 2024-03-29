var imageLeng;
const imageArrData = [];

$(document).ready(function() {
	// 태그에 onchange를 부여한다.
	$('#imageFile').change(function() {		
		if (imageArrData.length >= 4) {
			alert("사진 첨부는 최대 4장까지 가능합니다.");
			return false;
		} else {
			addPreview($(this)); //preview form 추가하기
		}
	});

	$('#endDay').change(function() {
		auctionTime();
	});
	$('#endTime').change(function() {
		auctionTime();
	});
	
	$("#productWriteDiv").hide();
});

function deletePreview(input) {
	imageArrData.splice($(input).parent('li').index(), 1);
	$(input).parent('li').remove();
	$('#imageTbl small').empty().append("(" + imageArrData.length + "/4)");
}


function auctionTime() {
	var selectTime = parseInt($('#endDay').val()) + parseInt($('#endTime').val());

	var date = new Date();
	date.setHours(date.getHours() + selectTime);
	var s = leadingZeros(date.getFullYear(), 4) + '-' +
		leadingZeros(date.getMonth() + 1, 2) + '-' +
		leadingZeros(date.getDate(), 2) + ' ' +

		leadingZeros(date.getHours(), 2) + ':' +
		leadingZeros(date.getMinutes(), 2) + ':' +
		leadingZeros(date.getSeconds(), 2);

	$('#timeMent').text("마감시간:" + s);
}

function leadingZeros(n, digits) {
	var zero = '';
	n = n.toString();

	if (n.length < digits) {
		for (i = 0; i < digits - n.length; i++)
			zero += '0';
	}
	return zero + n;
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
			for(var i=0;i<imageArr.length;i++){
				name = "#imageface"+(i+1);
				$(name).val("/resources/file/"+imageArr[i]);
			}
			document.InsertForm.submit();
		}, error: function() {
			alert("사진업로드 에러발생");
		}
	});
}

function productWrite() {

	var iname = document.InsertForm.iname.value;
	var ccode = document.InsertForm.ccode.value;
	var price = document.InsertForm.price.value;
	var maxPrice = document.InsertForm.maxPrice.value;
	var minPrice = document.InsertForm.minPrice.value; // document는 웹페이지에 접근하기위한 객체.. form1에 있는 상품의 값을 반환해서 price에 저장함
	var uad = document.InsertForm.uad.value; 
	var endDay = document.InsertForm.endDay.value;
	var endTime = document.InsertForm.endTime.value;
	var priceText = document.InsertForm.priceText.value;
 	var auctioncheck = document.InsertForm.auctioncheck.value;

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
	if (price == "" && auctioncheck == "N") {
		alert("가격을 입력하세요");
		document.InsertForm.price.focus();
		return;
	}
		if (maxPrice == "" && auctioncheck == "Y") { //상품가격이 입력되어 있지 않으면
		alert("최대가격을 입력하세요");
		document.InsertForm.maxPrice.focus(); //form1페이지에 있는 "가격을 입력하세요" 에 커서를 올려둔다.
		return;
	}
	if (minPrice == "" && auctioncheck == "Y") { //상품가격이 입력되어 있지 않으면
		alert("최소가격을 입력하세요");
		document.InsertForm.minPrice.focus(); //form1페이지에 있는 "가격을 입력하세요" 에 커서를 올려둔다.
		return;
	}
	if (uad == "") {
		alert("주소를 선택 하세요");
		document.InsertForm.uad.focus();
		return;
	}
	if (endDay == "0" && endTime == "0" && auctioncheck == "Y") { //상품설명이 입력되어 있지 않으면
		alert("경매시간을 설정하세요");
		return;
	}
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


// image preview 기능 구현
// input = file object[]
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
				$("#preview ul").append("<li><img src=\"" + img.target.result + "\"\/><button type='button' class='fa fa-close' onclick='deletePreview($(this))'></button></li>");
				$('#imageTbl small').empty().append("(" + imageArrData.length + "/4)");
			};
			reader.readAsDataURL(file);
		}
	} else
		alert('invalid file input'); // 첨부클릭 후 취소시의 대응책은 세우지 않았다.
}

function fnOpen(open) {
	$("#productWriteDiv").show();
   if(open == "normal"){
		$('#auctioncheck').val("N");
      $('.normal').show();
      $('.auction').hide();
    
   }else{
	$('#auctioncheck').val("Y");
      $('.normal').hide();
      $('.auction').show();
   }

}

