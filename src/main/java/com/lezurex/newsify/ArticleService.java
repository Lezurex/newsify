package com.lezurex.newsify;

import com.lezurex.newsify.entities.Article;
import com.lezurex.newsify.entities.Category;
import com.lezurex.newsify.entities.RSSFeed;

import java.util.Date;
import java.util.List;

public class ArticleService implements IArticleService{
	@Override
	public List<Article> getArticles() {
		return null;
	}

	@Override
	public Article createArticle(String guid, String title, String description, Date pubDate, Category category, String linkToArticle, RSSFeed rssFeed) {
		return null;
	}
}
