package org.zerock.mapper;

import org.zerock.domain.ProductDetail;
import org.zerock.dto.Product;

public interface ProductMapper {

	//상품 등록
	void insertProduct(Product product)throws Exception;
	//상품 상세페이지 
	ProductDetail selectProduct(int ino)throws Exception;
	//상품 상세페이지 카테고리 불러오기
	String selectCname(String ccode)throws Exception;





}
