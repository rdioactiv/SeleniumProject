package seleniumproject.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import abstractComponents.Abstract;

public class OrdersPage extends Abstract{

	
	WebDriver driver;
	
	public OrdersPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//tr/td[2]")
	List<WebElement> ordersProducts; 
	

	
	public Boolean VerifyOrdersDisplayed(String productName) 
	{
		Boolean match = ordersProducts.stream().anyMatch(orderProd->orderProd.getText().equalsIgnoreCase(productName));
		return match;
	
	}
	

 
	
}
