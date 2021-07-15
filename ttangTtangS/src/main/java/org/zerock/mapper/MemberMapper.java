package org.zerock.mapper;

import org.zerock.domain.Member;
import org.zerock.domain.User;

public interface MemberMapper {
	void insertMemberJoin(Member member) throws Exception;

	User selectById(String userid) throws Exception;

}
