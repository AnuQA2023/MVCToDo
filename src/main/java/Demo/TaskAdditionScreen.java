package Demo;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TaskAdditionScreen {
	
	WebDriver driver;	
	
	//Defining the constructor
    public TaskAdditionScreen(WebDriver d)
    {
    	driver=d;
    	PageFactory.initElements(d, this);
    }
	
	@FindBy(className="new-todo")
	WebElement txttoDO;
	

    public boolean taskAddition(String[] tasks)
    {
    	boolean bflag= false;
    	if(txttoDO.isDisplayed())
    	{
	    	 int iCount;
	    	 for (iCount=0;iCount < tasks.length;iCount++)
	    	 {
			    	try {
			    		txttoDO.sendKeys(tasks[iCount]);
						Thread.sleep(1000);
						txttoDO.sendKeys(Keys.ENTER);
						 bflag=true;
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						return bflag;
					}
      	    	  }
	   
    	}
    	 return bflag;  
    }
    

}
