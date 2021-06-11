package admin.qna.model;

import java.util.Date;

public class Qnacolumn {

	private Integer qno;
	private String userid;
	private String qtit;
	private String qtext;
	private Date qdate;
	public Qnacolumn(Integer qno, String userid, String qtit, String qtext, Date qdate) {
		this.qno = qno;
		this.userid = userid;
		this.qtit = qtit;
		this.qtext = qtext;
		this.qdate = qdate;
	}

	public Integer getqno() {
		return qno;
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

	public Date getqdate() {
		return qdate;
	}
}
