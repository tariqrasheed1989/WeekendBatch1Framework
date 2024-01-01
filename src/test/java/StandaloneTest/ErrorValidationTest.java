package StandaloneTest;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import abc.PageObjects.CartPage;
import abc.PageObjects.ProductCateloguePage;

public class ErrorValidationTest extends BaseClass
{
	@Test
	public void loginValidation()
	{
		loginPage.login("qwerty2511@gmail.com", "Abc@123456");
		System.out.println(loginPage.getText());
		Assert.assertEquals(loginPage.getText(), "Incorrect email or password.");
	}
	
	@Test
	public void ProductValidation()
	{
		String productName="I PHONE1";
		ProductCateloguePage productCateloguePage=loginPage.login("qwerty2511@gmail.com", "Abc@12345");
		List<WebElement> productsName=productCateloguePage.productList();
		productCateloguePage.addToCart(productsName, productName);		
		CartPage cartPage=productCateloguePage.GoToCart();		
		String actualProduct=cartPage.getProduct();
		Assert.assertEquals(actualProduct, "Zara Coat");
	}


}
