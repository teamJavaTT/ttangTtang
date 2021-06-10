package admin.qna.model;

public class Qna {

	private String qtit;
	private String qtext;

	public Qna(String qtit, String qtext) {

		this.qtit = qtit;
		this.qtext = qtext;
	}

	public String getqtit() {
		return qtit;
	}

	public String getqtext() {
		return qtext;
	}

}
