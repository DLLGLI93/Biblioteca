package it.corsojava.testmaven.services;

import it.corsojava.testmaven.dao.DaoFactory;
import it.corsojava.testmaven.dao.GenericSecurityDao;
import it.corsojava.testmaven.vo.Utente;

public class SecurityService {
	
	public Utente authenticate(String username, String psw, int userType) {
		Utente retUtente=null;
		GenericSecurityDao secDao = new DaoFactory().getSecurityDao(userType);
		retUtente = secDao.findUserByUsernameAndPsw(username, psw);
		if(retUtente==null) {
			// lancio eccezione
		}
		return retUtente;
	}

}
