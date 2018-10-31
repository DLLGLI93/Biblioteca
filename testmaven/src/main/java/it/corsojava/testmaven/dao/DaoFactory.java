package it.corsojava.testmaven.dao;

public class DaoFactory {

	public GenericSecurityDao getSecurityDao(int type) {
		GenericSecurityDao retDao = null;
		switch (type) {
		case 0:
			retDao = new SecurityDao();
			break;
		case 1:
			retDao = new RemoteSecurityDao();
			break;

		default:
			break;
		}
		return retDao;
	}
}
