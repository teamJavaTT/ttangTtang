
(function ($) {
    "use strict";

	$("#btnDelete").on('click', function () {
		var result = confirm("탈퇴하시겠습니까?");
		if (result) {
			document.deleteForm.submit();
		} else {
			alert("취소되었습니다.");
		}
	});
	
	
})(jQuery);