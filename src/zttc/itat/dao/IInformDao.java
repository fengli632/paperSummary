package zttc.itat.dao;

import java.util.List;

import zttc.itat.model.Inform;
import zttc.itat.model.Pager;

public interface IInformDao {

	public void add(Inform inform);
	public void update(Inform inform);
	public void delete(int infoId);
	public Inform load(int infoId);
	public List<Inform> list();
	public Pager<Inform> find();
	
}
