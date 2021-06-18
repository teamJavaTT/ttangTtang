package member.service;

import java.util.Map;

public class MemberRequest {
	private String userid;
	private String upw;
	private String upw2;
	private String uemail;
	private String uname;
	private String phone;
	private String sex;
	private String address1;
	private String address2;
	private String address3;
	
		
	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}
	
	public String getUpw() {
		return upw;
	}

	public void setUpw(String upw) {
		this.upw = upw;
	}

	public String getUpw2() {
		return upw2;
	}

	public void setUpw2(String upw2) {
		this.upw2 = upw2;
	}
	
	public String getUemail() {
		return uemail;
	}

	public void setUemail(String uemail) {
		this.uemail = uemail;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	
	public String getAddress1() {
		return address1;
	}
	
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	
	public String getAddress2() {
		return address2;
	}
	
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	
	public String getAddress3() {
		return address3;
	}
	
	public void setAddress3(String address3) {
		this.address3 = address3;
	}
	



	public boolean isPasswordEqualToConfirm() {
		return upw != null && upw.equals(upw2);
	}

	public void validate(Map<String, Boolean> errors) {
		checkEmpty(errors, userid, "userid");
		checkEmpty(errors, upw, "upw");
		checkEmpty(errors, upw2, "upw2");
		checkEmpty(errors, uname, "uname");
		checkEmpty(errors, phone, "phone");
		checkEmpty(errors, sex, "sex");
				
		if (!errors.containsKey("upw2")) {
			if (!isPasswordEqualToConfirm()) {
				errors.put("notMatch", Boolean.TRUE);
			}
		}
	}

	private void checkEmpty(Map<String, Boolean> errors, String value, String fieldName) {
		if (value == null || value.isEmpty())
			errors.put(fieldName, Boolean.TRUE);
	}
}
