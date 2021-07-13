package org.zerock.mapper;

import java.util.List;

import org.zerock.domain.Category;
import org.zerock.domain.Product;
import org.zerock.domain.ProductToday;

public interface MainMapper {
	List<Category> selectCategory() throws Exception;
	List<Product> selectProduct() throws Exception;
	List<ProductToday> selectProductToday() throws Exception;
}
