package com.springmvc.controller.upload;

import java.io.File;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/** 
* @author 作者 wxd  
* @version 1.0
* E-mail: wangxudong@jetsen.cn
* 创建时间：2018年4月19日 上午10:13:35 
* 类说明 
*/

@Controller
@RequestMapping("/upload")
public class UploadController {

	@RequestMapping("/testUpload")
	@ResponseBody
	public String uploadGo(MultipartFile file) throws Exception{
		String fileName = file.getOriginalFilename();//文件名称
		String paramName = file.getName();//文件传递时的名称（页面传递的名称）
		String path = "E:/testUpload/" + fileName;
		File filePath = new File(path);
		file.transferTo(filePath);
		System.out.println(fileName);
		System.out.println(paramName);
		return "SUCCESS";
	}
	
	
	@RequestMapping("/upload")
	public String upload(){
		return "/upload/upload";
	}
	
}
 