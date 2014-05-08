package ming.controller;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ming.ProductController;
import ming.service.ITransactionDemoService;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class DemoController extends MultiActionController {
	Logger log = Logger.getLogger(DemoController.class);
	private ITransactionDemoService service;

	public ITransactionDemoService getService() {
		return service;
	}

	public void setService(ITransactionDemoService service) {
		this.service = service;
	}

	public ModelAndView getAllHandler(HttpServletRequest req,
			HttpServletResponse resp) throws Exception {
		resp.setContentType("text/html; charset=utf-8");
		resp.getWriter().println(service.getAll());
		return null;
	}

	public ModelAndView saveDemoHandler(HttpServletRequest req,
			HttpServletResponse resp) throws Exception {
		service.tSaveInfo(null);
		return null;
	}

	public ModelAndView commonQueryHandler(HttpServletRequest req,
			HttpServletResponse resp) throws Exception {
		String className = req.getParameter("className");
		Class beanClass = Class.forName(className);
		Object bean = null;
		Method[] methods = beanClass.getDeclaredMethods();
		String methodName, pv;
		bean = beanClass.newInstance();
		for (int i = 0; i < methods.length; i++) {
			methodName = methods[i].getName();
			if (methodName.startsWith("set")) {
				methodName = methodName.substring(3, 4).toLowerCase()
						+ methodName.substring(4);
				pv = req.getParameter(methodName);
				if (null != pv) {
					methods[i].invoke(bean, pv);
				}
			}
		}

		log.debug(bean.toString());
		return null;
	}
}
