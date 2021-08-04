package org.zerock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.domain.ProductDetail;
import org.zerock.dto.ProductDTO;
import org.zerock.mapper.ProductMapper;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductMapper productMapper;

	// 상품 등록
	@Override
	@Transactional
	public void insertProduct(ProductDTO product) throws Exception {
		productMapper.insertProduct(product);
	}

	// 상품 상세페이지
	@Override
	@Transactional
	public ProductDetail selectProduct(int ino) throws Exception {
		return productMapper.selectProduct(ino);
	}

	@Override
	@Transactional
	public String selectCname(String ccode) throws Exception {
		String category = productMapper.selectCname(ccode);
		return category;
	}

	@Override
	@Transactional
	public List<ProductDTO> productUser(String userid, String ino) throws Exception {
		List<ProductDTO> productUser = productMapper.productUserSelect(userid, ino);
		return productUser;
	}

//상품수정
	@Override
	@Transactional
	public void productModify(ProductDTO Product) throws Exception {

		productMapper.productModify(Product);
	}

//상품 삭제
	@Override
	@Transactional
	public void productDelete(int ino) throws Exception {
		productMapper.productDelete(ino);
	}

	@Override
	@Transactional
	public void likeDelete(int ino) throws Exception {
		productMapper.likeDelete(ino);
	}

	@Override
	@Transactional
	public void aucProductTabDelete(int ino) throws Exception {
		productMapper.aucProductTabDelete(ino);
	}

//찜하기	
	@Override
	@Transactional
	public void likeProductCountInsert(String userid, int ino) throws Exception {
		productMapper.likeProductCountInsert(userid, ino);
	}

	@Override
	@Transactional
	public void viewCountUpdate(int ino) throws Exception {
		productMapper.viewCountUpdate(ino);

	}

	@Override
	@Transactional
	public void likeCountUpdate(String userid, int ino) throws Exception {
		productMapper.likeCountUpdate(userid, ino);
	}

	@Override
	@Transactional
	public void likeCountSubtract(String userid, int ino) throws Exception {
		productMapper.likeCountSubtract(userid, ino);
	}

	@Override
	@Transactional
	public int likeProductUser(String userid, int ino) throws Exception {
		return productMapper.likeProductUser(userid, ino);
	}

	@Override
	@Transactional
	public Integer likeProductCount(String userid) throws Exception {
		return productMapper.likeProductCount(userid);
	}

	@Override
	public void likeCountDelete(String userid, int ino) throws Exception {
		productMapper.likeCountDelete(userid, ino);
	}

//가격제시
	@Override
	public void auctionPartInsert(String userid, int aucIno, String oPrice) throws Exception {
	
		productMapper.auctionPartInsert(userid, aucIno, oPrice);
	}

	@Override
	public void updateAucPart(String userid, int aucIno, String oPrice) throws Exception {
		 productMapper.updateAucPart(userid, aucIno, oPrice);
	}
	
	@Override
	@Transactional
	public int apricenowSelect(int ino) throws Exception {
		int apricenow = productMapper.apricenowSelect(ino);
		return apricenow;
	}

}
