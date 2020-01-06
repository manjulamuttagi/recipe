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
private final RecipeService recipeService;

public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository, RecipeService recipeService) {
this.categoryRepository = categoryRepository;
this.unitOfMeasureRepository = unitOfMeasureRepository;
this.recipeService = recipeService;
}

@RequestMapping({"","/","/index"})
public String getIndexPage(Model model) {

log.debug("Getting index page");
Optional<Category> cat = categoryRepository.findByDescription("American");
Optional<UnitOfMeasure> uom = unitOfMeasureRepository.findByDescription("Teaspoon");
   model.addAttribute("recipes", recipeService.getRecipes());

System.out.println("Cat Id is " + cat.get().getId());
System.out.println("Uom Id is " + uom.get().getId());

return "index";
}


}
