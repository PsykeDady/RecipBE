package psykeco.recipbe.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import psykeco.recipbe.model.ShoppingEntry;

@Repository
public interface ShoppingEntryQuery extends JpaRepository<ShoppingEntry,String>{}
