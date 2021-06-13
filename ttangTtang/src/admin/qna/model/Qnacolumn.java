 package admin.qna.model;

import java.util.Date;

public class Qnacolumn {

	private Integer qNo;
	private String userId;
	private String qTit;
	private String qText;
	private Date qDate;
	private String paText;
	private String qsText;
	private Date qsDate;
	
	public Qnacolumn(Integer qNo, String userId, String qTit, String qText, Date qDate, String paText, String qsText, Date qsDate) {
		this.qNo = qNo;
		this.userId = userId;
		this.qTit = qTit;
		this.qText = qText;
		this.qDate = qDate;
		this.paText = paText;
		this.qsText = qsText;
		this.qsDate = qsDate;
	}

	public Integer getQno() {
		return qNo;
	}
	
	public String getUserId() {
		return userId;
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
}
