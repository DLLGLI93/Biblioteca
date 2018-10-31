package it.corsojava.testmaven.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.corsojava.testmaven.dto.UserDto;

//http servlet espone funzionalità all'esterno
@WebServlet(value= {"/login","/logout"})
public class LoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
// 	devo eliminare la sessione (se c'è ancora)
		// chiamo la session... se è scaduta, non darmene una nuova!
		HttpSession session = req.getSession(false);
		if(session!=null) {
			session.removeAttribute("userInSession");
			session.invalidate();
		}
		getServletContext().getRequestDispatcher("/WEB-INF/Pages/Login.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("nomeInserito"); // variabile come parametro nel mio metodo
		String psw = req.getParameter("psw");

		String outPath = "";
		
		if (username.equals("admin") && psw.equals("admin")) {
			// loginOK
			UserDto loggedUser = new UserDto();
			loggedUser.setUsername(username);
			HttpSession session = req.getSession();
			session.setAttribute("userInSession", loggedUser);

			outPath = "/WEB-INF/pages/welcome.jsp";
		}else {
			outPath = "/WEB-INF/pages/Login.jsp";
		}
		getServletContext().getRequestDispatcher(outPath).forward(req, resp);
	}

//	
}
