package it.corsojava.testmaven.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//http servlet espone funzionalità all'esterno
@WebServlet("/sayHello")
public class HelloServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String name = (String) req.getAttribute("nomeInserito");
		PrintWriter out = resp.getWriter();
	String output = "<html> <body> Ciao "+ name + "</body> </html>";
	out.write(output);
	
	
//	per andare da un servlet a un altro
//	req.setAttribute("username", name);
	
	
//	ServletContext sc = getServletContext();
//	RequestDispatcher rd = sc.getRequestDispatcher("/authenticate");
//	rd.forward(req, resp);
	
	// riassumo le ultime 3 in una riga:
	
	// getServletContext().getRequestDispatcher("il Path che mi interessa").forward(req, resp);
	}

//	
}
