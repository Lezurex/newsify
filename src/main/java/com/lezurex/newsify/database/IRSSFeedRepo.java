package com.lezurex.newsify.database;

import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import com.lezurex.newsify.entities.RSSFeed;

public interface IRSSFeedRepo extends CrudRepository<RSSFeed, Long> {

  public List<RSSFeed> findAll();

  public Optional<RSSFeed> findById(Long id);

  public void delete(RSSFeed feed);

  public void deleteById(Long id);

}
