package com.springmvc.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.io.IOUtils;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;

/** 
* @author 作者 wxd  
* @version 1.0
* E-mail: wangxudong@jetsen.cn
* 创建时间：2018年4月23日 下午5:54:55 
* 类说明  sftp上传文件工具类
*/
public class SFTPUpload {

	
    private ChannelSftp sftp;  
        
    private Session session;  
    /** FTP 登录用户名*/    
    private String username;  
    /** FTP 登录密码*/    
    private String password;  
    /** 私钥 */    
    private String privateKey;  
    /** FTP 服务器地址IP地址*/    
    private String host;  
    /** FTP 端口*/  
    private int port;  
	
    
    /**  
     * 构造基于密码认证的sftp对象  
     * @param userName  
     * @param password  
     * @param host  
     * @param port  
     * @return 
     */    
    public SFTPUpload(String username, String password, String host, int port) {  
        this.username = username;  
        this.password = password;  
        this.host = host;  
        this.port = port;  
    }  
    
    
    /**  
     * 构造基于秘钥认证的sftp对象 
     * @param userName 
     * @param host 
     * @param port 
     * @param privateKey 
     */  
    public SFTPUpload(String username, String host, int port, String privateKey) {  
        this.username = username;  
        this.host = host;  
        this.port = port;  
        this.privateKey = privateKey;  
    }  
    
    public SFTPUpload(){
    	
    }  
    
    /** 
     * 连接sftp服务器 
     * 
     * @throws Exception  
     */  
    public void login(){  
        try {  
            JSch jsch = new JSch();  
            if (privateKey != null) {  
                jsch.addIdentity(privateKey);// 设置私钥  
                System.out.println(String.format("sftp connect,path of private key file：{}" , privateKey));
            } 
            System.out.println(String.format("sftp connect by host:{} username:{}",host,username));  
            session = jsch.getSession(username, host, port); 
            System.out.println("Session is build");
            if (password != null) {  
                session.setPassword(password);    
            }  
            Properties config = new Properties();  
            config.put("StrictHostKeyChecking", "no");  
            session.setConfig(config);  
            session.connect(); 
            System.out.println("Session is connected");
            Channel channel = session.openChannel("sftp");  
            channel.connect();  
            System.out.println("channel is connected");  
            sftp = (ChannelSftp) channel;  
            System.out.println(String.format("sftp server host:[%s] port:[%s] is connect successfull", host, port));
        } catch (JSchException e) {  
        	e.printStackTrace();
        	System.out.println("Cannot connect to specified sftp server");
        }  
    }    
    
    /** 
     * 关闭连接 server  
     */  
    public void logout(){  
        if (sftp != null) {  
            if (sftp.isConnected()) {  
                sftp.disconnect();  
                System.out.println("sftp is closed already");
            }  
        }  
        if (session != null) {  
            if (session.isConnected()) {  
                session.disconnect();  
                System.out.println("sshSession is closed already");  
            }  
        }  
    }  
    
    
    /**  
     * 将输入流的数据上传到sftp作为文件  
     * @param directory   上传到该目录  
     * @param sftpFileName   sftp端文件名  
     * @param in  输入流  
     * @throws SftpException   
     * @throws Exception  
     */    
    public void upload(String directory, String sftpFileName, InputStream input) throws SftpException{  
        try {    
            sftp.cd(directory);  
        } catch (SftpException e) { 
        	System.out.println("directory is not exist");  
        	e.printStackTrace();
            sftp.mkdir(directory);  
            sftp.cd(directory);  
        }  
        sftp.put(input, sftpFileName);  
        System.out.println(String.format("file:{} is upload successful" , sftpFileName));  
    }  
    
    /** 
     * 下载文件  
     * 
     * @param directory  下载目录  
     * @param downloadFile  下载的文件 
     * @param saveFile  存在本地的路径 
     * @throws SftpException 
     * @throws FileNotFoundException 
     * @throws Exception 
     */    
    public void download(String directory, String downloadFile, String saveFile) throws SftpException, FileNotFoundException{  
        if (directory != null && !"".equals(directory)) {  
            sftp.cd(directory);  
        }  
        File file = new File(saveFile);  
        sftp.get(downloadFile, new FileOutputStream(file));  
        System.out.println(String.format("file:{} is download successful" , downloadFile));  
    }  
    
    /**  
     * 下载文件 
     * @param directory 下载目录 
     * @param downloadFile 下载的文件名 
     * @return 字节数组 
     * @throws SftpException 
     * @throws IOException 
     * @throws Exception 
     */  
    public byte[] download(String directory, String downloadFile) throws SftpException, IOException{  
        if (directory != null && !"".equals(directory)) {  
            sftp.cd(directory);  
        }  
        InputStream is = sftp.get(downloadFile);  
        byte[] fileData = IOUtils.toByteArray(is);  
        System.out.println(String.format("file:{} is download successful" , downloadFile));  
        return fileData;  
    }  
    
    /** 
     * 删除文件 
     *   
     * @param directory  要删除文件所在目录 
     * @param deleteFile   要删除的文件 
     * @throws SftpException 
     * @throws Exception 
     */  
    public void delete(String directory, String deleteFile) throws SftpException{  
        sftp.cd(directory);  
        sftp.rm(deleteFile);  
    }
    /**  
     * 上传单个文件 
     * @param directory   上传到sftp目录  
     * @param uploadFile  要上传的文件,包括路径  
     * @throws FileNotFoundException 
     * @throws SftpException 
     * @throws Exception 
     */  
    public void upload(String directory, String uploadFile) throws FileNotFoundException, SftpException{  
        File file = new File(uploadFile);  
        upload(directory, file.getName(), new FileInputStream(file));  
    }

}
 