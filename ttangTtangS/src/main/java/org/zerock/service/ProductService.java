package org.zerock.service;

import org.zerock.domain.ProductDetail;
import org.zerock.dto.Product;

public interface ProductService {
	void insertProduct(Product product) throws Exception;
	ProductDetail selectProduct(int ino) throws Exception;
	String selectCname(String ccode) throws Exception;
	//Product productModify(Product Product) throws Exception;

	
}
