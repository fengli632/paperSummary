package zttc.itat.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import zttc.itat.model.Inform;
import zttc.itat.model.Pager;
import zttc.itat.model.SystemContext;

@Repository("informDao")
public class InformDao extends HibernateDaoSupport implements IInformDao {

	@Resource
	public void setSuperSessionFactory(SessionFactory sessionFactory){
		this.setSessionFactory(sessionFactory);
	}
	
	@Override
	public void add(Inform inform) {
		this.getHibernateTemplate().save(inform);
	}

	@Override
	public void update(Inform inform) {
		this.getHibernateTemplate().update(inform);
	}

	@Override
	public void delete(int infoId) {
		Inform inform = this.load(infoId);
		this.getHibernateTemplate().delete(inform);
	}

	@Override
	public Inform load(int infoId) {
		
		return this.getHibernateTemplate().load(Inform.class, infoId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Inform> list() {
		return this.getSession().createQuery("from Inform").list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Pager<Inform> find() {
		int size = SystemContext.getPageSize();
		int offset = SystemContext.getOffset();
		Query query = this.getSession().createQuery("from Inform order by infoId desc");
		query.setFirstResult(offset).setMaxResults(size);
		List<Inform> datas = query.list();
		Pager<Inform> pager = new Pager<Inform>();
		Long total = (Long) this.getSession().createQuery("select count (*) from Inform").uniqueResult();
		pager.setDatas(datas);
		pager.setSize(size);
		pager.setOffset(offset);
		pager.setTotal(total);
	
		return pager;
	}

}
