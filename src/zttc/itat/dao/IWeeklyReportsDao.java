package zttc.itat.dao;

import java.util.List;

import zttc.itat.model.Pager;
import zttc.itat.model.WeeklyReports;

public interface IWeeklyReportsDao {
	
	public void add(WeeklyReports weeklyReports);
	public void update(WeeklyReports weeklyReports);
	public void delete(int id);
	public WeeklyReports load(int id);
	public List<WeeklyReports> list();
	public Pager<WeeklyReports> find();
	public Pager<WeeklyReports> loadByReportsUser(int reportsUserId);
	
}
