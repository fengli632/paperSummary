package zttc.itat.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import zttc.itat.dao.IWeeklyReportsDao;
import zttc.itat.model.Pager;
import zttc.itat.model.WeeklyReports;

@Service("weeklyReportsService")
public class WeeklyReportsService implements IWeeklyReportsService {

	private IWeeklyReportsDao weeklyReportsDao;
	
	public IWeeklyReportsDao getWeeklyReportsDao() {
		return weeklyReportsDao;
	}

	@Resource
	public void setWeeklyReportsDao(IWeeklyReportsDao weeklyReportsDao) {
		this.weeklyReportsDao = weeklyReportsDao;
	}

	@Override
	public void add(WeeklyReports weeklyReports) {
		weeklyReportsDao.add(weeklyReports);
	}

	@Override
	public void update(WeeklyReports weeklyReports) {
		weeklyReportsDao.update(weeklyReports);
	}

	@Override
	public void delete(int id) {
		weeklyReportsDao.delete(id);
	}

	@Override
	public WeeklyReports load(int id) {
		return weeklyReportsDao.load(id);
	}

	@Override
	public List<WeeklyReports> list() {
		return weeklyReportsDao.list();
	}

	@Override
	public Pager<WeeklyReports> find() {
		return weeklyReportsDao.find();
	}

	@Override
	public Pager<WeeklyReports> loadByReportsUser(int reportsUserId) {
		return weeklyReportsDao.loadByReportsUser(reportsUserId);
		
	}

	//去除提交的周报中的html标签
	@Override
	public Pager<WeeklyReports> findNoHtml() {
		
		Pager<WeeklyReports> reportsPager = weeklyReportsDao.find();
		if(reportsPager!=null && reportsPager.getDatas().size()>0){
			for(int i=0;i<reportsPager.getDatas().size();i++){
				String removeHtmlSummary = reportsPager.getDatas().get(i).getSummary().replaceAll("<.*?>", "").replace("&nbsp;","");
				reportsPager.getDatas().get(i).setSummary(removeHtmlSummary);
			}
		}
		return reportsPager;
	}

	//去除提交的周报中的html标签，
	@Override
	public Pager<WeeklyReports> loadByReportsUserNoHtml(int reportsUserId) {
		
		Pager<WeeklyReports> reportsPager = weeklyReportsDao.loadByReportsUser(reportsUserId);
		if(reportsPager!=null && reportsPager.getDatas().size()>0){
			for(int i=0;i<reportsPager.getDatas().size();i++){  //注意这里判断页大小不能用reportsPager.getTotal()，因为getTotal()是所有条目数目，而这里每次只加载一页级pagesize（10）的大小。会有数组越界的错误
				String removeHtmlSummary = reportsPager.getDatas().get(i).getSummary().replaceAll("<.*?>", "").replace("&nbsp;","");
				reportsPager.getDatas().get(i).setSummary(removeHtmlSummary);
			}
		}
		return reportsPager;
	}

}
