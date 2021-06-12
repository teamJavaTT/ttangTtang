package admin.userproduct.model;

public class UserProduct {

	private String userid;
	private String qtit;
	private String qtext;

	public UserProduct(String userid, String qtit, String qtext) {
		
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
