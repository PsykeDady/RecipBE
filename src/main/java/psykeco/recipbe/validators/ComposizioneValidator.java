package psykeco.recipbe.validators;

import psykeco.recipbe.model.Composizione;

public class ComposizioneValidator  {
	private Composizione composizione; 

	private boolean valid=true;

	public ComposizioneValidator(Composizione composizione) {
		this.composizione=composizione;
	}

	public ComposizioneValidator requireName(){
		valid=valid&&this.composizione.getName() != null && !"".equals(composizione.getName());
		return this; 
	}

	public ComposizioneValidator qtaPositive(){
		valid=valid&&this.composizione.getQta()>0;
		return this; 
	}

	public boolean isValid(){
		return valid;
	}
}
