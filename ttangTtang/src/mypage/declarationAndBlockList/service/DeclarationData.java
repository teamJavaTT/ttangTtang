package mypage.declarationAndBlockList.service;

import mypage.declarationAndBlockList.model.DeclarationColumn;

public class DeclarationData {
	private DeclarationColumn blockDeclaration;

	public DeclarationData(DeclarationColumn blockDeclaration) {
		this.blockDeclaration = blockDeclaration;
	}

	public DeclarationColumn getProduct() {
		return blockDeclaration;
	}

}
