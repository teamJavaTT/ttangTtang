package org.zerock.service;

import org.zerock.domain.ProductDetail;
import org.zerock.dto.LikeProduct;
import org.zerock.dto.Product;

public interface ProductService {
	
	//상품 등록
	void insertProduct(Product product) throws Exception;
	//상품 상세페이지 
	ProductDetail selectProduct(int ino) throws Exception;
	String selectCname(String ccode) throws Exception;
	//상품 수정
	void productModify(Product Product) throws Exception;
	
	//상품 삭제
	void productDelete(int ino) throws Exception;
	void likeDelete(int ino) throws Exception;
	void aucProductTabDelete(int ino) throws Exception;

	//상품 찜하기
	void  likeProductCountInsert(LikeProduct likeProduct) throws Exception;
	 void likeCountUpdate(String userid, int ino)throws Exception;
	 void likeCountSubtract(String userid, int ino)throws Exception;
	 LikeProduct  likeProductUser(String userid, int ino)throws Exception;
	 

	 //조회수
	 void viewCountUpdate(int ino) throws Exception ;


	
}
