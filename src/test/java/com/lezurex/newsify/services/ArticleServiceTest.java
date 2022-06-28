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

}
