package org.zerock.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.domain.ProductDetail;
import org.zerock.dto.LikeProduct;
import org.zerock.dto.Product;
import org.zerock.mapper.ProductMapper;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductMapper productMapper;

	//상품 등록 
	@Override
	@Transactional
	public void  insertProduct(Product product) throws Exception {
		 productMapper.insertProduct(product);
	}


  //상품 상세페이지 
	@Override
	@Transactional
	public ProductDetail selectProduct(int ino) throws Exception {
	return productMapper.selectProduct(ino);
	}

	@Override
	@Transactional
	public String selectCname(String ccode) throws Exception {
		String category  = productMapper.selectCname(ccode);
		return category;
	}


	@Override
	@Transactional
	public void productModify(Product Product) throws Exception {
		  productMapper.productModify(Product);
	}


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


	

	@Override
	@Transactional
	public void  likeProductCountInsert(LikeProduct likeProduct) throws Exception {
		  productMapper.likeProductCountInsert(likeProduct);
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
	public void likeCountSubtract(String userid, int ino)throws Exception {
		productMapper.likeCountSubtract(userid, ino);
	}


	@Override
	@Transactional
	public LikeProduct likeProductUser(String userid, int ino) throws Exception{
		return productMapper.likeProductUser(userid, ino);
	}





	
}
