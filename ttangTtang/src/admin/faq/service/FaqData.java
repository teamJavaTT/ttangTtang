package admin.faq.service;

import admin.faq.model.Faqcolumn;

public class FaqData {
	private Faqcolumn faq;

	public FaqData(Faqcolumn faq) {
		this.faq = faq;
	}

	public Faqcolumn getFaq() {
		return faq;
	}

}
