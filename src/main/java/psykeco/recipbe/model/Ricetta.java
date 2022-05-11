package psykeco.recipbe.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Ricetta {
	@Id
	private String name; 
	
	@OneToMany(mappedBy = "name")
	private List<Ingrediente> ingredients; 
	private String descrizione; 
	private String imgPath;
}
