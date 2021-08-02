$("input:radio[name='uad']]").prop('checked', true); // 선택하기
$("input:radio[name='uad']").prop('checked', false); // 해제하기



function getFileUpload() {

	var form = $('#fileUpload')[0];
	var formData = new FormData(form);

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
		getFileUpload("#fileUpload");
	}
};

/*$(changImg).change(function(){
	if(this.files&&this.files[0]){
				var reader = new FileReader;
				reader.onload=function(date){
				$(".select_img img").attr("src",data.target.result).width(500);	
				}
				reader.readAsDataURL(this.files[0]);
				}
});*/

var imageLeng;

$(document).ready(function() {
	// 태그에 onchange를 부여한다.
	$('#imageFile').change(function() {
		if ($('#imageFile')[0].files.length > 4 || imageLeng >= 4 || $('#imageFile')[0].files.length + imageLeng > 4) {
			alert("사진 첨부는 최대 4장까지 가능합니다.");
			return false;
		} else {
			addPreview($(this)); //preview form 추가하기
		}
	});


	function deletePreview(input) {
		$(input).parent('li').remove();
		imageLeng -= 1;
		$('#imageTbl small').empty().append("(" + imageLeng + "/4)");

	}

	


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

				$("#preview ul").append("<li style='float:left;list-style:none;position:relative;'><img src=\"" + img.target.result + "\"\/><button type='button' class='fa fa-close' onclick='deletePreview($(this))' style='position:absolute;right:0px;background:none;border:none;border-radius:50%;height:1.5em;background-color:rgba(255,255,255,0.5);'></button></li>");
				imageLeng = $('#preview li').length;
				$('#imageTbl small').empty().append("(" + imageLeng + "/4)");

			};

			reader.readAsDataURL(file);
		}
	} else
		alert('invalid file input'); // 첨부클릭 후 취소시의 대응책은 세우지 않았다.
}
});
