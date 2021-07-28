package org.zerock.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.domain.Category;
import org.zerock.mapper.InitMapper;

@Service
public class InitServiceImpl implements InitService {
	@Autowired
	private InitMapper initMapper;
	
	@Override
	@Transactional
	public List<Category> selectCategory() throws Exception {
		return initMapper.selectCategory();
	}
	
	@Override
	@Transactional
	public void auctionEnd() throws Exception {
		List<String> likeProduct = initMapper.auctionEndInoSelect();
		int aucPartCnt = 0;
		if(!likeProduct.isEmpty()) {
			for (int i = 0; i < likeProduct.size(); i++) {
				initMapper.auctionEndUpdate(likeProduct.get(i));
				aucPartCnt = initMapper.auctionEndInoCount(likeProduct.get(i));
				String lText = "";
				if(aucPartCnt == 0) {
					Map<String, String> noMachUserId = initMapper.aucAlimUserIdSelect(likeProduct.get(i));
					lText = noMachUserId.get("INAME") + " 상품이 기간 내에 경매에 참여한 사람이 없어 종료되었습니다.";
					initMapper.alimInsert(noMachUserId.get("USERID"), lText);
				}else {
					Map<String, String> machAlimUserId = initMapper.aucAlimUserIdSelect(likeProduct.get(i));
					lText = machAlimUserId.get("INAME") + " 상품이 구매자와 매칭되었습니다.";
					initMapper.alimInsert(machAlimUserId.get("USERID"), lText);
					
					initMapper.auctioConnUpdate(likeProduct.get(i));
					String connUserId = initMapper.aucConnUserIdSelect(likeProduct.get(i));
					lText = machAlimUserId.get("INAME") + " 상품 경매에 매칭되었습니다.";
					initMapper.alimInsert(connUserId, lText);
				}
			}
		}
	}
	
}
