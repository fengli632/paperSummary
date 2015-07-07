package zttc.itat.dao;

import java.util.List;

import zttc.itat.model.Pager;
import zttc.itat.model.PaperSummary;

public interface IPaperSummaryDao {

	public void add(PaperSummary paperSummary);
	public void update(PaperSummary paperSummary);
	public void delete(int psId);
	public PaperSummary load(int psId);
	public List<PaperSummary> list();
	public Pager<PaperSummary> find();
	public Pager<PaperSummary> searchPaperSummary(String keyString);
	public Pager<PaperSummary> loadByPaperUser(int paperUserId);
	public Pager<PaperSummary> loadByPaperCategory(int categoryId);
}
