package psykeco.recipbe.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class ShoppingKey implements Serializable {

	private String shoppingList;
	private String name;

	public ShoppingKey () {}


	public String getName() {
		return name;
	}
	public String getShoppingList() {
		return shoppingList;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setShoppingList(String shoppingList) {
		this.shoppingList = shoppingList;
	}
}
