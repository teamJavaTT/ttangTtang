package mypage.service;

import java.util.List;

import mypage.model.BlockColumn;

public class BlockListPage {

	
	private List<BlockColumn> block;
	
	private int total;
	private int currentPage;
	private int totalPages;
	private int startPage;
	private int endPage;
	private int countupPage;
	private int countdownPage;
	
	public BlockListPage(int total, int pageNo, int size, List<BlockColumn> block) {
		this.total = total;
		this.currentPage = pageNo;
		this.block = block;
		if (total == 0) {
			totalPages = 0;
			startPage = 0;
			endPage = 0;
		} else {
			totalPages = total / size;
			if (total % size > 0) {
				totalPages++;
			}
			int modVal = pageNo % 10;
			startPage = pageNo / 10 * 10 + 1;
			if (modVal == 0) startPage -= 10;
			
			endPage = startPage + 9;
			if (endPage > totalPages) endPage = totalPages;
		}
		
	}
	
	public List<BlockColumn> getBlock() {
		return block;
	}
	
	public int getTotal() {
		return total;
	}

	public boolean hasNoArticles() {
		return total == 0;
	}

	public boolean hasArticles() {
		return total > 0;
	}
	
	public int getCurrentPage() {
		return currentPage;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public int getStartPage() {
		return startPage;
	}
	
	public int getEndPage() {
		return endPage;
	}
	public int getCountupPage() {
		return countupPage + 1;
	}
	public int getCountdownPage() {
		return countdownPage - 1;
	}
}