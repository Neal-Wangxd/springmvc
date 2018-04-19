package com.springmvc.controller.upload;

import java.io.File;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

/** 
* @author 作者 wxd  
* @version 1.0
* E-mail: wangxudong@jetsen.cn
* 创建时间：2018年4月19日 上午10:13:35 
* 类说明   文件上传
*/

@Controller
@RequestMapping("/upload")
public class UploadController {

	@RequestMapping("/testUpload")
	public String uploadGo(HttpServletRequest request,
			HttpServletResponse response,MultipartFile file,Model modle) throws Exception{
		ServletContext sc = request.getServletContext();
		String path = sc.getRealPath("/upload");
		String fileName = file.getOriginalFilename();//文件名称
		File filePath = new File(path +"/"+ UUID.randomUUID().toString()+"_"+ fileName);
		file.transferTo(filePath);//将上传的文件保存到指定的路径下
		String imagesPath = filePath.toString();
		System.out.println(imagesPath);
		modle.addAttribute("imagesPath", imagesPath);
		return "/upload/uploadShow";
	}
	
	@RequestMapping("/upload")
	public String upload(){
		return "/upload/upload";
	}
	
}
 