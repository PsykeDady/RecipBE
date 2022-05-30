package psykeco.recipbe.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import psykeco.recipbe.model.ShoppingEntry;
import psykeco.recipbe.resposes.GenericResponse;
import psykeco.recipbe.services.ShoppingListService;

@RestController
@RequestMapping("ingredients")
@CrossOrigin(originPatterns = "*")
public class IngredientApi {

	@Autowired
	private ShoppingListService shoppingEntryService;
	
	@PostMapping("add")
	public GenericResponse addIngredient(@RequestBody ShoppingEntry shoppingEntry) {

		return shoppingEntryService.addIngredient(shoppingEntry);
	}

	@PostMapping("delete")
	public GenericResponse deleteIngredient(@RequestBody ShoppingEntry shoppingEntry) {
		return shoppingEntryService.deleteIngredient(shoppingEntry);
	}

	@PostMapping("")
	public GenericResponse getIngredient(@RequestBody ShoppingEntry shoppingEntry) {
		return shoppingEntryService.getIngredient(shoppingEntry);
	}

	@PostMapping("edit")
	public GenericResponse editIngredient(@RequestBody ShoppingEntry shoppingEntry) {
		return shoppingEntryService.editIngredient(shoppingEntry);
	}

}
