package zttc.itat.web;

/**
 * ����Աҳ��
 * @author ���
 *
 */

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import zttc.itat.model.PaperSummary;
import zttc.itat.model.User;
import zttc.itat.model.WeeklyReports;
import zttc.itat.service.IPaperCategoryService;
import zttc.itat.service.IPaperSummaryService;
import zttc.itat.service.IUserService;
import zttc.itat.service.IWeeklyReportsService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	private IWeeklyReportsService weeklyReportsService ;
	private IPaperSummaryService paperSummaryService;
	private IPaperCategoryService paperCategoryService;
	private IUserService userService;
	
	public IUserService getUserService() {
		return userService;
	}
	
	@Resource
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public IPaperCategoryService getPaperCategoryService() {
		return paperCategoryService;
	}
	
	@Resource
	public void setPaperCategoryService(IPaperCategoryService paperCategoryService) {
		this.paperCategoryService = paperCategoryService;
	}

	public IPaperSummaryService getPaperSummaryService() {
		return paperSummaryService;
	}

	@Resource
	public void setPaperSummaryService(IPaperSummaryService paperSummaryService) {
		this.paperSummaryService = paperSummaryService;
	}
	
	public IWeeklyReportsService getWeeklyReportsService() {
		return weeklyReportsService;
	}

	@Resource
	public void setWeeklyReportsService(IWeeklyReportsService weeklyReportsService) {
		this.weeklyReportsService = weeklyReportsService;
	}
	
	//�û�����
	
	//�û��б�
		@RequestMapping(value="/user/users",method=RequestMethod.GET)
		public String list(Model model){
			model.addAttribute("pagers",userService.find());
			return "/user/list";
		} 
	
	//����û�,����ͨ�û�ע���õ���IndexController���register�������˴���Ҫ�������Ա��ӹ���Ա�û�
	@RequestMapping(value="/user/add",method=RequestMethod.GET)
	public String add(Model model){
		model.addAttribute(new User());
		return "/user/add";
	}
	@RequestMapping(value="/user/add",method=RequestMethod.POST)
	public String add(Model model,@Validated User user,BindingResult br){
		if(br.hasErrors()){
			return "/user/add";
		}
		
		System.out.println(user.getUserType());
		
		userService.add(user);
		
		return "redirect:/admin/user/users";
	}
	
	//�����û�
		@RequestMapping(value="/user/{id}/update",method=RequestMethod.GET)
		public String update(@PathVariable int id, Model model){
			model.addAttribute(userService.load(id));
			return "/user/adminUpdate";
		}
		
		@RequestMapping(value="/user/{id}/update",method=RequestMethod.POST)
		public String update(@PathVariable int id,@Validated User user,BindingResult br,Model model){
			if(br.hasErrors()){
				
				return "/user/update";
			}
			User tu = userService.load(id);
			tu.setPassword(user.getPassword());
			tu.setNickname(user.getNickname());
			tu.setEmail(user.getEmail());
			tu.setUserType(user.getUserType());
			userService.update(tu);
			return "redirect:/admin/user/users";
		}
		
		//ɾ���û�
		@RequestMapping(value="/user/{id}/delete",method=RequestMethod.GET)
		public String delete(@PathVariable int id){
			userService.delete(id);
			return "redirect:/admin/user/users";
		}
	
	
	//�����ܽ����
	
	//����Ա�����ܽ��б�
	@RequestMapping(value="/paper/adminPaperList",method=RequestMethod.GET)
	public String paperList(Model model){
		model.addAttribute("paperSummaryList", paperSummaryService.find());
		return "/paper/adminPaperList";
	}
	
	//����Ա�����ܽ�����
	@RequestMapping(value="/paper/{id}/show",method=RequestMethod.GET)
	public String showPaperSummary(@PathVariable int id,Model model){
		model.addAttribute(paperSummaryService.load(id));
		return "/paper/showPaper";	
	}
	
	//���������ܽ�
	@RequestMapping(value="/paper/{id}/update",method=RequestMethod.GET)
	public String updatePaperSummary(@PathVariable int id,Model model){
		model.addAttribute(paperSummaryService.load(id));
		model.addAttribute("Pcategory", paperCategoryService.list());
		return "/paper/updatePaper";
	}
	
	@RequestMapping(value="/paper/{id}/update",method=RequestMethod.POST)
	public String updatePaperSummary(@PathVariable int id,@Validated PaperSummary paperSummary,BindingResult br,Model model){
		/*if(br.hasErrors()){
			return "/paper/updatePaper";
		}*/
		
		paperSummary.setPaperCategory(paperCategoryService.list().get(0));   //���ԣ�ֱ���������Ϊ2
		
		PaperSummary uPaperSummary = paperSummaryService.load(id);
		
		uPaperSummary.setName(paperSummary.getName());
		uPaperSummary.setPaperCategory(paperSummary.getPaperCategory());
		uPaperSummary.setAuthor(paperSummary.getAuthor());
		uPaperSummary.setPeriodical(paperSummary.getPeriodical());
		uPaperSummary.setPublishTime(paperSummary.getPublishTime());
		uPaperSummary.setGoal(paperSummary.getGoal());
		uPaperSummary.setMethod(paperSummary.getMethod());
		uPaperSummary.setResult(paperSummary.getResult());
		uPaperSummary.setShortcomings(paperSummary.getShortcomings());
		uPaperSummary.setOutlook(paperSummary.getOutlook());
		uPaperSummary.setSignificance(paperSummary.getSignificance());
		uPaperSummary.setThought(paperSummary.getThought());
		
		paperSummaryService.update(uPaperSummary);//���¸��ĺ���ܽ��б�
		
		return "redirect:/admin/paper/adminPaperList";
	}
	
	//ɾ�������ܽ���Ŀ
	@RequestMapping(value="/paper/{id}/delete",method=RequestMethod.GET)
	public String deletePaperSummary(@PathVariable int id){
		paperSummaryService.delete(id);
		return "redirect:/admin/paper/adminPaperList";
	}
	
	//�ܱ�����
	
	//����Ա�ܱ��б�
	@RequestMapping(value="/reports/reportsListAll",method=RequestMethod.GET)
	public String reportsListAll(Model model){
		model.addAttribute("allReports",weeklyReportsService.findNoHtml());
		return "/reports/adminReportsList";
	}
	
	//�����ܱ�
	@RequestMapping(value="/reports/{id}/updateReports",method=RequestMethod.GET)
	public String updateReports(@PathVariable int id,Model model){
		model.addAttribute(weeklyReportsService.load(id));
		return "/reports/updateReports";
	}
	
	@RequestMapping(value="/reports/{id}/updateReports",method=RequestMethod.POST)
	public String updateReports(@PathVariable int id,Model model,@Validated WeeklyReports weeklyReports,BindingResult br){
		if(br.hasErrors()){
			return "/reports/updateReports";
		}
		
		WeeklyReports uWeeklyReports = weeklyReportsService.load(id);
		
		uWeeklyReports.setSummary(weeklyReports.getSummary());
		uWeeklyReports.setPlan(weeklyReports.getPlan());
		uWeeklyReports.setTime(weeklyReports.getTime());
		
		weeklyReportsService.update(uWeeklyReports);
		return "redirect:/admin/reports/reportsListAll";
	}
	
	//�ܱ�����
	@RequestMapping(value="/reports/{id}/showReports",method=RequestMethod.GET)
	public String showReports(@PathVariable int id,Model model){
		model.addAttribute(weeklyReportsService.load(id));
		return "/reports/showReports";
	}
	
	//ɾ���ܱ�
	@RequestMapping(value="/reports/{id}/deleteReports",method=RequestMethod.GET)
	public String deleteReports(@PathVariable int id){
		weeklyReportsService.delete(id);
		return "redirect:/admin/reports/reportsListAll";
	}
	
	//�ϴ��ܱ� ����һ
	/*@RequestMapping(value="/uploadWeeklyReports1",method=RequestMethod.POST)
	public String uploadWeeklyReports(@RequestParam("file") CommonsMultipartFile file,HttpServletRequest request) throws IOException {
		System.out.println("fileName--->"+file.getOriginalFilename());
		
		if(!file.isEmpty()){
			try {
				FileOutputStream outputStream = new FileOutputStream("D:/"+new Date().getTime()+ file.getOriginalFilename());
				InputStream inputStream = file.getInputStream();
				int b = 0;
				while((b=inputStream.read()) != -1){     //=-1˵��������β��
					outputStream.write(b);
				}
				outputStream.flush();
				outputStream.close();
				inputStream.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return "/uploadSuccess";
	}
	
	//�ϴ��ܱ� ������
	@RequestMapping(value="/uploadWeeklyReports2",method=RequestMethod.POST)
	public String uploadWeeklyReports2(HttpServletRequest request,HttpServletResponse response) throws IllegalStateException, IOException{
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
		if(multipartResolver.isMultipart(request)){
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
			Iterator<String> iterator = multiRequest.getFileNames();
			while(iterator.hasNext()){
				MultipartFile file = multiRequest.getFile((String)iterator.next());
				if(file != null){
					String fileName = new Date().getTime() + file.getOriginalFilename();
					String path = "D:/WeeklyReports/" + fileName;
					File localFile = new File(path);
					//springMVC��transferTo����:���ϴ��ļ�д��������ָ�����ļ���
					file.transferTo(localFile);
				}
			}
		}
		return "uploadSuccess";
	}*/
	
	
	
}
