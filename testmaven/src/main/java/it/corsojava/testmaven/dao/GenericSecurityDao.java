package it.corsojava.testmaven.dao;

import it.corsojava.testmaven.vo.Utente;

public interface GenericSecurityDao {

	Utente findUserByUsernameAndPsw(String username, String psw);

}