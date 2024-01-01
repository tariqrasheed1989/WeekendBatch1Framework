package abc.AbstractComponents;

import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import abc.PageObjects.OrderConfirmationPage;

public class AbstractComponents 
{
	WebDriver driver;	
	
	public AbstractComponents(WebDriver driver2) 
	{
		driver=driver2;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//button[@routerlink='/dashboard/cart']")
	WebElement cart;
	
	@FindBy(xpath="//button[@routerlink='/dashboard/myorders']")
	WebElement order;

	public void waitUntilElementIsInvisible(WebElement element, int time)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(time));	
		wait.until(ExpectedConditions.invisibilityOf(element));
	}
	
	public void waitUntilElementIsVisible(WebElement element, int time)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(time));	
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void ClickOnCart()
	{
		cart.click();
	}
	public OrderConfirmationPage ClickOnOrder()
	{
		order.click();
		OrderConfirmationPage orderConfPage=new OrderConfirmationPage(driver);
		return orderConfPage;
	}
	
	public void scrollDownByPixel(int pixel)//+ scroll down, - scroll up
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,"+pixel+")");
	}
	
	public void waitUntillElementIsClickable(WebElement element,int Seconds)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(Seconds));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void jsClick(WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",element);
	}

}
