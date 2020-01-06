package guru.springframework.recipe.services;

import org.junit.Before;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import guru.springframework.recipe.converters.RecipeCommandToRecipe;
import guru.springframework.recipe.converters.RecipeToRecipeCommand;
import guru.springframework.recipe.repository.RecipeRepository;

public class RecipeServiceImpleTest {
	RecipeServiceImpl recipeService;
	   
    @Mock
    RecipeRepository recipeRepository;
    
    @Mock
    RecipeToRecipeCommand recipeToRecipeCommand;

    @Mock
    RecipeCommandToRecipe recipeCommandToRecipe;
   
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        recipeService = new RecipeServiceImpl(recipeRepository, recipeCommandToRecipe, recipeToRecipeCommand);
       
    }   
}
