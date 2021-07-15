package org.zerock.service;

import org.zerock.domain.Member;
import org.zerock.domain.User;

public interface MemberService {
	
	void insertMemberJoin(Member member) throws Exception;
	
	User selectById(String userid, String upw) throws Exception;
}
