package psykeco.recipbe.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import psykeco.recipbe.model.Composizione;


@Repository
public interface ComposizioneQuery extends JpaRepository<Composizione,String>{}
