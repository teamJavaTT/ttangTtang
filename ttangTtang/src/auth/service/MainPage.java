package auth.service;

import java.util.List;

import auth.model.ProductToday;
import auth.model.Product;

public class MainPage {
	private List<ProductToday> productToday;
	private List<Product> product;
	
	

	public MainPage(List<ProductToday> productToday, List<Product> product) {
		this.productToday = productToday;
		this.product = product;
	}
	public List<ProductToday> getProductToday() {
		return productToday;
	}
	public List<Product> getProduct() {
		return product;
	}
}
