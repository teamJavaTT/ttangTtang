
(function ($) {
    "use strict";

	$("#btnDelete").on('click', function () {
		var dId = $("#userid").val();
		var result = confirm("정말 삭제하시겠습니까?");
		if (result) {
			location.href = 'index.do?no='+dId;
		} else {
			alert("취소되었습니다.");
			history.back();
		}
	});
	
	
})(jQuery);