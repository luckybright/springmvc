package ming;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ming.service.ITransactionDemoService;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class ProductController extends MultiActionController {
	Logger log = Logger.getLogger(ProductController.class);
	
	private PlatformTransactionManager txManager;
	private JdbcTemplate jdbcTemplate;
	private ITransactionDemoService service;
	
	public ITransactionDemoService getService() {
		return service;
	}

	public void setService(ITransactionDemoService service) {
		this.service = service;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public PlatformTransactionManager getTxManager() {
		return txManager;
	}

	public void setTxManager(PlatformTransactionManager txManager) {
		this.txManager = txManager;
	}

	public ModelAndView viewHandler(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		resp.getOutputStream().println("viewing product " + req.getParameter("productId"));
		return null;
	}
	
	public ModelAndView tableformHandler(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		String className = req.getParameter("className");
		Class beanClass = Class.forName(className);
		Object bean = null;
		Method[] methods = beanClass.getDeclaredMethods();
		String methodName,paramValues[];
		boolean hasMoreValue = true;
		List<Object> paramList = new ArrayList<Object>();
		for ( int outer = 0; outer < 50 && hasMoreValue; outer++){
			bean = beanClass.newInstance();
			for ( int i = 0; i < methods.length; i++){
				methodName = methods[i].getName();
				if ( methodName.startsWith("set")){
					methodName = methodName.substring(3,4).toLowerCase() + methodName.substring(4);
					paramValues = req.getParameterValues(methodName);
					if ( null != paramValues){
						if (paramValues.length > outer){
							methods[i].invoke(bean, paramValues[outer]);
						} else {
							hasMoreValue=false;
							break;
						}
					}
				}
			}
			if (hasMoreValue){
				paramList.add(bean);
			}
		}
		
		log.debug(paramList);
		return null;
	}
	
	public ModelAndView platformTransactionHandler(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		DefaultTransactionDefinition def = new DefaultTransactionDefinition();
		def.setIsolationLevel(TransactionDefinition.ISOLATION_READ_COMMITTED);
		def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
		TransactionStatus ts = txManager.getTransaction(def);
		resp.setContentType("text/html; charset=utf-8");
		try{
			try{
			jdbcTemplate.execute("insert into wp_qz.temptable values(1,'abc')");
			jdbcTemplate.execute("insert into wp_qz.temptable values(2,'345')");
			txManager.commit(ts);
			} catch (Exception e){
				txManager.rollback(ts);
			}
			jdbcTemplate.execute("delete from wp_qz.temptable where id = 1");
			jdbcTemplate.execute("insert into wp_qz.temptable values(1,'232323')");
			txManager.commit(ts);
			resp.getWriter().println("OK");
		} catch (Exception e){
			e.printStackTrace(resp.getWriter());
			txManager.rollback(ts);
			resp.getWriter().println("ERROR");
		}
		return null;
	}
	
	public ModelAndView transactionTemplateHandler(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		TransactionTemplate tt = new TransactionTemplate(txManager);
		tt.setIsolationLevel(TransactionDefinition.ISOLATION_READ_COMMITTED);
		tt.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
		tt.execute(new TransactionCallbackWithoutResult() {
			
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus status) {
				try{
					jdbcTemplate.execute("delete from wp_qz.temptable where id = 1");
					jdbcTemplate.execute("insert into wp_qz.temptable values(1,'232323')");
				} catch (Exception e){
					status.setRollbackOnly();
				}
			}
		});
		return null;
	}
	
	public ModelAndView saveDemoHandler(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		service.tSaveInfo(null);
		return null;
	}
}
