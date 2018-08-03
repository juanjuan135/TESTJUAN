package com.xdl.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class GetPropertiesUtil {
	
	 public static String getUrl(String string) throws IOException {
		InputStream is= GetPropertiesUtil.class.getClassLoader().getResourceAsStream("application.properties");
		Properties pro=new Properties();
		pro.load(is);
		return pro.getProperty(string);	 
	 }
}
