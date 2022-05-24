package psykeco.recipbe.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import psykeco.recipbe.model.Ricetta;
import psykeco.recipbe.resposes.GenericResponse;
import psykeco.recipbe.services.RecipeService;

@RestController
@RequestMapping("recipes")
@CrossOrigin(originPatterns = "*")
public class RecipeApi {

	@Autowired
	RecipeService recipeService;

	@PostMapping("add")
	public GenericResponse addRecipe(@RequestBody Ricetta r){
		
		return recipeService.addRecipe(r);
	}

	@PostMapping("")
	public GenericResponse getRecipes(@RequestBody Ricetta r) {
		return recipeService.getRecipes(r);
	}

	@PostMapping("delete")
	public GenericResponse deleteRecipe (@RequestBody Ricetta r){
		
		return recipeService.deleteRecipe(r);
	}

	@PostMapping("edit")
	public GenericResponse editRecipe (@RequestBody Ricetta r){
		return recipeService.editRecipe(r);
	}
}
