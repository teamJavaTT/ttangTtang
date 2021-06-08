package product.service;

import java.util.List;

import product.model.Notice;
import product.model.Noticecolumn;

public class ProductPage {

	private List<Productcolumn> product;

	public ProductPage(List<Productcolumn>  prodcut) {
		this.product = product;
	}
	public List<Productcolumn> getProduct() {
		return product;
	}
}