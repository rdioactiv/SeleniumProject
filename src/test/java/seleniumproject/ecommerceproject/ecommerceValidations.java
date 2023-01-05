package seleniumproject.ecommerceproject;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import seleniumproject.pageobjects.CartPage;
import seleniumproject.pageobjects.CheckoutPage;
import seleniumproject.pageobjects.FinalPage;
import seleniumproject.pageobjects.Products;
import testComponents.Base;

public class ecommerceValidations extends Base{

	@Test(groups = {"Error Validation"})
		public void LoginError() throws IOException, InterruptedException {
		Products productsList = login.loginSteps("firstname@firstname.com", "first@09");
		Assert.assertEquals("Incorrect email or password.", login.getErrorMessage());
	}
	
	@Test
		public void WrongProduct() throws IOException, InterruptedException {
		String productName = "ADIDAS ORIGINAL";
		Products productsList = login.loginSteps("name@name.com", "Name@009");
		List<WebElement> product = productsList.getProducts();
		productsList.addProductsToCart(productName);
		CartPage cartPage = productsList.clickCartButton();
		Boolean match = cartPage.checkCartProducts("ADIDAS REPLICA");
		Assert.assertTrue(match);
	
		
	
	
	}
}


