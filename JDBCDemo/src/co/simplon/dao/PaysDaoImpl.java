package co.simplon.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



import co.simplon.model.Pays;

public  class PaysDaoImpl implements PaysDAO{

	Connection connexion = null;
	PreparedStatement preparedStatement = null;
	
	private DAOContext daoContext;
	
	public PaysDaoImpl(DAOContext daoContext) {
		
		this.daoContext = daoContext;
		
		
	}
	
	
	@Override
	public void ajouter(Pays pays) {
		

		
		try {
			
			
			connexion = DAOContext.getConnection();
			preparedStatement = connexion.prepareStatement("INSERT INTO pays(nom) VALUES(?);");
			preparedStatement.setString(1, pays.getNom());
			
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		
	}
	
	
	@Override
	public List<Pays> lister() {
		
		List<Pays> Lpays = new ArrayList<Pays>();
		
		Statement statement = null;
		ResultSet resultat = null;
		
	
try {
			
	        connexion = DAOContext.getConnection();
			statement = connexion.createStatement();
			// REQUETE SQL
			resultat = statement.executeQuery("SELECT id,nom FROM testjdbc.pays;");
			
			// RECUPERE LES DONNEES
			
			while(resultat.next()) {
				
				int id = resultat.getInt("id");
				String nom = resultat.getString("nom");
				
		      	Pays pays = new Pays();
				//Pays pays = new Pays(nom,id);
				
				pays.setId(id);
				pays.setNom(nom);
				
				Lpays.add(pays);
		
			}
				
			}catch (SQLException e) {
				e.printStackTrace();
			}

return Lpays;

	}
	
	
	@Override
	public void modifier(Pays pays) {
		

		
		try {
			
			
			connexion = DAOContext.getConnection();
			preparedStatement = connexion.prepareStatement("UPDATE pays SET nom = ? WHERE id = ?;");
			preparedStatement.setString(1, pays.getNom());
			preparedStatement.setInt(2, pays.getId());
			
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		
	}
	
	
	
	@Override
	public void effacer(Pays pays) {
		

		
		try {
			
			
			connexion = DAOContext.getConnection();
			preparedStatement = connexion.prepareStatement("DELETE FROM pays WHERE id= ?;");
			preparedStatement.setInt(1, pays.getId());
			
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		
	}
	
	
}
