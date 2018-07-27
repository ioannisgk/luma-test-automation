package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadConfigFile {
	
	protected InputStream input = null;
	protected Properties prop = null;
	
	
	// Class constructor
	public ReadConfigFile() {
		
		try {
			
			// Get properties file directory
			input = ReadConfigFile.class.getClassLoader().getResourceAsStream(Constant.CONFIG_PROPERTIES_DIRECTORY);
			prop = new Properties();
			prop.load(input);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// Method to get browser name from properties file
	public String getBrowser() {
		
		if (prop.getProperty("browser") == null) return "";
		return prop.getProperty("browser");
	}
	
	// Method to get os name from properties file
		public String getOS() {
			
			if (prop.getProperty("os") == null) return "";
			return prop.getProperty("os");
		}
}