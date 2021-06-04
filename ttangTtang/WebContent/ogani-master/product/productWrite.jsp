<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>

<!-- Hero Section Begin -->
<section class="hero hero-normal">
	<div class="container">
		<div class="row">
			<div class="col-lg-3">
				<div class="hero__categories">
					<div class="hero__categories__all">
						<i class="fa fa-bars"></i> <span>All departments</span>
					</div>
					<ul>
						<li><a href="#">Fresh Meat</a></li>
						<li><a href="#">Vegetables</a></li>
						<li><a href="#">Fruit & Nut Gifts</a></li>
						<li><a href="#">Fresh Berries</a></li>
						<li><a href="#">Ocean Foods</a></li>
						<li><a href="#">Butter & Eggs</a></li>
						<li><a href="#">Fastfood</a></li>
						<li><a href="#">Fresh Onion</a></li>
						<li><a href="#">Papayaya & Crisps</a></li>
						<li><a href="#">Oatmeal</a></li>
						<li><a href="#">Fresh Bananas</a></li>
					</ul>
				</div>
			</div>
			<div class="col-lg-9">
				<div class="hero__search">
					<div class="hero__search__form">
						<form action="#">
							<div class="hero__search__categories">
								All Categories <span class="arrow_carrot-down"></span>
							</div>
							<input type="text" placeholder="What do yo u need?">
							<button type="submit" class="site-btn">SEARCH</button>
						</form>

					</div>
					<div class="hero__search__phone">
						<div class="hero__search__phone__icon">
							<i class="fa fa-phone"></i>
						</div>
						<div class="hero__search__phone__text">
							<h5>+65 11.188.888</h5>
							<span>support 24/7 time</span>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

</section>
<!-- Hero Section End -->

<title>상품 등록</title>
<div id="test" style="text-align: center; margin-top: 10px;">
	<button onmouseover="chColor(this,'over')"
		onmouseout="chColor(this,'out')"
		style="color: black; text-align: center;">
		<a href="norProductWrite.jsp">일반 상품</a>
	</button>
	<button onmouseover="chColor(this,'over')"
		onmouseout="chColor(this,'out')" style="color: black;">
		<a href="aucProductWrite.jsp">경매 상품</a>
	</button>
</div>
<script  type="text/javascript">
	function chColor(obj, state) {
		var myColor;
		if (state == "over") {
			myColor = "red";
		} else {
			myColor = "black";
		}
		obj.style.color = myColor;
	}
</script>
</head>

<style>
#test button {
	width: 120px;
	height: 100px;
	padding: 20px;
	border: 3px solid #ff0000;
}
</style>

<%@ include file="../include/footer.jsp"%>