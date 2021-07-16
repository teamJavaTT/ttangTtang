package org.zerock.service;

import org.zerock.domain.User;
import org.zerock.dto.Member;

public interface MemberService {
	//ȸ������
	void insertMemberJoin(Member member) throws Exception;
	//�α���
	User selectById(String userid, String upw) throws Exception;
	//���̵�ã��
	String selectIdFind(String uname, String uemail) throws Exception;
}
