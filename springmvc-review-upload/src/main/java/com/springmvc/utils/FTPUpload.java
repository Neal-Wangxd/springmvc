package com.springmvc.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;

/** 
* @author 作者 wxd  
* @version 1.0
* E-mail: wangxudong@jetsen.cn
* 创建时间：2018年4月24日 上午10:52:59 
* 类说明  使用FTP上传到远程服务的工具类
*/
public class FTPUpload {

	/** 
	* Description: 向FTP服务器上传文件 
	* @param url FTP服务器hostname 
	* @param port FTP服务器端口 
	* @param username FTP登录账号 
	* @param password FTP登录密码 
	* @param path FTP服务器保存目录 
	* @param filename 上传到FTP服务器上的文件名 
	* @param input 输入流 
	* @return 成功返回true，否则返回false 
	*/
	public static boolean uploadFile(String url,int port,String username, String password, String path, String filename, InputStream input) { 
		boolean success = false; 
		FTPClient ftp = new FTPClient(); 
		try { 
			int reply; 
			ftp.connect(url, port);//连接FTP服务器 
			//如果采用默认端口，可以使用ftp.connect(url)的方式直接连接FTP服务器 
			ftp.login(username, password);//登录 
			reply = ftp.getReplyCode(); 
			if (!FTPReply.isPositiveCompletion(reply)) { 
				ftp.disconnect(); 
				return success; 
			} 
			ftp.changeWorkingDirectory(path); 
			ftp.storeFile(filename, input); 
			input.close(); 
			ftp.logout(); 
			success = true; 
		} catch (IOException e) { 
			e.printStackTrace(); 
		} finally { 
			if (ftp.isConnected()) { 
				try { 
					ftp.disconnect(); 
				} catch (IOException ioe) { 
					ioe.printStackTrace();
				} 
			} 
		} 
		return success; 
	}
    
	/** 
	* Description: 从FTP服务器下载文件 
	* @Version. Jul , :: PM by 崔红保（cuihongbao@d-heaven.com）创建 
	* @param url FTP服务器hostname 
	* @param port FTP服务器端口 
	* @param username FTP登录账号 
	* @param password FTP登录密码 
	* @param remotePath FTP服务器上的相对路径 
	* @param fileName 要下载的文件名 
	* @param localPath 下载后保存到本地的路径 
	* @return 
	*/
	public static boolean downFile(String url, int port,String username, String password, String remotePath,String fileName,String localPath) { 
		boolean success = false; 
		FTPClient ftp = new FTPClient(); 
		try { 
			int reply; 
			ftp.connect(url, port); 
			//如果采用默认端口，可以使用ftp.connect(url)的方式直接连接FTP服务器 
			ftp.login(username, password);//登录 
			reply = ftp.getReplyCode(); 
			if (!FTPReply.isPositiveCompletion(reply)) { 
				ftp.disconnect(); 
				return success; 
			} 
			ftp.changeWorkingDirectory(remotePath);//转移到FTP服务器目录 
			FTPFile[] fs = ftp.listFiles(); 
			for(FTPFile ff:fs){ 
				if(ff.getName().equals(fileName)){ 
					File localFile = new File(localPath+"/"+ff.getName()); 
					OutputStream is = new FileOutputStream(localFile); 
					ftp.retrieveFile(ff.getName(), is); 
					is.close(); 
				} 
			} 
			ftp.logout(); 
			success = true; 
		} catch (IOException e) { 
			e.printStackTrace(); 
		} finally { 
			if (ftp.isConnected()) { 
				try { 
					ftp.disconnect(); 
				} catch (IOException ioe) { 
					ioe.printStackTrace();
				} 
			} 
		} 
		return success; 
	}
    
    @org.junit.Test
    public void Test(){
    	String ftpHost = "192.168.44.130";
        String ftpUserName = "root";
        String ftpPassword = "ZAQ!XSW@cde3vfr4";
        int ftpPort = 21;
        String ftpPath = "/home/tomcat/apache-tomcat-8.5.30-8080/webapps/upload";
        String localPath = "C:\\Users\\wxd\\Desktop\\1.png";
        String fileName = "1234.png";
        try {
        	FileInputStream in=new FileInputStream(new File(localPath));
        	boolean flag = uploadFile(ftpHost, ftpPort, ftpUserName, ftpPassword, ftpPath, fileName, in);
        	System.out.println(flag);
        } catch (FileNotFoundException e) {
        	e.printStackTrace();
        }
    }

}
 