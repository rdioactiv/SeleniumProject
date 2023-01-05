package seleniumproject.ecommerceproject;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import seleniumproject.pageobjects.CartPage;
import seleniumproject.pageobjects.CheckoutPage;
import seleniumproject.pageobjects.FinalPage;
import seleniumproject.pageobjects.Login;
import seleniumproject.pageobjects.OrdersPage;
import seleniumproject.pageobjects.Products;
import testComponents.Base;

public class ecommerceShopping extends Base{
	
	
	String productName = "ADIDAS ORIGINAL";
	
	@Test
		public void EcommerceShopping() throws IOException, InterruptedException {
		
		Products productsList = login.loginSteps("firstname@firstname.com", "Firstname@09");
		List<WebElement> product = productsList.getProducts();
		productsList.addProductsToCart(productName);
		CartPage cartPage = productsList.clickCartButton();
		Boolean match = cartPage.checkCartProducts(productName);
		Assert.assertTrue(match);	
		CheckoutPage checkoutPage = cartPage.clickCheckout();
		
		checkoutPage.selectCountry("canada");
		FinalPage finalPage = checkoutPage.clickPlaceOrderButton();
		String message = finalPage.verifyThankYouMessage();
		Assert.assertTrue(message.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	}

	@Test(dependsOnMethods = {"EcommerceShopping"})
	public void OrderHistory()
	{
		Products productsList = login.loginSteps("firstname@firstname.com", "Firstname@09");
	
		OrdersPage ordersPage = productsList.clickOrdersButton();
		Assert.assertTrue(ordersPage.VerifyOrdersDisplayed(productName));
		
		
		
	}

}
