package zttc.itat.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import zttc.itat.model.PaperCategory;
import zttc.itat.service.IPaperCategoryService;
import zttc.itat.service.IPaperSummaryService;
/**
 * 论文分类管理控制器
 * @author 李锋
 */
@Controller
@RequestMapping("/paperCategory")
public class PaperCategoryController {
	
	private IPaperCategoryService paperCategoryService;
	private IPaperSummaryService paperSummaryService;
	
	public IPaperSummaryService getPaperSummaryService() {
		return paperSummaryService;
	}
	@Resource
	public void setPaperSummaryService(IPaperSummaryService paperSummaryService) {
		this.paperSummaryService = paperSummaryService;
	}

	public IPaperCategoryService getPaperCategoryService() {
		return paperCategoryService;
	}

	@Resource
	public void setPaperCategoryService(IPaperCategoryService paperCategoryService) {
		this.paperCategoryService = paperCategoryService;
	}
	
	//论文类别列表
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String paperCategoryList(Model model){
		model.addAttribute("categoryList", paperCategoryService.find());
		return "/paperCategory/list";
	}
	
	//添加论文类别
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String addPaperCategory(Model model){
		model.addAttribute("paperCategory",new PaperCategory());
		return "/paperCategory/add";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String add(Model model,@Validated PaperCategory paperCategory,BindingResult br){
		if(br.hasErrors()){
			return "/paperCategory/add";
		}
		paperCategoryService.add(paperCategory);
		return "redirect:/paperCategory/list";
	}
	
	//论文分类详情页面,此类论文类别下所有的论文   为什么这个方法不能运行？？？？ 没有注解papersummaryService的  @Resource！！！
	@RequestMapping(value="/{id}/show",method=RequestMethod.GET)
	public String show(@PathVariable int id,Model model){
		model.addAttribute("paperCategoryShow",paperCategoryService.load(id));
		model.addAttribute("papersByCategory",paperSummaryService.loadByPaperCategory(id));
		return "/paperCategory/show";
	}
	
	//论文分类更新页面
	@RequestMapping(value="/{id}/update",method=RequestMethod.GET)
	public String update(@PathVariable int id,Model model){
		model.addAttribute(paperCategoryService.load(id));
		return "/paperCategory/update";
	}

	@RequestMapping(value="/{id}/update",method=RequestMethod.POST)
	public String update(@PathVariable int id,@Validated PaperCategory paperCategory,BindingResult br,Model model){
		if(br.hasErrors()){
			return "/paperCategory/update";
		}
		PaperCategory pc = paperCategoryService.load(id);
		pc.setCategoryName(paperCategory.getCategoryName());
		pc.setCategoryRemark(paperCategory.getCategoryRemark());
		paperCategoryService.update(pc);
		return "redirect:/paperCategory/list";
	}
	
	//删除论文分类
	@RequestMapping(value="/{id}/delete",method=RequestMethod.GET)
	public String delete(@PathVariable int id){
		paperCategoryService.delete(id);
		return "redirect:/paperCategory/list";
	}
}
