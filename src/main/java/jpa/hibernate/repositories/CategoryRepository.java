package jpa.hibernate.repositories;

import jpa.hibernate.domain.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
