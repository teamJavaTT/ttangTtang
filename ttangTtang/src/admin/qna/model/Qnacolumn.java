 package admin.qna.model;

import java.util.Date;

public class Qnacolumn {

	private Integer qno;
	private String userid;
	private String qtit;
	private String qtext;
	private Date qdate;
	private String patext;
	private String qstext;
	private Date qsdate;
	
	public Qnacolumn(Integer qno, String userid, String qtit, String qtext, Date qdate, String patext, String qstext, Date qsdate) {
		this.qno = qno;
		this.userid = userid;
		this.qtit = qtit;
		this.qtext = qtext;
		this.qdate = qdate;
		this.patext = patext;
		this.qstext = qstext;
		this.qsdate = qsdate;
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
	
	// 댓글
	public String getpatext() {
		return patext;
	}
	public String getqstext() {
		return qstext;
	}
	public Date getqsdate() {
		return qsdate;
	}
}
