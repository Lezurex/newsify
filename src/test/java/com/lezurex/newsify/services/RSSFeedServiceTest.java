package com.lezurex.newsify.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.lezurex.newsify.database.IRSSFeedRepo;
import com.lezurex.newsify.entities.Category;
import com.lezurex.newsify.entities.RSSFeed;

@SpringBootTest(classes = {RSSFeedService.class, IRSSFeedRepo.class})
public class RSSFeedServiceTest {

  @MockBean
  private IRSSFeedRepo rssFeedRepo;

  @Autowired
  private RSSFeedService rssFeedService;

  @Test
  public void canGetAll() {
    final List<RSSFeed> mockFeeds =
        List.of(new RSSFeed(0L, "https://nonexistent.com", new Category(0L, "Inland", List.of())));
    when(rssFeedRepo.findAll()).thenReturn(mockFeeds);

    List<RSSFeed> result = rssFeedService.getRSSFeeds();

    assertEquals(mockFeeds, result);
  }

}
