$(document).ready(function() {

});

function aucPricePart() {
	var priceNow = $('#now_price').text();
	var pricePart = $('#oPrice').val();
	if (priceNow >= pricePart) {
		alert("현재가보다 높은 금액만 제시할 수 있습니다.");
	} else {
		document.auctionPart.submit();
	}
}

function productDel() {
	$("#productDel").on('click', function() {
		var ino = $("#delNo").val();
		var result = confirm("정말 삭제하시겠습니까?");
		if (result) {
			location.href = 'productDelete.do?ino=' + ino;
		} else {
			alert("취소되었습니다.");
		}
	});
} (jQuery);