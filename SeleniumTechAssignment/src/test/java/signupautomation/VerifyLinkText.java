package signupautomation;

import java.io.*;
import org.openqa.selenium.*;
import org.testng.annotations.*;
import Checker.*;
import Exception.*;
import Pages.*;

public class VerifyLinkText {

	WebDriver webDriver;
	Browser browser;
	HomePage homepage;
	LoginPage loginPage;
	WebElement webElement;
	SignUpPage signUpPage;
	HomePageChecker hpageChecker;
	LoginPageChecker lpageChecker;
	RegisterationChecker schecker;

	@BeforeClass(alwaysRun=true)
	public void Browser() throws IOException{
		browser = new Browser(webDriver);
		webDriver= browser.startBrowser(System.getProperty("browser"));
	}
	
	@Test
	public void testHomePage() throws IOException, ElementNotFound {
		homepage = new HomePage(webDriver);
		
		loginPage = homepage.openHomePageUrl()
					.verify().checkTitle()
					.verify().checkLoginButtonDisplayed()
					.openLoginPage();
	}
	
	@Test
	public void testLoginPage() throws IOException, ElementNotFound{
	
		signUpPage = loginPage
					.verify().checkTitle()
					.openSignUpPage();
	}
	
	@Test
	public void testSignUpPage() throws IOException, ElementNotFound{
		
		schecker =  signUpPage.verify().checkSignUpTextBox()
				  				.verify().checkSignUpTitle()
				  				.enterEmailIdInSignUpText()
				  				.clickSignUpButton();
	}
	
	@Test(dependsOnMethods={"testSignUpPage"})
	public void testEmailSuccess() throws Exception{
		schecker = schecker.verifySignUpSuccess();
	}
	
	@Test(dependsOnMethods={"testEmailSuccess"})
	public void testEmailFail() throws IOException, ElementNotFound{
		loginPage = loginPage.navigate().navigateBack()
							 .openSignUpPage()
							 .enterEmailIdFromCreatedSignUpPropertyFile()
							 .clickSignUpButton()
							 .verifySignUpFailure();
	}
	
	@AfterClass(alwaysRun=true)
	public void destroyDriver(){
		webDriver.close();
	}
	
}
