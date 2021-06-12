package admin.faq.model;

import java.util.Date;

public class Faqcolumn {

	private Integer fNo;
	private String fTit;
	private String fText;
	private Date fDate;
	public Faqcolumn(Integer fNo, String fTit, String fText, Date fDate) {
		this.fNo = fNo;
		this.fTit = fTit;
		this.fText = fText;
		this.fDate = fDate;
	}

	public Integer getFno() {
		return fNo;
	}

	public String getFtit() {
		return fTit;
	}

	public String getFtext() {
		return fText;
	}

	public Date getFdate() {
		return fDate;
	}
}
