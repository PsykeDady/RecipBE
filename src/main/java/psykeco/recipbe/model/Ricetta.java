package psykeco.recipbe.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
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
	
	@OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
	@JoinColumn()
	private List<Composizione> ingredients; 
	private String descrizione; 
	private String imgPath;
}
