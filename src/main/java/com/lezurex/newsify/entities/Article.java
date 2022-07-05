package com.lezurex.newsify.entities;

import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Article {

  @Id
  private String guid;

  private String title;
  @Lob
  private String description;
  private Date pubDate;
  private String link;

  @ManyToOne
  private Category category;

  @ManyToOne
  private RSSFeed rssFeed;

  public Article(String guid, String title, String description, Date pubDate, String link, Category category, RSSFeed rssFeed) {
    this.guid = guid;
    this.title = title;
    this.description = description;
    this.pubDate = pubDate;
    this.link = link;
    this.category = category;
    this.rssFeed = rssFeed;
  }

	public Article() {

	}
}
