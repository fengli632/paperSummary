package zttc.itat.service;

import java.util.List;

import zttc.itat.model.Pager;
import zttc.itat.model.PaperCategory;

public interface IPaperCategoryService {
	
	public void add(PaperCategory paperCategory);
	public void update(PaperCategory paperCategory);
	public void delete(int categoryId);
	public PaperCategory load(int categoryId);
	public List<PaperCategory> list();
	public Pager<PaperCategory> find();
}
