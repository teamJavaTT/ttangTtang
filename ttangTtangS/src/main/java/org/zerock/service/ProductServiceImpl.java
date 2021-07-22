package org.zerock.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.domain.ProductDetail;
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



	/*
	 * @Override
	 * 
	 * @Transactional public NorProduct productModify(NorProduct norProduct) throws
	 * Exception { return productMapper.productModify(norProduct); }
	 */
}
