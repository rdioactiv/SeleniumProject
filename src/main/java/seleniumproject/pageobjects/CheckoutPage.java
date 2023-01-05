package seleniumproject.pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import abstractComponents.Abstract;

public class CheckoutPage extends Abstract{
WebDriver driver;
	
	public CheckoutPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(css="input[placeholder='Select Country']")
	private WebElement country;
	
	@FindBy(css="span[class='ng-star-inserted']")
	private WebElement requiredCountry;
	
	
	@FindBy(css="a[class='btnn action__submit ng-star-inserted']")
	private WebElement placeOrderButton;
	

	private By results = By.cssSelector("button[type='button']");
	
	
	
	
	public void selectCountry(String countryName) throws InterruptedException {
		Thread.sleep(2000);
		Actions a = new Actions(driver);
		a.sendKeys(country, countryName).build().perform();
		waitForElementToBeVisible(By.cssSelector("button[type='button']"));
		requiredCountry.click();
	}
	
	public FinalPage clickPlaceOrderButton() {
		placeOrderButton.click();
		return new FinalPage(driver); 
	}
	
	

}
