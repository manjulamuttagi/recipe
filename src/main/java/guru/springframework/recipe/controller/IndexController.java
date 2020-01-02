package guru.springframework.recipe.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import guru.springframework.recipe.domain.Category;
import guru.springframework.recipe.domain.UnitOfMeasure;
import guru.springframework.recipe.repository.CategoryRepository;
import guru.springframework.recipe.repository.UnitOfMeasureRepository;
import guru.springframework.recipe.services.RecipeService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class IndexController {
	
	private CategoryRepository categoryRepository;
	private UnitOfMeasureRepository unitOfMeasureRepository;
	private RecipeService recipeService;

	public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository,RecipeService recipeService) {
		this.categoryRepository = categoryRepository;
		this.unitOfMeasureRepository = unitOfMeasureRepository;
		this.recipeService = recipeService;
	}

	@RequestMapping({"","/","/index"})
	public String getIndexPage(Model model) {
		log.debug("inside getting index page");
		
		Optional<Category> cat = categoryRepository.findByDescription("Fast Food");
		Optional<UnitOfMeasure> uom = unitOfMeasureRepository.findByDescription("Teaspoon");
		model.addAttribute("recipes", recipeService.getRecipes());
		
		System.out.println("CatcategoryRepositoryegory Id" + cat.get().getId());
		System.out.println("UnitofMeasureRepositoryegory Id" + uom.get().getId());
		return "index";
	}
}
