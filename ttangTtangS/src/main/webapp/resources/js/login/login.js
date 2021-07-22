
$(document).ready(function() {
	$("body").keypress(function(e) {
		if (e.keyCode == 13) {
			loginFunc();
		}
	})
});

function loginFunc() {
		var userid = document.loginForm.userid.value;
		var password = document.loginForm.upw.value;


		if (userid == "") {
			alert("아이디를 입력하세요.");
			document.loginForm.userid.focus();
			return "/member/login";
		}
		if (password == "") {
			alert("비밀번호를 입력하세요.");
			document.loginForm.upw.focus();
			return "/member/login"; 
		} 
		document.loginForm.submit();


}
