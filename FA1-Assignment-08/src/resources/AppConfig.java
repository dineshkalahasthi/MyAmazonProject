package resources;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AppConfig {
	
	public static final Properties PROPERTIES;
	public static InputStream inputStream = null;
	
	static {
		try {
			inputStream = AppConfig.class.getResourceAsStream("configuration.properties");
		}
		catch (Exception e) {
			LogConfig.getLogger(AppConfig.class).error(e.getMessage(), e);
		}
		
		PROPERTIES = new Properties();
		
		try {
			PROPERTIES.load(inputStream);
		}
		catch (IOException e) {
			LogConfig.getLogger(AppConfig.class).error(e.getMessage(), e);
		}
	}
}
