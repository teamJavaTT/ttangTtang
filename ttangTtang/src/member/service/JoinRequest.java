package member.service;

import java.util.Map;

public class JoinRequest {
	private String userid;
	private String uname;
	private String upw;
	private String upw2;
	private String uemail;
	private String phone;
	private String sex;



	
	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
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

	

	public boolean isPasswordEqualToConfirm() {
		return upw != null && upw.equals(upw2);
	}

	public void validate(Map<String, Boolean> errors) {
		checkEmpty(errors, userid, "id");
		checkEmpty(errors, uname, "name");
		checkEmpty(errors, upw, "password");
		checkEmpty(errors, upw2, "confirmPassword");
		checkEmpty(errors, uemail, "email");
		checkEmpty(errors, phone, "phone");
		checkEmpty(errors, sex, "sex");
		if (!errors.containsKey("confirmPassword")) {
			if (!isPasswordEqualToConfirm()) {
				errors.put("notMatch", Boolean.TRUE);
			}
		}
	}

	private void checkEmpty(Map<String, Boolean> errors, 
			String value, String fieldName) {
		if (value == null || value.isEmpty())
			errors.put(fieldName, Boolean.TRUE);
	}
}
