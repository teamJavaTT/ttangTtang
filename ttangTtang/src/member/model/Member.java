package member.model;

public class Member {

	private String userid;
	private String upw;
	private String uname;
	private String sex;
	private String uemail;
	private String phone;
	
	public Member(String userid, String upw, String uemail, String uname, String phone, String sex) {
		this.userid = userid;
		this.upw = upw;
		this.uemail = uemail;
		this.uname = uname;
		this.phone = phone;
		this.sex = sex;
	}

	public String getUserid() {
		return userid;
	}

	public String getUpw() {
		return upw;
	}
	
	public String getUname() {
		return uname;
	}

	public String getSex() {
		return sex;
	}

	public String getUemail() {
		return uemail;
	}

	public String getPhone() {
		return phone;
	}

	public boolean matchPassword(String inputUpw) {
		return upw.equals(inputUpw);
	}

	public void changePassword(String newPwd) {
		this.upw = newPwd;
	}

}
