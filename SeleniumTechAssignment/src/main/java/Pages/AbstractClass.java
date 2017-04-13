package Pages;

import java.io.*;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

public abstract class AbstractClass {
	WebDriver webDriver;
	
	AbstractClass(WebDriver webDriver) {
		this.webDriver = webDriver;	
	}
	
}
