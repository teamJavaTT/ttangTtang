package org.zerock.service;

import java.util.List;

import org.zerock.domain.Category;

public interface InitService {
	List<Category> selectCategory() throws Exception;
	void auctionEnd() throws Exception;
}
