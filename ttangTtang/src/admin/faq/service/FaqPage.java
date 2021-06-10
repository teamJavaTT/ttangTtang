package admin.faq.service;

import java.util.List;

import admin.faq.model.Faqcolumn;

public class FaqPage {

	private List<Faqcolumn> faq;
	
	private int total;
	private int currentPage;
	private int totalPages;
	private int startPage;
	private int endPage;
	private int countupPage;
	private int countdownPage;
	
	public FaqPage(int total, int pageNo, int size, List<Faqcolumn> faq) {
		this.total = total;
		this.currentPage = pageNo;
		this.faq = faq;
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
	public FaqPage(int total, int currentPage, int size) {
		/*
		 * // 이전, 다음 클릭버튼 사이에 있는 숫자들 this.pageNo = pageNo; // 시작하는 숫자 startPage =
		 * (pageNo - 1) * 5 + 1; // 끝나는 숫자 endPage = startPage + 4;
		 */
	}
	public List<Faqcolumn> getFaq() {
		return faq;
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