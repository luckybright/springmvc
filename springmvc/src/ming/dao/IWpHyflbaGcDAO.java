package ming.dao;

import java.sql.SQLException;
import java.util.List;

import ming.bean.WpHyflbaGc;

public interface IWpHyflbaGcDAO {

	public List<WpHyflbaGc> getAll();
	public void saveHyflbaGc() throws SQLException;
}
