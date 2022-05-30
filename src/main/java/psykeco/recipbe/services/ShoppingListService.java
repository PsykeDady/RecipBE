package psykeco.recipbe.services;

import static psykeco.recipbe.utils.Messages.*;
import static psykeco.recipbe.utils.ResultProperties.GET_OK_RESULTS;
import static psykeco.recipbe.utils.StatusCode.CODE_200_OK;
import static psykeco.recipbe.utils.StatusCode.CODE_404_NOT_FOUND;
import static psykeco.recipbe.utils.StatusCode.CODE_412_NOT_VALID;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import psykeco.recipbe.db.ShoppingEntryQuery;
import psykeco.recipbe.model.ShoppingEntry;
import psykeco.recipbe.resposes.GenericResponse;
import psykeco.recipbe.validators.ShoppingEntryValidator;

@Service
public class ShoppingListService {
	
	@Autowired
	private ShoppingEntryQuery shoppingEntryQuery; 

	public GenericResponse addIngredient(ShoppingEntry shoppingEntry){
		ShoppingEntryValidator validate=new ShoppingEntryValidator(shoppingEntry).requiredName().qtaPositive();

		if(!validate.isValid()){
			return new GenericResponse().code(CODE_412_NOT_VALID).message(ADDED_KO_INGREDIENT+validate.message());
		}

		shoppingEntryQuery.saveAndFlush(shoppingEntry);
		return new GenericResponse().code(CODE_200_OK).message(ADDED_OK_INGREDIENT);
	}

	public GenericResponse deleteIngredient(ShoppingEntry shoppingEntry){
		ShoppingEntryValidator validate=new ShoppingEntryValidator(shoppingEntry).requiredName();

		if(! validate.isValid()){
			return new GenericResponse().code(CODE_412_NOT_VALID).message(DELETE_KO_INGREDIENT+validate.message());
		}

		shoppingEntryQuery.delete(shoppingEntry);
		return new GenericResponse().code(CODE_200_OK).message(DELETE_OK_INGREDIENT);
	}

	public GenericResponse getIngredient (ShoppingEntry shoppingEntry){

		String name=Optional.ofNullable(shoppingEntry.getName()).orElse("");


		if(name.equals("")){
			return new GenericResponse().code(CODE_200_OK).message(GET_OK_INGREDIENT_ALL).property(GET_OK_RESULTS,shoppingEntryQuery.findAll());
		}

		shoppingEntry=shoppingEntryQuery.findById(name).orElse(null);

		return shoppingEntry==null? 
			new GenericResponse().code(CODE_404_NOT_FOUND).message(GET_KO_INGREDIENT_NO_ENTRIES).property(GET_OK_RESULTS,Collections.emptyList()) : 
			new GenericResponse().code(CODE_200_OK).message(GET_OK_INGREDIENT_ONE).property(GET_OK_RESULTS,Collections.singleton(shoppingEntry));
	}

	public GenericResponse editIngredient (ShoppingEntry shoppingEntry){
		ShoppingEntryValidator validate=new ShoppingEntryValidator(shoppingEntry).requiredName().qtaPositive();
		if(!validate.isValid()){
			return new GenericResponse().code(CODE_412_NOT_VALID).message(EDIT_KO_INGREDIENT_INVALID+validate.message());
		}

		if(! shoppingEntryQuery.existsById(shoppingEntry.getName())) {
			return new GenericResponse().code(CODE_404_NOT_FOUND).message(EDIT_KO_INGREDIENT_NO_ENTRIES+validate.message());
		}

		shoppingEntryQuery.save(shoppingEntry);
		return new GenericResponse().code(CODE_200_OK).message(EDIT_OK_INGREDIENT);
	}
}
