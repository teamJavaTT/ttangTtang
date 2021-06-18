$(document).ready(function() {
	
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
		var distDt = _vDate - now; if (distDt < 0) {
			clearInterval(timer);
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

for(var i=0;i<endTimeArr.length;i++){
	countDownTimer('auc'+iNoArr[i], endTimeArr[i]);
	countDownTimer('all'+iNoArr[i], endTimeArr[i]);		
}

