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

	//��ȡϵͳʱ��
	public static String addDateString(){
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss E");
		Date date = new Date();
		String addDateString = dateFormat.format(date);
		return addDateString;
	}
	
	//�����ļ�
	public static void download(HttpServletRequest request,HttpServletResponse response,String fileName,String downLoadPath,String contentType) throws Exception{
		
		request.setCharacterEncoding("UTF-8");  
	    BufferedInputStream bis = null;  
	    BufferedOutputStream bos = null;  
	    //��ȡ�ļ�·��
	    //String downLoadPath = filePath;
	    //��ȡ�ļ��ĳ���
	    long fileLength = new File(downLoadPath).length();
	    //�����ļ���������
	    response.setContentType("application/octet-stream");
	    response.setHeader("Content-disposition", "attachment; filename="+ new String(fileName.getBytes("utf-8"), "ISO8859-1")); 
	    //�����������
	    response.setHeader("Content-Length", String.valueOf(fileLength));
	    //��ȡ������
	    bis = new BufferedInputStream(new FileInputStream(downLoadPath));  
	    //�����
	    bos = new BufferedOutputStream(response.getOutputStream());  
	    byte[] buff = new byte[2048];  
	    int bytesRead;  
	    while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {  
	      bos.write(buff, 0, bytesRead);  
	    }  
	    //�ر���
	    bis.close();  
	    bos.close(); 
	}

}
