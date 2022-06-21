package com.lezurex.newsify.entities;

import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Article {

  @Id
  private String guid;

  private String title;
  private String description;
  private Date pubDate;
  private String link;

  @ManyToOne
  private Category category;

  @ManyToOne
  private RSSFeed rssFeed;

}
