package org.zerock.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.domain.Member;
import org.zerock.domain.User;
import org.zerock.mapper.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService {
@Autowired
private MemberMapper memberMapper;
	@Override
	@Transactional
	public void insertMemberJoin(Member member) throws Exception {
		memberMapper.insertMemberJoin(member);
	}
	
		@Override
		@Transactional
		public User selectById(String userid, String upw) throws Exception {
			User user = memberMapper.selectById(userid);
			
			if(user == null) {
				throw new LoginFailException();
			}
			if(!user.matchPassword(upw)) {
				throw new PasswordFailException();
			}
			return user;
		}


}
