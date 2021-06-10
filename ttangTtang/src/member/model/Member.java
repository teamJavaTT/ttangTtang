package member.model;

public class Member {

	private String userid;
	private String uname;
	private String upw;
	private String upw2;
	private String uemail;
	private String phone;
	private String sex;
	private String birth;

	public Member(String userid, String uname, String upw, String upw2, String uemail, String phone, String sex, String birth) {
		this.userid = userid;
		this.uname = uname;
		this.upw = upw;
		this.upw2 = upw2;
		this.uemail = uemail;
		this.phone = phone;
		this.sex = sex;
		this.sex = birth;

	}

	public String getUserid() {
		return userid;
	}

	public String getUname() {
		return uname;
	}

	public String getUpw() {
		return upw;
	}

	public String getUpw2() {
		return upw2;
	}

	public String getUemail() {
		return uemail;
	}

	public String getPhone() {
		return phone;
	}

	public String getSex() {
		return sex;
	}
	
	public String getBirth() {
		return birth;
	}

	public boolean matchPassword(String upw) {
		return upw.equals(upw);
	}

	public void changePassword(String newPwd) {
		this.upw = newPwd;
	}

}
