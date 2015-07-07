package zttc.itat.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import zttc.itat.model.Pager;
import zttc.itat.model.SystemContext;
import zttc.itat.model.WeeklyReports;

@Repository("weeklyReportsDao")
public class WeeklyReportsDao extends HibernateDaoSupport implements IWeeklyReportsDao {

	@Resource
	public void setSuperSessionFactory(SessionFactory sessionFactory){
		this.setSessionFactory(sessionFactory);
	}
	
	@Override
	public void add(WeeklyReports weeklyReports) {
		this.getHibernateTemplate().save(weeklyReports);
	}

	@Override
	public void update(WeeklyReports weeklyReports) {
		this.getHibernateTemplate().update(weeklyReports);
	}

	@Override
	public void delete(int id) {
		WeeklyReports weeklyReports = this.load(id);
		this.getHibernateTemplate().delete(weeklyReports);
	}

	@Override
	public WeeklyReports load(int id) {
		return this.getHibernateTemplate().load(WeeklyReports.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<WeeklyReports> list() {
		return this.getSession().createQuery("from WeeklyReports").list();
	}

	//分页查询所有周报
	@SuppressWarnings("unchecked")
	@Override
	public Pager<WeeklyReports> find() {
		int pageSize = SystemContext.getPageSize();
		int offset = SystemContext.getOffset();
		Query query = this.getSession().createQuery("from WeeklyReports order by id desc");
		query.setFirstResult(offset).setMaxResults(pageSize);
		List<WeeklyReports> datas = query.list();
		System.out.println(datas.size());
		Pager<WeeklyReports> pager = new Pager<WeeklyReports>();
		pager.setDatas(datas);
		pager.setOffset(offset);
		pager.setSize(pageSize);
		long total = (Long) this.getSession()
					.createQuery("select count(*) from WeeklyReports")
					.uniqueResult();
		pager.setTotal(total);
		return pager;
	}

	//按提交人查询
	@SuppressWarnings("unchecked")
	@Override
	public Pager<WeeklyReports> loadByReportsUser(int reportsUserId) {
		int size = SystemContext.getPageSize();
		int offset = SystemContext.getOffset();
		Query query = this.getSession().createQuery("from WeeklyReports where reportsUserId=? order by id desc ");
		query.setParameter(0, reportsUserId);
		query.setFirstResult(offset).setMaxResults(size);
		
		List<WeeklyReports> datas = query.list();
		Pager<WeeklyReports> pager = new Pager<WeeklyReports>();
		long total = (Long) this.getSession()
				.createQuery("select count(*) from WeeklyReports where reportsUserId=?")
				.setParameter(0, reportsUserId)
				.uniqueResult();
		
		pager.setDatas(datas);
		pager.setOffset(offset);
		pager.setSize(size);
		pager.setTotal(total);
		
		return pager;
	}

}
