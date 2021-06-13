package admin.userinfo.model;

public class Userinfo {

	private String fTit;
	private String fText;

	public Userinfo(String fTit, String fText) {

		this.fTit = fTit;
		this.fText = fText;
	}

	public String getFtit() {
		return fTit;
	}

	public String getFtext() {
		return fText;
	}

}
