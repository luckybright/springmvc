package ming.service.impl;

import java.util.List;

import ming.bean.DemoBean;
import ming.dao.IDemoBeanDAO;
import ming.service.ITransactionDemoService;

public class TransactionDemoServiceImpl implements ITransactionDemoService {
	private IDemoBeanDAO dao;
	
	public IDemoBeanDAO getDao() {
		return dao;
	}
	public void setDao(IDemoBeanDAO dao) {
		this.dao = dao;
	}
	@Override
	public void tSaveInfo(DemoBean bean) throws Exception{
		DemoBean bean1 = new DemoBean();
		bean1.setId(3);
		bean1.setName("test");
		dao.save(bean1);
		dao.save(bean1);
	}
	@Override
	public List<DemoBean> getAll() throws Exception {
		return dao.getAll();
	}

}
