package ming;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ming.bean.WpHyflbaGc;
import ming.dao.IWpHyflbaGcDAO;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class IndexController implements Controller{
	private JdbcTemplate template;
	private IWpHyflbaGcDAO dao;
	
	public IWpHyflbaGcDAO getDao() {
		return dao;
	}

	public void setDao(IWpHyflbaGcDAO dao) {
		this.dao = dao;
	}

	public JdbcTemplate getTemplate() {
		return template;
	}

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest req,
			HttpServletResponse resp) throws Exception {
//		String result = template.execute(new StatementCallback<String>(){
//			@Override
//			public String doInStatement(Statement st) throws SQLException,
//					DataAccessException {
//				ResultSet rs = st.executeQuery("select count(*) from wr_workitem");
//				rs.next();
//				return rs.getString(1);
//			}
//			
//		});
		List<WpHyflbaGc> list = dao.getAll();
		resp.getWriter().println(list.size());
		return null;
	}

}
