package it.corsojava.testmaven.controller;

import it.corsojava.testmaven.services.SecurityService;
import it.corsojava.testmaven.vo.Utente;

public class LoginController {

	public Utente login(String username, String psw, int type) {
		Utente retUser=null;
		try {
			SecurityService secService = new SecurityService();
			retUser= secService.authenticate(username, psw, type);
		} catch (Exception e) {
			System.out.println("Credenziali non valide o utente non trovato");
		}
		return retUser;
	}
}
