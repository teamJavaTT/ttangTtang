package mypage.model;

public class DeclarationColumn {

	private String dNo;
	private String userId;
	private String duid;
	private String dtext;
	private String ddate;

	public DeclarationColumn(String dNo, String userId, String duid, String dtext, String ddate) {
		this.dNo = dNo;
		this.userId = userId;
		this.duid = duid;
		this.dtext = dtext;
		this.ddate = ddate;

	}

	public String getdNo() {
		return dNo;
	}

	public void setdNo(String dNo) {
		this.dNo = dNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getDuid() {
		return duid;
	}

	public void setDuid(String duid) {
		this.duid = duid;
	}

	public String getDtext() {
		return dtext;
	}

	public void setDtext(String dtext) {
		this.dtext = dtext;
	}

	public String getDdate() {
		return ddate;
	}

	public void setDdate(String ddate) {
		this.ddate = ddate;
	}

}
