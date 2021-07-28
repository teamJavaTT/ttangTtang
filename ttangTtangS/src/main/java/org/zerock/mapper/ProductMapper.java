package org.zerock.mapper;

import org.apache.ibatis.annotations.Param;
import org.zerock.domain.ProductDetail;
import org.zerock.dto.Product;

public interface ProductMapper {

	//상품 등록
	void insertProduct(Product product)throws Exception;
	//상품 상세페이지 
	ProductDetail selectProduct(int ino)throws Exception;
	//상품 상세페이지 카테고리 불러오기
	String selectCname(String ccode)throws Exception;
	//상품 수정 
	Product productModify(Product product) throws Exception;
	//상품 삭제 
	void productDelete(int ino)throws Exception;
	void likeDelete(int ino)throws Exception;
	void aucProductTabDelete(int ino)throws Exception;
	
	//찜하기
	 int likeProductCount(String userId)throws Exception;
	 void likeCountUpdate(String userid, int ino)throws Exception;
	 void likeCountSubtract(String userid, int ino)throws Exception;
	int likeProductUser(@Param("userid") String userid,@Param("ino") int ino)throws Exception;
	 
	 //조회수
	 void viewCountUpdate(int ino) throws Exception ;



}

