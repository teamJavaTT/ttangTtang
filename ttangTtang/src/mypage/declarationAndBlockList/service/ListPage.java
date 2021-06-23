package mypage.declarationAndBlockList.service;

import java.util.List;

import mypage.declarationAndBlockList.model.DeclarationColumn;

public class ListPage {

	private List<DeclarationColumn> blockDeclaration;
	
	private int total;
	private int currentPage;
	private int totalPages;
	private int startPage;
	private int endPage;
	private int countupPage;
	private int countdownPage;
	
	public ListPage(int total, int pageNo, int size, List<DeclarationColumn> blockDeclaration) {
		this.total = total;
		this.currentPage = pageNo;
		this.blockDeclaration = blockDeclaration;
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
	public List<DeclarationColumn> getProduct() {
		return blockDeclaration;
	}
	
	// page 분할

}