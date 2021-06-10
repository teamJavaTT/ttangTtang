package admin.faq.service;

public class FaqUser {
	private String fno;
	private String ftit;
	private String ftext;
	private String fdate;

	public FaqUser(String fno, String ftit, String ftext, String fdate) {
		this.fno = fno;
		this.ftit = ftit;
		this.ftext = ftext;
		this.fdate = fdate;
	}

	public String getfno() {
		return fno;
	}

	public String getftit() {
		return ftit;
	}

	public String getftext() {
		return ftext;
	}

	public String getfdate() {
		return fdate;
	}
}
