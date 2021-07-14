package org.zerock.service;

import java.util.List;

import org.zerock.domain.Category;
import org.zerock.domain.Product;

public interface ProductService {
	List<Category> selectCategory() throws Exception;
}
