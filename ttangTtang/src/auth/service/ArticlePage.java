package auth.service;

import java.util.List;

import auth.model.Article;

public class ArticlePage {

	private List<Article> content;

	public ArticlePage(List<Article> content) {
		this.content = content;
	}
	public List<Article> getContent() {
		return content;
	}
}
