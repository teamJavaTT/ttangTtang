package mypage.sellcheck.service;

import mypage.sellcheck.model.ProductColumn;

public class SellCheckData {
	private ProductColumn product;

	public SellCheckData(ProductColumn product) {
		this.product = product;
	}

	public ProductColumn getProduct() {
		return product;
	}

}
