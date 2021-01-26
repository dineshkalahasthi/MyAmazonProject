package AmazonPageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AmazonHomeObjects {
	
WebDriver driver;
Actions action;
	public AmazonHomeObjects(WebDriver driver) {
		super();
		action=new Actions(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.ID,using="nav-link-accountList-nav-line-1") private WebElement SIGN_IN_GLOBAL_LINK;
	@FindBy(how=How.ID,using="nav-flyout-ya-signin") private WebElement SIGN_IN_FLYOUT_BUTTON;
	@FindBy(how=How.XPATH,using="//div[@id='nav-tools']/a[2]") private WebElement YOUR_ACCOUNT_NAV;
	@FindBy(how=How.ID,using="nav-item-signout") private WebElement SIGNOUT;
	@FindBy(how=How.ID,using="searchDropdownBox") private WebElement ALL_DROPDOWN;
	
	
	public void GlobalSignInAction(String action) {
		//SignInPageObjects sigin = null;
		switch(action.toLowerCase()) {
		case "click":
			SIGN_IN_GLOBAL_LINK.click();
			break;
		case "displayed":
			SIGN_IN_GLOBAL_LINK.isDisplayed();
			break;
		}
	}
	
	public void ClickSignInFlyout() {
		SIGN_IN_FLYOUT_BUTTON.click();
	}
	
	public void ClickYourAccount() {
		YOUR_ACCOUNT_NAV.click();
	}
	
	public void ClickSignout() {
		action.moveToElement(YOUR_ACCOUNT_NAV).moveToElement(SIGNOUT).click().build().perform();
	}
	public void SelectAllDropdown() {
		Select sel=new Select(ALL_DROPDOWN);
		List<WebElement> opt=sel.getOptions();
		for(WebElement i:opt) {
			i.getText();
		}
		opt.get(1).getText();
	}
}
