package org.zerock.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.zerock.domain.Category;

public interface InitMapper {
	List<Category> selectCategory() throws Exception;
	List<String> auctionEndInoSelect() throws Exception;
	void auctionEndUpdate(String ino) throws Exception;
	int auctionEndInoCount(String ino) throws Exception;
	Map<String, String> aucAlimUserIdSelect(String ino) throws Exception;
	void alimInsert(@Param("userid") String userid, @Param("lText") String lText, @Param("ino") String ino) throws Exception;
	void auctioConnUpdate(String ino) throws Exception;
	String aucConnUserIdSelect(String ino) throws Exception;
}
