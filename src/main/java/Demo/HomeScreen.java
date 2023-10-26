package Demo;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import org.apache.commons.*;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomeScreen {
	
		WebDriver driver;	
		
		
		//Declaring the elements in the Home Page
		@FindBy(xpath="//h1[contains(text(),'todos')]")
		WebElement lbltoDO;
		
		@FindBy(className="new-todo")
		WebElement txttoDO;
		
		@FindBy(className="todo-count")
		WebElement lbltodoCount;
		
		@FindBy(className="selected")
		WebElement btnAll;
		
		@FindBy(className="Active")
		WebElement btnActive;
		
		@FindBy(className="Completed")
		WebElement btnCompleted;
		
		@FindBy(className="todo-list")
		WebElement listTodos;
		

		//Defining the methods in the Home Page	
        public HomeScreen(WebDriver d)
        {
        	driver=d;
        	PageFactory.initElements(d, this);
        }
        
   		public boolean verifyLabelToDoExists()
        {  	
        	if(lbltoDO.isDisplayed())
        		return true;        		        	
        	else 
        		return false;
        }
        
    
        public int taskcountVerification()
        {
        	String txtCount =lbltodoCount.getText();
        	String[] todoCount = txtCount.split(" ");
        	return Integer.valueOf(todoCount[0]);
        }
        
        public void selectTasks(String task)
        {

        	
        }
        	
        	
    	// Capture Screen Shot and save in the location
        /**
    	 * Method for Take a Screen Shot 
    	 * @return
    	 * @throws IOException
    	 */
    	public String takeScreenshot(WebDriver d) throws IOException {
    		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
    		TakesScreenshot ts = (TakesScreenshot) d;
    		File source = ts.getScreenshotAs(OutputType.FILE);
    		String destination = System.getProperty("user.dir") + File.separator + "screenshots" + File.separator + dateName + ".png";
    		File finalDestination = new File(destination);
    		FileHandler.copy(source, finalDestination);
    		String html = "";
    		html = convertScreenshotToBase64(source);
    		return html;
    	}
       	
    	public static String doImageClickAnimation(String img) {
    		boolean bool = false;
    		int width = 500;
    		int height = 250;
    		if (bool) {
    			width = 1240;
    			height = 2040;
    		}
    		String image = "<img onclick='clickImage(this)' src=\"data:image/png;base64, " + img + "\" alt=\"" 
    				+ "\" width=\"" + width + "\" height=\"" + height + "\"/>";
    		return image;

    	}

    	/**
    	 * Method for Convert the image to Base64 
    	 * @param file
    	 * @param name
    	 * @return
    	 */
    	@SuppressWarnings("resource")
    	public static String convertScreenshotToBase64(File file) {
    		try {
    			FileInputStream fis = new FileInputStream(file);
    			byte[] byteArray = new byte[(int) file.length()];
    			fis.read(byteArray);
    			String imageString = Base64.getEncoder().encodeToString(byteArray);
    			return doImageClickAnimation(imageString);
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    		return null;
    	}
        
    	
}


