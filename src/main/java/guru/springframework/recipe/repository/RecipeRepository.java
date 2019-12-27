package guru.springframework.recipe.repository;

import org.springframework.data.repository.CrudRepository;

import guru.springframework.recipe.domain.Recipe;

public interface RecipeRepository extends CrudRepository<Recipe, Long>{

}
