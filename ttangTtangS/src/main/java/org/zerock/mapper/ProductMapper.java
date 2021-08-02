package org.zerock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.zerock.domain.ProductDetail;
import org.zerock.dto.ProductDTO;

public interface ProductMapper {

	// 상품 등록
	void insertProduct(ProductDTO product) throws Exception;

	// 상품 상세페이지
	ProductDetail selectProduct(int ino) throws Exception;

	// 상품 상세페이지 카테고리 불러오기
	String selectCname(String ccode) throws Exception;

	List<ProductDTO> productUserSelect(@Param("userid") String userid, @Param("ino") String ino) throws Exception;

	// 상품 수정
	void productModify(ProductDTO product) throws Exception;

	// 상품 삭제
	void productDelete(@Param("ino") int ino) throws Exception;

	void likeDelete(@Param("ino") int ino) throws Exception;

	void aucProductTabDelete(@Param("ino") int ino) throws Exception;

	// 찜하기
	void likeProductCountInsert(@Param("userid") String userid, @Param("ino") int ino) throws Exception;

	void likeCountUpdate(@Param("userid") String userid, @Param("ino") int ino) throws Exception;

	void likeCountSubtract(@Param("userid") String userid, @Param("ino") int ino) throws Exception;

	void likeCountDelete(@Param("userid") String userid, @Param("ino") int ino);

	int likeProductUser(@Param("userid") String userid, @Param("ino") int ino) throws Exception;

	Integer likeProductCount(@Param("userid") String userid) throws Exception;

	// 조회수
	void viewCountUpdate(int ino) throws Exception;

	//가격제시
	void auctionPartInsert(@Param("userid") String userid, @Param("aucIno") int aucIno, @Param("oPrice") String oPrice)throws Exception;
	void updateAucPart(@Param("userid")String userid,@Param("aucIno")  int aucIno, @Param("oPrice") String oPrice)throws Exception;
}
