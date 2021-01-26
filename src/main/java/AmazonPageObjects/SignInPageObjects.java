package AmazonPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class SignInPageObjects {

	
	public SignInPageObjects(WebDriver driver) {
		super();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.ID,using="ap_email") private WebElement USERNAME;
	@FindBy(how=How.ID,using="continue") private WebElement SIGNIN_CONTINUE_BUTTON;
	@FindBy(how=How.ID,using="ap_password") private WebElement PASSWORD;
	@FindBy(how=How.ID,using="signInSubmit") private static WebElement SIGNIN_SUBMIT_BUTTON;
	
	
	public void UserNameAction(String userName) {
		USERNAME.clear();
		USERNAME.click();
		USERNAME.sendKeys(userName);
	}
	
	public void ClickContinue() {
		SIGNIN_CONTINUE_BUTTON.click();
	}
	public void PasswordAction(String pwd) {
		PASSWORD.clear();
		PASSWORD.clear();
		PASSWORD.sendKeys(pwd);
	}
	
public void ClickSubmitButton() {
	//SignInPageObjects signIn=(SignInPageObjects)SIGNIN_SUBMIT_BUTTON.click();
	SIGNIN_SUBMIT_BUTTON.click();
	//return signIn;
}
}
