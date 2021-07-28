package org.zerock.service;

import java.util.ArrayList;

import org.zerock.domain.Alim;
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
	
	//주소 찾기
	ArrayList<String> address(String userid) throws Exception;

	//아이디 중복 확인 
	int idCheck(String userid) throws Exception;
	
	// 관심상품 카운트
	int likeProductCount(String userid) throws Exception;
	
	// 알림 카운트
	ArrayList<Alim> alimSelect(String userid) throws Exception;
}
