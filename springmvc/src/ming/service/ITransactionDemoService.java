package ming.service;

import java.util.List;

import ming.bean.DemoBean;

public interface ITransactionDemoService {
	public void tSaveInfo(DemoBean bean) throws Exception;
	public List<DemoBean> getAll() throws Exception;
}
