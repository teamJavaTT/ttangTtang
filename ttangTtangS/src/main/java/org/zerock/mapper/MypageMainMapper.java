package org.zerock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.zerock.domain.AccountDeclaration;
import org.zerock.domain.BlockUser;
import org.zerock.domain.Product;
import org.zerock.domain.Secession;
import org.zerock.dto.AccountDeclarationDTO;
import org.zerock.dto.BlockUserDTO;

public interface MypageMainMapper {
	List<AccountDeclaration> selectAccountDeclaration(@Param("userid") String userid, @Param("accountDeclaration") String accountDeclaration) throws Exception;
	void insertAccountDeclaration(AccountDeclarationDTO accountDec) throws Exception;
	int selectCountDec(@Param("userid") String userid, @Param("badid") String badid) throws Exception;

	List<BlockUser> selectBlockUser(@Param("userid") String userid, @Param("blockUser") String blockUser) throws Exception;
	void insertBlockUser(BlockUserDTO accountBl) throws Exception;
	int selectCountBl(@Param("userid")String userid, @Param("blockid") String blockid) throws Exception;

	List<Product> selectLikeProduct(String userid) throws Exception;
	List<Product> selectSellList(@Param("userid") String userid, @Param("sellchk") String sellchk) throws Exception;
	List<Secession> selectDeleteForm() throws Exception;
}
