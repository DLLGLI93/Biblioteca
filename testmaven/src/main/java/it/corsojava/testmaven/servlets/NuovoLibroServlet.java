package it.corsojava.testmaven.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.umana.pacchettoBiblioSQL.model.Libro;



@WebServlet(value={"/aggiungiLibro", "/caricaDati"})
public class NuovoLibroServlet extends BaseServlet {

	@Override
	protected String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String outPath = "";
		HttpSession session = getCurrentSession(req, resp);
		
		if("aggiungiLibro".equals(req.getPathInfo())) {
			outPath="WEB-INF/pages/datiNuovoLibro.jsp";
		}else if("caricaDati".equals(req.getPathInfo())) {
			Libro libro = new Libro();
			libro.setAnno(Long.parseLong(req.getParameter("anno")));
			libro.setTitolo(req.getParameter("titolo"));
			libro.setAutore(req.getParameter("autore"));
			session.setAttribute("libro", libro);
			outPath= "WEB-INF/pages/riassuntoDatiLibro";			
		}
			return outPath;
	}

}
