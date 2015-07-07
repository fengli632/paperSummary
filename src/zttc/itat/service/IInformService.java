package zttc.itat.service;

import java.util.List;

import zttc.itat.model.Inform;
import zttc.itat.model.Pager;

public interface IInformService {

	public void add(Inform inform);
	public void update(Inform inform);
	public void delete(int infoId);
	public Inform load(int infoId);
	public List<Inform> list();
	public Pager<Inform> find();
	public Pager<Inform> findNoHtml();//去除inform中的html标签
}
