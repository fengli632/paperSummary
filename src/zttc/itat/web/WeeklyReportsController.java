package zttc.itat.web;

/**
 * �ܱ�ҳ��
 * @author ���
 *
 */

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
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

import zttc.itat.model.Pager;
import zttc.itat.model.PaperSummary;
import zttc.itat.model.User;
import zttc.itat.model.WeeklyReports;
import zttc.itat.service.IWeeklyReportsService;
import zttc.itat.util.BaseUtil;

@Controller
@RequestMapping("/reports")
public class WeeklyReportsController {

	private IWeeklyReportsService weeklyReportsService ;
	
/*	private ServletRequest req;
	@SuppressWarnings("unused")
	private ServletResponse resp;
	HttpServletRequest hsq = (HttpServletRequest) req;
	User loginUser = (User) hsq.getSession().getAttribute("loginUser");
	*/

	public IWeeklyReportsService getWeeklyReportsService() {
		return weeklyReportsService;
	}

	@Resource
	public void setWeeklyReportsService(IWeeklyReportsService weeklyReportsService) {
		this.weeklyReportsService = weeklyReportsService;
	}

	//�ܱ��б�
	@RequestMapping(value="/reportsListAll",method=RequestMethod.GET)
	public String reportsListAll(Model model){
		model.addAttribute("allReports",weeklyReportsService.find());
		return "/reports/reportsListAll";
	}
	
	//�ܱ��б�(ֻ�ܿ���¼�û��Լ���)
	@RequestMapping(value="/{id}/reportsList",method=RequestMethod.GET)
	public String reportsList(@PathVariable int id,Model model){
		
		Pager<WeeklyReports> reportsPager = weeklyReportsService.loadByReportsUserNoHtml(id);
		model.addAttribute("loadByReportsUser",reportsPager);
		return "/reports/reportsList";
	}
	
	//����ܱ�
	@RequestMapping(value="/addReports",method=RequestMethod.GET)
	public String addReports(Model model){
		model.addAttribute(new WeeklyReports());
		return "/reports/addReports";
	}
	
	@RequestMapping(value="/addReports",method=RequestMethod.POST)
	public String addReports(ServletRequest req,ServletResponse resq,Model model,@Validated WeeklyReports weeklyReports,BindingResult br,MultipartFile attach,HttpServletRequest hreq) throws IOException{
		System.out.println(weeklyReports.getPlan());
		if(br.hasErrors()){
			return "/reports/addReports";
		}
		
		String realpath = hreq.getSession().getServletContext().getRealPath("/upload/reports");   //�ϴ��ļ�
		System.out.println(realpath);
		if(!attach.isEmpty()){ 				//�ж������ϴ��ļ�����Ӱ���ύ��
			File file = new File(realpath+"/"+attach.getOriginalFilename());
		    FileUtils.copyInputStreamToFile(attach.getInputStream(),file);
		    String path = file.getPath().toString();
			weeklyReports.setReportsFilePath(path);
			weeklyReports.setFileName(attach.getOriginalFilename());
		}
		
		//System.out.println(attach.getName()+","+attach.getOriginalFilename()+","+attach.getContentType());
		//System.out.println(file.getPath());
		
		
		HttpServletRequest hsq = (HttpServletRequest) req;
		User user = (User) hsq.getSession().getAttribute("loginUser");
		weeklyReports.setReportsUser(user);
		weeklyReports.setTime(BaseUtil.addDateString());	//��ȡϵͳʱ��
		weeklyReportsService.add(weeklyReports);
		return "redirect:/reports/"+user.getId()+"/reportsList/";
		//return "/reports/addReports";
	}
	
	//�����ܱ�
	@RequestMapping(value="/{id}/update",method=RequestMethod.GET)
	public String updateReports(@PathVariable int id,Model model){
		model.addAttribute(weeklyReportsService.load(id));
		return "/reports/updateReports";
	}
	
	@RequestMapping(value="/{id}/update",method=RequestMethod.POST)
	public String updateReports(@PathVariable int id,Model model,@Validated WeeklyReports weeklyReports,BindingResult br,ServletRequest req,ServletResponse resq,MultipartFile attach,HttpServletRequest hreq) throws IOException{
		if(br.hasErrors()){
			return "/reports/updateReports";
		}
		WeeklyReports uWeeklyReports = weeklyReportsService.load(id);
		/*�ϴ��ļ�*/
		String realpath = hreq.getSession().getServletContext().getRealPath("/upload/reports");   //�ϴ��ļ�
		System.out.println(realpath);
		if(!attach.isEmpty()){ 				//�ж������ϴ��ļ�����Ӱ���ύ��
			File file = new File(realpath+"/"+attach.getOriginalFilename());
		    FileUtils.copyInputStreamToFile(attach.getInputStream(),file);
		    String path = file.getPath().toString();
		    uWeeklyReports.setReportsFilePath(path);
		    uWeeklyReports.setFileName(attach.getOriginalFilename());
		}
		
		HttpServletRequest hsq = (HttpServletRequest) req;
		User user = (User) hsq.getSession().getAttribute("loginUser");
		
		
		
		uWeeklyReports.setSummary(weeklyReports.getSummary());
		uWeeklyReports.setPlan(weeklyReports.getPlan());
		uWeeklyReports.setTime(weeklyReports.getTime());
		
		weeklyReportsService.update(uWeeklyReports);
		return "redirect:/reports/"+user.getId()+"/reportsList";
	}
	
	//�ܱ�����
	@RequestMapping(value="{id}/show",method=RequestMethod.GET)
	public String showReports(@PathVariable int id,Model model){
		model.addAttribute(weeklyReportsService.load(id));
		return "/reports/showReports";
	}
	
	//�����ļ�
		@RequestMapping(value="/{id}/download")
		public ModelAndView download(@PathVariable int id,HttpServletRequest request,HttpServletResponse response) throws Exception{
			WeeklyReports reports = weeklyReportsService.load(id);
			//model.addAttribute(weeklyReportsService.load(id));
			String fileName = reports.getFileName();			//��ȡ��������
			String downLoadPath = reports.getReportsFilePath();	//��ȡ����·��
			String contentType = "application/octet-stream";	
			BaseUtil.download(request, response, fileName, downLoadPath, contentType);
		      
			return null;
		} 
	
	//ɾ���ܱ�
	@RequestMapping(value="/{id}/delete",method=RequestMethod.GET)
	public String deleteReports(@PathVariable int id,ServletRequest req,ServletResponse resq){
		HttpServletRequest hsq = (HttpServletRequest) req;
		User user = (User) hsq.getSession().getAttribute("loginUser");
		weeklyReportsService.delete(id);
		return "redirect:/reports/"+user.getId()+"/reportsList";
	}
	
	//�ϴ��ܱ�
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
