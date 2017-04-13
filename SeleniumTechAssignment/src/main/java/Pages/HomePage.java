package Pages;

import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.*;
import Checker.HomePageChecker;
import Exception.ElementNotFound;
import Utils.ReporterLog;
import Utils.Util;

public class HomePage{
	ReporterLog rlog = new ReporterLog();
	WebDriver webDriver;
	Util util;
	Properties properties ;
	
	public HomePage(WebDriver webDriver) throws IOException {
		this.webDriver = webDriver;
		properties = new Util(webDriver).readPropertyFile("Properties/HomePage.properties");
	}
	
	public HomePage openHomePageUrl() throws IOException, ElementNotFound {
		rlog.info("Open Appdirect HomePage",true);
		webDriver.get(properties.getProperty("website"));
		
		return new HomePage(webDriver);
	}
	
	public LoginPage openLoginPage() throws IOException, ElementNotFound{
		rlog.info("Open Login Page", true);
		WebElement element = webDriver.findElement(By.cssSelector(properties.getProperty("cssSelector")));
		if(element==null){
			throw new ElementNotFound("Element not found");
		}
		else
			element.click();
		
		return new LoginPage(webDriver);
	}
	
	public HomePageChecker verify() throws IOException{
		
		return new HomePageChecker(webDriver);
	}
}
