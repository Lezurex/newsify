package com.lezurex.newsify.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import java.util.Date;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.lezurex.newsify.database.IArticleRepo;
import com.lezurex.newsify.entities.Article;
import com.lezurex.newsify.entities.Category;
import com.lezurex.newsify.entities.RSSFeed;

@SpringBootTest(classes = {ArticleService.class, IArticleRepo.class})
public class ArticleServiceTest {

  @MockBean
  private IArticleRepo articleRepo;

  @Autowired
  private ArticleService articleService;

  @Test
  public void canGetAll() {
    final List<Article> mockArticles = List.of(new Article("abc", "An Article", "A Description",
        new Date(), "https://nonexistent.com", null, null));
    when(articleRepo.findAll()).thenReturn(mockArticles);

    List<Article> result = articleService.getArticles();

    assertEquals(mockArticles, result);
  }

  @Test
  public void canGetAllWhenEmpty() {
    when(articleRepo.findAll()).thenReturn(List.of());

    List<Article> result = articleService.getArticles();

    assertEquals(List.of(), result);
  }

  @Test
  public void canAddArticle() {
    Category category = new Category(null, "Schweiz", List.of());
    RSSFeed rssFeed = new RSSFeed(0L, "https://nonexistent.com", category);
    Article article = new Article("123", "An Article", "A Description", new Date(),
        "https://nonexistent.com", category, rssFeed);

    Article createdArticle = articleService.createArticle(article.getGuid(), article.getTitle(),
        article.getDescription(), article.getPubDate(), article.getLink(), article.getRssFeed());

    assertEquals(article, createdArticle);
  }

  @Test
  public void canSetCategory() {
    Category category = new Category(0L, "Schweiz", List.of());
    Category newCategory = new Category(1L, "International", List.of());
    RSSFeed rssFeed = new RSSFeed(0L, "https://nonexistent.com", category);
    Article article = new Article("123", "An Article", "A Description", new Date(),
        "https://nonexistent.com", category, rssFeed);
    Article createdArticle = articleService.createArticle(article.getGuid(), article.getTitle(),
        article.getDescription(), article.getPubDate(), article.getLink(), article.getRssFeed());

    articleService.setCategory(createdArticle, newCategory);

    assertEquals(newCategory, createdArticle.getCategory());
  }

}
