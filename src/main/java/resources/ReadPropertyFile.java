package resources;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertyFile {
	
	public static Object getProperty(String key) throws IOException {
		
		FileInputStream file=new FileInputStream(new File("src/main/java/resources/config.properties").getAbsolutePath());
		Properties prop=new Properties();
		prop.load(file);
		return prop.get(key);
	}

}
