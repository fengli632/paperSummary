package zttc.itat.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import zttc.itat.model.Pager;
import zttc.itat.model.PaperSummary;
import zttc.itat.model.SystemContext;

@Repository
public class PaperSummaryDao extends HibernateDaoSupport implements IPaperSummaryDao {

	@Resource
	public void setSuperSessionFatory(SessionFactory sessionFactory){
		this.setSessionFactory(sessionFactory);
	}
	
	@Override
	public void add(PaperSummary paperSummary) {
		this.getHibernateTemplate().save(paperSummary);
	}

	@Override
	public void update(PaperSummary paperSummary) {
		this.getHibernateTemplate().update(paperSummary);
	}

	@Override
	public void delete(int psId) {
		PaperSummary paperSummary = this.load(psId);
		this.getHibernateTemplate().delete(paperSummary);
	}

	@Override
	public PaperSummary load(int psId) {
		return this.getHibernateTemplate().load(PaperSummary.class, psId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PaperSummary> list() {
		return this.getSession().createQuery("from PaperSummary").list();
	}

	
	//查询所有
	@SuppressWarnings("unchecked")
	@Override
	public Pager<PaperSummary> find() {
		int size = SystemContext.getPageSize();
		int offset = SystemContext.getOffset();
		Query query = this.getSession().createQuery("from PaperSummary order by id desc");
		query.setFirstResult(offset).setMaxResults(size);
				
		List<PaperSummary> datas = query.list();
		Pager<PaperSummary> pager = new Pager<PaperSummary>();
		pager.setDatas(datas);
		pager.setOffset(offset);
		pager.setSize(size);
		long total = (Long) this.getSession().createQuery("select count(*) from PaperSummary").uniqueResult();
		pager.setTotal(total);
		return pager;
	}
	
	//按论文标题、内容 搜索
	@SuppressWarnings("unchecked")
	@Override
	public Pager<PaperSummary> searchPaperSummary(String keyString) {
		int size = SystemContext.getPageSize();
		int offset = SystemContext.getOffset();
		Query query = this.getSession().createQuery("from PaperSummary where name like :key or goal like :key order by id desc ");
		query.setString("key","%"+keyString+"%");
		query.setFirstResult(offset).setMaxResults(size);
		
		List<PaperSummary> datas = query.list();
		Pager<PaperSummary> pager = new Pager<PaperSummary>();
		long total = (Long) this.getSession()
				.createQuery("select count(*) from PaperSummary where name like :key or goal like :key ")
				.setString("key","%"+keyString+"%")
				.uniqueResult();
		
		pager.setDatas(datas);
		pager.setOffset(offset);
		pager.setSize(size);
		pager.setTotal(total);
		return pager;
	}

	//按上传人查询论文总结列表
	@SuppressWarnings("unchecked")
	@Override
	public Pager<PaperSummary> loadByPaperUser(int paperUserId) {
		int size = SystemContext.getPageSize();
		int offset = SystemContext.getOffset();
		Query query = this.getSession().createQuery("from PaperSummary where paperUserId=? order by id desc");
		query.setParameter(0, paperUserId);
		query.setFirstResult(offset).setMaxResults(size);
		
		List<PaperSummary> datas = query.list();
		Pager<PaperSummary> pager = new Pager<PaperSummary>();
		long total = (Long) this.getSession()
				.createQuery("select count(*) from PaperSummary where paperUserId=?")
				.setParameter(0, paperUserId)
				.uniqueResult();
		
		pager.setDatas(datas);
		pager.setOffset(offset);
		pager.setSize(size);
		pager.setTotal(total);
		return pager;
		
	}

	//按论文类别查询
	@Override
	@SuppressWarnings("unchecked")
	public Pager<PaperSummary> loadByPaperCategory(int categoryId) {
		int size = SystemContext.getPageSize();
		int offset = SystemContext.getOffset();
		Query query = this.getSession().createQuery("from PaperSummary where paperCategoryId=? order by id desc");
		query.setParameter(0, categoryId);
		query.setFirstResult(offset).setMaxResults(size);
		
		List<PaperSummary> datas = query.list();
		Pager<PaperSummary> pager = new Pager<PaperSummary>();
		long total = (Long) this.getSession()
				.createQuery("select count(*) from PaperSummary where paperCategoryId=?")
				.setParameter(0, categoryId)
				.uniqueResult();
		
		pager.setDatas(datas);
		pager.setOffset(offset);
		pager.setSize(size);
		pager.setTotal(total);
		
		return pager;
	}

}
