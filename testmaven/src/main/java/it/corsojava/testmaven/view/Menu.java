package it.corsojava.testmaven.view;

import java.util.Scanner;

import it.corsojava.testmaven.controller.LoginController;
import it.corsojava.testmaven.vo.Utente;

public class Menu {
	private static Utente loggedOne = null;

	public boolean printLoginMenu() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Inserisci nome utente");
		String username = scan.nextLine();
		System.out.println("Inserisci psw");
		String psw = scan.nextLine();
		System.out.println("Inserisci type");
		String type = scan.nextLine();

		LoginController lController = new LoginController();

		try {
			loggedOne = lController.login(username, psw, Integer.parseInt(type));

		} catch (Exception e) {
			return false;
		}

		return true;
	}

	public static void main(String[] args) {
		Menu menuManager = new Menu();
		boolean auth = menuManager.printLoginMenu();

		if (auth) {
			// ...utente autenticato quindi visualizzazione dei menu profilati event per
			// tipologia
		} else {
			// errore			
		}
	}
}
