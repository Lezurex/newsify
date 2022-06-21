package com.lezurex.newsify;

import java.util.Date;
import java.util.List;

public interface IArticleService {
	public List<Article> getArticles();
	public Article createArticle(String guid, String title, String description, Date pubDate, Category category, String linkToArticle, RssFeed rssFeed);
}
