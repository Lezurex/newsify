package com.lezurex.newsify.services;

import java.util.List;
import com.lezurex.newsify.database.IArticleRepo;
import com.lezurex.newsify.database.ICategoryRepo;
import com.lezurex.newsify.entities.Article;
import com.lezurex.newsify.entities.Category;

public class CategoryService implements ICategoryService {

  private final ICategoryRepo categories;
  private final IArticleRepo articles;

  public CategoryService(ICategoryRepo categories, IArticleRepo articles) {
    this.categories = categories;
    this.articles = articles;
  }

  @Override
  public List<Category> getCategories() {
    return categories.findAll();
  }

  @Override
  public Category createCategory(String name) {
    Category category = new Category(null, name, List.of());
    categories.save(category);
    return category;
  }

  @Override
  public void addArticleBasedOnFeed(Article article) {
    article.setCategory(article.getRssFeed().getCategory());
    articles.save(article);
  }

  @Override
  public List<Article> getRecentArticlesOfCategory(Category category) {
    return articles.findByCategoryOrderByPubDate(category);
  }

}
