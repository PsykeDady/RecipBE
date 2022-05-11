package psykeco.recipbe.services;

import static psykeco.recipbe.utils.Messages.ADDED_OK_RECIPE;
import static psykeco.recipbe.utils.Messages.DELETE_OK_RECIPE;
import static psykeco.recipbe.utils.Messages.EDIT_KO_RECIPE;
import static psykeco.recipbe.utils.Messages.EDIT_OK_RECIPE;
import static psykeco.recipbe.utils.Messages.GET_KO_RECIPES;
import static psykeco.recipbe.utils.Messages.GET_OK_RECIPES_ALL;
import static psykeco.recipbe.utils.Messages.GET_OK_RECIPES_ONE;
import static psykeco.recipbe.utils.ResultProperties.GET_OK_RESULTS;
import static psykeco.recipbe.utils.StatusCode.CODE_200_OK;
import static psykeco.recipbe.utils.StatusCode.CODE_404_NOT_FOUND;

import java.util.Collections;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import psykeco.recipbe.db.RecipeQuery;
import psykeco.recipbe.model.Ricetta;
import psykeco.recipbe.resposes.GenericResponse;


@Service
public class RecipeService {

	@Autowired
	private RecipeQuery recipeQuery;

	public GenericResponse addRecipe(Ricetta r){
		recipeQuery.saveAndFlush(r);
		return new GenericResponse().code(CODE_200_OK).message(ADDED_OK_RECIPE).property("existsTable",recipeQuery.existsRecipeTable().stream().reduce((p,n)->p+";"+n).get());
	}

	public GenericResponse getRecipes(Ricetta ricetta){
		String recipeName = Optional.ofNullable(ricetta.getName()).orElse("");
		if(recipeName.equals("")){
			return new GenericResponse().code(CODE_200_OK).message(GET_OK_RECIPES_ALL).property(GET_OK_RESULTS,recipeQuery.findAll());
		}
		Ricetta r= recipeQuery.findById(recipeName).orElse(null);
		return r==null? 
			new GenericResponse().code(CODE_404_NOT_FOUND).message(GET_KO_RECIPES).property(GET_OK_RESULTS, Collections.emptyList()) : 
			new GenericResponse().code(CODE_200_OK).message(GET_OK_RECIPES_ONE).property(GET_OK_RESULTS,Collections.singletonList(r));
	}

	public GenericResponse deleteRecipe(Ricetta r){
		recipeQuery.delete(r);
		return new GenericResponse().code(CODE_200_OK).message(DELETE_OK_RECIPE);
	}

	public GenericResponse editRecipe(Ricetta r) {
		if(!recipeQuery.existsById(r.getName()) ) {
			return new GenericResponse().code(CODE_404_NOT_FOUND).message(EDIT_KO_RECIPE);
		}
		recipeQuery.saveAndFlush(r);
		return new GenericResponse().code(CODE_200_OK).message(EDIT_OK_RECIPE);
	}

	
}
