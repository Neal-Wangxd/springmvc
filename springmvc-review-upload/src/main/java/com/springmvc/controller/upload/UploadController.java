package com.springmvc.controller.upload;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

import com.springmvc.utils.FileUpload;

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
	public String uploadGo(HttpServletRequest request,MultipartFile file,Model modle) throws Exception{
        /*String pathRoot = request.getSession().getServletContext().getRealPath(""); //获得物理路径webapp所在路径   
        if(!file.isEmpty()){  
            String fileName = file.getOriginalFilename();//文件名称
            String path = "/upload/" + UUID.randomUUID().toString() +"_"+ fileName;  
            file.transferTo(new File(pathRoot + path));  
            modle.addAttribute("imagesPath", path);
        }*/
        String imagesPath = FileUpload.uploadSignle(request, file);
        modle.addAttribute("imagesPath", imagesPath);
		return "/upload/uploadShow";
	}
	
	@RequestMapping("/upload")
	public String upload(){
		return "/upload/upload";
	}
	
	@RequestMapping("/uploadMut")
	public String uploadMut(){
		return "/upload/uploadMut";
	}
	
	
	@RequestMapping("/testUploadMut")
	public String uploadMutGo(HttpServletRequest request,MultipartRequest files,Map<String, Object> fileMap) throws Exception{
		Map<String, Object> filepaths = FileUpload.uploadMult(request, files);
		System.out.println(filepaths);
		fileMap.put("imagesPathList", filepaths);
		return "/upload/uploadShowMut";
	}
	
}
 