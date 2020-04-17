package com.gyhl.test.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class DownLoadFile {
	
	@RequestMapping(value = "/downloadFile", method = RequestMethod.GET)
   
    public String downloadFile(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String name ="Excel表格.xlsx";
		String downloadPath = ClassUtils.getDefaultClassLoader().getResource("").getPath();
		System.out.println(downloadPath);
//        进行转码后的文件名，用来下载之后的文件名
        String result=download(resp,name,downloadPath);
        return result;
    }
	/**
     * @param resp
     * @param name         文件真实名字
     * @param downloadName 文件下载时名字
	 * @throws IOException 
     */
    public static String download(HttpServletResponse resp, String name, String downloadPath) throws IOException {
        String filePath = null;
        try {
        	
            filePath=URLDecoder.decode(downloadPath,"UTF-8");
            System.out.println(filePath);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        //String realPath = "D:" + File.separator + "apache-tomcat-8.5.15" + File.separator + "files";
        String realPath=filePath+"static"+File.separator +"software";//项目路径下你存放文件的地方
        System.out.println("realPath="+realPath);
        String path = realPath + File.separator + name;//加上文件名称
        System.out.println("path="+path);
        File file = new File(path);
        if(!file.exists()){
        	return "文件不存在";
        	//throw new IOException("文件不存在");
        }
        name = new String(name.getBytes("GBK"), "ISO-8859-1");
        resp.reset();
        resp.setContentType("application/octet-stream");
        resp.setCharacterEncoding("utf-8");
        resp.setContentLength((int) file.length());
        resp.setHeader("Content-Disposition", "attachment;filename=" + name);
        byte[] buff = new byte[1024];
        BufferedInputStream bis = null;
        OutputStream os = null;
        try {
            os = resp.getOutputStream();
            bis = new BufferedInputStream(new FileInputStream(file));
            int i = 0;
            while ((i = bis.read(buff)) != -1) {
                os.write(buff, 0, i);
                os.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
		return "gg";
    }

}
