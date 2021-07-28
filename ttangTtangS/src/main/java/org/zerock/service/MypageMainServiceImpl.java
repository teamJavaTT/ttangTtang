package org.zerock.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
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
	private List<BlockUser> blockUser;
	private List<AccountDeclaration> product;

	@Override  //신고
	@Transactional
	public List<AccountDeclaration> selectAccountDeclaration(String userid, String accountDeclaration, int pageStart, int pageEnd) throws Exception {
		List<AccountDeclaration> accountDeclaration1 = mypageMainMapper.selectAccountDeclaration(userid, accountDeclaration, pageStart, pageEnd);
		return accountDeclaration1;
	}

	@Override  //차단
	public List<BlockUser> selectBlockUser(String userid, String blockUser1, int pageStart, int pageEnd) throws Exception {
		List<BlockUser> blockUser = mypageMainMapper.selectBlockUser(userid, blockUser1, pageStart, pageEnd);
		return blockUser;
	}

	@Override
	@Transactional // 게시물 총 갯수 
	public int selectDclrBlckListCount(@Param("userid") String userid, @Param("blockChk") String blockChk) throws Exception{
		return mypageMainMapper.selectSellListCount(userid, blockChk);
	}
	
	
	@Override  //관심 상품
	public List<Product> selectLikeProduct(String userid,int pageStart, int pageEnd) throws Exception {
		List<Product> product = mypageMainMapper.selectLikeProduct(userid,pageStart,pageEnd);
		return product;
	}
	
	@Override
	@Transactional // 게시물 총 갯수 
	public int selectLikeProductListCount() throws Exception{
		return mypageMainMapper.selectLikeProductListCount();
	}
	
	
	@Override  //판매 내역
	public List<Product> selectSellList(String userid, String sellchk, int pageStart, int pageEnd) throws Exception {
		List<Product> product = mypageMainMapper.selectSellList(userid, sellchk, pageStart, pageEnd);
		return product;
	}
	@Override
	@Transactional // 게시물 총 갯수 
	public int selectSellListCount(@Param("userid") String userid, @Param("sellchk") String sellchk) throws Exception{
		return mypageMainMapper.selectSellListCount(userid, sellchk);
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

	@Override
	public List<AccountDeclaration> selectAccountDeclaration(String userid, String accountDeclaration)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BlockUser> selectBlockUser(String userid, String blockUser) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	



}
