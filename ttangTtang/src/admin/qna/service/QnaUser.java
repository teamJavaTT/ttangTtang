package admin.qna.service;

public class QnaUser {
	private String qno;
	private String userid;
	private String qtit;
	private String qtext;
	private String qdate;

	public QnaUser(String qno, String userid, String qtit, String qtext, String qdate) {
		this.qno = qno;
		this.qtit = qtit;
		this.qtext = qtext;
		this.qdate = qdate;
	}

	public String getqno() {
		return qno;
	}

	public String getqtit() {
		return qtit;
	}

	public String getqtext() {
		return qtext;
	}

	public String getqdate() {
		return qdate;
	}
}
