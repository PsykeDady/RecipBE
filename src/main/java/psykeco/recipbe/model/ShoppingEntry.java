package psykeco.recipbe.model;


import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import psykeco.recipbe.jsonmapping.ShoppingEntryDeserialize;
import psykeco.recipbe.jsonmapping.ShoppingEntrySerialize;

@Entity
@JsonSerialize(using=ShoppingEntrySerialize.class)
@JsonDeserialize(using = ShoppingEntryDeserialize.class)
public class ShoppingEntry {

	public static final String DEFAULT_SHOPPING_LIST="DEFAULT";

	@EmbeddedId
	private ShoppingKey chiave=new ShoppingKey(); 
	private double qta; 
	private String unit;
	private boolean spunta;
	

	public ShoppingEntry() {
		nameOrDefault();
	}

	public ShoppingEntry(String shoppingList, String name, float qta, String unit,boolean spunta){
		setShoppingList(shoppingList);
		setName(name);
		this.qta=qta;
		this.unit=unit;
		this.spunta=spunta;
		nameOrDefault();
	}

	public void nameOrDefault() {
		setShoppingList(getShoppingList()==null||"".equals(getShoppingList())?DEFAULT_SHOPPING_LIST:getShoppingList());
	}

	
	
	public String getUnit() {
		return unit;
	}
	public double getQta() {
		return qta;
	}
	public ShoppingKey getChiave() {
		return chiave;
	}
	public void setSpunta(boolean spunta) {
		this.spunta = spunta;
	}
	public boolean isSpunta() {
		return spunta;
	}
	public void setChiave(ShoppingKey chiave) {
		this.chiave = chiave;
	}
	public void setQta(double qta) {
		this.qta = qta;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	
	public void setShoppingList(String shoppingList){
		this.chiave.setShoppingList(shoppingList);
	}
	public void setName(String name){
		this.chiave.setName(name);
		System.out.println("set"+this.chiave.getName());
	}

	public String getShoppingList () {
		return this.chiave.getShoppingList();
	}
	
	public String getName () {
		return this.chiave.getName();
	}
}
