package org.zerock.service;

import java.util.List;

import org.zerock.domain.AccountDeclaration;
import org.zerock.domain.BlockUser;
import org.zerock.domain.Product;
import org.zerock.domain.Secession;
import org.zerock.dto.Member;

public interface MypageMainService {
	List<AccountDeclaration> selectAccountDeclaration(String userid, String accountDeclaration) throws Exception;
	List<BlockUser> selectBlockUser(String userid, String blockUser1) throws Exception;
	List<Product> selectLikeProduct(String userid) throws Exception;
	List<Product> selectSellList(String userid, String sellchk) throws Exception;
	List<Secession> selectDeleteForm() throws Exception;
	
}
