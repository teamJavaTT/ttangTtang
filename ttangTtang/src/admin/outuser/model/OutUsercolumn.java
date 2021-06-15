package admin.outuser.model;

import java.util.Date;

public class OutUsercolumn {

	private Integer sNo;
	private String userId;
	private String sText;
	private Date sDate;
	private Date scDate;
	
	
	public OutUsercolumn(Integer sNo,String userId, String sText, Date sDate, Date scDate) {
		this.sNo = sNo;
		this.userId = userId;
		this.sText = sText;
		this.sDate = sDate;
		this.scDate = scDate;
	}
	public Integer getsNo() {
		return sNo;
	}
	public String getUserId() {
		return userId;
	}
	public String getsText() {
		return sText;
	}
	public Date getsDate() {
		return sDate;
	}
	public Date getscDate() {
		return scDate;
	}
}
