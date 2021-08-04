package org.zerock.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.domain.Category;
import org.zerock.domain.Product;
import org.zerock.domain.ProductToday;
import org.zerock.mapper.MainMapper;

@Service
public class MainServiceImpl implements MainService {
	@Autowired
	private MainMapper mainMapper;
	
	@Override
	@Transactional
	public List<Product> selectProduct() throws Exception {
		return mainMapper.selectProduct();
	}
	
	@Override
	@Transactional
	public List<ProductToday> selectProductToday() throws Exception {
		return mainMapper.selectProductToday();
	}
	
	@Override
	@Transactional
	public List<Product> selectCategoryProduct(String ccode) throws Exception {
		return mainMapper.selectCategoryProduct(ccode);
	}
	
	@Override
	@Transactional
	public List<Product> selectSearchProduct(String search) throws Exception {
		String[] searchArr = search.trim().split("");
				
		return mainMapper.selectSearchProduct(searchArr);
	}
	
	@Override
	@Transactional
	public ArrayList<?> selectLikeproduct(String userid) throws Exception {
		return mainMapper.selectLikeproduct(userid);
	}
	
}
