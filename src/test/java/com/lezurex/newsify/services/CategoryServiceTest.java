package com.lezurex.newsify.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.lezurex.newsify.database.IArticleRepo;
import com.lezurex.newsify.database.ICategoryRepo;
import com.lezurex.newsify.entities.Article;
import com.lezurex.newsify.entities.Category;
import com.lezurex.newsify.entities.RSSFeed;

@SpringBootTest(classes = {CategoryService.class, ICategoryService.class, IArticleRepo.class})
public class CategoryServiceTest {

  @MockBean
  private ICategoryRepo categoryRepo;
  @MockBean
  private IArticleRepo articleRepo;

  @Autowired
  private CategoryService categoryService;

  @Test
  public void testGetAll() {
    final List<Article> mockArticles = List.of();
    final List<Category> mockCategories = new ArrayList<>();
    mockCategories.add(new Category(1L, "Schweiz", mockArticles));
    when(categoryRepo.findAll()).thenReturn(mockCategories);

    List<Category> result = categoryService.getCategories();
    assertEquals(mockCategories, result);
  }

  @Test
  public void testGetAllEmpty() {
    final List<Category> mockCategories = List.of();
    when(categoryRepo.findAll()).thenReturn(mockCategories);

    List<Category> result = categoryService.getCategories();
    assertEquals(mockCategories, result);
  }

  @Test
  public void testAddCategory() {
    Category category = new Category(null, "Schweiz", List.of());

    when(categoryRepo.save(category)).thenReturn(null);

    Category createdCategory = categoryService.createCategory(category.getName());
    assertEquals(category, createdCategory);
  }

  @Test
  public void testAddBasedOnFeed() {
    final Category category = new Category(1L, "Weather", List.of());
    final RSSFeed rssFeed = new RSSFeed(1L, "https://nonexistens.com", category);
    final Article article = new Article("123", "Beautiful weather", "Sunny and 43 degrees",
        new Date(1655801367), "https://nonexistens.com", null, rssFeed);

    categoryService.addArticleBasedOnFeed(article);

    assertEquals(category, article.getCategory());
  }

}
