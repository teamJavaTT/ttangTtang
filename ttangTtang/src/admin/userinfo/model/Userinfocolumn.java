package admin.userinfo.model;

import java.util.Date;

public class Userinfocolumn {

	private String userId;
	private String uEmail;
	private String uName;
	private String phone;
	private String sex;
	private Date dateTime;
	private Integer memberChk;
	
	
	public Userinfocolumn(String userId, String uEmail, String uName, String phone, String sex, Date dateTime, Integer memberChk) {
		this.userId = userId;
		this.uEmail = uEmail;
		this.uName = uName;
		this.phone = phone;
		this.sex = sex;
		this.dateTime = dateTime;
		this.memberChk = memberChk;
	}

	public String getUserId() {
		return userId;
	}
	public String getUEmail() {
		return uEmail;
	}
	public String getUName() {
		return uName;
	}
	public String getPhone() {
		return phone;
	}
	public String getSex() {
		return sex;
	}
	public Date getDateTime() {
		return dateTime;
	}
	public Integer getMemberChk() {
		return memberChk;
	}
}
