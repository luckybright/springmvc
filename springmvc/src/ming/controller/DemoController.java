package ming.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ming.service.ITransactionDemoService;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class DemoController extends MultiActionController{
	private ITransactionDemoService service;
	
	public ITransactionDemoService getService() {
		return service;
	}
	public void setService(ITransactionDemoService service) {
		this.service = service;
	}

	public ModelAndView getAllHandler(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		resp.setContentType("text/html; charset=utf-8");
		resp.getWriter().println(service.getAll());
		return null;
	}
	
	public ModelAndView saveDemoHandler(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		service.tSaveInfo(null);
		return null;
	}
}
