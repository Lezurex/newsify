package com.lezurex.newsify.services;

import java.util.List;
import com.lezurex.newsify.entities.Article;
import com.lezurex.newsify.entities.Category;

public interface ICategoryService {

  public List<Category> getCategories();

  public Category createCategory(String name);

  public void addArticleBasedOnFeed(Article article);

  public List<Article> getRecentArticlesOfCategory(Category category);

}
