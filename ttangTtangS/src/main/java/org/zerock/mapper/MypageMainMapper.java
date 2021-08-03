package org.zerock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.zerock.domain.AccountDeclaration;
import org.zerock.domain.Alim;
import org.zerock.domain.BlockUser;
import org.zerock.domain.Product;
import org.zerock.domain.Secession;
import org.zerock.dto.AccountDeclarationDTO;
import org.zerock.dto.BlockUserDTO;

public interface MypageMainMapper {
	// 신고
	List<AccountDeclaration> selectAccountDeclaration(@Param("userid") String userid, @Param("pageStart") int pageStart, @Param("pageEnd") int pageEnd) throws Exception;
	void insertAccountDeclaration(AccountDeclarationDTO accountDec) throws Exception;
	int selectCountDec(@Param("userid") String userid, @Param("badid") String badid) throws Exception;

	// 차단
	List<BlockUser> selectBlockUser(@Param("userid") String userid, @Param("pageStart") int pageStart, @Param("pageEnd") int pageEnd) throws Exception;
	void insertBlockUser(BlockUserDTO accountBl) throws Exception;
	int selectCountBl(@Param("userid") String userid, @Param("blockid") String blockid) throws Exception;

	// 관심상품
	List<Product> selectLikeProduct(@Param("userid") String userid, @Param("pageStart") int pageStart, @Param("pageEnd") int pageEnd) throws Exception;
	int selectLikeProductListCount(String userid);

	// 판매내역
	List<Product> selectSellList(@Param("userid") String userid, @Param("sellchk") String sellchk, @Param("pageStart") int pageStart, @Param("pageEnd") int pageEnd) throws Exception;
	int selectSellListCount(@Param("userid") String userid, @Param("sellchk") String sellchk) throws Exception;

	// 회원탈퇴
	List<Secession> selectDeleteForm() throws Exception;

	// 신고 및 차단 리스트
	int selectDclrBlckListCount(@Param("userid") String userid, @Param("blockChk") String blockChk) throws Exception;

	// 알림
	List<Alim> alimAllSelect(String userid) throws Exception;
	void alimChkUpdate(String userid) throws Exception;
}
