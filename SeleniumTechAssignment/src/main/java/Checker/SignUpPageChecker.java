package Checker;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Pages.SignUpPage;
import Utils.ReporterLog;
import Utils.Util;

public class SignUpPageChecker {
	ReporterLog rlog = new ReporterLog();
	WebDriver webDriver;
	FileInputStream fileInput;
	Properties properties;
	Util util;
	
	public SignUpPageChecker(WebDriver webDriver) throws IOException{
		this.webDriver = webDriver;
		properties = new Util(webDriver).readPropertyFile("Properties/SignUpPage.properties");
	}
	
	public SignUpPage checkSignUpTextBox() throws IOException{
		rlog.verify("Verify If Appdirect SignUp Page is Displayed",true);
		boolean status = webDriver.findElement(By.cssSelector(properties.getProperty("signUpCssTextBoxClass"))).isDisplayed();
		Assert.assertTrue(status);
		return new SignUpPage(webDriver);
	}
	
	public SignUpPage checkSignUpTitle() throws IOException{
		rlog.verify("Verify If SignUpPage Title is correct",true);
		Assert.assertEquals(webDriver.getTitle(), properties.getProperty("SignUpTitle"));
		return new SignUpPage(webDriver);
	}
	
}
