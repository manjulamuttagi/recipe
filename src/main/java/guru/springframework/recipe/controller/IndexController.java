package guru.springframework.recipe.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import guru.springframework.recipe.domain.Category;
import guru.springframework.recipe.domain.UnitOfMeasure;
import guru.springframework.recipe.repository.CategoryRepository;
import guru.springframework.recipe.repository.UnitOfMeasureRepository;

@Controller
public class IndexController {
	
	private CategoryRepository categoryRepository;
	private UnitOfMeasureRepository unitOfMeasureRepository;

	public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
		this.categoryRepository = categoryRepository;
		this.unitOfMeasureRepository = unitOfMeasureRepository;
	}

	@RequestMapping({"","/","/index"})
	public String getIndexPage() {
		Optional<Category> cat = categoryRepository.findByDescription("Fast Food");
		Optional<UnitOfMeasure> uom = unitOfMeasureRepository.findByDescription("Teaspoon");
		
		System.out.println("CatcategoryRepositoryegory Id" + cat.get().getId());
		System.out.println("UnitofMeasureRepositoryegory Id" + uom.get().getId());
		return "index";
	}
}
