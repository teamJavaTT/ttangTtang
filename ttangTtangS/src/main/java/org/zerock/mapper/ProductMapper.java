package org.zerock.mapper;

import java.util.List;

import org.zerock.domain.Category;

public interface ProductMapper {
	List<Category> selectCategory() throws Exception;
}
