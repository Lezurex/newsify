package com.lezurex.newsify.database;

import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import com.lezurex.newsify.entities.Category;

public interface ICategoryRepo extends CrudRepository<Category, Long> {

  public List<Category> findAll();

  public Optional<Category> findById(Long id);

  public void delete(Category category);

  public void deleteById(Long id);

}
