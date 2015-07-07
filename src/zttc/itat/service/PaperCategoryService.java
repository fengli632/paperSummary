package zttc.itat.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import zttc.itat.dao.IPaperCategoryDao;
import zttc.itat.model.Pager;
import zttc.itat.model.PaperCategory;

@Service("paperCategoryService")
public class PaperCategoryService implements IPaperCategoryService {

	private IPaperCategoryDao paperCategoryDao;
	
	
	public IPaperCategoryDao getPaperCategoryDao() {
		return paperCategoryDao;
	}

	@Resource
	public void setPaperCategoryDao(IPaperCategoryDao paperCategoryDao) {
		this.paperCategoryDao = paperCategoryDao;
	}

	@Override
	public void add(PaperCategory paperCategory) {
		paperCategoryDao.add(paperCategory);
	}

	@Override
	public void update(PaperCategory paperCategory) {
		paperCategoryDao.update(paperCategory);
	}

	@Override
	public void delete(int categoryId) {
		paperCategoryDao.delete(categoryId);
	}

	@Override
	public PaperCategory load(int categoryId) {
		return paperCategoryDao.load(categoryId);
	}

	@Override
	public List<PaperCategory> list() {
		return paperCategoryDao.list();
	}

	@Override
	public Pager<PaperCategory> find() {
		return paperCategoryDao.find();
	}

}
