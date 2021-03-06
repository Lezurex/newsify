package com.lezurex.newsify.services;

import java.util.Date;
import java.util.List;
import com.lezurex.newsify.database.IArticleRepo;
import com.lezurex.newsify.entities.Article;
import com.lezurex.newsify.entities.Category;
import com.lezurex.newsify.entities.RSSFeed;
import org.springframework.stereotype.Service;

@Service
public class ArticleService implements IArticleService {
	private final IArticleRepo articleRepo;

	public ArticleService(IArticleRepo articleRepo) {
		this.articleRepo = articleRepo;
	}

	@Override
	public List<Article> getArticles() {
		return articleRepo.findAll();
	}

	@Override
	public Article createArticle(String guid, String title, String description, Date pubDate,
			String link, RSSFeed rssFeed) {
		Category category = rssFeed.getCategory();
		return new Article(guid, title, description, pubDate, link, category, rssFeed);
	}

	@Override
	public void setCategory(Article article, Category category) {
		article.setCategory(category);
		articleRepo.save(article);
	}
}
