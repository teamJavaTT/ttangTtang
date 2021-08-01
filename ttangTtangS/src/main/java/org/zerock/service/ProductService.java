package org.zerock.service;

import java.util.List;

import org.zerock.domain.ProductDetail;
import org.zerock.dto.LikeProduct;
import org.zerock.dto.Product;

public interface ProductService {
	
	//상품 등록
	void insertProduct(Product product) throws Exception;
	//상품 상세페이지 
	ProductDetail selectProduct(int ino) throws Exception;
	String selectCname(String ccode) throws Exception;
	List<Product> productUser(String userid, String ino) throws Exception;
	//상품 수정
	void productModify(Product Product) throws Exception;
	
	//상품 삭제
	void productDelete(int ino) throws Exception;
	void likeDelete(int ino) throws Exception;
	void aucProductTabDelete(int ino) throws Exception;

	//상품 찜하기
	 void likeCountUpdate(String userid, int ino)throws Exception;
	 void likeCountSubtract(String userid, int ino)throws Exception;
	 void likeCountDelete(String userid, int ino)throws Exception;
	 Integer likeProductCount(String userid)throws Exception;
	 LikeProduct  likeProductUser(String userid,int ino)throws Exception;
	

	 //조회수
	 void viewCountUpdate(int ino) throws Exception ;
	void likeProductCountInsert(String userid, int ino) throws Exception;


	
}
