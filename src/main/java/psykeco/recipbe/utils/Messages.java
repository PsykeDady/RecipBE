package psykeco.recipbe.utils;

public final class Messages {
	private Messages(){}

	public static final String ADDED_OK_RECIPE	  = "Added";
	public static final String ADDED_OK_INGREDIENT = "Added";
	public static final String ADDED_KO_INGREDIENT = "Invalid Shopping list:";

	public static final String GET_OK_RECIPES_ALL = "entries founds";
	public static final String GET_OK_RECIPES_ONE = "entry found";
	public static final String GET_KO_RECIPES  = "no entries founds";

	public static final String GET_OK_INGREDIENT_ALL = "entries founds";
	public static final String GET_OK_INGREDIENT_ONE = "entry found";
	public static final String GET_KO_INGREDIENT_NO_ENTRIES  = "no entries founds";
	public static final String GET_KO_INGREDIENT_INVALID  = "no entries founds";

	public static final String DELETE_OK_RECIPE = "deleted"; 
	public static final String DELETE_OK_INGREDIENT = "deleted";
	public static final String DELETE_KO_INGREDIENT  = "Invalid ingredient data:";
	
	public static final String EDIT_OK_RECIPE = "edited";
	public static final String EDIT_KO_RECIPE  = "no entries founds";
	public static final String EDIT_OK_INGREDIENT = "edited";
	public static final String EDIT_KO_INGREDIENT_NO_ENTRIES  = "no entries founds";
	public static final String EDIT_KO_INGREDIENT_INVALID  = "Invalid ingredient data:";


	// Validators Message
	public static final char INVALID_DATA_SEPARATOR=';';
	public static final String REQUIRED_NAME="required name";
	public static final String NEGATIVE_QTA="negative qta";
	public static final String INVALID_INGREDIENT_DATA="invalid ingredient data:";
}
