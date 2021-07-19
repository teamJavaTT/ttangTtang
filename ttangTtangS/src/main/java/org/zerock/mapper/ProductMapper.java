package org.zerock.mapper;

import java.util.List;

import org.zerock.domain.ProductDetail;
import org.zerock.dto.AucProduct;
import org.zerock.dto.NorProduct;

public interface ProductMapper {
	List<AucProduct> insertAucProduct() throws Exception;
	List<NorProduct> insertNorProduct() throws Exception;
	ProductDetail selectProduct(int ino);
	String selectCname(String ccode);
	ProductDetail productModify() throws Exception;




}
