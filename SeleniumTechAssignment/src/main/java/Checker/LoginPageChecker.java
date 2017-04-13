package Checker;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import Pages.LoginPage;
import Utils.ReporterLog;
import Utils.Util;

public class LoginPageChecker {
	ReporterLog rlog = new ReporterLog();
	WebDriver webDriver;
	WebDriverWait wait;
	FileInputStream fileInput;
	Properties properties;
	
	public LoginPageChecker(WebDriver webDriver) throws IOException{
		this.webDriver = webDriver;
		properties = new Util(webDriver).readPropertyFile("Properties/LoginPage.properties");
	}
	
	public LoginPage checkTitle() throws IOException{
		rlog.verify("Verify If Appdirect LoginPage Title",true);
		Assert.assertEquals(webDriver.getTitle(), properties.getProperty("LoginPageTitle"));
		return new LoginPage(webDriver);
	}
	
}
