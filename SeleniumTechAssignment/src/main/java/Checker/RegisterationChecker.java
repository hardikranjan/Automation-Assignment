package Checker;

import org.openqa.selenium.support.ui.*;
import org.testng.*;

import Pages.LoginPage;
import Utils.ReporterLog;
import Utils.Util;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.*;

public class RegisterationChecker {
	ReporterLog rlog = new ReporterLog();
	WebDriver webDriver;
	WebElement webElement1,webElement2;;
	WebDriverWait wait;
	FileInputStream fileInput;
	Properties properties;
	
	public RegisterationChecker(WebDriver webDriver) throws IOException{
		this.webDriver = webDriver;
		properties = new Util(webDriver).readPropertyFile("Properties/SuccessChecker.properties");
	}
	
	public RegisterationChecker verifySignUpSuccess() throws Exception{
		new Util(webDriver).waitVisibilityConditionByCssSelector(properties.getProperty("verifySignUpSuccess"), 10);
		rlog.verify("Verify SignUp Success", true);
		
		if(webDriver.findElement(By.cssSelector(properties.getProperty("verifySignUpSuccess"))).isDisplayed()){
			rlog.info("Succcessfully SignedUp",true);
			rlog.info("Thanks for registering.", true);
			
		}
		
		return new RegisterationChecker(webDriver);
	}
	
	public LoginPage verifySignUpFailure() throws IOException{
		new Util(webDriver).waitVisibilityConditionByCssSelector(properties.getProperty("verifySignUpFailure"), 10);
		rlog.verify("Verify SignUp Failure", true);
		
		if(webDriver.findElement(By.cssSelector(properties.getProperty("verifySignUpFailure"))).isDisplayed()){
			Reporter.log("SignedUp Failed",true);
			Reporter.log("Error Message: This email address has already been registered in our system. Please register with a new email address.",true);
		}
		return new LoginPage(webDriver);
	}
	
}
