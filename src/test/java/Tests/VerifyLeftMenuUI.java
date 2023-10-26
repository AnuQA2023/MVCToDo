package Tests;

import java.io.File;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Demo.*;


public class VerifyLeftMenuUI{
	  
	   private Logger logger; 
	   ExtentReports report; 
	   ExtentTest test; 
	   WebDriver driver= new ChromeDriver(); 
	   HomeScreen Homepage= new HomeScreen(driver);
	   LeftMenuScreen leftMenu= new LeftMenuScreen(driver);
	   Assertion assertions; 
		public static String projectPath = System.getProperty("user.dir");
   
		/**
		 * Constructor
		 * 
		 * @throws Exception
		 */
		public VerifyLeftMenuUI() throws Exception {
			//GenLib = new GeneralFunctions();
			PropertyConfigurator.configure("log4j.properties");
			logger = Logger.getLogger(VerifyLeftMenuUI.class);
			report = new ExtentReports(projectPath + File.separator + "Reports" + File.separator + "TestCase1.html");
			assertions = new Assertion();
		}
		
		/**
		 * 
		 * Launch the App
		 * 
		 * @throws Exception
		 */
		@BeforeMethod
		public void launchURL() throws Exception {
			try {
				test = report.startTest("Launch To Do MMVC");
				driver.navigate().to("https://todomvc.com/examples/vue/");
				logger.info("Successfully Launched the TODO MVC");
			} catch (Exception ex) {
				logger.info("Exception is : Please check URL entered " + ex);
				test.log(LogStatus.FAIL, "Exception is : Please check URL entered " + ex);
			}
		}

	 
		
@SuppressWarnings("static-access")
  @Test(priority = 1)
	public void verifyLeftMenuHeader() throws Exception {
		try {
		
		test.log(LogStatus.PASS, "Successfully Launched the TODO MVC : " + Homepage.takeScreenshot(driver));
		test = report.startTest("Verifying the Header Title");	
		
		boolean bflag=false;
		bflag = leftMenu.verifyHeaderTitle();
		logger.info("Verifying the Header Title");
		if(bflag)
		{
			test.log(LogStatus.PASS, "Header Title is displaying" + Homepage.takeScreenshot(driver));
			logger.info("Header Title is displaying");
		}
		else
		{
			test.log(LogStatus.PASS, "Header Title is not displaying" + Homepage.takeScreenshot(driver));
			logger.info("Header Title is not displaying");
		}	
		

		} catch (Exception ex) {
			logger.error("Test Case Status is Fail due " + ex);
			test.log(LogStatus.FAIL, "Test Case is Failed : " +  Homepage.takeScreenshot(driver));
		}
	}

@SuppressWarnings("static-access")
@Test(priority = 2)
	public void verifyLeftMenuHeaderFields() throws Exception {
		try {
	
		test = report.startTest("Verifying the Header fields");	
		
		boolean bflag=false;
		bflag = leftMenu.verifyHeaderChildFields();
		logger.info("Verifying the Header fields");
		if(bflag)
		{
			test.log(LogStatus.PASS, "Header Child fields are displaying properly" + Homepage.takeScreenshot(driver));
			logger.info("Header Child fields are displaying properly");
		}
		else
		{
			test.log(LogStatus.PASS, "Header Child fields are not displaying" + Homepage.takeScreenshot(driver));
			logger.info("Header Child fields are not displaying");
		}	
		

		} catch (Exception ex) {
			logger.error("Test Case Status is Fail due " + ex);
			test.log(LogStatus.FAIL, "Test Case is Failed : " +  Homepage.takeScreenshot(driver));
		}
	}

@SuppressWarnings("static-access")
@Test(priority = 3)
	public void verifyOfficialResourcesLinks() throws Exception {
		try {
		test = report.startTest("Verifying the Official resources links");	
		
		boolean bflag=false;
		bflag = leftMenu.verifyOfficialResourcesHeader();
		logger.info("Verifying the Official Resources label");
		if(bflag)
		{
			test.log(LogStatus.PASS, "Official Resources label is displaying properly" + Homepage.takeScreenshot(driver));
			logger.info("Official Resources label is displaying properly");
		}
		else
		{
			test.log(LogStatus.PASS, "Official Resources label is not displaying" + Homepage.takeScreenshot(driver));
			logger.info("Official Resources label is not displaying");
		}	
				
		boolean blink1=false;
		blink1 = leftMenu.verifyLinkDisplayed("lnkDocumentation");
		logger.info("Verifying the Official resources links");
		if(blink1)
		{
			test.log(LogStatus.PASS, "Documentation link is displaying" + Homepage.takeScreenshot(driver));
			logger.info("Documentation link is displaying properly");
		}
		else
		{
			test.log(LogStatus.PASS, "Documentation link is not displaying" + Homepage.takeScreenshot(driver));
			logger.info("Documentation link is not displaying");
		}
		
		boolean blink2=false;
		blink2 = leftMenu.verifyLinkDisplayed("lnkAPIReference");
		if(blink2)
		{
			test.log(LogStatus.PASS, "API Reference link is displaying" + Homepage.takeScreenshot(driver));
			logger.info("API Reference link is displaying properly");
		}
		else
		{
			test.log(LogStatus.PASS, "API Reference link is not displaying" + Homepage.takeScreenshot(driver));
			logger.info("API Reference link is not displaying");
		}	
		
		boolean blink3=false;
		blink3 = leftMenu.verifyLinkDisplayed("lnkExamples");
		if(blink3)
		{
			test.log(LogStatus.PASS, "Examples link is displaying" + Homepage.takeScreenshot(driver));
			logger.info("Examples link is displaying properly");
		}
		else
		{
			test.log(LogStatus.PASS, "Examples link is not displaying" + Homepage.takeScreenshot(driver));
			logger.info("Examples link is not displaying");
		}
		
		boolean blink4=false;
		blink4 = leftMenu.verifyLinkDisplayed("lnkVueOnGitHub");
		if(blink4)
		{
			test.log(LogStatus.PASS, "Vue on Github link is displaying" + Homepage.takeScreenshot(driver));
			logger.info("Vue on Github link is displaying properly");
		}
		else
		{
			test.log(LogStatus.PASS, "Vue on Github link is not displaying" + Homepage.takeScreenshot(driver));
			logger.info("Vue on Github link is not displaying");
		}
		
		
		} catch (Exception ex) {
			logger.error("Test Case Status is Fail due " + ex);
			test.log(LogStatus.FAIL, "Test Case is Failed : " +  Homepage.takeScreenshot(driver));
		}
	}

@SuppressWarnings("static-access")
@Test(priority = 4)
	public void verifyCommunityLinks() throws Exception {
		try {
		test = report.startTest("Verifying the Community links");	
		
		boolean bflag=false;
		bflag = leftMenu.verifyCommunityHeader();
		logger.info("Verifying the Community label");
		if(bflag)
		{
			test.log(LogStatus.PASS, "Community label is displaying properly" + Homepage.takeScreenshot(driver));
			logger.info("Community label is displaying properly");
		}
		else
		{
			test.log(LogStatus.PASS, "Community label is not displaying" + Homepage.takeScreenshot(driver));
			logger.info("Community label is not displaying");
		}	
		
		boolean blink1=false;
		blink1 = leftMenu.verifyLinkDisplayed("lnkTwitter");
		if(blink1)
		{
			test.log(LogStatus.PASS, "Twitter link is displaying" + Homepage.takeScreenshot(driver));
			logger.info("Twitter link is displaying properly");
		}
		else
		{
			test.log(LogStatus.PASS, "Twitter link is not displaying" + Homepage.takeScreenshot(driver));
			logger.info("Twitter link is not displaying");
		}	
		
		boolean blink2=false;
		blink2 = leftMenu.verifyLinkDisplayed("lnkGitter");
		if(blink2)
		{
			test.log(LogStatus.PASS, "Gitter link is displaying" + Homepage.takeScreenshot(driver));
			logger.info("Gitter link is displaying properly");
		}
		else
		{
			test.log(LogStatus.PASS, "Gitter link is not displaying" + Homepage.takeScreenshot(driver));
			logger.info("Gitter link is not displaying");
		}
		
		boolean blink3=false;
		blink3 = leftMenu.verifyLinkDisplayed("lnkDiscussionsOnGitHub");
		if(blink3)
		{
			test.log(LogStatus.PASS, "Discussions on Github link is displaying" + Homepage.takeScreenshot(driver));
			logger.info("Discussions on Github  link is displaying properly");
		}
		else
		{
			test.log(LogStatus.PASS, "Discussions on Github link is not displaying" + Homepage.takeScreenshot(driver));
			logger.info("Discussions on Github link is not displaying");
		}
		
		
		} catch (Exception ex) {
			logger.error("Test Case Status is Fail due " + ex);
			test.log(LogStatus.FAIL, "Test Case is Failed : " +  Homepage.takeScreenshot(driver));
		}
	}

	@AfterClass
	public void tearDown() {
		try {
			driver.quit();
			report.endTest(test);
			report.flush();
		} catch (Exception ex) {
			logger.info("Exception is : " + ex);
		}
	}
	
	
	
}
