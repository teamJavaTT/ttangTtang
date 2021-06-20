function productDel() {
   

	$("#productDel").on('click', function () {
		var ino = $("#delNo").val();
		var result = confirm("정말 삭제하시겠습니까?");
		if (result) {
			location.href = 'productDelete.do?ino='+ino;
		} else {
			alert("취소되었습니다.");
		}
	});
	}(jQuery);