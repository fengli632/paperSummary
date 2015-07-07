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

/*	//用户列表
	//此方法已移至adminController
	@RequestMapping(value="/users",method=RequestMethod.GET)
	public String list(Model model){
		model.addAttribute("pagers",userService.find());
		return "user/list";
	} */
	
/*	//添加用户,因普通用户注册用的是IndexController里的register方法，此处主要用与管理员添加管理员用户 
	//此方法已移至adminController
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
		user.setUserType(1);	//设为管理员
		userService.add(user);
		
		return "redirect:/user/users";
	}*/
	
	//用户详情含上传论文信息
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public String show(@PathVariable int id,Model model,ServletRequest req, ServletResponse resp){
		
		//权限控制，已登录的普通用户不能通过修改地址栏id的方式看其他用户的信息，还没找到更好的方法，这样一个一个Controller方法里加验证很麻烦。
		//其他的还有/{id}/update；/{id}/changePassword；以及user的/paper;reports.
		HttpServletRequest hsq = (HttpServletRequest) req;
		User loginUser = (User) hsq.getSession().getAttribute("loginUser");
		if(id != loginUser.getId()){
			throw new UserException("您没有权限查看！请联系管理员蜀黍。。。");
		}
		model.addAttribute("loginUserPaper",paperSummaryService.loadByPaperUser(id));
		model.addAttribute("loginUserReports",weeklyReportsService.loadByReportsUser(id));
		return "user/show";
	}
	
	//更新用户
	//此方法已移至adminController 因要可以改变用户类型 普通用户的更改个人信息页面 看不到
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
	
	//修改密码方法
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
				model.addAttribute("msg","原始密码不正确，请重新输入！");
				return "/user/changePassword";
			}
			User nUser = userService.load(id);
			nUser.setPassword(user.getPassword());
			nUser.setUserType(user.getUserType());
			userService.update(nUser);
			return "redirect:/user/"+id;
		}
	
/*	//删除用户
	//此方法已移至adminController
	@RequestMapping(value="/{id}/delete",method=RequestMethod.GET)
	public String delete(@PathVariable int id){
		userService.delete(id);
		return "redirect:/user/users";
	}*/
	
	
}
