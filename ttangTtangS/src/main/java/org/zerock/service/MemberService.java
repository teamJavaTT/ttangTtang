package org.zerock.service;

import org.zerock.domain.User;
import org.zerock.dto.Member;

public interface MemberService {
	// 회원가입
	void insertMemberJoin(Member member) throws Exception;

	// 로그인
	User memberLogin(String userid, String upw) throws Exception;
	
	User selectById(String userid) throws Exception;

	// 아이디 찾기
	String selectIdFind(String uname, String uemail) throws Exception;

	// 회원 수정
	void updateMember(Member member) throws Exception;

	//비밀번호 찾기
	String selectPasswordFind(String userid, String uname, String uemail) throws Exception;
	
	//비밀 번호 변경
	void updatePassword(String upw, String userid) throws Exception;

}
