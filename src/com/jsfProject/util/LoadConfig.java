package com.jsfProject.util;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;



public class LoadConfig {
	
	
		 
		public String getPropValues(String key) throws IOException {
	 
			String result = "";
			Properties prop = new Properties();
			String propFileName = "com/jsfProject/resources/config.properties";
	 
			InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
	 
			if (inputStream != null) {
				prop.load(inputStream);
			} else {
				throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
			}
	 
			result = prop.getProperty(key);
	
			
			return result;
		}
	}


