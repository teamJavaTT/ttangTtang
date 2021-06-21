package member.service;

public class User {

	private String userid;
	private String uname;
	private String memberChk;

	public User(String userid, String uname, String memberChk) {
		this.userid = userid;
		this.uname = uname;
		this.memberChk = memberChk;
	}

	public String getUserid() {
		return userid;
	}
	public String getUname() {
		return uname;
	}
	public String getMemberChk() {
		return memberChk;
	}

}
