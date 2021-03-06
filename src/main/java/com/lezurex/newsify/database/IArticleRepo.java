package com.lezurex.newsify.database;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.lezurex.newsify.entities.Article;
import com.lezurex.newsify.entities.Category;

public interface IArticleRepo extends CrudRepository<Article, String> {

  public List<Article> findAll();

  public Optional<Article> findByGuid(String guid);

  public List<Article> findByCategory(Category category);

  public List<Article> findByCategoryOrderByPubDate(Category category);

  public void delete(Article article);

  public void deleteByGuid(String guid);

  @Modifying
  @Query("update Article set category = ?2 where id = ?1")
  public void setCategoryById(String id, Category category);

}
