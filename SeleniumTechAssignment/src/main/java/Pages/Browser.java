package Pages;

import java.io.*;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import Pages.EnumBrowser.InternetBrowser;
import Utils.ReporterLog;
import Utils.Util;

public class Browser extends EnumBrowser {
	
	boolean val = true;
	ReporterLog log = new ReporterLog();
	InternetBrowser ibrowser;
	String choice;
	WebDriver webDriver;
	FileInputStream fileInput;
	Properties properties;
	
	Browser(InternetBrowser ibrowser){
		this.ibrowser = ibrowser;
	}
	
	public Browser(WebDriver webDriver) throws IOException{
		this.webDriver = webDriver;
		properties = new Util(webDriver).readPropertyFile("Properties/Browser.properties");
	}
	
	public WebDriver startBrowser(String browser) throws IOException{
		
		
		for(InternetBrowser ibrowser: InternetBrowser.values()){
			System.out.print(ibrowser+" ");
		}
		
		if(InternetBrowser.Chrome.toString().equalsIgnoreCase(properties.getProperty("browserName"))){
		log.info("Open Chrome Browser",val);
			System.setProperty(properties.getProperty("cdriverName"),properties.getProperty("cdriverPath"));
			webDriver = new ChromeDriver();
		}
		else if(InternetBrowser.Firefox.toString().equalsIgnoreCase(properties.getProperty("browserName"))){
			log.info("Open Firefox Browser",val);
			System.setProperty(properties.getProperty("fdriverName"),properties.getProperty("fdriverPath"));
			webDriver = new FirefoxDriver();
		}
		
		return webDriver;
	}
}