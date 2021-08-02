$(document).ready(function() {
	if(auctionChk == "Y") countDownTimer();
	
	$("body").keypress(function(e) {
		if (e.keyCode == 13) {
			aucPricePart();
			return false;
		}
	})
});

const countDownTimer = function () {

	var id = "aucTimer";
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

function aucPricePart() {
	var priceNow = $('#now_price').text();
	var pricePart = $('#oPrice').val();
	if (parseInt(priceNow) >= parseInt(pricePart)) {
		alert("현재가보다 높은 금액만 제시할 수 있습니다.");
		return false;
	} else {
		document.auctionPart.submit();
	}
}

function productDel() {
	var ino = $("#delNo").val();
	var result = confirm("정말 삭제하시겠습니까?");
	if (result) {
		location.href = '/product/productDelete?ino=' +ino;
	} else {
		alert("취소되었습니다.");
	}
}

function matchingwindow() {
	var url = "/ttangTtang/ogani-master/matching/matching.jsp";
	window.open(url, "", "width=600,height=800,left=800");
}

(jQuery);