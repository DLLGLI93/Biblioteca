package it.corsojava.testmaven.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.corsojava.testmaven.dao.UserDao;
import it.corsojava.testmaven.vo.UserVo;

@WebServlet("/userList")
public class UserListServlet extends BaseServlet {

	@Override
	protected String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String outPath = "/WEB-INF/pages/userList.jsp";
		UserDao uDao = new UserDao();
		try {
			List<UserVo> userList=uDao.listAll();
			req.setAttribute("userList", userList);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return outPath;
	}

}
