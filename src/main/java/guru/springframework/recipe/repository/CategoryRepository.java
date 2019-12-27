package guru.springframework.recipe.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import guru.springframework.recipe.domain.Category;

public interface CategoryRepository extends CrudRepository<Category, Long>{
	Optional<Category>  findByDescription(String description);
	
}
