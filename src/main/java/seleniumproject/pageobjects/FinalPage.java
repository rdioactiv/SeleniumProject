package seleniumproject.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponents.Abstract;

public class FinalPage extends Abstract{

WebDriver driver;
	
	public FinalPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="h1[class='hero-primary']")
	WebElement thankYouMessage;
	
	public String verifyThankYouMessage() {
		return thankYouMessage.getText();
	}
	
}
