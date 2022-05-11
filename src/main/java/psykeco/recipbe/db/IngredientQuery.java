package psykeco.recipbe.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import psykeco.recipbe.model.Ingrediente;

@Repository
public interface IngredientQuery extends JpaRepository<Ingrediente,String>{}
