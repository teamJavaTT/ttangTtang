package org.zerock.mapper;

import org.zerock.domain.User;
import org.zerock.dto.Member;

public interface MemberMapper {
	void insertMemberJoin(Member member) throws Exception;

	User selectById(String userid) throws Exception;

}
