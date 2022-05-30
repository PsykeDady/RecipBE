package psykeco.recipbe.jsonmapping;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import psykeco.recipbe.model.ShoppingEntry;

public class ShoppingEntrySerialize extends StdSerializer<ShoppingEntry> {

	public ShoppingEntrySerialize(){
		this(null);
	}

	public ShoppingEntrySerialize(Class<ShoppingEntry> t) {
		super(t);
	}

	@Override
	public void serialize(ShoppingEntry value, JsonGenerator gen, SerializerProvider provider) throws IOException {
		gen.writeStartObject();

		gen.writeStringField("shoppingList", value.getShoppingList());

		gen.writeStringField("name", value.getName());

		gen.writeNumberField("qta", value.getQta());

		gen.writeStringField("unit", value.getUnit());
		gen.writeBooleanField("spunta", value.isSpunta());

		gen.writeEndObject();
		
	}
	
}
