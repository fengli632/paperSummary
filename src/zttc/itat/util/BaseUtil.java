package zttc.itat.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BaseUtil {

	//获取系统时间
	public static String addDateString(){
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss E");
		Date date = new Date();
		String addDateString = dateFormat.format(date);
		return addDateString;
	}
	
	//下载文件
	public static void download(HttpServletRequest request,HttpServletResponse response,String fileName,String downLoadPath,String contentType) throws Exception{
		
		request.setCharacterEncoding("UTF-8");  
	    BufferedInputStream bis = null;  
	    BufferedOutputStream bos = null;  
	    //获取文件路径
	    //String downLoadPath = filePath;
	    //获取文件的长度
	    long fileLength = new File(downLoadPath).length();
	    //设置文件输入类型
	    response.setContentType("application/octet-stream");
	    response.setHeader("Content-disposition", "attachment; filename="+ new String(fileName.getBytes("utf-8"), "ISO8859-1")); 
	    //设置输出长度
	    response.setHeader("Content-Length", String.valueOf(fileLength));
	    //获取输入流
	    bis = new BufferedInputStream(new FileInputStream(downLoadPath));  
	    //输出流
	    bos = new BufferedOutputStream(response.getOutputStream());  
	    byte[] buff = new byte[2048];  
	    int bytesRead;  
	    while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {  
	      bos.write(buff, 0, bytesRead);  
	    }  
	    //关闭流
	    bis.close();  
	    bos.close(); 
	}

}
