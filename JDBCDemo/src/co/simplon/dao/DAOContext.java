package co.simplon.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletContext;



public class DAOContext {

	static Connection connexion;
	static String db_url;
	static String db_username;
	static String  db_password;
	
	
	public static void init( ServletContext context ) {

		try {
		Class.forName( context.getInitParameter( "JDBC_DRIVER" ) );
		 db_url = context.getInitParameter( "JDBC_URL" );
		 db_username = context.getInitParameter( "JDBC_LOGIN" );
		 db_password = context.getInitParameter( "JDBC_PASSWORD" );
		} catch( Exception exception ) {
		exception.printStackTrace();
		}
		}
	
	public static Connection getConnection() throws SQLException {
		
           try {
			
			Class.forName("com.mysql.jdbc.Driver");
		}catch (ClassNotFoundException e){
		}
			
		try {
			
			connexion = DriverManager.getConnection(db_url, db_username,db_password);
			System.out.print("succes");
		}catch (SQLException e) {
			
			e.printStackTrace();
			System.out.print("fuck");
		}

return connexion;
	
	
	}
	
	
	public PaysDAO getPaysDao() {
		
		return new PaysDaoImpl(this);
		
		
	}
	
	
	
	
	
}
