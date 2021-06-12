package admin.faq.model;

public class Faq {

	private String fTit;
	private String fText;

	public Faq(String fTit, String fText) {

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
