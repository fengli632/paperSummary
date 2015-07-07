package zttc.itat.web;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.context.support.StaticApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.portlet.ModelAndView;

import zttc.itat.model.PaperSummary;
import zttc.itat.model.User;
import zttc.itat.service.IPaperCategoryService;
import zttc.itat.service.IPaperSummaryService;
import zttc.itat.util.BaseUtil;

/**
 * �����ܽ����ҳ��
 * @author ���
 *
 */

@Controller
@RequestMapping("/paper")
public class PaperSummaryController {

	private IPaperSummaryService paperSummaryService;
	private IPaperCategoryService paperCategoryService;

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
	
	//�����б�
		@RequestMapping(value={"/paperHome","/"},method=RequestMethod.GET)
		public String paperHome(Model model){
			model.addAttribute("paperSummaryList", paperSummaryService.find());
			return "/paper/paperHome";
		}
		
	
	//�����ܽ��б�
	@RequestMapping(value="/paperList",method=RequestMethod.GET)
	public String paperList(Model model){
		model.addAttribute("paperSummaryList", paperSummaryService.find());
		return "/paper/paperList";
	}
	
	//���
	@RequestMapping(value="/addPaper",method=RequestMethod.GET)
	public String addPaperSummary(Model model){
		model.addAttribute(new PaperSummary());				//��ô��select�д��������������ݣ�����
		/*Map<String, List<PaperCategory>> categoryMap = new HashMap<String, List<PaperCategory>>();
		categoryMap.put("categoryMap", paperCategoryService.list());*/
		//System.out.println(paperCategoryService.list().get(0));
		//System.out.println(paperCategoryService.find().getDatas().get(0).getClass().toString());
		model.addAttribute("Pcategory", paperCategoryService.list());
		
		System.out.println(BaseUtil.addDateString());
		return "/paper/addPaper";
	}
	
	@RequestMapping(value="/addPaper",method=RequestMethod.POST)
	public String addPaperSummary2(ServletRequest req,ServletResponse resq, Model model,@Validated PaperSummary paperSummary,BindingResult br,MultipartFile attach,HttpServletRequest hreq) throws IOException{
		System.out.println(paperSummary.getName());
		if(br.hasErrors()){
			return "/paper/addPaper";
		}
		//int selectId = paperSummary.getPaperCategory().getCategoryId();
		//paperSummary.setPaperCategory(paperCategoryService.load(selectId));
		for(int i=1;i<=10;i++){
			if(paperSummary.getSelectTest().equals(i+"") )
			{
				paperSummary.setPaperCategory(paperCategoryService.list().get(i-1));
				break;
			}
		
		}

		//System.out.println(paperSummary.getPaperCategory().getCategoryName());
		
		 /*�ϴ��ļ�*/
		String realpath = hreq.getSession().getServletContext().getRealPath("/upload/paper");  //�������ļ�����·��
		//System.out.println(realpath);
		
		if(!attach.isEmpty()){			//�ж������ϴ��ļ�����Ӱ���ύ
			File file = new File(realpath+"/"+attach.getOriginalFilename());
		    FileUtils.copyInputStreamToFile(attach.getInputStream(),file);
			//System.out.println(attach.getName()+","+attach.getOriginalFilename()+","+attach.getContentType());
			//System.out.println(file.getPath());
			String path = file.getPath().toString();
			String fileName = attach.getOriginalFilename().toString();//�ϴ��ļ�����
			paperSummary.setFilePath(path);
			paperSummary.setFileName(fileName);
		}
		
		HttpServletRequest hsq = (HttpServletRequest) req; 
		User user = (User) hsq.getSession().getAttribute("loginUser");
		paperSummary.setPaperUser(user);
		
		//�ϴ�ʱ��
		paperSummary.setAddDate(BaseUtil.addDateString());
		paperSummaryService.add(paperSummary);
		//System.out.println(paperSummary.getPaperCategory().getCategoryName());
		return "redirect:/paper/paperList"; 
	}
	
	
	//�����ܽ�����
	@RequestMapping(value="/{id}/show",method=RequestMethod.GET)
	public String showPaperSummary(@PathVariable int id,Model model){
		System.out.println("-------------"+paperSummaryService.load(id).getFilePath());
		model.addAttribute(paperSummaryService.load(id));
		return "/paper/showPaper";	
	}
	
	//�����ļ�
	@RequestMapping(value="/{id}/download")
	public ModelAndView download(@PathVariable int id,HttpServletRequest request,HttpServletResponse response) throws Exception{
		PaperSummary paper = paperSummaryService.load(id);
		//model.addAttribute(paperSummaryService.load(id));
		String fileName = paper.getFileName();
		String downLoadPath = paper.getFilePath();
		String contentType = "application/octet-stream";
		BaseUtil.download(request, response, fileName, downLoadPath, contentType);
		
	    
		return null;
	} 
	
	//���������ܽ�
	@RequestMapping(value="/{id}/update",method=RequestMethod.GET)
	public String updatePaperSummary(@PathVariable int id,Model model){
		model.addAttribute(paperSummaryService.load(id));
		model.addAttribute("Pcategory", paperCategoryService.list());
		return "/paper/updatePaper";
	}
	
	@RequestMapping(value="/{id}/update",method=RequestMethod.POST)
	public String updatePaperSummary(@PathVariable int id,@Validated PaperSummary paperSummary,BindingResult br,Model model,MultipartFile attach,HttpServletRequest hreq) throws IOException{
		if(br.hasErrors()){
			return "/paper/updatePaper";
		}
		PaperSummary uPaperSummary = paperSummaryService.load(id);
		for(int i=1;i<=10;i++){
			if(paperSummary.getSelectTest().equals(i+"") )
			{
				paperSummary.setPaperCategory(paperCategoryService.list().get(i-1));
				break;
			}
		
		}
		
		//paperSummary.setPaperCategory(paperCategoryService.list().get(0));   //���ԣ�ֱ���������Ϊ2
		
		 /*�ϴ��ļ�*/
		String realpath = hreq.getSession().getServletContext().getRealPath("/upload/paper");  //�������ļ�����·��
		//System.out.println(realpath);
		
		if(!attach.isEmpty()){			//�ж������ϴ��ļ�����Ӱ���ύ
			File file = new File(realpath+"/"+attach.getOriginalFilename());
		    FileUtils.copyInputStreamToFile(attach.getInputStream(),file);
			//System.out.println(attach.getName()+","+attach.getOriginalFilename()+","+attach.getContentType());
			//System.out.println(file.getPath());
			String path = file.getPath().toString();
			String fileName = attach.getOriginalFilename().toString();//�ϴ��ļ�����
			uPaperSummary.setFilePath(path);
			uPaperSummary.setFileName(fileName);
		}
		
	
		
		uPaperSummary.setName(paperSummary.getName());
		uPaperSummary.setPaperCategory(paperSummary.getPaperCategory());
		uPaperSummary.setKeyWords(paperSummary.getKeyWords());
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
		
		return "redirect:/paper/paperList";
	}
	
	//ɾ�������ܽ���Ŀ
	@RequestMapping(value="/{id}/delete",method=RequestMethod.GET)
	public String deletePaperSummary(@PathVariable int id,ServletRequest req,ServletResponse resq){
		HttpServletRequest hsq = (HttpServletRequest) req;
		User user = (User) hsq.getSession().getAttribute("loginUser");
		paperSummaryService.delete(id);
		return "redirect:/user/"+user.getId();
	}
	
	//���û�����ѯ�����ܽ��б�
	@RequestMapping(value="/{id}/showPaperByUser",method=RequestMethod.GET)
	public String loadByPaperUser(@PathVariable int id,Model model){
		model.addAttribute("loadByPaperUser",paperSummaryService.loadByPaperUser(id));
		return "/paper/showPaperByUser";
	}
	
	//������ѯ�����ܽ���Ŀ
	@RequestMapping(value="/{id}/showPaperByCategory",method=RequestMethod.GET)
	public String loadByPaperCategory(@PathVariable int id, Model model){
		model.addAttribute("paperCategoryShow",paperCategoryService.load(id));
		model.addAttribute("papersByCategory",paperSummaryService.loadByPaperCategory(id));
		
		return "/paper/showPaperByCategory";
	}
}
