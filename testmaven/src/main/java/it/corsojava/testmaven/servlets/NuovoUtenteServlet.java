package it.corsojava.testmaven.servlets;

import java.io.IOException;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.corsojava.testmaven.dto.NuovoUtenteDto;
import it.corsojava.testmaven.dao.UserDao;
import it.corsojava.testmaven.exception.DataException;
import it.corsojava.testmaven.utils.UserUtils;
import it.corsojava.testmaven.vo.UserVo;

@WebServlet(value= {"/pagina1","/pagina2","/pagina3","/pagina4"})
public class NuovoUtenteServlet extends BaseServlet {

	@Override
	protected String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String path = req.getServletPath();
		String outPath = "";
		NuovoUtenteDto uDto = null;
		HttpSession session = getCurrentSession(req, resp);

		if ("/pagina1".equals(path)) {
			outPath = "/WEB-INF/pages/pagina1.jsp";
		} else if ("/pagina2".equals(path)) {
			uDto = new NuovoUtenteDto();
			uDto.setNome(req.getParameter("nome"));
			uDto.setCognome(req.getParameter("cognome"));
			uDto.setCf(req.getParameter("cf"));
			session.setAttribute("nuovoUtente", uDto);

			outPath = "/WEB-INF/pages/pagina2.jsp";
		} else if ("/pagina3".equals(path)) {
			uDto = (NuovoUtenteDto) session.getAttribute("nuovoUtente");
			uDto.setUsername(req.getParameter("username"));
			uDto.setPsw(req.getParameter("psw"));
			uDto.setEmail(req.getParameter("email"));

			outPath = "/WEB-INF/pages/pagina3.jsp";
		} else if ("/pagina4".equals(path)) {
			uDto = (NuovoUtenteDto) session.getAttribute("nuovoUtente");
			uDto.setDomanda(req.getParameter("domanda"));
			uDto.setRisposta(req.getParameter("risposta"));
			UserVo vo = UserUtils.fromUserDtoToVo(uDto);
			UserDao uDao = new UserDao();
			try {
				uDao.saveUser(vo);
			} catch (DataException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
					outPath = "/WEB-INF/pages/pagina4.jsp";
		}
		return outPath;
	}
}
