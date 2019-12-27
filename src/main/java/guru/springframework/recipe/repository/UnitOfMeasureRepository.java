package guru.springframework.recipe.repository;

import org.springframework.data.repository.CrudRepository;

import guru.springframework.recipe.domain.UnitOfMeasure;

public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long>{

}
