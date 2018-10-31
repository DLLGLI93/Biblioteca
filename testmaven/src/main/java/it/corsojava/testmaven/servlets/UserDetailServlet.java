package it.corsojava.testmaven.servlets;

import java.io.IOException;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.corsojava.testmaven.dao.UserDao;
import it.corsojava.testmaven.exception.DataException;
import it.corsojava.testmaven.vo.UserVo;

@WebServlet(value= {"/searchUser" })
public class UserDetailServlet extends BaseServlet {

	@Override
	protected String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String outPath ="/WEB-INF/pages/userDetail.jsp";
		String userId = req.getParameter("userId");
		UserDao ud = new UserDao();
		UserVo vo =null;
		try {
			vo = ud.findUserById(Integer.parseInt( userId));
		} catch (NumberFormatException | DataException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		req.setAttribute("user", vo);
		return outPath;
	}

}
