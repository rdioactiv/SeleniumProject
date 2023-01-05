package seleniumproject.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponents.Abstract;

public class Login extends Abstract
{
	WebDriver driver;
	
	public Login(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id="userEmail")
	WebElement usernameElement;
	
	@FindBy(css="input[placeholder='enter your passsword']")
	WebElement passwordElement;
	
	@FindBy(id="login")
	WebElement loginButton;
	
	@FindBy(css="div[aria-label='Incorrect email or password.']")
	WebElement errorMessage;
	


	public Products loginSteps(String username, String password) 
	{
		usernameElement.sendKeys(username);
		passwordElement.sendKeys(password);
		loginButton.click();
		Products productsList = new Products(driver);
		return productsList;
	}
	
	public String getErrorMessage() {
		waitForElementToBeVisible(errorMessage);
		return errorMessage.getText();
		
	}
	
	public void url() 
	{
		driver.get("https://rahulshettyacademy.com/client");
	}
}