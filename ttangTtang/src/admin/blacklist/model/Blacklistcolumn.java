package admin.blacklist.model;

import java.util.Date;

public class Blacklistcolumn {

	private Integer bNo;
	private String userId;
	private String bId;
	private String bText;
	private Date bDate;
	
	
	public Blacklistcolumn(Integer bNo,String userId, String bId, String bText, Date bDate) {
		this.bNo = bNo;
		this.userId = userId;
		this.bId = bId;
		this.bText = bText;
		this.bDate = bDate;
	}
	public Integer getbNo() {
		return bNo;
	}
	public String getUserId() {
		return userId;
	}
	public String getbId() {
		return bId;
	}
	public String getbText() {
		return bText;
	}
	public Date getbDate() {
		return bDate;
	}
}
