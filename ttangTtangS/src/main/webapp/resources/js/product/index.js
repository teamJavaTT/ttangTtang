$(document).ready(function() {
	for(var i=0;i<endTimeArr.length;i++){
		countDownTimer('auc'+iNoArr[i], endTimeArr[i]);
		countDownTimer('all'+iNoArr[i], endTimeArr[i]);		
	}
	
	for(var i=0;i<likeproductArr.length;i++){
		var likeClass = ".like"+likeproductArr[i];
		$(likeClass).addClass("active");
	}
	
});
const countDownTimer = function (id, date) {

	//var date="${mainPage.productToday.endtime}";
	var _vDate = new Date(date);
	var _second = 1000;
	var _minute = _second * 60;
	var _hour = _minute * 60;
	var _day = _hour * 24;
	var timer;
	
	function showRemaining() {
		var now = new Date();
		var distDt = _vDate - now; 
		if (distDt < 0) {
			clearInterval(timer);
			document.getElementById(id).textContent = '경매종료';
			return;
		}
		
		var days = Math.floor(distDt / _day);
		var hours = Math.floor((distDt % _day) / _hour);
		var minutes = Math.floor((distDt % _hour) / _minute);
		var seconds = Math.floor((distDt % _minute) / _second);
		
		//document.getElementById(id).textContent = date.toLocaleString() + "까지 : ";
		document.getElementById(id).textContent = days + '일 ';
		document.getElementById(id).textContent += hours + '시간 ';
		document.getElementById(id).textContent += minutes + '분 ';
		document.getElementById(id).textContent += seconds + '초'; 	
	} 
	
	timer = setInterval(showRemaining, 1000);
}


function likeProductFunc(ino) {
	event.preventDefault(); // a태그를 누르면 화면 최상단으로 가는 기능 해결
	event.stopPropagation(); //현재 이벤트가 부모에게 전파되지 않도록 중지
	if(sessionUser == false){
		location.href = '/member/login';
	}else{
		$.ajax({
			url: "/likeCountInsert?ino="+ino,
			type: "POST",
			contentType: false,
			processData: false,
			success: function(data) {
				if(data == 0) $(".like"+ino).addClass("active");
				else $(".like"+ino).removeClass("active");
			}
		});
	}
}