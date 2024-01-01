package abc.PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abc.AbstractComponents.AbstractComponents;

public class PaymentConfirmationPage extends AbstractComponents
{
	 WebDriver driver;
		public PaymentConfirmationPage(WebDriver driver) {
			super(driver);
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
		

	@FindBy(xpath="//div[contains(.,'CVV Code') and @class='title']/following-sibling::input")
	WebElement txtCVVCode;
	
	@FindBy(xpath="//div[contains(.,'Name on Card ') and @class='title']/following-sibling::input")
	WebElement txtNameOnCard;
	
	@FindBy(xpath="//input[@placeholder='Select Country']")
	WebElement txtCountry;
	
	@FindBy(xpath="//section[@class='ta-results list-group ng-star-inserted']/button")
	List<WebElement>countryList;
	
	@FindBy(xpath="//a[normalize-space()='Place Order']")
	WebElement btnPlaceOrder;
	
	public void enterPaymentDetails(String CVV, String Name, String countryName)
	{
		txtCVVCode.sendKeys(CVV);
		txtNameOnCard.sendKeys(Name);
		txtCountry.sendKeys(countryName);
		for(WebElement cl:countryList)
		{
			String country=cl.getText();
			if(country.equals(countryName))
			{
				cl.click();
			}
		}
		scrollDownByPixel(150);
	}
	
	public OrderConfirmationPage placeOrder()
	{
		try{
			btnPlaceOrder.click();
		}catch(Exception e)
		{
			System.out.println("Unable to click on UI");
			jsClick(btnPlaceOrder);
		}
		return new OrderConfirmationPage(driver);
	}
		
}
