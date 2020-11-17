package co.simplon.dao;

import java.util.List;

import co.simplon.model.Pays;

public interface PaysDAO {

	List<Pays> lister();
	void ajouter ( Pays pays );
	void modifier(Pays pays);
	void effacer(Pays pays);
	
	
	
}
