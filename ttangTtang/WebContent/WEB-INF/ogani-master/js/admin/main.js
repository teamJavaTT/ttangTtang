
(function ($) {
    "use strict";

	$("#noticeDel").on('click', function () {
		var mno = $("#delNo").val();
		var result = confirm("정말 삭제하시겠습니까?");
		if (result) {
			location.href = 'noticedelete.do?no='+mno;
		} else {
			alert("취소되었습니다.");
		}
	});
	
	$("#faqDel").on('click', function () {
		var fno = $("#delNo").val();
		var result = confirm("정말 삭제하시겠습니까?");
		if (result) {
			location.href = 'faqdelete.do?no='+fno;
		} else {
			alert("취소되었습니다.");
		}
	});
	
	$("#qnaDel").on('click', function () {
		var qno = $("#delNo").val();
		var result = confirm("정말 삭제하시겠습니까?");
		if (result) {
			location.href = 'qnadelete.do?no='+qno;
		} else {
			alert("취소되었습니다.");
		}
	});
})(jQuery);