package com.lezurex.newsify.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class RSSFeed {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String url;

  @ManyToOne
  private Category category;

  public RSSFeed() {}

  public RSSFeed(Long id, String url, Category category) {
    this.id = id;
    this.url = url;
    this.category = category;
  }

}
