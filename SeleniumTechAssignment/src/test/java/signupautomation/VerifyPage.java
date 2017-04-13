package signupautomation;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import Checker.RegisterationChecker;

public class VerifyPage {
	WebDriver webDriver;
	
	
	
	@AfterClass
	public void theEnd(){
		webDriver.close();
	}
}
