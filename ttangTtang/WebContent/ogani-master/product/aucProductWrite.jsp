<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<%@ include file="../include/middle_header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 등록</title>
<style>
#form {
!important;
}
</style>
</head>
	<!-- 관리자용 메뉴는 일반 회원의 메뉴와 다르기 때문에 일부러 관리자용 메뉴를 만들고 그 메뉴를 출력한다. -->
	<h2 style="text-align: center;">경매 상품 등록</h2>
<!--    <form id="form1" name="form1" method="post"
        enctype="multipart/form-data">  -->
	<!-- 파일업로드를 위해 추가하는 타입 -->
<form name="form" method="post" > 
예약시간 : 
</p> 
- 시작 시간 : 
<select name="starthour" id="starthour" onchange="selectStart(this.value)"> 
</select> 
:
<select name="startminute" id="startminute" onchange="selectStart(this.value)">
</select>

</p> 
- 종료 시간 : 
<select name="endhour" id="endhour" onchange="selectStart(this.value)"> 
</select> 
:
<select name="endminute" id="endminute" onchange="selectStart(this.value)">
</select>
</p>
<input type = "button" onclick="selectEnd()" value="시작"/>
</form>

	

<script>
	//상품을 추가하기위한 정보를 담아 insert.do로 보내는 자바스크립트 함수
	function product_write() {

		var product_name = document.form1.product_name.value; // document는 웹페이지에 접근하기위한 객체.. form1에 있는 상품이름을 반환해서 name에 저장함
		var price = document.form1.price.value; // document는 웹페이지에 접근하기위한 객체.. form1에 있는 상품의 값을 반환해서 price에 저장함
		var description = document.form1.description.value; // document는 웹페이지에 접근하기위한 객체.. form1에 있는 상품의 정보를 반환해서 description에 저장함

		//document.form.은 폼페이지에 있는 값을 반환한다는 뜻.

		if (product_name == "") { //상품 이름이 입력되어 있지 않으면
			alert("상품명을 입력하세요");
			document.form1.product_name.focus(); //form1페이지에 있는 "상품명을 입력하세요" 에 커서를 올려둔다.
			return;
		}
		if (price == "") { //상품가격이 입력되어 있지 않으면
			alert("가격을 입력하세요");
			document.form1.price.focus(); //form1페이지에 있는 "가격을 입력하세요" 에 커서를 올려둔다.
			return;
		}
		if (description == "") { //상품설명이 입력되어 있지 않으면
			alert("상품설명을 입력하세요");
			document.form1.description.focus(); //form1페이지에 있는 "상품설명을 입력하세요" 에 커서를 올려둔다.
			return;
		}
		// input 태그를 마우스로 클릭하여 입력상태로 만든것을 포커스를 얻었다고 한다.
		// 그리고 입력상태를 떠난 것을 포커스가 벗어났다고 한다.

		document.form1.action = "${path}/shop/product/insert.do"; //insert.do 페이지로 form1에 저장된 자료를 전송함
		document.form1.submit();
	};

	(function() {
		var autoSave = new Object();
		(function(obj) {
			obj.configuration = {
				interval : 60
			// second(s)
			};
			obj.bindTimer = function() {
				var textEle = document.querySelector('#test');
				var textVal = textEle.value;
				var ref1, ref2, ref3; // Newer -&gt; Older

				// Save to localStorage
				var encodedTextVal = btoa(textVal);
				ref1 = window.localStorage.getItem('textval-01');
				ref2 = window.localStorage.getItem('textval-02');

				if ((window.localStorage) && (encodedTextVal != ref1)) {
					window.localStorage.setItem('textval-01', encodedTextVal);
					window.localStorage.setItem('textval-02', ref1);
					window.localStorage.setItem('textval-03', ref2);
				} else if (!window.localStorage) {
					console.log('Error' + ': Your browser not support')
					return false;
				}
			};

			obj.start = function() {
				obj.bindTimer();
				setTimeout(function() {
					obj.start();
				}, obj.configuration.interval * 1000);
			};
			obj.start();
		})(autoSave);
	})();
	
$(document).ready(function(){
	$("#starthour").append("시간");
	$("#startminute").append("분");
	$("#endhour").append("시간");
	$("#endminute").append("분");
	
	for(var i=0; i<24; i++){
		if(i>9){
			$("#starthour").append("<option>"+i+"</option>");
		}else{
			$("#starthour").append("<option>"+i+"</option>");
		}
	}
	for(var j=0; j<60; j++){
		if(j>9){
			$("#startminute").append("<option>"+j+"</option>");
		}else{
			$("#startminute").append("<option>"+j+"</option>");
		}
		}
	for(var k=0; k<24; i++){
		if(i>9){
			$("#endhour").append("<option>"+k+"</option>");
		}else{
			$("#endhour").append("<option>"+k+"</option>");
		}
	}
	for(var l=0; l<60; l++){
		if(l>9){
			$("#endminute").append("<option>"+l+"</option>");
		}else{
			$("#endminute").append("<option>"+l+"</option>");
		}
		}
	}
});

function selectEnd(){
	var ss=$("#starthour").val();
	var ss=$("#startminute").val();
	var ss=$("#endhour").val();
	var ss=$("#endminute").val();
	
	if(ss==''||se==''||es==''||ee==''){
		alert("시간을 선택해 주세요.");
		return;
	}
	
	var ss1=parseint(ss.subsring(0,2));
	var se1=parseint(ss.subsring(0,2));
	var es1=parseint(ss.subsring(0,2));
	var ee1=parseint(ss.subsring(0,2));
	
	var m1=es1-ss1;
	var m2=ee1-se1;
	var m3=(m1*60)+m2;
	
	if(m3<0){
		alert("종료시간이 시작시간 보다 작습니다.");
		return;
	}else if(m3==0){
		alert("시작시간과 종료시간이 같습니다");
		return;
	}

	if(m3>240||m3<0){
		alert("시간이 초과되었습니다.");
		return;
	}else{
		var s1=ss.toString()+se.toString();
		var s2=es.toString()+ee.toString();
		
		$.ajax({
			type:"POST",
			url:"",
			dataType:"json",
			success:function(){
				//$("#from").submit();
				alert("처리되었습니다.");
			}
		});
	}
}
</script>
	<%@ include file="../include/footer.jsp"%>