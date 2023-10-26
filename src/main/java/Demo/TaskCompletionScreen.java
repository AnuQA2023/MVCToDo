package Demo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TaskCompletionScreen {
	
	WebDriver driver;	
	//Defining the constructor
    public TaskCompletionScreen(WebDriver d)
    {
    	driver=d;
    	PageFactory.initElements(d, this);
    }
	
	@FindBy(className="new-todo")
	WebElement txttoDO;
	
	@FindBy(css="a[href='#/completed']")
	WebElement btnCompleted;
	
	@FindBy(css="a[href='#/all']")
	WebElement btnAll;
	
	@FindBy(css="a[href='#/selected']")
	WebElement btnActive;
	
	@FindBy(className="clear-completed")
	WebElement btnClrCompleted;
	
		
	public boolean SelectTask(String stask)
	{
		
		boolean bflag=false;
		
		WebElement selectTask =driver.findElement(By.xpath("//label[text()='"+stask+"']/preceding-sibling::input"));
		selectTask.click(); 
		
		btnCompleted.click();
		
		WebElement selectTask1 =driver.findElement(By.xpath("//label[text()='"+stask+"']"));
		if(selectTask1.isDisplayed())
		{
			bflag=true;
		}
		
		return bflag;
		 
	}
	
	public boolean verifyClearCompleted()
		{
		boolean bflag=false;
		if(btnClrCompleted.isDisplayed())
		{
			btnClrCompleted.click();
			bflag=true;
		}
				
		return bflag;
		}
}
