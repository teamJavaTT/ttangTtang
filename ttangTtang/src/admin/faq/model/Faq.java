package admin.faq.model;

public class Faq {

	private String ftit;
	private String ftext;

	public Faq(String ftit, String ftext) {

		this.ftit = ftit;
		this.ftext = ftext;
	}

	public String getftit() {
		return ftit;
	}

	public String getftext() {
		return ftext;
	}

}
