package com.lezurex.newsify.entities;

import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Category {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String name;

  @OneToMany
  private List<Article> articles;

  public Category() {};

  public Category(Long id, String name, List<Article> articles) {
    this.id = id;
    this.name = name;
    this.articles = articles;
  }

}
