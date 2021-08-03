package org.zerock.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.zerock.domain.AccountDeclaration;
import org.zerock.domain.Alim;
import org.zerock.domain.BlockUser;
import org.zerock.domain.Criteria;
import org.zerock.domain.Notice;
import org.zerock.domain.Product;
import org.zerock.domain.Secession;
import org.zerock.dto.AccountDeclarationDTO;
import org.zerock.dto.BlockUserDTO;
import org.zerock.dto.NoticeColumn;

public interface MypageMainService {
	// 신고
	List<AccountDeclaration> selectAccountDeclaration(String userid, int pageStart, int pageEnd) throws Exception;
	void insertAccountDeclaration(AccountDeclarationDTO accountDec) throws Exception;
	int selectCountDec(String userid, String badid) throws Exception;

	// 차단
	List<BlockUser> selectBlockUser(String userid, int pageStart, int pageEnd) throws Exception;
	void insertBlockUser(BlockUserDTO accountBl) throws Exception;
	int selectCountBl(String userid, String blockid) throws Exception;

	// 관심상품
	List<Product> selectLikeProduct(String userid, int pageStart, int pageEnd) throws Exception;
	int selectLikeProductListCount(String userid) throws Exception;

	// 판매 상품
	List<Product> selectSellList(String userid, String sellchk, int pageStart, int pageEnd) throws Exception;
	int selectSellListCount(@Param("userid") String userid, @Param("sellchk") String sellchk) throws Exception;

	// 회원탈퇴
	List<Secession> selectDeleteForm() throws Exception;

	// 신고 및 차단 리스트
	int selectDclrBlckListCount(String userid, String blockChk) throws Exception;
	
	//알림
	List<Alim> alimAllSelect(String userid) throws Exception;
	void alimChkUpdate(String userid) throws Exception;
}
