package psykeco.recipbe.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import psykeco.recipbe.model.Ingrediente;
import psykeco.recipbe.resposes.GenericResponse;
import psykeco.recipbe.services.IngredientService;

@RestController
@RequestMapping("ingredients")
public class IngredientApi {

	@Autowired
	private IngredientService ingredientService;
	
	@PostMapping("add")
	public GenericResponse addIngredient(@RequestBody Ingrediente ingrediente) {
		return ingredientService.addIngredient(ingrediente);
	}

	@PostMapping("delete")
	public GenericResponse deleteIngredient(@RequestBody Ingrediente ingrediente) {
		return ingredientService.deleteIngredient(ingrediente);
	}

	@PostMapping("")
	public GenericResponse getIngredient(@RequestBody Ingrediente ingrediente) {
		return ingredientService.getIngredient(ingrediente);
	}

	@PostMapping("edit")
	public GenericResponse editIngredient(@RequestBody Ingrediente ingrediente) {
		return ingredientService.editIngredient(ingrediente);
	}

}
