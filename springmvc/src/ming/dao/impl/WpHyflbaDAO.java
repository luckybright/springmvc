package ming.dao.impl;

import java.sql.SQLException;
import java.util.List;

import ming.bean.WpHyflbaGc;
import ming.dao.IWpHyflbaGcDAO;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;

public class WpHyflbaDAO implements IWpHyflbaGcDAO {
	public SqlSessionFactory sqlSessionFactory;

	public SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}

	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	@Override
	public List<WpHyflbaGc> getAll() {
		return sqlSessionFactory.openSession().selectList("wpHyflbaGc.getAll");
	}
	
	public void saveHyflbaGc() throws SQLException{
		sqlSessionFactory.openSession().insert("wpHyflbaGc.insertDemo");
	}
}
