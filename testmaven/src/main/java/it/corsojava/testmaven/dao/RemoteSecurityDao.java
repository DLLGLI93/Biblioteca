package it.corsojava.testmaven.dao;

import it.corsojava.testmaven.vo.Utente;

public class RemoteSecurityDao implements GenericSecurityDao{

	@Override
	public Utente findUserByUsernameAndPsw(String username, String psw) {
		Utente retUser = null;
//		String outURL= ServiceManager.getInstance().getRemoteServiceUrl();
		
		return retUser;
	}
}
