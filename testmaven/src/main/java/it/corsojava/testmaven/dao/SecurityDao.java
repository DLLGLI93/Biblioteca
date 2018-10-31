package it.corsojava.testmaven.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import it.corsojava.testmaven.vo.Utente;

public class SecurityDao implements GenericSecurityDao {

	@Override
	public Utente findUserByUsernameAndPsw(String username, String psw) {
		Utente retUtente =null;
		Connection connection =null;
		try {
			connection = ServiceManager.getInstance().openConnection();
			PreparedStatement pStatement= connection.prepareStatement("Select * from utente where username = ? and psw = ?");
		pStatement.setString(1, username);	
		pStatement.setString(2, psw);	
		ResultSet rs = pStatement.executeQuery();
		if(rs.next()) {
			retUtente= new Utente();
			retUtente.setUsername(rs.getString("username"));
			retUtente.setPsw(rs.getString("psw"));
			retUtente.setId(rs.getInt("idutente"));
		}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			
		}
		
		return retUtente; 
	}
}
