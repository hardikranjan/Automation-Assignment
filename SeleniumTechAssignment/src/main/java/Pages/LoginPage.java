package Pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import Checker.LoginPageChecker;
import Checker.RegisterationChecker;
import Exception.ElementNotFound;
import Utils.ReporterLog;
import Utils.Util;

public class LoginPage {
	ReporterLog rlog = new ReporterLog();
	WebDriver webDriver;
	Properties properties = new Properties();
	WebDriverWait wait;
	FileInputStream fileInput;
	WebElement element;
	Util util;
	
	public LoginPage(WebDriver webDriver) throws IOException{
		this.webDriver = webDriver;
		properties = new Util(webDriver).readPropertyFile("Properties/LoginPage.properties");
	}
	
	public SignUpPage openSignUpPage() throws IOException, ElementNotFound{
		rlog.info("Open SignUp Page",true);
		try{
		element = webDriver.findElement(By.xpath(properties.getProperty("signUpXpath")));
		}catch(Exception e){
			throw new ElementNotFound("Element was not located "+e);
		}
		element.click();
		return new SignUpPage(webDriver);
	}
	
	public LoginPage signUpStatus() throws IOException{
		rlog.verify("Verify If Appdirect LoginPages is Displayed",true);
		boolean status = webDriver.findElement(By.className(properties.getProperty("status_password"))).isDisplayed();
		Assert.assertTrue(status);
		return new LoginPage(webDriver); 
	}
	
	public LoginPageChecker verify() throws IOException{
		new Util(webDriver).waitVisibilityConditionByXpath(properties.getProperty("signUpXpath"),10);
		return new LoginPageChecker(webDriver);
	}
	
	public RegisterationChecker check() throws IOException{
		return new RegisterationChecker(webDriver);
	}
	
	public Util navigate(){
		return new Util(webDriver);
	}
}
