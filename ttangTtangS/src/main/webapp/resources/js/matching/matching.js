
(function($) {
	"use strict";

	$("#matchingout").on('click', function() {
		var con_test = confirm("나가시겠습니까?");
		if (con_test == true) {
			alert("나가기");
		    window.close();

			/*location.href = "/ttangTtang/ogani-master/index.jsp"*/
		} else if (con_test == false) {
			alert("취소하였습니다");
			history.back();
		}
	});
	
	
	
	
	
	
})(jQuery);