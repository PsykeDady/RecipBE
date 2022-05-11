package psykeco.recipbe.resposes;

import java.util.HashMap;
import java.util.Map;


public class GenericResponse {
	private String message;
	private int code; 
	private Map<String,Object> content=new HashMap<>();


	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getCode() {
		return this.code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public Map<String,Object> getContent() {
		return this.content;
	}

	public void setContent(Map<String,Object> content) {
		this.content = content;
	}

	public void addProperty(String key, Object value){
		content.put(key, value);
	}

	public GenericResponse message(String message){
		setMessage(message);
		return this;
	}

	public GenericResponse code(int code){
		setCode(code);
		return this;
	}

	public GenericResponse content(Map<String, Object> content){
		setContent(content);
		return this;
	}

	public GenericResponse property(String key, Object value) {
		addProperty(key, value);
		return this;
	}

}
