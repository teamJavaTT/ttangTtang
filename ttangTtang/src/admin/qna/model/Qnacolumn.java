 package admin.qna.model;

import java.util.Date;

public class Qnacolumn {

	private Integer qNo;
	private String userid;
	private String qTit;
	private String qText;
	private Date qDate;
	private String paText;
	private String qsText;
	private Date qsDate;
	private String qPw;
	
	public Qnacolumn(Integer qNo, String userid, String qTit, String qText, Date qDate, String paText, String qsText, Date qsDate, String qPw) {
		this.qNo = qNo;
		this.userid = userid;
		this.qTit = qTit;
		this.qText = qText;
		this.qDate = qDate;
		this.paText = paText;
		this.qsText = qsText;
		this.qsDate = qsDate;
		this.qPw = qPw;
	}

	public Integer getQno() {
		return qNo;
	}
	
	public String getUserId() {
		return userid;
	}
	public String getQtit() {
		return qTit;
	}
	public String getQtext() {
		return qText;
	}
	public Date getQdate() {
		return qDate;
	}
	
	// 댓글
	public String getPatext() {
		return paText;
	}
	public String getQstext() {
		return qsText;
	}
	public Date getQsdate() {
		return qsDate;
	}

	public String getQpw() {
		return qPw;
	}
}
