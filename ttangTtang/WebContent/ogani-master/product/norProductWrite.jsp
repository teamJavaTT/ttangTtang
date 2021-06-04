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
#test textarea {
 width: 200px; 
 height: 100px;
 border: 3px solid #ff0000;
  }
</style>
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
    
    (function () {
    	  var autoSave = new Object();
    	  (function (obj) {
    	    obj.configuration = {
    	      interval: 60 // second(s)
    	    };
    	    obj.bindTimer = function() {
    	      var textEle = document.querySelector('#test');
    	      var textVal = textEle.value;
    	      var ref1, ref2, ref3; // Newer -&gt; Older

    	      // Save to localStorage
    	      var encodedTextVal = btoa(textVal);
    	      ref1 = window.localStorage.getItem('textval-01');
    	      ref2 = window.localStorage.getItem('textval-02');

    	      if ((window.localStorage) && (encodedTextVal != ref1)){
    	        window.localStorage.setItem('textval-01', encodedTextVal);
    	        window.localStorage.setItem('textval-02', ref1);
    	        window.localStorage.setItem('textval-03', ref2);
    	      }
    	      else if (!window.localStorage) {
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
 </script>
 </head>
 <body>
     <!-- 관리자용 메뉴는 일반 회원의 메뉴와 다르기 때문에 일부러 관리자용 메뉴를 만들고 그 메뉴를 출력한다. -->
    <h3>일반 상품 등록</h3>
        <form id="form1" name="form1" method="post"
        enctype="multipart/form-data">
        <!-- 파일업로드를 위해 추가하는 타입 -->
 
        <table>
            <tr>
                <td>상품명</td>
                <td><input name="product_name"></td>
            </tr>
           
            <tr>
                <td>가격</td>
                <td><input name="price"></td>
            </tr>
            <tr>
                <td>상품설명</td>
                <td><textarea id="test"></textarea></td>
            </tr>
            </table>
            <table>
                <td>상품이미지<span style=opacity:0.6 ; font-size=12px >(최대 10개의 이미지를 선택하실 수 있습니다.)</span></td>
      	      
	       <tr><td><input type="file" name="file1" multiple accept="image/*"></td></tr>	
			<td><input name="image" id="image" placeholder="정면"
				 onchange="filePreview()" style="margin-left: 48px;"></td>
		<tr>
			<td><input name="image" id="image" placeholder="후면" 
				onchange="filePreview()" style="margin-left: 48px;"></td>
		</tr>
		
		<tr>
			<td><input name="image" id="image" placeholder="측면" 
				onchange="filePreview()" style="margin-left: 48px;"></td>
		</tr>
	<tr>
			<td><input name="image" id="image" placeholder="추가" 
				onchange="filePreview()" style="margin-left: 48px;"></td>
		</tr>
		
		<tr>
 
                <td colspan="2" align="center"><input type="button" value="등록"
                    onclick="product_write()"> <!-- "등록" 버튼을 누르면 위쪽에 있는 스크립트문에서 product_write()함수가 호출되서 실행되 insert.do페이지로 자료를 전송한다. -->
                    <input type="button" value="목록"
                    onclick="location.href='${path}/admin/product/list.do'"> <!-- "목록 버튼을 누르면 list.do페이지로 이동" -->
                </td>
            </tr>
        </table>
 </form>
    

 <%@ include file="../include/footer.jsp"%>