package admin.declaration.service;

public class DeclarationUser {
	private String fNo;
	private String fTit;
	private String fText;
	private String fDate;

	public DeclarationUser(String fNo, String fTit, String fText, String fDate) {
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
