package Checker;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Pages.HomePage;
import Pages.LoginPage;
import Utils.ReporterLog;
import Utils.Util;

public class HomePageChecker {
	ReporterLog rlog = new ReporterLog();
	WebDriver webDriver;
	FileInputStream fileInput;
	Properties properties;
	
	public HomePageChecker(WebDriver webDriver) throws IOException{
		this.webDriver = webDriver;
		properties = new Util(webDriver).readPropertyFile("Properties/HomePage.properties");
	}
	
	public HomePage checkTitle() throws IOException{
		rlog.verify("Verify If Appdirect HomePage Title",true);
		Assert.assertEquals(webDriver.getTitle(), properties.getProperty("HomePageTitle"));
		return new HomePage(webDriver);
	}
	
	public HomePage checkLoginButtonDisplayed() throws IOException{
		rlog.verify("Verify If Appdirect HomePage is Displayed",true);
		boolean status = webDriver.findElement(By.cssSelector(properties.getProperty("cssSelector"))).isDisplayed();
		Assert.assertTrue(status);
		return new HomePage(webDriver);
	}
	
}