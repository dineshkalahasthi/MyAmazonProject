package amazonTestCases;

import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import AmazonPageObjects.AmazonHomeObjects;
import AmazonPageObjects.SignInPageObjects;
import resources.LogConfig;
import utilities.SeleniumWebDriverFactory;

public class SignInTest extends SeleniumWebDriverFactory {

	public static Logger log=LogConfig.getLogger(SignInTest.class);

	@Test(description = "Verify Amazon Sign In is successful:")
	public void ValidateTestSignIn() {
		AmazonHomeObjects home = new AmazonHomeObjects(driver);
		log.info("Title of the page : " + driver.getTitle());
		home.GlobalSignInAction("click");
		SignInPageObjects signIn = new SignInPageObjects(driver);
		signIn.UserNameAction("kalahasthi.dinesh10@gmail.com");
		signIn.ClickContinue();
		signIn.PasswordAction("Amazon@123");
		log.info("User logging in");
		
//		signIn.ClickSubmitButton();
//		log.info(driver.getTitle() + " After clicking on login button ");
//		//Assert.assertEquals(driver.getTitle()," Your Amazon.in");
//				//"Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");
//		home.ClickSignout();
//		Assert.assertEquals(driver.getTitle(),"Amazon Sign In");
	}

	//@Test(description = "Amazon Sign In fail test:")
	public void ValidateTestSignInFail() {
		AmazonHomeObjects home = new AmazonHomeObjects(driver);
		log.info("Title of the page : " + driver.getTitle());
		home.GlobalSignInAction("click");
		SignInPageObjects signIn = new SignInPageObjects(driver);
		signIn.UserNameAction("kalahasthi.dinesh10@gmail.com");
		signIn.ClickContinue();
		signIn.PasswordAction("Amazon@12");
		log.info("User logging in");
		signIn.ClickSubmitButton();
		log.info(driver.getTitle() + " After clicking on login button ");
		Assert.assertEquals(driver.getTitle(),"Amazon Sign In");
		log.info("Login Failes , due to incorrect password");
	}
}
