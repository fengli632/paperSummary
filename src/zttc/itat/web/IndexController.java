package zttc.itat.web;


import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

/*import com.sun.org.apache.bcel.internal.generic.NEW;*/



import zttc.itat.model.User;
import zttc.itat.service.IInformService;
import zttc.itat.service.IPaperSummaryService;
import zttc.itat.service.IUserService;

@Controller
@SessionAttributes("loginUser")
public class IndexController {
	private IUserService userService;
	private IPaperSummaryService  paperSummaryService;
	private IInformService informService;
	
	public IInformService getInformService() {
		return informService;
	}
	
	@Resource
	public void setInformService(IInformService informService) {
		this.informService = informService;
	}

	public IUserService getUserService() {
		return userService;
	}

	@Resource
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	
	public IPaperSummaryService getPaperSummaryService() {
		return paperSummaryService;
	}
	
	@Resource
	public void setPaperSummaryService(IPaperSummaryService paperSummaryService) {
		this.paperSummaryService = paperSummaryService;
	}

	//������ͼ����
	@RequestMapping(value="/test",method=RequestMethod.GET)
	public String test(){
		return "home";
	}
	
	@RequestMapping(value="/admin",method=RequestMethod.GET)
	public String adminController(){
		return "/admin";
	}
	
	//��ҳ
	@RequestMapping(value="/home",method=RequestMethod.GET)
	public String home(){
		return "/home";
	}
	
	//��ҳ�������б�
	@RequestMapping(value="/paperHome",method=RequestMethod.GET)
	public String paperHome(Model model){
	model.addAttribute("paperSummaryList", paperSummaryService.find());
	return "/paper/paperHome";
	}
	
	//��ҳ��֪ͨ  ���õ�
	@RequestMapping(value={"/informHome","/"},method=RequestMethod.GET)
	public String informHome(Model model){
		model.addAttribute("informPager",informService.findNoHtml());
		return "/inform/informHome";
	}
	//�������
	@RequestMapping(value="/search",method=RequestMethod.GET)
	public String search(){
		return "/search";
	}
	
	@RequestMapping(value="/search",method=RequestMethod.POST)
	public String search(String keyString,Model model){
		System.out.println("�����ؼ�����:"+keyString);
		model.addAttribute("keyString",keyString);
		model.addAttribute("searchResult",paperSummaryService.searchPaperSummary(keyString));
		return "/searchlist";
	}
	

	//��¼����
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login(){
		return "login";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(String username,String password,Model model){
		System.out.println(username);
		User u = userService.login(username, password);
		model.addAttribute("loginUser",u);
		return "redirect:/informHome";
	}
	
	//ע�᷽��
	@RequestMapping(value="/register",method=RequestMethod.GET)
	public String register(Model model){
		model.addAttribute(new User());
		return "register";
	}
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String register(Model model,@Validated User user,BindingResult br){
		if(br.hasErrors()){
			return "register";
		}
		user.setUserType(2);
		userService.add(user);
		return "redirect:/informHome";
	}
	
	//ע������
	@RequestMapping("/logout")
	public String logout(Model model,HttpSession session){
		model.asMap().remove("loginUser");
		session.invalidate();
		return "redirect:/login";
	}
	
	@RequestMapping(value="/error",method=RequestMethod.GET)
	public String error(){
		return "/update-browser";
	}
	
}
