package com.lezurex.newsify.database;

import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import com.lezurex.newsify.entities.Article;
import com.lezurex.newsify.entities.Category;

public interface IArticleRepo extends CrudRepository<Article, String> {

  public List<Article> getArticles();

  public Optional<Article> getByGuid(String guid);

  public List<Article> getByCategory(Category category);

  public void add(Article article);

  public void delete(Article article);

  public void deleteByGuid(String guid);

  public void update(Article article);

}
