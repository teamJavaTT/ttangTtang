package org.zerock.mapper;

import org.zerock.domain.ProductDetail;
import org.zerock.dto.Product;

public interface ProductMapper {

	
	Product insertProduct(Product product);
	ProductDetail selectProduct(int ino);
	String selectCname(String ccode);





}
