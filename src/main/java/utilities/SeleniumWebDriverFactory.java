package utilities;

import java.io.IOException;
import java.net.URL;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import resources.LogConfig;
import resources.SuiteConfiguration;
import ru.stqa.selenium.factory.WebDriverPool;

public class SeleniumWebDriverFactory extends BaseDriver {

	// public static Logger
	// log=LogConfig.getLogger(SeleniumWebDriverFactory.class.getClass());
	// LogConfig.getLogger(SeleniumWebDriverFactory.class);
	// public static WebDriver driver;
	protected static URL gridHubUrl = null;
	protected static String baseUrl;
	protected static Capabilities capabilities;

	// protected WebDriver driver;
	public SeleniumWebDriverFactory() {
		super();
		SeleniumWebDriverFactory.log = LogConfig.getLogger(SeleniumWebDriverFactory.class);
	}

	public void setDriver(WebDriver driver) throws IOException {
		BaseDriver.driver = initiateDriver(driver);
	}

	public static WebDriver getCurrentDriver() {
		return driver;
	}

	@BeforeSuite
	  public void initTestSuite() throws IOException {
	    SuiteConfiguration config = new SuiteConfiguration("/debug.properties");
	    baseUrl = config.getProperty("site.url");
	   // System.out.println(baseUrl);
	    if (config.hasProperty("grid.url") && !"".equals(config.getProperty("grid.url"))) {
	      gridHubUrl = new URL(config.getProperty("grid.url"));
	    }
	    capabilities = config.getCapabilities();
	   // System.out.println(capabilities);
	  }

//	  @BeforeMethod
//	  public void initWebDriver() {
//	    //driver = WebDriverPool.DEFAULT.getDriver(gridHubUrl, capabilities);
//	    driver = WebDriverPool.DEFAULT.getDriver(capabilities);
//	  }

	@BeforeMethod
	public void BeforeMehod() throws IOException {
		setDriver(driver);
		driver = getCurrentDriver();
		log.info("Driver initated");
		// System.out.println(baseUrl);
		driver.get(baseUrl);
		//System.setProperty("org.freemarker.loggerLibrary", "none");
//		 extent=new ExtentReports("/ExtentReports.html");
//		 test=extent.startTest(this.getClass().toString());
	}

	@AfterMethod
	public void AfterMethod(ITestResult result) {
		driver.quit();
		// driver.getTitle();
		//extent.endTest(test);
		//report.buildTestNodes(, status);
	}

	// @AfterMethod
//	public void AfterMethod() {
//		log.info("");
//	}

	@AfterSuite(alwaysRun = true)
	public void AfterSuite(ITestContext context) {
//		ExtentReportNG rep = new ExtentReportNG();
//		rep.generateReport(xmlSuite.);
//		System.out.println(context.getSuite().toString());
		WebDriverPool.DEFAULT.dismissAll();
	}
}
