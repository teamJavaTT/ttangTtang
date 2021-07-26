package org.zerock.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.domain.User;
import org.zerock.dto.Member;
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
	public User selectById(String userid) throws Exception {
		User user = memberMapper.selectById(userid);
		return user;
	}
	
	@Override
	@Transactional
	public User memberLogin(String userid, String upw) throws Exception {
		User user = selectById(userid);

		if (user == null) {
			throw new LoginFailException();
		}
		if (!user.matchPassword(upw)) {
			throw new PasswordFailException();
		}
		return user;
	}

	@Override
	@Transactional
	public String selectIdFind(String uname, String uemail) throws Exception {
		String userid = memberMapper.selectIdFind(uname, uemail);
		return userid;

	}

	@Override
	@Transactional
	public void updateMember(Member member) throws Exception {
		 memberMapper.updateMember(member);
		
		
	}
	
	@Override
	@Transactional
	public String selectPasswordFind(String userid, String uname, String uemail) throws Exception {
		String upw = memberMapper.selectPasswordFind(userid, uname, uemail);
		return upw;

	}
	
	@Override
	@Transactional
	public void updatePassword(String upw, String userid) throws Exception {
		 memberMapper.updatePassword(upw, userid);
		
		
	}

	@Override
	@Transactional
	public ArrayList<String> address(String userid) throws Exception {
		return memberMapper.addressSelect(userid);
	}
	
}
