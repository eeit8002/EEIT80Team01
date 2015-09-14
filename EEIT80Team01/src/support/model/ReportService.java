package support.model;

import java.util.ArrayList;
import java.util.List;

import support.model.dao.ReportDAOjdbc;

public class ReportService {

	public List<ReportBean> findAllReport(){
		ReportDAO dao = new ReportDAOjdbc();
		List<ReportBean> list = new ArrayList<ReportBean>();
		list = dao.select();
		return list;
	}
	
	public ReportBean Freeze(int legal,int status){
		ReportBean bean = new ReportBean();
		ReportDAO dao = new ReportDAOjdbc();
		bean = dao.select(legal);
		if(bean!=null){
			bean.setStatus(status);
			bean = dao.update(bean);
		}
		return bean;
	}
}
