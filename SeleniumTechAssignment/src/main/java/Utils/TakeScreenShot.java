package Utils;

import java.io.*;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

public class TakeScreenShot {
	static int number = 1;
	WebDriver webDriver;
	String filePath = "Resources/Screenshot"+number+".png";
	
	public TakeScreenShot(WebDriver webDriver){
		this.webDriver = webDriver;
	}
	
	public void takeScreenshot() throws IOException{
		
		File scrFile = ((TakesScreenshot)webDriver).getScreenshotAs(OutputType.FILE);
	    FileUtils.copyFile(scrFile, new File(filePath));
	    number++;
	}
}

