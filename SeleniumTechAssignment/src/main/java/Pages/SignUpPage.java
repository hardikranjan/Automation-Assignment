package Pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import Checker.SignUpPageChecker;
import Checker.RegisterationChecker;
import Exception.ElementNotFound;
import Utils.ReporterLog;
import Utils.Util;
	
public class SignUpPage {
	
	Random randomGenerator = new Random();
	int randomInt = randomGenerator.nextInt(1000);  
	String emailId = "username"+ randomInt + randomInt +"@yopmail.com";
	
	WebDriver webDriver;
	ReporterLog log = new ReporterLog();
	static int count=1;
	WebElement element;
	Properties properties = new Properties();
	FileInputStream fileInput;
	Util util;
	
	public SignUpPage(WebDriver webDriver) throws IOException{
		this.webDriver = webDriver;
		properties = new Util(webDriver).readPropertyFile("Properties/SignUpPage.properties");
	}
	
	public SignUpPage enterEmailIdInSignUpText() throws IOException, ElementNotFound{
		log.info("Enter EmailId in SignUp Text",true);
		try{
		element = webDriver.findElement(By.xpath(properties.getProperty("xpath")));
		}
		catch(Exception e){
			throw new ElementNotFound("Element Not Found");
		}
		element.sendKeys(emailId);
		
		new Util(webDriver).writeEmailIdInPropertyFile("email"+(count++),emailId);
		return new SignUpPage(webDriver);
	}
	
	public SignUpPage enterEmailIdFromCreatedSignUpPropertyFile() throws IOException{
		log.info("Enter Email Id from Already Registered EmailId",true);
		properties = new Util(webDriver).readPropertyFile("EmailList.properties");
		emailId = properties.getProperty("email1");
		webDriver.findElement(By.cssSelector(".adb-text__full_width")).sendKeys(emailId);
		
		return new SignUpPage(webDriver);
	}
	public SignUpPageChecker verify() throws IOException
	{
		return new SignUpPageChecker(webDriver);
	}
	
	public RegisterationChecker clickSignUpButton() throws IOException, ElementNotFound{
		log.info("SignUp Button Is Clicked", true);
		try{
		element = webDriver.findElement(By.cssSelector(properties.getProperty("signUpButton")));
		}
		catch(Exception e){
			throw new ElementNotFound("Element was not located"+e);
		}
		element.click();
		
		return new RegisterationChecker(webDriver);
	}
	
}
