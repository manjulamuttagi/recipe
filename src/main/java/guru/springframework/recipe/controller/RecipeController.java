package guru.springframework.recipe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import guru.springframework.recipe.commands.RecipeCommand;
import guru.springframework.recipe.services.RecipeService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class RecipeController {
	private final RecipeService recipeService;
	
	public RecipeController(RecipeService recipeService) {
		this.recipeService = recipeService;
	}
	
	@GetMapping
	@RequestMapping("/recipe/{id}/show")
	public String findById(@PathVariable String id, Model model) {
		model.addAttribute("recipe",recipeService.findById(new Long(id)));
		return "recipe/show";
	}
	
	@GetMapping
	@RequestMapping("recipe/new")
    public String newRecipe(Model model){
        model.addAttribute("recipe", new RecipeCommand());
        return "recipe/recipeform";
    }
	
	@GetMapping
	@RequestMapping("/recipe/{id}/update")
	public String updateRecipe(@PathVariable String id, Model model) {
		model.addAttribute("recipe",recipeService.findCommandById(Long.valueOf(id)));
		return "recipe/recipeform";
	}
	
	@GetMapping
	@RequestMapping("/recipe/{id}/delete")
	public String deleteRecipeById(@PathVariable String id) {
		log.debug("Recipe deleted id is" + id);
		recipeService.deleteRecipeById(Long.valueOf(id));
		return "redirect:/";
	}

    @PostMapping("recipe")
    public String saveOrUpdate(@ModelAttribute RecipeCommand command){
        RecipeCommand savedCommand = recipeService.saveRecipeCommand(command);
        return "redirect:/recipe/" + savedCommand.getId()+ "/show";
    }
}
