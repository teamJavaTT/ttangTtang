package org.zerock.service;

import java.util.List;

import org.zerock.domain.AccountDeclaration;
import org.zerock.domain.BlockUser;
import org.zerock.domain.LikeProduct;

public interface MypageMainService {
	List<AccountDeclaration> selectAccountDeclaration() throws Exception;
	List<BlockUser> selectBlockUser() throws Exception;
	List<LikeProduct> selectLikeProduct() throws Exception;

}
