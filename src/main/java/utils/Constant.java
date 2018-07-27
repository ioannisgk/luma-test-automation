package utils;

public class Constant {

	// Configuration properties file
	public final static String CONFIG_PROPERTIES_DIRECTORY = "properties/config.properties";
	
	// Drivers directories for linux systems
	public final static String CHROME_DRIVER_DIRECTORY_LINUX = System.getProperty("user.dir") + "/src/test/java/resources/other/chromedriver";
	public final static String GECKO_DRIVER_DIRECTORY_LINUX = System.getProperty("user.dir") + "/src/test/java/resources/other/geckodriver";
	public final static String IE_DRIVER_DIRECTORY_LINUX = System.getProperty("user.dir") + "/src/test/java/resources/other/IEDriverServer";
	public final static String FIREFOX_BINARY_DIRECTORY_LINUX = "/opt/firefox/firefox-bin";
	
	// Drivers directories for windows systems
	public final static String CHROME_DRIVER_DIRECTORY_WINDOWS = System.getProperty("user.dir") + "\\src\\test\\java\\resources\\other\\chromedriver.exe";
	public final static String GECKO_DRIVER_DIRECTORY_WINDOWS = System.getProperty("user.dir") + "\\src\\test\\java\\resources\\other\\geckodriver.exe";
	public final static String IE_DRIVER_DIRECTORY_WINDOWS = System.getProperty("user.dir") + "\\src\\test\\java\\resources\\other\\IEDriverServer.exe";
	public final static String FIREFOX_BINARY_DIRECTORY_WINDOWS = "";
}