package abc.PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abc.AbstractComponents.AbstractComponents;

public class OrderConfirmationPage extends AbstractComponents
{

	WebDriver driver;
	String orderNum;
	public OrderConfirmationPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h1[@class='hero-primary']")
	WebElement msg;
	
	@FindBy(xpath="//label[@class='ng-star-inserted']")
	WebElement orderNumber;
	
	@FindBy(xpath="//table/tbody/tr/th")
	List<WebElement>OrderList;
	
	@FindBy(id="toast-container")
	WebElement toastMsg;
	
	@FindBy(xpath="(//tr/td[2])[1]")
	WebElement productNameOrderHistory;
	
	public String getMsg()
	{
		orderNum=orderNumber.getText();
		String OrderMsg=msg.getText();
		return OrderMsg;
	}
	
	public String getOrderNumber()
	{
		return orderNum;
	}
	
	public boolean orderMatch(String order)
	{
		waitUntilElementIsInvisible(toastMsg, 20);
		scrollDownByPixel(-500);
		ClickOnOrder();
		boolean output=false;
		for(WebElement oList:OrderList)
		{
			
			if (oList.getText().trim().equalsIgnoreCase(order)) 
			{
				output=true;
				break;
			}
		
		}
		return output;
	}
	
	public String getProductName()
	{

	return productNameOrderHistory.getText();
		
	}
	
	
}
