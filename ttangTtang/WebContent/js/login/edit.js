
/*변수 선언*/

var id = document.querySelector('#id');
var pw1 = document.querySelector('#pswd1');
var pwMsg = document.querySelector('#alertTxt');
var pwImg1 = document.querySelector('#pswd1_img1');
var pw2 = document.querySelector('#pswd2');
var pwImg2 = document.querySelector('#pswd2_img1');
var pwMsgArea = document.querySelector('.int_pass');
var userName = document.querySelector('#name');
var gender = document.querySelector('#gender');
var email = document.querySelector('#email');
var mobile = document.querySelector('#mobile');
var error = document.querySelectorAll('.error_next_box');

/*이벤트 핸들러 연결*/
id.addEventListener("focusout", checkId);
pw1.addEventListener("focusout", checkPw);
pw2.addEventListener("focusout", comparePw);
userName.addEventListener("focusout", checkName);
email.addEventListener("focusout", isEmailCorrect);
mobile.addEventListener("focusout", checkPhoneNum);
gender.addEventListener("focusout", checkGender);



/*콜백 함수*/
function checkId() {
	var idPattern = /[a-zA-Z0-9_-]{5,20}/;
	if (id.value === "") {
		error[0].innerHTML = "필수 정보입니다.";
		error[0].style.color = "red";
		error[0].style.display = "block";
		$('#idCheckBnt').css("display", "none");
	}
	else if (!idPattern.test(id.value)) {
		error[0].innerHTML = "5~20자의 영문 소문자, 숫자와 특수기호(_),(-)만 사용 가능합니다.";
		error[0].style.color = "red";
		error[0].style.display = "block";
		$('#idCheckBnt').css("display", "none");
	} else {
		error[0].innerHTML = "멋진 아이디네요!";
		error[0].style.color = "#08A600";
		error[0].style.display = "block";
		$('#idCheckBnt').css("display", "block");
	}
}

function checkPw() {
	var pwPattern = /[a-zA-Z0-9~!@#$%^&*()_+|<>?:{}]{8,16}/;
	if (pw1.value === "") {
		error[1].innerHTML = "필수 정보입니다.";
		error[1].style.display = "block";
	} else if (!pwPattern.test(pw1.value)) {
		error[1].innerHTML = "8~16자 영문 대 소문자, 숫자, 특수문자를 사용하세요.";
		pwMsg.innerHTML = "사용불가";
		pwMsgArea.style.paddingRight = "93px";
		error[1].style.display = "block";
		pwMsg.style.color = "red";
		pwMsg.style.display = "block";
		pwImg1.src = "/ttangTtang/img/login/m_icon_not_use.png";
	} else {
		error[1].style.display = "none";
		pwMsg.innerHTML = "안전";
		pwMsg.style.display = "block";
		pwMsg.style.color = "#03c75a";
		pwImg1.src = "/ttangTtang/img/login/m_icon_safe.png";
	}
}

function comparePw() {
	if (pw2.value === pw1.value && pw2.value != "") {
		pwImg2.src = "/ttangTtang/img/login/m_icon_check_enable.png";
		error[2].style.display = "none";
	} else if (pw2.value !== pw1.value) {
		pwImg2.src = "/ttangTtang/img/login/m_icon_check_disable.png";
		error[2].innerHTML = "비밀번호가 일치하지 않습니다.";
		error[2].style.display = "block";
	}

	if (pw2.value === "") {
		error[2].innerHTML = "필수 정보입니다.";
		error[2].style.display = "block";
	}
}

function isEmailCorrect() {
	var emailPattern = /[a-z0-9]{2,}@[a-z0-9-]{2,}\.[a-z0-9]{2,}/;

	if (email.value === "") {
		error[3].innerHTML = "필수 정보입니다.";
		error[3].style.display = "block";
	} else if (!emailPattern.test(email.value)) {
		error[3].style.display = "block";
		error[3].innerHTML = "이메일 주소를 다시 확인해주세요.";
	} else {
		error[3].style.display = "none";
	}
}

function checkName() {
	var namePattern = /[a-zA-Z가-힣]/;
	if (userName.value === "") {
		error[4].innerHTML = "필수 정보입니다.";
		error[4].style.display = "block";
	} else if (!namePattern.test(userName.value) || userName.value.indexOf(" ") > -1) {
		error[4].innerHTML = "한글과 영문 대 소문자를 사용하세요. (특수기호, 공백 사용 불가)";
	} else {
		error[4].style.display = "none";
	}
}

function checkPhoneNum() {
	var isPhoneNum = /([01]{2})([01679]{1})([0-9]{3,4})([0-9]{4})/;

	if (mobile.value === "") {
		error[5].innerHTML = "필수 정보입니다.";
		error[5].style.display = "block";
	} else if (!isPhoneNum.test(mobile.value)) {
		error[5].innerHTML = "형식에 맞지 않는 번호입니다.";
		error[5].style.display = "block";
	} else {
		error[5].style.display = "none";
	}


}

function checkGender(cnk) {
	if (gender.value === "성별") {
		error[6].style.display = "block";
	} else {
		error[6].style.display = "none";
	}

	if (cnk == "editGo") {
		//회원가입
		document.joinform.submit();
	}
}


function idCheckFunc() {
	var url = "idCheck.do?userid=" + document.joinform.userid.value;
	//alert(url);
	window.open(url, "", "width=400, height=200");
}



