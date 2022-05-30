package psykeco.recipbe.jsonmapping;

import java.io.IOException;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import psykeco.recipbe.model.ShoppingEntry;

public class ShoppingEntryDeserialize extends StdDeserializer<ShoppingEntry> {

	public ShoppingEntryDeserialize(){
		this(null);
	}
	public ShoppingEntryDeserialize(Class<?> vc) {
		super(vc);
	}

	@Override
	public ShoppingEntry deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {
		JsonNode node = p.getCodec().readTree(p);
		ShoppingEntry s= new ShoppingEntry();

		JsonNode nameNode=node.get("name");
		JsonNode shoppingListNode=node.get("shoppingList");
		JsonNode qtaNode=node.get("qta");
		JsonNode unitNode=node.get("unit");
		JsonNode spuntaNode=node.get("spunta");

		String name=nameNode==null? "": nameNode.asText();
		String shoppingList=shoppingListNode==null?"" : shoppingListNode.asText();
		double qta=qtaNode==null? 0.0d: qtaNode.asDouble();
		String unit=unitNode==null? "" : unitNode.asText();
		boolean spunta=spuntaNode==null? false: spuntaNode.asBoolean(false);


		s.setName(name);
		s.setShoppingList(shoppingList);
		s.setQta(qta);
		s.setUnit(unit);
		s.setSpunta(spunta);
		return s;
	}
	
}
