package zttc.itat.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import zttc.itat.dao.IInformDao;
import zttc.itat.model.Inform;
import zttc.itat.model.Pager;

@Service("informService")
public class InformService implements IInformService {

	private IInformDao informDao;
	
	public IInformDao getInformDao() {
		return informDao;
	}
	@Resource
	public void setInformDao(IInformDao informDao) {
		this.informDao = informDao;
	}

	@Override
	public void add(Inform inform) {
		this.informDao.add(inform);
	}

	@Override
	public void update(Inform inform) {
		this.informDao.update(inform);
	}

	@Override
	public void delete(int infoId) {
		this.informDao.delete(infoId);
	}

	@Override
	public Inform load(int infoId) {
		return informDao.load(infoId);
	}

	@Override
	public List<Inform> list() {
		return informDao.list();
	}

	@Override
	public Pager<Inform> find() {
		return informDao.find();
	}
	@Override
	public Pager<Inform> findNoHtml() {
		Pager<Inform> informPager = informDao.find();
		if (informPager!=null && informPager.getDatas().size()>0) {
			for (int i = 0; i < informPager.getDatas().size(); i++) {
				
				String removeInformContentHtml = informPager.getDatas().get(i).getInfoContent().replaceAll("<.*?>", "").replace("&nbsp;","");
				
				informPager.getDatas().get(i).setInfoContent(removeInformContentHtml);
			}
		}
		return informPager;
	}

}
