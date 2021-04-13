package amazonTestCases;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class CEshop {
	// kavya.kovid0206@gmail.com
	@Test
	public void addCreditsInDashboard() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "/Users/dineshkalahasthi/Drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.theceshop.com/dashboard/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		Thread.sleep(4000);
		driver.findElement(By.xpath("//input[@name='email']")).click();
		driver.findElement(By.name("email")).sendKeys("kavyasri.pantangi@theceshop.com");
		driver.findElement(By.name("password")).sendKeys("kavyakavas");
		WebElement signinButton = driver.findElement(By.xpath("//button[@name='sub_login']"));
		signinButton.click();

		WebElement customercareLink = driver.findElement(By.xpath("//span[text()='Customer Care']"));
		customercareLink.click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Customer Search")).click();
		WebElement customerEmailAddress = driver.findElement(By.id("email_address"));
		customerEmailAddress.sendKeys("kavya.kovid0206@gmail.com");
		Thread.sleep(5000);
		WebElement searchButton = driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
		searchButton.click();
		wait.until(ExpectedConditions
				.visibilityOf(driver.findElement(By.xpath("//*[@id='student_list']//a[@onclick='getuser(946899)']"))));

		driver.findElement(By.xpath("//*[@id='student_list']//a[@onclick='getuser(946899)']")).click();// customer id

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1500)");
		Thread.sleep(5000);
		driver.switchTo().frame("student_detail_frame");
		wait.until(ExpectedConditions.visibilityOf(
				driver.findElement(By.xpath("//*[@id='customer_giftcards_results_wrapper']//descendant::button"))));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
				driver.findElement(By.xpath("//*[@id='customer_giftcards_results_wrapper']//descendant::button")));
		driver.findElement(By.xpath("//*[@id='customer_giftcards_results_wrapper']//descendant::button")).click();
		Select sel = new Select(driver.findElement(By.id("DTE_Field_giftcard_type")));
		sel.selectByValue("2");
		driver.findElement(By.id("DTE_Field_amount")).sendKeys("27");
		driver.findElement(By.xpath("//div[@class='DTE_Form_Buttons']//descendant::button")).click();
		driver.switchTo().defaultContent();

	}
	
	@Test
	public void verifyApplyCredits() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/dineshkalahasthi/Drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.theceshop.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		Thread.sleep(4000);
		driver.findElement(By.xpath("//li/a[text()=' Log In']")).click();
		//driver.findElement(By.id("emailId")).click();
		driver.findElement(By.id("emailId")).sendKeys("kavyasri.pantangi@theceshop.com");
		driver.findElement(By.id("passwordId")).sendKeys("kavyakavas");
		driver.findElement(By.xpath("//div/button[@type='submit']")).click();
		driver.get("https://www.theceshop.com/indiana/pre-licensing/in-broker-pre-licensing-cost");
		Thread.sleep(5000);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
				driver.findElement(By.xpath("(//*[@id='block-generalsection-1689']//button)[1]")));
		driver.findElement(By.xpath("(//*[@id='block-generalsection-1689']//button)[1]")).click();
		//WebElement GO_TO_CART=driver.findElement(By.xpath("//div[@class='modal-dialog modal-sm']//button[2]"));
		Wait<WebDriver> w=new FluentWait<WebDriver>(driver).withTimeout(10,TimeUnit.SECONDS)
				.pollingEvery(3, TimeUnit.SECONDS).ignoring(org.openqa.selenium.NoSuchElementException.class);
		//w.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//div[@class='modal-dialog modal-sm']//button[2]"))));
		//WebElement ele=w.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//div[@class='modal-dialog modal-sm']//button[2]"))));
		try {
		if(driver.findElements(By.xpath("//div[@class='modal-dialog modal-sm']//button[2]")).size() >0) {
			driver.findElement(By.xpath("//div[@class='modal-dialog modal-sm']//button[2]")).click();
		}
		}catch(NoSuchElementException e) {}
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//div[@class='promo-credits']/div[2]/label)[2]"))));
		driver.findElement(By.xpath("(//div[@class='promo-credits']/div[2]/label)[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='collapseCreditsWeb']/button[text()='Apply Credits']")).click();
		//driver.findElement(By.xpath("(//div[@class='promo-credits']/div)[3]/div/input")).click();
	}
}