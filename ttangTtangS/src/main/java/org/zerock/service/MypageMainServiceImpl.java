package org.zerock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.domain.AccountDeclaration;
import org.zerock.domain.BlockUser;
import org.zerock.domain.Product;
import org.zerock.domain.Secession;
import org.zerock.mapper.MypageMainMapper;

@Service
public class MypageMainServiceImpl implements MypageMainService {
	@Autowired
	private MypageMainMapper mypageMainMapper;

	@Override  //신고
	@Transactional
	public List<AccountDeclaration> selectAccountDeclaration(String userid, String accountDeclaration) throws Exception {
		return mypageMainMapper.selectAccountDeclaration(userid, accountDeclaration);
	}

	@Override  //차단
	public List<BlockUser> selectBlockUser(String userid, String blockUser1) throws Exception {
		return mypageMainMapper.selectBlockUser(userid, blockUser1);
	}

	
	@Override  //관심 상품
	public List<Product> selectLikeProduct(String userid) throws Exception {
		return mypageMainMapper.selectLikeProduct(userid);
	}

	
	@Override  //판매 내역
	public List<Product> selectSellList(String userid, String sellchk) throws Exception {
		return mypageMainMapper.selectSellList(userid, sellchk);
	}

	
	@Override  //회원 탈퇴
	public List<Secession> selectDeleteForm() throws Exception {
		return mypageMainMapper.selectDeleteForm();
	}
	
	
}
