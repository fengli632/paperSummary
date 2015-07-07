package zttc.itat.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import zttc.itat.dao.IPaperSummaryDao;
import zttc.itat.model.Pager;
import zttc.itat.model.PaperSummary;

@Service("paperSumaryService")
public class PaperSummaryService implements IPaperSummaryService {

	private IPaperSummaryDao paperSummaryDao;

	public IPaperSummaryDao getPaperSummaryDao() {
		return paperSummaryDao;
	}

	@Resource
	public void setPaperSummaryDao(IPaperSummaryDao paperSummaryDao) {
		this.paperSummaryDao = paperSummaryDao;
	}

	@Override
	public void add(PaperSummary paperSummary) {
		paperSummaryDao.add(paperSummary);
	}

	@Override
	public void update(PaperSummary paperSummary) {
		paperSummaryDao.update(paperSummary);
	}

	@Override
	public void delete(int psId) {
		paperSummaryDao.delete(psId);
	}

	@Override
	public PaperSummary load(int psId) {
		return paperSummaryDao.load(psId);
	}

	@Override
	public List<PaperSummary> list() {
		return paperSummaryDao.list();
	}
	
	@Override
	public Pager<PaperSummary> find() {
		
		return paperSummaryDao.find();
	}
	@Override
	public Pager<PaperSummary> searchPaperSummary(String keyString) {
		return paperSummaryDao.searchPaperSummary(keyString);
	}

	@Override
	public Pager<PaperSummary> loadByPaperUser(int paperUserId) {
		return paperSummaryDao.loadByPaperUser(paperUserId);
	}

	@Override
	public Pager<PaperSummary> loadByPaperCategory(int categoryId) {
		return paperSummaryDao.loadByPaperCategory(categoryId);
	}

}
