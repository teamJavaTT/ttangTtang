package org.zerock.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;
import org.zerock.domain.Alim;
import org.zerock.domain.User;
import org.zerock.dto.Member;

public interface MemberMapper {
	//회원가입
	void insertMemberJoin(Member member) throws Exception;
	//로그인
	User selectById(String userid) throws Exception;
	//아이디찾기
	String selectIdFind(@Param("uname") String uname, @Param("uemail") String uemail) throws Exception;
	//회원정보 수정
	 void updateMember(Member member) throws Exception;
	 //비밀번호찾기
	 String selectPasswordFind(@Param("userid") String userid,@Param("uname") String uname, @Param("uemail") String uemail) throws Exception;
	//비밀 번호 변경
	 void updatePassword(@Param("upw") String upw, @Param("userid") String userid) throws Exception;
	// 상품 등록 주소 찾기
	 ArrayList<String> addressSelect(@Param("userid") String userid)throws Exception;
	//아이디 중복확인
	 int idCheck(String userid)throws Exception;
	// 관심상품 카운트
	int likeProductCount(String userid) throws Exception;
	// 알림 카운트
	ArrayList<Alim> alimSelect(String userid) throws Exception;
}
