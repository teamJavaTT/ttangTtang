package admin.outuser.service;

import java.util.List;

import admin.outuser.model.OutUsercolumn;

public class OutUserPage {

	private List<OutUsercolumn> outuser;
	
	private int total;
	private int currentPage;
	private int totalPages;
	private int startPage;
	private int endPage;
	private int countupPage;
	private int countdownPage;
	
	public OutUserPage(int total, int pageNo, int size, List<OutUsercolumn> outuser) {
		this.total = total;
		this.currentPage = pageNo;
		this.outuser = outuser;
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
	public List<OutUsercolumn> getOutUser() {
		return outuser;
	}
	
	// page 분할
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