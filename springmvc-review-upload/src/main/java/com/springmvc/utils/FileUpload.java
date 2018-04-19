package com.springmvc.utils;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

/** 
* @author 作者 wxd  
* @version 1.0
* E-mail: wangxudong@jetsen.cn
* 创建时间：2018年4月19日 下午5:20:25 
* 类说明  文件上传工具类
*/
public class FileUpload {

	/**
	 * 多文件上传(上传到服务器目录下)
	 * @param request
	 * @param files
	 * @return
	 */
	public static Map<String, Object> uploadMult(HttpServletRequest request,MultipartRequest files){
		Map<String, Object> filePahtMap = new HashMap<String, Object>();
		try {
			String pathRoot = request.getSession().getServletContext().getRealPath(""); 
			String path = "/upload/" + UUID.randomUUID().toString() +"_"; 
			Map<String, MultipartFile> fileMap = files.getFileMap();
			Set<String> keySet = fileMap.keySet();
			for (String key : keySet) {
				MultipartFile file = fileMap.get(key);
				String fileName = file.getOriginalFilename();//文件名称
				String partName = file.getName();
				if(null != fileName && fileName.length() > 0){
					file.transferTo(new File(pathRoot +path + fileName));
					//将上传的文件保存到指定的路径下
					filePahtMap.put(partName, path + fileName);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return filePahtMap;
	}
	
	/**
	 * 单文件上传(上传到服务器目录下)
	 * @param request
	 * @param file
	 * @return
	 */
	public static String uploadSignle(HttpServletRequest request,MultipartFile file){
		String filePath = null;
		try{
			String pathRoot = request.getSession().getServletContext().getRealPath(""); //获得物理路径webapp所在路径   
			if(!file.isEmpty()){  
				String fileName = file.getOriginalFilename();//文件名称
				String path = "/upload/" + UUID.randomUUID().toString() +"_"+ fileName;  
				file.transferTo(new File(pathRoot + path));  
				filePath =  path;
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return filePath;
	}
	
	
	/**
	 * 上传文件到本地磁盘(需要在tomcat的server.xml配置文件中加如下配置)
	 * <Context docBase="E:\testUpload\image" path="/testUpload/image" reloadable="false"/>
	 * 并且页面获取时不需要${basePath}
	 * @param request
	 * @param file
	 * @return
	 */
	public static String uploadToLocalDist(HttpServletRequest request,MultipartFile file){
		String filePath = null;
		String uuid = UUID.randomUUID().toString();
		try{
			if(!file.isEmpty()){  
	            String fileName = file.getOriginalFilename();//文件名称
	            String path = "E:/testUpload/image/" + uuid +"_"+ fileName;  
	            file.transferTo(new File(path));  
	            String imagesPath = "/testUpload/image/" + uuid +"_"+ fileName ;
	            filePath = imagesPath;
	        }
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return filePath;
	}
}
 