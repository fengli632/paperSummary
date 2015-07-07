package zttc.itat.web;

import java.io.File;
import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.portlet.ModelAndView;

import zttc.itat.model.Inform;
import zttc.itat.model.User;
import zttc.itat.model.WeeklyReports;
import zttc.itat.service.IInformService;
import zttc.itat.util.BaseUtil;

@Controller
@RequestMapping("/inform")
public class InformController {
	
	private IInformService informService;

	public IInformService getInformService() {
		return informService;
	}
	@Resource
	public void setInformService(IInformService informService) {
		this.informService = informService;
	}
	
	//通知列表
	@RequestMapping(value="/informList",method=RequestMethod.GET)
	public String informList(Model model){
		model.addAttribute("informList",informService.findNoHtml());
		return "/inform/informList";
	}
	
	//添加通知
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String informAdd(Model model){
		model.addAttribute(new Inform());
		return "/inform/addInform";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String informAdd(ServletRequest req,ServletResponse resq,Model model,@Validated Inform inform,BindingResult br,MultipartFile attach,HttpServletRequest hreq) throws IOException{
		if(br.hasErrors()){
			return "/inform/addInform";
		}
		
		String realpath = hreq.getSession().getServletContext().getRealPath("/upload/inform");   //上传文件
		System.out.println(realpath);
		if(!attach.isEmpty()){ 				//判断若不上传文件，不影响提交。
			File file = new File(realpath+"/"+attach.getOriginalFilename());
		    FileUtils.copyInputStreamToFile(attach.getInputStream(),file);
		    String path = file.getPath().toString();
		    inform.setInfoFilePath(path);
		    inform.setInfoFileName(attach.getOriginalFilename());
		}
		
		//System.out.println(attach.getName()+","+attach.getOriginalFilename()+","+attach.getContentType());
		//System.out.println(file.getPath());
			
		HttpServletRequest hsq = (HttpServletRequest) req;
		User user = (User) hsq.getSession().getAttribute("loginUser");
		inform.setInfoUser(user);
		inform.setInfoTime(BaseUtil.addDateString());	//存入当前时间
		informService.add(inform);
		return "redirect:/inform/informList";
	}
	
	//通知详情
	@RequestMapping(value="/show/{id}",method=RequestMethod.GET)
	public String showInform(@PathVariable int id,Model model){
		model.addAttribute(informService.load(id));
		return "/inform/showInform";
	}
	
	//下载文件
	@RequestMapping(value="/download/{id}")
	public ModelAndView download(@PathVariable int id,HttpServletRequest request,HttpServletResponse response) throws Exception{
		Inform inform = informService.load(id);
		//model.addAttribute(weeklyReportsService.load(id));
		String fileName = inform.getInfoFileName();			//获取附件名称
		String downLoadPath = inform.getInfoFilePath();	//获取附件路径
		String contentType = "application/octet-stream";	
		BaseUtil.download(request, response, fileName, downLoadPath, contentType);
	      
		return null;
	} 
	
	//更新通知
	@RequestMapping(value="/admin/update/{id}",method=RequestMethod.GET)
	public String updateInform(@PathVariable int id,Model model){
		model.addAttribute(informService.load(id));
		return "/inform/updateInform";
	}
	
	@RequestMapping(value="/admin/update/{id}",method=RequestMethod.POST)
	public String updateInform(@PathVariable int id,Model model,@Validated Inform inform,BindingResult br,MultipartFile attach,HttpServletRequest hreq) throws IOException{
		if(br.hasErrors()){
			return "/inform/informUpdate";
		}
		Inform uInform = informService.load(id);
		/*上传文件*/
		String realpath = hreq.getSession().getServletContext().getRealPath("/upload/inform");   //上传文件
		System.out.println(realpath);
		if(!attach.isEmpty()){ 				//判断若不上传文件，不影响提交。
			File file = new File(realpath+"/"+attach.getOriginalFilename());
		    FileUtils.copyInputStreamToFile(attach.getInputStream(),file);
		    String path = file.getPath().toString();
		    System.out.println("新上传文件路径-----"+path);
		    System.out.println("新上传文件名称-----"+attach.getOriginalFilename());
		    uInform.setInfoFilePath(path);
		    uInform.setInfoFileName(attach.getOriginalFilename());
		}
			
		uInform.setInfoTitle(inform.getInfoTitle());
		uInform.setInfoContent(inform.getInfoContent());
		uInform.setInfoFilePath(inform.getInfoFilePath());
		uInform.setInfoTime(BaseUtil.addDateString()); //存入当前时间
		informService.update(uInform);
		return "redirect:/inform/informList";
	}
	
	//删除通知
	@RequestMapping(value="/admin/delete/{id}",method=RequestMethod.GET)
	public String deleteInform(@PathVariable int id){
		informService.delete(id);
		return "redirect:/inform/informList";
	}
}
