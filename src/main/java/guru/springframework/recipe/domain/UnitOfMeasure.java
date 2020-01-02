package guru.springframework.recipe.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Data
@Entity
public class UnitOfMeasure {
	private String description;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
}
