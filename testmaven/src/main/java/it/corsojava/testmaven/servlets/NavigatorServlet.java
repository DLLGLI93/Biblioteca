package it.corsojava.testmaven.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value= {"/goToLogin", "/goToUserList"})
public class NavigatorServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		// mi dice da dove vengo per capire dove devo andare
		String path = req.getServletPath();
		String outPath ="";
		if (path.equals("/goToLogin")) {
			outPath = "/WEB-INF/pages/Login.jsp";
		} else 	if (path.equals("/goToUserList")) {
				outPath = "/WEB-INF/pages/userList.jsp";
			}
		getServletContext().getRequestDispatcher(outPath).forward(req, res);
	}

}
