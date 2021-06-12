package admin.userproduct.service;

import admin.userproduct.model.UserProductcolumn;

public class UserProductData {
	private UserProductcolumn userproduct;

	public UserProductData(UserProductcolumn userproduct) {
		this.userproduct = userproduct;
	}

	public UserProductcolumn getQna() {
		return userproduct;
	}

}
