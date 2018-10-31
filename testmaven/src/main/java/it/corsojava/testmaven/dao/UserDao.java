package it.corsojava.testmaven.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import it.corsojava.testmaven.vo.UserVo;
import it.corsojava.testmaven.vo.Utente;
import it.corsojava.testmaven.exception.DataException;

public class UserDao {

	public void saveUser(UserVo user) throws DataException, NamingException {
		Utente retUser = null;

		Connection connection = null;

		try {
			connection = ServiceManager.getInstance().openConnection();
			connection.setAutoCommit(false);
			String query = "insert into utente (username,password) values (?,?)";
			PreparedStatement pStatement = connection.prepareStatement(query);
			pStatement.setString(1, user.getUsername());
			pStatement.setString(2, user.getPsw());

			pStatement.executeUpdate();
			connection.commit();

		} catch (SQLException e) {
			if (connection != null) {
				try {
					connection.rollback();
				} catch (SQLException e2) {
					e2.printStackTrace();
					throw new DataException();
				}
			}
			throw new DataException();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e2) {
					e2.printStackTrace();
					throw new DataException();
				}
			}
		}
	}

	public List<UserVo> listAll() throws SQLException, DataException, NamingException {
		List<UserVo> userList = null;
		Connection connection = null;
		try {
			connection = ServiceManager.getInstance().openConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select * from utente");
			userList = new ArrayList<>();
			while (rs.next()) {
				UserVo uvo = new UserVo();
				uvo.setId(rs.getInt("idutente"));
				uvo.setUsername(rs.getString("username"));
				uvo.setPsw(rs.getString("password"));
				userList.add(uvo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DataException();
		} finally {
			if (connection != null)
				connection.close();
		}

		return userList;
	}

	public UserVo findUserById(int id) throws DataException, NamingException {
		Connection connection = null;
		UserVo retUser = null;
		try {
			connection = ServiceManager.getInstance().openConnection();
			String query = "select * from utente where idutente = ?";
			PreparedStatement pStatement = connection.prepareStatement(query);
			pStatement.setInt(1, id);
			ResultSet rs = pStatement.executeQuery();
			if (rs.next()) {
				retUser = new UserVo();

				retUser.setId(rs.getInt("idutente"));
				retUser.setUsername(rs.getString("username"));
				retUser.setPsw(rs.getString("password"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DataException();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
					throw new DataException();
				}
			}
		}

		return retUser;
	}
}
