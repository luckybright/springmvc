package ming.dao;

import java.util.List;

import ming.bean.DemoBean;

public interface IDemoBeanDAO {

	public abstract List<DemoBean> getAll() throws Exception;

	public abstract void save(DemoBean bean) throws Exception;

}