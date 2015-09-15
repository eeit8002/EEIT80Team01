package support.model;

import java.util.List;

public interface ReportDAO {

	public abstract ReportBean select(int legal);
	
	public abstract List<ReportBean> select();
		
	public abstract ReportBean insert(ReportBean bean);

	public abstract ReportBean update(ReportBean bean);

	public abstract boolean delete(int legal);
	
}
