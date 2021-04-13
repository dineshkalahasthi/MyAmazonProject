package com.maven.Amazon.AmazonProject;

import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestRunner {

//	@SuppressWarnings("deprecation")
//	public static void main(String[] args) {
//		//ReportNGUtils report=new ReportNGUtils();
//		ExtentReports ext=new ExtentReports("/test-output/ExtentReport");
//		// TODO Auto-generated method stub
//TestNG testng=new TestNG();
//testng.setTestClasses(new Class[] {SignInTest.class});
//testng.addListener(ext);
//		testng.run();
//	}
	
//	public static int wordcount(String str) {
//		int count=1;
//		String nstr=str.trim();
//		System.out.println(nstr+ + nstr.length());
//		for(int i=0;i<nstr.length();i++) {
//			if(nstr.charAt(i)==' ') {
//				count++;
//			}
//		}
//		//count++;
//		return count;
//	}
	public static void main(String[] args) throws InterruptedException {
		
		//TestRunner.wordcount("How are you doing by too");
//		System.out.println(TestRunner.wordcount("  How are you doing How are you doing by to "));
//		System.out.println("How are you doing How are you doing by to ");
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver","/Users/dineshkalahasthi/Drivers/chromedriver_87");
		//System.out.println("Broswer");
		//DesiredCapabilities cap=DesiredCapabilities.chrome();
		//cap.setCapability(CapabilityType.UNHANDLED_PROMPT_BEHAVIOUR,unhandledPromptBehavior.IGNORE);
		driver=new SafariDriver();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		//driver.get("https://ces-cms-dev2.theceshop.com/indiana/pre-licensing/in-broker-pre-licensing-cost");
		driver.get("https://www.theceshop.com/indiana/pre-licensing/in-broker-pre-licensing-cost");
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//*[@id='block-generalsection-1689']//button)[1]")).click();
		Thread.sleep(5000);
		//Set<String> windows=driver.getWindowHandles();
		//System.out.println(windows);
		//driver.navigate().refresh();
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,300)");
		WebElement promo=driver.findElement(By.xpath("(//*[@id='collapsePromo']/div[1]/input)[1]"));
		//WebElement promo=driver.findElement(By.xpath("(//*[@id='collapsePromo']/div[1]/input)[1]"));
		promo.sendKeys("Dinesh");
//		jse.executeScript("arguments[0].click();", promo);
		jse.executeScript("arguments[0].value='Dinesh';", promo);
		WebDriverWait wait=new WebDriverWait(driver, 20);
		//wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.flex.promobox > input"))).sendKeys("Dinesh");
		Actions action=new Actions(driver);
		
//		action.moveToElement(promo).click();
//		action.sendKeys("Dinesh").build().perform();
		
		//driver.findElement(By.xpath("//*[@id='collapsePromo']/div/input")).click();
		//driver.findElement(By.tagName("input[ng-model='promo']"));
		//driver.findElement(By.xpath("(//div[@id='collapsePromo'])[1]")).sendKeys("Dinesh");;
//		for (int i=0;i<=15;i++)
//			{
//			action.sendKeys(Keys.TAB);
//			}
//		action.sendKeys("Dinesh");
		//action.sendKeys("Dinesh").build().perform();
//		NgWebDriver ngDriver=new NgWebDriver((JavascriptExecutor) driver);
//		ngDriver.waitForAngularRequestsToFinish();
		//driver.findElement(ByAngular.model("promo")).sendKeys("Dinesh");
		//WebElement popup=driver.findElement(By.cssSelector(".PopupCloseButton__"));
		//wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector(".PopupCloseButton__")))).click();
		driver.findElement(By.cssSelector("#block-navbarblock > div > nav.tier1 > ul > li.upgradelicense > a")).getAttribute("href");
		action.sendKeys(Keys.ESCAPE);action.sendKeys(Keys.TAB);
		//String checkout=driver.findElement(By.xpath("//*[@id='block-carthome']//aside/div/div[2]/div[3]/button")).getText();
		//System.out.println(checkout);
				action.sendKeys(Keys.chord("Dinesh"));
		//jse.executeScript("document.getElementById('collapsePromo').click();");
		//driver.findElement(By.xpath("(//div[@id='collapsePromo'])[1]")).sendKeys("Dinesh");; 
		//wait.until(ExpectedConditions.visibilityOf(promo));  
		//wait.until(ExpectedConditions.elementToBeClickable(promo));
		//action.moveByOffset(7,-3).click().build().perform();
		//action.contextClick();
		//action.moveToElement(promo).sendKeys("Dinesh");
		Thread.sleep(5000);
		//jse.executeScript("WebElement element = document.querySelector('(//div[@id='collapsePromo'])[1]'); element.value = 'whatever';") ;
		//javascript.executeScript("var element = document.querySelector('input[]'); element.value = 'whatever';")
		//jse.executeScript("document.getElementById('collapsePromo').value='Selenium';");
//		String s = (String) jse.executeScript("return document.getElementById('collapsePromo').value");
//	      System.out.print("Value entered in hidden field: " +s);
		//jse.executeScript("document.getElementsByClassName('form-control ng-pristine ng-untouched ng-valid ng-empty')[0].click();");
//		WebElement e=driver.findElement(By.cssSelector("div.flex.promobox"));
//		e.findElement(By.tagName("input")).sendKeys("Dinesh");
//	      jse.executeScript("document.getElementsByClassName('form-control ng-pristine ng-untouched ng-valid ng-empty')[0].innerHTML='Dinesh';");
		//jse.executeScript("document.getElementsByTagName('input')[9].value='Dinesh';");
		//jse.executeScript("arguments[0].setAttribute('value','Dinesh')",promo);
//		jse.executeScript("document.getElementsByClassName('btn btn-primary ced-btn-med')[0].input.value='Dinesh';");
		//jse.executeScript("document.querySelector('#collapsePromo > div.flex.promobox > input').click();");
		//jse.executeScript("document.querySelector('#collapsePromo > div.flex.promobox > input').Value='Dinesh';");
		//javascript error: Cannot set property 'innerHTML' of null OR 
		//javascript error: Cannot set property 'value' of null
		jse.executeScript("document.getElementsByClassName('form-control ng-pristine ng-untouched ng-valid ng-empty')[0].setAttribute('ng-model', 'Dinesh');");
		jse.executeScript("document.querySelector('#collapsePromo > div.flex.promobox > button').click();");
		//WORKING - jse.executeScript("document.getElementsByClassName('btn btn-primary ced-btn-med')[0].click();"); 

	}

}
