package admin.faq.model;

import java.util.Date;

public class Faqcolumn {

	private Integer fno;
	private String ftit;
	private String ftext;
	private Date fdate;
	public Faqcolumn(Integer fno, String ftit, String ftext, Date fdate) {
		this.fno = fno;
		this.ftit = ftit;
		this.ftext = ftext;
		this.fdate = fdate;
	}

	public Integer getfno() {
		return fno;
	}

	public String getftit() {
		return ftit;
	}

	public String getftext() {
		return ftext;
	}

	public Date getfdate() {
		return fdate;
	}
}
