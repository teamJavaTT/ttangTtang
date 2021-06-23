package mypage.declarationAndBlockList.service;

import mypage.declarationAndBlockList.model.DeclarationColumn;

public class ListtData {
	private DeclarationColumn blockDeclaration;

	public ListtData(DeclarationColumn blockDeclaration) {
		this.blockDeclaration = blockDeclaration;
	}

	public DeclarationColumn getProduct() {
		return blockDeclaration;
	}

}
