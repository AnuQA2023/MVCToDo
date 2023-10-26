package Demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeftMenuScreen {
	

	WebDriver driver;	
	
	//Defining the Constructor 
    public LeftMenuScreen(WebDriver d)
    {
    	driver=d;
    	PageFactory.initElements(d, this);
    }
    
    
	@FindBy(xpath="//h3[text()='Vue.js']")
	WebElement lblTitle;
	
	@FindBy(className="source-links")
	WebElement lnkSource;
	
	@FindBy(xpath="//p[text()='Vue.js provides efficient MVVM data bindings with a simple and flexible API. It uses plain JavaScript object models, DOM-based templating and extendable directives and filters.']")
	WebElement txtHeader;
	
	@FindBy(xpath="//a[@href='http://vuejs.org'][@Name='Vue.js']")
	WebElement lnkHeadertxt;
	
	@FindBy(xpath="//h4[contains(text(),'Official Resources')]")
	WebElement hdrOfficialResources;
	
	@FindBy(xpath="//a[contains(text(),'Documentation')]")
	WebElement lnkDocumentation;
	
	@FindBy(xpath="//a[@href='http://vuejs.org/api/']")
	WebElement lnkAPIReference;
	
	@FindBy(xpath="//a[@href='http://vuejs.org/examples/']")
	WebElement lnkExamples;
	
	@FindBy(xpath="//a[@href='https://github.com/vuejs/vue']")
	WebElement lnkVueOnGitHub;
	
	@FindBy(xpath="//h4[contains(text(),'Community')]")
	WebElement hdrCommunity;
	
	@FindBy(xpath="//a[@href='http://twitter.com/vuejs']")
	WebElement lnkTwitter;
	
	@FindBy(xpath="//a[@href='https://gitter.im/yyx990803/vue']")
	WebElement lnkGitter;
	
	@FindBy(xpath="//a[@href='https://github.com/vuejs/Discussion/issues']")
	WebElement lnkDiscussionsOnGitHub;
	
	public boolean verifyHeaderTitle()
	{
		boolean bflag=false;
		if(lblTitle.isDisplayed())
		{
			bflag=true;
		}
		return bflag;
	}
	
	public boolean verifyHeaderChildFields()
	{
		boolean bflag=false;
		if(lnkSource.isDisplayed())
		{
			bflag=true;
		
		}
		return bflag;
	}
	
	
	public boolean verifyHeaderTxt()
	{
		boolean bflag=false;
		if(txtHeader.isDisplayed())
		{
			bflag=true;
		}
		return bflag;
	}
	
	public boolean verifyHeaderlnk()
	{
		boolean bflag=false;
		if(lnkHeadertxt.isDisplayed())
		{
			bflag=true;
		}
		return bflag;
	}
	
	public boolean verifyOfficialResourcesHeader()
	{
		boolean bflag=false;
		if(hdrOfficialResources.isDisplayed())
		{
			bflag=true;
		}
		return bflag;
	}
	
	public boolean verifyCommunityHeader()
	{
		boolean bflag=false;
		if(hdrCommunity.isDisplayed())
		{
			bflag=true;
		}
		return bflag;
	}
	
	public boolean verifyLinkDisplayed(String linkName)
	{
		boolean bflag=false;
		switch(linkName)
		{
		case "lnkDocumentation":
			if(lnkDocumentation.isDisplayed())
			{
				bflag=true;	
				break;
			}
		case "lnkAPIReference":
			if(lnkAPIReference.isDisplayed())
			{
				bflag=true;
				break;
			}

		case "lnkExamples":
			if(lnkExamples.isDisplayed())
			{
				bflag=true;
				break;
			}
			
		case "lnkTwitter":
			if(lnkTwitter.isDisplayed())
			{
				bflag=true;
				break;
			}
		case "lnkVueOnGitHub":
			if(lnkVueOnGitHub.isDisplayed())
			{
				bflag=true;
				break;
			}
		case "lnkGitter":
			if(lnkGitter.isDisplayed())
			{
				bflag=true;
				break;
			}
		case "lnkDiscussionsOnGitHub":
			if(lnkDiscussionsOnGitHub.isDisplayed())
			{
				bflag=true;
				break;
			}
		}
		return bflag;
	}
	

}
