
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
	
	/*$("#qnaRead").on('click', function() {
		var qno = $("#qnaNo").val();
		var qpw = $("#qnaPw").val();
		if (qpw == null) {
			var result = prompt("비밀번호를 입력하세요");
			if (result == qpw) {
				location.href = 'qnaread.do?no=' + qno;
			} else {
				alert("비밀번호가 틀렸습니다.");
			}
		}else{
			location.href = 'qnaread.do?no=' + qno; 
		}
	});*/
})(jQuery);