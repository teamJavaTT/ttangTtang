package org.zerock.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;
import org.zerock.domain.User;
import org.zerock.dto.Member;

public interface MemberMapper {
	void insertMemberJoin(Member member) throws Exception;

	User selectById(String userid) throws Exception;

	String selectIdFind(@Param("uname") String uname, @Param("uemail") String uemail) throws Exception;
	
	 void updateMember(Member member) throws Exception;
		
		
	
}
