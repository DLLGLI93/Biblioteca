package it.corsojava.testmaven.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import it.corsojava.testmaven.utils.ConfigBean;

public class ServiceManager {
	private static ServiceManager _instance;
	private ConfigBean configBean;
	private DataSource datasource;

	private ServiceManager() {
	}

	public synchronized static ServiceManager getInstance() {
		if (_instance == null) {
			_instance = new ServiceManager();
		}
		return _instance;

	}

	public void initDatabase(ConfigBean cb) throws ClassNotFoundException {
		this.configBean = cb;
		if ("SM".equals(this.configBean.getConnectionType())) {
			Class.forName(this.configBean.getDriver());
		}
	}

	public Connection openConnection() throws SQLException, NamingException {
		Connection connection = null;
		if ("DS".equals(this.configBean.getConnectionType())) {
			datasource = getDatasource();
			connection = datasource.getConnection();
		} else if ("SM".equals(this.configBean.getConnectionType())) {
			return DriverManager.getConnection(this.configBean.getUrl(), this.configBean.getUsername(),
					this.configBean.getPassword());

		}
		return connection;
	}

	private DataSource getDatasource() throws NamingException {
		if (this.datasource == null) {
			Context context = new InitialContext();
			Context envContext = (Context) context.lookup(this.configBean.getEnv());
			this.datasource = (javax.sql.DataSource) envContext.lookup(this.configBean.getJndiName());
		}
		return this.datasource;
	}

}
