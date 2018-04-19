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
	 * 多文件上传
	 * @param request
	 * @param files
	 * @return
	 */
	public static Map<String, Object> uploadMult(HttpServletRequest request,MultipartRequest files){
		Map<String, Object> filePahtMap = new HashMap<String, Object>();
		try {
			String pathRoot = request.getSession().getServletContext().getRealPath(""); 
			//String path = "E:\\testUpload\\image\\";//sc.getRealPath("/upload");
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
	 * 单文件上传
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
}
 