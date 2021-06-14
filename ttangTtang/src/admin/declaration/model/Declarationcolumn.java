package admin.declaration.model;

import java.util.Date;

public class Declarationcolumn {

	private Integer dNo;
	private String userId;
	private String duId;
	private String dText;
	private Date dDate;
	
	
	public Declarationcolumn(Integer dNo,String userId, String duId, String dText, Date dDate) {
		this.dNo = dNo;
		this.userId = userId;
		this.duId = duId;
		this.dText = dText;
		this.dDate = dDate;
	}
	public Integer getdNo() {
		return dNo;
	}
	public String getUserId() {
		return userId;
	}
	public String getDuId() {
		return duId;
	}
	public String getdText() {
		return dText;
	}
	public Date getdDate() {
		return dDate;
	}
}
