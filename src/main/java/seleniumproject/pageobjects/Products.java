package seleniumproject.pageobjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import abstractComponents.Abstract;

public class Products extends Abstract 
{
	
	WebDriver driver;
	
	public Products(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(css="div[class='card-body']")
	List<WebElement> product; 
	
	@FindBy(css="\".ng-animating\"")
	WebElement spinner; 
	
	
	By productsBy = By.cssSelector("div[class='card-body']");
	By addToCart = By.cssSelector("button[class='btn w-10 rounded']");
	By productMessage = By.id("toast-container");
	
	
    public List<WebElement> getProducts() 
    {
	waitForElementToBeVisible(productsBy);
	return product;
}
    public WebElement getProductsByName(String productName) 
    {
    	WebElement product = getProducts().stream().filter(prod->prod.findElement(By.cssSelector("b"))
    			.getText().equals(productName)).findFirst().orElse(null);
    	return product;
    }
	
    public void addProductsToCart(String productName) 
    {	
    	
    	WebElement product = getProductsByName(productName);
    	product.findElement(addToCart).click();
        waitForElementToBeVisible(productMessage);
        waitForElementToBeInvisible(spinner);
       
     
    }
	



}
