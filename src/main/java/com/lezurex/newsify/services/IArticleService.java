package com.lezurex.newsify.services;

import com.lezurex.newsify.entities.Article;
import com.lezurex.newsify.entities.Category;
import com.lezurex.newsify.entities.RSSFeed;

import java.util.Date;
import java.util.List;

public interface IArticleService {
	public List<Article> getArticles();

	public Article createArticle(String guid, String title, String description, Date pubDate, String link, Category category, RSSFeed rssFeed);
}