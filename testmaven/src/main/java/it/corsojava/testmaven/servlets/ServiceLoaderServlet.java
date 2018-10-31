package it.corsojava.testmaven.servlets;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import it.corsojava.testmaven.dao.ServiceManager;
import it.corsojava.testmaven.utils.ConfigBean;

public class ServiceLoaderServlet extends HttpServlet {
// Servlet di inizializzazione
	// richiamato tutte le volte che un SERVLET VIENE CHIAMATAIN MEMORIA
	@Override
	public void init(ServletConfig config) throws ServletException {
		// recupero dei parametri di configurazione da file esterni
		super.init(config);
		ConfigBean CB = new ConfigBean();
//		Recupero dei param per Driver manager
		CB.setDriver(getInitParameter("DATABASE_DRIVER"));
		CB.setUrl(getInitParameter("DATABASE_URL"));
		CB.setUsername(getInitParameter("DATABASE_USERNAME"));
		CB.setPassword(("DATABASE_PASSWORD"));
//		Recupero dei param per configuarazione datasource
		CB.setConnectionType(getInitParameter("DATASOURCE-DRIVERMANAGER"));
		CB.setJndiName(getInitParameter("JNDA_NAME"));
		CB.setEnv(getInitParameter("ENV"));
		
		try {
			ServiceManager.getInstance().initDatabase(CB);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
