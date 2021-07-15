package org.zerock.service;

import java.util.List;

import org.zerock.domain.AccountDeclaration;
import org.zerock.domain.BlockUser;
import org.zerock.domain.Product;

public interface MypageMainService {
	List<AccountDeclaration> selectAccountDeclaration() throws Exception;
	List<BlockUser> selectBlockUser() throws Exception;
	List<Product> selectLikeProduct(String userid) throws Exception;
	List<Product> selectSellList(String userid) throws Exception;
	
}