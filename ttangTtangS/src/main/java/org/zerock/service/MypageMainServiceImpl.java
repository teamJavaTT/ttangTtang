package org.zerock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.domain.AccountDeclaration;
import org.zerock.domain.BlockUser;
import org.zerock.domain.Product;
import org.zerock.mapper.MypageMainMapper;

@Service
public class MypageMainServiceImpl implements MypageMainService {
	@Autowired
	private MypageMainMapper mypageMainMapper;

	@Override  //신고
	@Transactional
	public List<AccountDeclaration> selectAccountDeclaration() throws Exception {
		return mypageMainMapper.selectAccountDeclaration();
	}

	@Override  //차단
	public List<BlockUser> selectBlockUser() throws Exception {
		return mypageMainMapper.selectBlockUser();
	}

	
	
	@Override  //관심상품
	public List<Product> selectLikeProduct(String userid) throws Exception {
		return mypageMainMapper.selectLikeProduct(userid);
	}

	@Override  //판매내역
	public List<Product> selectSellList(String userid) throws Exception {
		return mypageMainMapper.selectSellList(userid);
	}



	
}
