package seleniumproject.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import abstractComponents.Abstract;

public class CartPage extends Abstract{

	
	WebDriver driver;
	
	public CartPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div/div/h3")
	List<WebElement> cartProducts; 
	
	@FindBy(xpath="//*[contains(text(),'Checkout')]")
	WebElement checkoutButton;
	
	public Boolean checkCartProducts(String productName) 
	{
		Boolean match = cartProducts.stream().anyMatch(cartProd->cartProd.getText().equals(productName));
		return match;
	}
	
	public CheckoutPage clickCheckout() {
		checkoutButton.click();	
		CheckoutPage checkoutPage = new CheckoutPage(driver);
		return checkoutPage;
	}
 
	
}
