package org.zerock.service;

import org.zerock.domain.User;
import org.zerock.dto.Member;

public interface MemberService {
	
	void insertMemberJoin(Member member) throws Exception;
	
	User selectById(String userid, String upw) throws Exception;
}
