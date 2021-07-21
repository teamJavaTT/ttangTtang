package org.zerock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.zerock.domain.AccountDeclaration;
import org.zerock.domain.BlockUser;
import org.zerock.domain.Product;
import org.zerock.domain.Secession;
import org.zerock.dto.Member;

public interface MypageMainMapper {
	List<AccountDeclaration> selectAccountDeclaration(@Param("userid") String userid, @Param("accountDeclaration") String accountDeclaration) throws Exception;
	List<BlockUser> selectBlockUser(@Param("userid") String userid, @Param("blockUser") String blockUser1) throws Exception;
	List<Product> selectLikeProduct(String userid) throws Exception;
	List<Product> selectSellList(@Param("userid") String userid, @Param("sellchk") String sellchk) throws Exception;
	List<Secession> selectDeleteForm() throws Exception;
	
}
