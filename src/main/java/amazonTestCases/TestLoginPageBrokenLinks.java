package amazonTestCases;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import utilities.SeleniumWebDriverFactory;

public class TestLoginPageBrokenLinks extends SeleniumWebDriverFactory{

	@Test(description="Verify all the links in login page and return the list of broken links")
	public void verifyLoginPageBrokenLinks() throws IOException {
		List<String> notWorkingUrls=new ArrayList<>();
		List<WebElement> links=driver.findElements(By.xpath("//*/a[contains(@href,'https://')]"));
		////*/a[contains(@href,'https://') or contains(@href,'/r')]
		links.stream().forEach(t->System.out.println(t.getAttribute("href")));
		for(int i=0;i<links.size();i++) {
			URL url=new URL(links.get(i).getAttribute("href"));
		HttpURLConnection con=(HttpURLConnection)url.openConnection();
		con.connect();
		int rescode=con.getResponseCode();
		if(rescode>=400) {
			System.out.println(url+ " : is not working");
			notWorkingUrls.add(url.toString());
		}
		else {
			System.out.println(url+" :is working Fines");
		}
		}
		System.out.println(notWorkingUrls.size());
		
  	}
}
