package reporting;
import java.io.File;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.status.StatusLogger;

public class LogConfig {

	static {
		StatusLogger.getLogger().setLevel(Level.OFF);
	   // System.out.println(LogConfig.class.getResource("src/main/resources/log4j2.xml").getPath());
		String configPath=LogConfig.class.getResource("/log4j/log4j2.xml").getPath().toLowerCase();
		//String configPath= new File(LogConfig.class.getResource("/utilities/log4j2.xml").getPath());
		//System.out.println(configPath);
		//String configPath=LogConfig.class.getResource("/log4j2.properties").getPath();
		((LoggerContext) LogManager.getContext(false)).setConfigLocation(new File(configPath).toURI());
	}
	
	public static Logger getLogger(Class<?> clazz) {
		return LogManager.getLogger(clazz);
	}
}
