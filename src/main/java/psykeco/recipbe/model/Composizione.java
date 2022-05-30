package psykeco.recipbe.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
@Entity
public class Composizione{
	@Id
	private String name;
	private double qta; 
	private String unit;
}
