package org.zerock.mapper;

import java.util.ArrayList;
import java.util.List;

import org.zerock.domain.Category;
import org.zerock.domain.Product;
import org.zerock.domain.ProductToday;

public interface MainMapper {
	List<Product> selectProduct() throws Exception;
	List<ProductToday> selectProductToday() throws Exception;
	List<Product> selectCategoryProduct(String ccode) throws Exception;
	List<Product> selectSearchProduct(String[] searchArr) throws Exception;
	ArrayList<?> selectLikeproduct(String userid) throws Exception;
}
