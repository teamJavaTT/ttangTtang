package admin.faq.service;

import admin.faq.model.Faq;

public class FaqRequest {
	private Faq faq;

	public FaqRequest(Faq faq) {
		this.faq = faq;
	}

	public Faq getfaq() {
		return faq;
	}

}
