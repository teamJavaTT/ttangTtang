package org.zerock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.domain.ProductDetail;
import org.zerock.dto.AucProduct;
import org.zerock.dto.NorProduct;
import org.zerock.mapper.ProductMapper;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductMapper productMapper;

	@Override
	// 경매 등록
	public List<AucProduct> insertAucProduct() throws Exception {
		return productMapper.insertAucProduct();
	}

	@Override
	// 일반 등록
	public List<NorProduct> insertNorProduct() throws Exception {
		return productMapper.insertNorProduct();
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
	public ProductDetail productModify(int ino) throws Exception {
		return productMapper.productModify(ino);
	}

}
