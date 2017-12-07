package wad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wad.domain.Category;

public interface CategoriesRepository extends JpaRepository<Category, Long> {
    
}
