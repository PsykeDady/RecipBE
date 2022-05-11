package psykeco.recipbe.services;

import static psykeco.recipbe.utils.Messages.ADDED_OK_INGREDIENT;
import static psykeco.recipbe.utils.Messages.DELETE_OK_INGREDIENT;
import static psykeco.recipbe.utils.Messages.EDIT_OK_INGREDIENT;
import static psykeco.recipbe.utils.Messages.GET_KO_INGREDIENT;
import static psykeco.recipbe.utils.Messages.GET_OK_INGREDIENT_ALL;
import static psykeco.recipbe.utils.Messages.GET_OK_INGREDIENT_ONE;
import static psykeco.recipbe.utils.ResultProperties.GET_OK_RESULTS;
import static psykeco.recipbe.utils.StatusCode.CODE_200_OK;
import static psykeco.recipbe.utils.StatusCode.CODE_404_NOT_FOUND;

import java.util.Collections;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import psykeco.recipbe.db.IngredientQuery;
import psykeco.recipbe.model.Ingrediente;
import psykeco.recipbe.resposes.GenericResponse;

@Service
public class IngredientService {
	
	@Autowired
	private IngredientQuery ingredientQuery; 

	public GenericResponse addIngredient(Ingrediente ingrediente){
		ingredientQuery.saveAndFlush(ingrediente);
		return new GenericResponse().code(CODE_200_OK).message(ADDED_OK_INGREDIENT);
	}

	public GenericResponse deleteIngredient(Ingrediente ingrediente){
		ingredientQuery.delete(ingrediente);
		return new GenericResponse().code(CODE_200_OK).message(DELETE_OK_INGREDIENT);
	}

	public GenericResponse getIngredient (Ingrediente ingrediente){
		String name = Optional.ofNullable(ingrediente.getName()).orElse("");

		if(name.equals("")){
			return new GenericResponse().code(CODE_200_OK).message(GET_OK_INGREDIENT_ALL).property(GET_OK_RESULTS,ingredientQuery.findAll());
		}

		Ingrediente i = ingredientQuery.findById(ingrediente.getName()).orElse(null);

		return i==null? 
			new GenericResponse().code(CODE_404_NOT_FOUND).message(GET_KO_INGREDIENT).property(GET_OK_RESULTS,Collections.emptyList()) : 
			new GenericResponse().code(CODE_200_OK).message(GET_OK_INGREDIENT_ONE).property(GET_OK_RESULTS,Collections.singletonList(i));
	}
	public GenericResponse editIngredient (Ingrediente ingrediente){
		if(!ingredientQuery.existsById(ingrediente.getName())){
			return new GenericResponse().code(CODE_404_NOT_FOUND).message(EDIT_OK_INGREDIENT);
		}

		ingredientQuery.save(ingrediente);
		return new GenericResponse().code(CODE_200_OK).message(EDIT_OK_INGREDIENT);
	}
}
