package psykeco.recipbe.validators;

import psykeco.recipbe.model.ShoppingEntry;
import static psykeco.recipbe.utils.Messages.REQUIRED_NAME;
import static psykeco.recipbe.utils.Messages.NEGATIVE_QTA;

public class ShoppingEntryValidator {
	private ShoppingEntry shoppingEntry;
	private boolean valid=true;
	private StringBuilder message=new StringBuilder("");

	public ShoppingEntryValidator(ShoppingEntry shoppingEntry) {
		this.shoppingEntry=shoppingEntry;
	}

	public ShoppingEntryValidator requiredName(){
		boolean precondition=this.shoppingEntry.getName() != null&&!"".equals(shoppingEntry.getName());
		valid=valid&&precondition;
		message.append(precondition?"":REQUIRED_NAME);
		return this; 
	}

	public ShoppingEntryValidator requiredListName(){
		boolean precondition=this.shoppingEntry.getShoppingList() != null&&!"".equals(shoppingEntry.getShoppingList());
		valid=valid&&precondition;
		message.append(precondition?"":REQUIRED_NAME);
		return this; 
	}

	public ShoppingEntryValidator qtaPositive(){
		boolean precondition=this.shoppingEntry.getQta()>0;
		valid=valid&&precondition;
		message.append(precondition?"":NEGATIVE_QTA);
		return this; 
	}

	public boolean isValid(){
		return valid;
	}

	public String message(){
		return message.toString();
	}
}
