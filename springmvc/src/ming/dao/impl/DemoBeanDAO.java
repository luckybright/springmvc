package ming.dao.impl;

import java.util.List;

import ming.bean.DemoBean;
import ming.dao.IDemoBeanDAO;

import org.apache.ibatis.session.SqlSessionFactory;

public class DemoBeanDAO implements IDemoBeanDAO {

	public SqlSessionFactory sqlSessionFactory;

	public SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}

	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}
	
	/* (non-Javadoc)
	 * @see ming.dao.impl.IDemoBeanDAO#getAll()
	 */
	@Override
	public List<DemoBean> getAll() throws Exception{
		return sqlSessionFactory.openSession().selectList("demoBean.getAll");
	}
	
	/* (non-Javadoc)
	 * @see ming.dao.impl.IDemoBeanDAO#save(ming.bean.DemoBean)
	 */
	@Override
	public void save(DemoBean bean) throws Exception{
		sqlSessionFactory.openSession().insert("demoBean.insertDemo", bean);
	}
}
