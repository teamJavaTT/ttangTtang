package org.zerock.service;

import java.util.List;

import org.zerock.domain.ProductDetail;
import org.zerock.dto.AucProduct;
import org.zerock.dto.NorProduct;

public interface ProductService {

	ProductDetail selectProduct(int ino) throws Exception;
	String selectCname(String ccode) throws Exception;
	List<AucProduct> insertAucProduct() throws Exception;
	List<NorProduct> insertNorProduct() throws Exception;
	ProductDetail productModify(ProductDetail productDetail) throws Exception;
	
}
