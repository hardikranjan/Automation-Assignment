package Utils;
import java.io.*;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.*;

import Pages.LoginPage;

public class Util {
	WebDriver webDriver;
	FileInputStream inputFile;
	Properties properties;
	ReporterLog log;
	WebDriverWait wait;
	FileOutputStream outputFile;
	
	public Util(WebDriver webDriver){
		this.webDriver = webDriver;
		log = new ReporterLog();
	}
	
	public Properties readPropertyFile(String fileName) throws IOException{
		properties = new Properties();
		try{
		inputFile = new FileInputStream(new File(fileName));
		}catch(Exception e){
			throw new FileNotFoundException("File Not Found " + e);
		}
			properties.load(inputFile);
			
		return properties;
	}
	
	public void waitVisibilityConditionByXpath(String waitSelector,int time) throws IOException{
	    wait = new WebDriverWait(webDriver,time);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(waitSelector)));
	}
	
	public void waitVisibilityConditionByCssSelector(String waitSelector,int time) throws IOException{
	    wait = new WebDriverWait(webDriver,time);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(waitSelector)));
	}
	
	public void writeEmailIdInPropertyFile(String key,String value) throws IOException{
		log.info("Writing Entered Email Id in Property File", true);
		outputFile = new FileOutputStream(new File("EmailList.properties"));
		properties = new Properties();
		properties.setProperty(key, value);
		properties.store(outputFile,null);
	}
	
	public LoginPage navigateBack() throws IOException{
		log.info("Navigate Back To Login Page",true);
		webDriver.navigate().back();
		return new LoginPage(webDriver);
	}
	
}
