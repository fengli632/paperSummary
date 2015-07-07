package zttc.itat.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import zttc.itat.model.Pager;
import zttc.itat.model.PaperCategory;
import zttc.itat.model.SystemContext;


@Repository
public class PaperCategoryDao extends HibernateDaoSupport implements IPaperCategoryDao {

	@Resource
	public void setSuperSessionFatory(SessionFactory sessionFactory){
		this.setSessionFactory(sessionFactory);
	}
	
	@Override
	public void add(PaperCategory paperCategory) {
		this.getHibernateTemplate().save(paperCategory);
	}

	@Override
	public void update(PaperCategory paperCategory) {
		this.getHibernateTemplate().update(paperCategory);
	}

	@Override
	public void delete(int categoryId) {
		PaperCategory paperCategory = this.load(categoryId);
		this.getHibernateTemplate().delete(paperCategory);
	}

	@Override
	public PaperCategory load(int categoryId) {
		return this.getHibernateTemplate().load(PaperCategory.class, categoryId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PaperCategory> list() {
		return this.getSession().createQuery("from PaperCategory").list();
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public Pager<PaperCategory> find() {
		int size = SystemContext.getPageSize();
		int offset = SystemContext.getOffset();
		Query query = this.getSession().createQuery("from PaperCategory");
		query.setFirstResult(offset).setMaxResults(size);
		
		List<PaperCategory> datas = query.list();
		Pager<PaperCategory> pager = new Pager<PaperCategory>();
		long total = (Long) this.getSession().createQuery("select count(*) from PaperCategory ").uniqueResult();
		pager.setSize(size);
		pager.setOffset(offset);
		pager.setDatas(datas);
		pager.setTotal(total);
		return pager;
	}

}
