package admin.qna.model;

public class Qna {

	private String userid;
	private String qtit;
	private String qtext;

	public Qna(String userid, String qtit, String qtext) {
		
		this.userid = userid;
		this.qtit = qtit;
		this.qtext = qtext;
	}
	
	public String getuserid() {
		return userid;
	}
	public String getqtit() {
		return qtit;
	}

	public String getqtext() {
		return qtext;
	}

}
