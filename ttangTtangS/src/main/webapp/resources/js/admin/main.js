
(function($) {
	"use strict";

	$("#noticeDel").on('click', function() {
		var mno = $("#delNo").val();
		var result = confirm("정말 삭제하시겠습니까?");
		if (result) {
			location.href = 'noticedelete?no=' + mno;
		} else {
			alert("취소되었습니다.");
		}
	});

	$("#faqDel").on('click', function() {
		var fno = $("#delNo").val();
		var result = confirm("정말 삭제하시겠습니까?");
		if (result) {
			location.href = 'faqdelete?no=' + fno;
		} else {
			alert("취소되었습니다.");
		}
	});

	$("#qnaDel").on('click', function() {
		var qno = $("#delNo").val();
		var result = confirm("정말 삭제하시겠습니까?");
		if (result) {
			location.href = 'qnadelete?no=' + qno;
		} else {
			alert("취소되었습니다.");
		}
	});

	$(".qnaRead").on('click', function() {
		
		$('#pwdForm input').hide();
		$(this).next("input").show();
		$(this).next().next("input").show();
		
	});
	
})(jQuery);