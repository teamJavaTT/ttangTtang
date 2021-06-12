package admin.userproduct.service;

import admin.userproduct.model.UserProduct;

public class UserProductRequest {
	private UserProduct userproduct;

	public UserProductRequest(UserProduct userproduct) {
		this.userproduct = userproduct;
	}

	public UserProduct getuserproduct() {
		return userproduct;
	}

}
