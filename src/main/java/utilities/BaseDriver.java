package utilities;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import reporting.LogConfig;
import resources.ReadPropertyFile;

public class BaseDriver {

	public static WebDriver driver;
	public static Logger log=LogConfig.getLogger(BaseDriver.class);
	//public static Logger log=LogManager.getLogger(BaseDriver.class);
	static String path="/resources/log4j2.xml";
	
//	public BaseDriver(WebDriver driver) {
//		this.driver=driver;
//	}
	
	public static WebDriver setBrowserDriver(WebDriver driver) throws IOException {
		String Browser=ReadPropertyFile.getProperty("Browser").toString().toLowerCase();
		//System.out.println(Browser);
		switch(Browser) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver","/Users/dineshkalahasthi/Drivers/chromedriver");
			//System.out.println("Broswer");
			driver=new ChromeDriver();
			break;

//		case "firefox":
//			System.setProperty("webdriver.firefox.driver", "");
//			driver=new FirefoxDriver();
//			break;
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver;
	}
	
	public static WebDriver initiateDriver(WebDriver driver) throws IOException {
		return setBrowserDriver(driver);		
	}
}
