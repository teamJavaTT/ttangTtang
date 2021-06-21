package member.model;

public class Member {

	private String userid;
	private String upw;
	private String uemail;
	private String uname;
	private String phone;
	private String sex;
	private String address1;
	private String address2;
	private String address3;
	private String memberChk;
	
	public Member(String userid, String upw, String uemail, String uname, String phone, String sex, String address1, String address2, String address3, String memberchk) {
		this.userid = userid;
		this.upw = upw;
		this.uemail = uemail;
		this.uname = uname;
		this.phone = phone;
		this.sex = sex;
		this.address1 = address1;
		this.address2 = address2;
		this.address3 = address3;
		this.memberChk = memberchk;
	}

	public String getUserid() {
		return userid;
	}

	public String getUpw() {
		return upw;
	}
	
	public String getUemail() {
		return uemail;
	}
	
	public String getUname() {
		return uname;
	}
	
	public String getPhone() {
		return phone;
	}

	public String getSex() {
		return sex;
	}
	
	public String getAddress1() {
		return address1;
	}
	
	public String getAddress2() {
		return address2;
	}
	
	public String getAddress3() {
		return address3;
	}
	
	public String getMemberChk() {
		return memberChk;
	}



	public boolean matchPassword(String inputUpw) {
		return upw.equals(inputUpw);
	}

	public void changePassword(String newPwd) {
		this.upw = newPwd;
	}

	

}
