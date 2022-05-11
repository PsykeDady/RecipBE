package psykeco.recipbe.db;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import psykeco.recipbe.model.Ricetta;

public interface RecipeQuery extends JpaRepository<Ricetta,String>{}
