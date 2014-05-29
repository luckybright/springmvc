package ming;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class LoginController implements Controller{
	Logger log = Logger.getLogger(LoginController.class);
	@Override
	public ModelAndView handleRequest(HttpServletRequest req,
			HttpServletResponse resp) throws Exception {
		HttpSession session = req.getSession(false);
		log.info("username:" + req.getParameter("username"));
		log.info("password:" + req.getParameter("pass"));
		if (session == null){
			session = req.getSession();
			session.setAttribute("username", req.getParameter("username"));
		} else {
			log.info(session.getAttribute("username"));
		}
		log.info("test login");
		req.setAttribute("aJspValue", "Redirect from spring to jsp");
		return new ModelAndView("/jsp/homepage.jsp");
	}
}
