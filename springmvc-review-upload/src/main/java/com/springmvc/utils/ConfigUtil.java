package com.springmvc.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
/** 
* @author 作者 wxd  
* @version 1.0
* E-mail: wangxudong@jetsen.cn
* 创建时间：2018年4月23日 下午7:36:03 
* 类说明  获取配置文件参数的工具类
*/
public class ConfigUtil {

	
	static Map<String, Properties> map = new HashMap();
	private ConfigUtil() {
		
	}
	
	public static Properties getProperties(Class clazz, String classpathFilename) {
		Properties properties = (Properties)map.get(classpathFilename);
		if (properties == null) {
			synchronized (Properties.class) {
				properties = new Properties();
				try {
					properties.load(clazz.getResourceAsStream(classpathFilename));
					properties.put(classpathFilename, properties);
				}catch (FileNotFoundException e) {
					e.printStackTrace();
				}catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return properties;
	}
	
	public static Properties loginProperties = getProperties(ConfigUtil.class, "/config.properties");
	
	public static int PORT = Integer.parseInt(loginProperties.getProperty("PORT"));//连接的默认端口
	public static String HOST = loginProperties.getProperty("HOST");//IP地址
	public static String USER = loginProperties.getProperty("USER");//用户名
	public static String PASSWORD = loginProperties.getProperty("PASSWORD");//密码
	public static String TARGET_URL = loginProperties.getProperty("TARGET_URL");//目标路径
	public static String FILE_SERVER_URL = loginProperties.getProperty("FILE_SERVER_URL");//远程文件服务访问路径
	
	
	
	
	public static void main(String[] args) {
		System.out.println(TARGET_URL);
	}
	
}
 