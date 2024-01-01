package StandaloneTest;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import abc.PageObjects.CartPage;
import abc.PageObjects.LoginPage;
import abc.PageObjects.OrderConfirmationPage;
import abc.PageObjects.PaymentConfirmationPage;
import abc.PageObjects.ProductCateloguePage;

public class OrderTest extends BaseClass
{
	String productName="I PHONE1";
@Test(dataProvider = "getData",groups="Regression")
public void PlaceOrderTest(String username,String Password) throws IOException
	{	
		ProductCateloguePage productCateloguePage=loginPage.login(username, Password);
		List<WebElement> productsName=productCateloguePage.productList();
		productCateloguePage.addToCart(productsName, productName);		
		CartPage cartPage=productCateloguePage.GoToCart();		
		String actualProduct=cartPage.getProduct();
		Assert.assertEquals(actualProduct, productName);
		PaymentConfirmationPage paymentConfirmationPage=cartPage.checkout();
		paymentConfirmationPage.enterPaymentDetails("1234","TestName","India");
		OrderConfirmationPage orderConfirmationPage=paymentConfirmationPage.placeOrder();
		String actualMsg=orderConfirmationPage.getMsg();
		System.out.println(actualMsg);
		Assert.assertEquals(actualMsg, "THANKYOU FOR THE ORDER.");
	}

@Test(dependsOnMethods = "PlaceOrderTest")
public void orderValidate()
{
	ProductCateloguePage productCateloguePage=loginPage.login("qwerty2511@gmail.com", "Abc@12345");
	OrderConfirmationPage orderConfirmationPage=productCateloguePage.ClickOnOrder();
	String prodName=orderConfirmationPage.getProductName();
	Assert.assertEquals(prodName, "I Phone1");	
}

@DataProvider
public String[][] getData()
{
	return new String[][] {{"qwerty232@gmail.com","pwd123"},{"qwerty2511@gmail.com", "Abc@12345"}};
}
}
