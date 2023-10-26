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


public class VerifyFunctionality{
	  
	   private Logger logger; 
	   ExtentReports report; 
	   ExtentTest test; 
	   WebDriver driver= new ChromeDriver(); 
	   HomeScreen Homepage= new HomeScreen(driver);
	   TaskCompletionScreen completeTask= new TaskCompletionScreen(driver);
	   TaskAdditionScreen AddToDo= new TaskAdditionScreen(driver);
	   Assertion assertions; 
		public static String projectPath = System.getProperty("user.dir");
   
		/**
		 * Constructor
		 * 
		 * @throws Exception
		 */
		public VerifyFunctionality() throws Exception {
			//GenLib = new GeneralFunctions();
			PropertyConfigurator.configure("log4j.properties");
			logger = Logger.getLogger(VerifyFunctionality.class);
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
	public void verifyTaskAddition() throws Exception {
		try {
		
		test.log(LogStatus.PASS, "Successfully Launched the TODO MVC : " + Homepage.takeScreenshot(driver));
		test = report.startTest("Tasks Addition Validation");	
		boolean pageDisplay = Homepage.verifyLabelToDoExists();
		
		test.log(LogStatus.PASS, "To Do Label is Displayed  \n" + Homepage.takeScreenshot(driver));
		logger.info("To Do Label is Displayed");
		
		logger.info("Adding the Tasks");
		
		String[] AddTasks= {"T1","T2","T3"};
		boolean bflag =false;
		bflag = AddToDo.taskAddition(AddTasks);
		if(bflag)
		{
		test.log(LogStatus.PASS, "Tasks Added Successfully \n" + Homepage.takeScreenshot(driver));
		logger.info("Tasks Added Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Tasks are not added \n" + Homepage.takeScreenshot(driver));
			logger.assertLog(false, "Tasks are not added ");
			System.exit(-1);//* Exiting the script if addition is not successful *//
		}	
		
		int ToDoListCount = Homepage.taskcountVerification();
		logger.info("Verifying the added Tasks");
		if(ToDoListCount == AddTasks.length)
		{
			test.log(LogStatus.PASS, "Added Tasks are displayed successfully" + Homepage.takeScreenshot(driver));
			logger.info("Added Tasks are displayed successfully");
		}
		
	
		} catch (Exception ex) {
			logger.error("Test Case Status is Fail due " + ex);
			test.log(LogStatus.FAIL, "Test Case is Failed : " +  Homepage.takeScreenshot(driver));
		}
	}


@SuppressWarnings("static-access")
@Test(priority = 2)
	public void verifyTaskCompletion() throws Exception {
		try {
		
	
		test.log(LogStatus.PASS, "Complete and Clear task verification\n" + Homepage.takeScreenshot(driver));
		logger.info("Verifying the Task Completion");
		
		boolean bflag =false;
		bflag = completeTask.SelectTask("T1");
		if(bflag)
		{
		test.log(LogStatus.PASS, "Able to complete task T1 successfully \n" + Homepage.takeScreenshot(driver));
		logger.info("Able to complete task T1 successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Unable to complete tasks\n" + Homepage.takeScreenshot(driver));
			logger.assertLog(false, "Unable to complete tasks");
			System.exit(-1);//* Exiting the script if addition is not successful *//
		}	
		boolean bClear= false;
		
		bClear = completeTask.verifyClearCompleted();
		logger.info("Verifying the clear complete functionality");
		if(bClear)
		{
			test.log(LogStatus.PASS, "Clear Complete tasks is successful" + Homepage.takeScreenshot(driver));
			logger.info("Clear Complete tasks is successful");
		}
		else
		{
			test.log(LogStatus.PASS, "Clear Complete tasks is not successful" + Homepage.takeScreenshot(driver));
			logger.info("Clear Complete tasks is not successful");
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
