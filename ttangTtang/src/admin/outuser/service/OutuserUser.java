package admin.outuser.service;

public class OutuserUser {
	private String fNo;
	private String fTit;
	private String fText;
	private String fDate;

	public OutuserUser(String fNo, String fTit, String fText, String fDate) {
		this.fNo = fNo;
		this.fTit = fTit;
		this.fText = fText;
		this.fDate = fDate;
	}

	public String getFno() {
		return fNo;
	}

	public String getFtit() {
		return fTit;
	}

	public String getFtext() {
		return fText;
	}

	public String getFdate() {
		return fDate;
	}
}
