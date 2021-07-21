package org.zerock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.domain.AccountDeclaration;
import org.zerock.domain.BlockUser;
import org.zerock.domain.Product;
import org.zerock.domain.Secession;
import org.zerock.dto.AccountDeclarationDTO;
import org.zerock.dto.BlockUserDTO;
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
	
	
	@Override //신고 insert
	public void insertAccountDeclaration(AccountDeclarationDTO accountDec) throws Exception {
		mypageMainMapper.insertAccountDeclaration(accountDec);
	}
	
	@Override  //신고 중복
	public int selectCountDec(String userid, String badid) throws Exception {
		return mypageMainMapper.selectCountDec(userid, badid);
	}
	
	@Override //차단 insert
	public void insertBlockUser(BlockUserDTO accountBl) throws Exception {
		mypageMainMapper.insertBlockUser(accountBl);
	}
	
	@Override  //차단 중복
	public int selectCountBl(String userid, String blockid) throws Exception {
		return mypageMainMapper.selectCountBl(userid, blockid);
	}
}
