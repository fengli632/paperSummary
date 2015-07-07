package zttc.itat.web;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import zttc.itat.model.User;
import zttc.itat.model.UserException;
import zttc.itat.service.IPaperSummaryService;
import zttc.itat.service.IUserService;
import zttc.itat.service.IWeeklyReportsService;

@Controller
@RequestMapping("/user")
public class UserController {
	private IUserService userService;
	private IPaperSummaryService  paperSummaryService;
	private IWeeklyReportsService weeklyReportsService;
	
	
	public IWeeklyReportsService getWeeklyReportsService() {
		return weeklyReportsService;
	}
	@Resource
	public void setWeeklyReportsService(IWeeklyReportsService weeklyReportsService) {
		this.weeklyReportsService = weeklyReportsService;
	}

	public IPaperSummaryService getPaperSummaryService() {
		return paperSummaryService;
	}
	
	@Resource
	public void setPaperSummaryService(IPaperSummaryService paperSummaryService) {
		this.paperSummaryService = paperSummaryService;
	}
	
	public IUserService getUserService() {
		return userService;
	}
	
	@Resource
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

/*	//�û��б�
	//�˷���������adminController
	@RequestMapping(value="/users",method=RequestMethod.GET)
	public String list(Model model){
		model.addAttribute("pagers",userService.find());
		return "user/list";
	} */
	
/*	//����û�,����ͨ�û�ע���õ���IndexController���register�������˴���Ҫ�������Ա��ӹ���Ա�û� 
	//�˷���������adminController
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String add(Model model){
		model.addAttribute(new User());
		return "user/add";
	}
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String add(Model model,@Validated User user,BindingResult br){
		if(br.hasErrors()){
			return "user/add";
		}
		user.setUserType(1);	//��Ϊ����Ա
		userService.add(user);
		
		return "redirect:/user/users";
	}*/
	
	//�û����麬�ϴ�������Ϣ
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public String show(@PathVariable int id,Model model,ServletRequest req, ServletResponse resp){
		
		//Ȩ�޿��ƣ��ѵ�¼����ͨ�û�����ͨ���޸ĵ�ַ��id�ķ�ʽ�������û�����Ϣ����û�ҵ����õķ���������һ��һ��Controller���������֤���鷳��
		//�����Ļ���/{id}/update��/{id}/changePassword���Լ�user��/paper;reports.
		HttpServletRequest hsq = (HttpServletRequest) req;
		User loginUser = (User) hsq.getSession().getAttribute("loginUser");
		if(id != loginUser.getId()){
			throw new UserException("��û��Ȩ�޲鿴������ϵ����Ա���򡣡���");
		}
		model.addAttribute("loginUserPaper",paperSummaryService.loadByPaperUser(id));
		model.addAttribute("loginUserReports",weeklyReportsService.loadByReportsUser(id));
		return "user/show";
	}
	
	//�����û�
	//�˷���������adminController ��Ҫ���Ըı��û����� ��ͨ�û��ĸ��ĸ�����Ϣҳ�� ������
	@RequestMapping(value="/{id}/update",method=RequestMethod.GET)
	public String update(@PathVariable int id, Model model){
		model.addAttribute(userService.load(id));
		return "user/update";
	}
	
	@RequestMapping(value="/{id}/update",method=RequestMethod.POST)
	public String update(@PathVariable int id,@Validated User user,BindingResult br,Model model){
		if(br.hasErrors()){
			return "/user/update";
		}
		User tu = userService.load(id);
		tu.setPassword(user.getPassword());
		tu.setNickname(user.getNickname());
		tu.setEmail(user.getEmail());
		tu.setUserType(1);
		userService.update(tu);
		return "redirect:/user/"+id;
	}
	
	//�޸����뷽��
		@RequestMapping(value="/{id}/changePassword",method=RequestMethod.GET)
		public String changePassword(@PathVariable int id,Model model){
			model.addAttribute(userService.load(id));
			
			return "/user/changePassword";
		}
		@RequestMapping(value="/{id}/changePassword",method=RequestMethod.POST)
		public String changePassword(@PathVariable int id,@Validated User user,BindingResult br,Model model,String newPassword,ServletRequest req,ServletResponse resp){
			if(br.hasErrors()){
				return "/user/changePassword";
			}
			HttpServletRequest hsq = (HttpServletRequest) req;
			User loginUser = (User) hsq.getSession().getAttribute("loginUser");
			if(!newPassword.equals(loginUser.getPassword())){
				model.addAttribute("msg","ԭʼ���벻��ȷ�����������룡");
				return "/user/changePassword";
			}
			User nUser = userService.load(id);
			nUser.setPassword(user.getPassword());
			nUser.setUserType(user.getUserType());
			userService.update(nUser);
			return "redirect:/user/"+id;
		}
	
/*	//ɾ���û�
	//�˷���������adminController
	@RequestMapping(value="/{id}/delete",method=RequestMethod.GET)
	public String delete(@PathVariable int id){
		userService.delete(id);
		return "redirect:/user/users";
	}*/
	
	
}
