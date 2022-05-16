package psykeco.recipbe.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import psykeco.recipbe.model.Ricetta;

@Repository
public interface RecipeQuery extends JpaRepository<Ricetta,String>{}
