package abc.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abc.AbstractComponents.AbstractComponents;

public class CartPage extends AbstractComponents
{
 WebDriver driver;
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='cartSection'] //h3")
	WebElement productsName;
	
	@FindBy(xpath="//button[normalize-space()='Checkout']") WebElement btnCheckout;
	
	public String getProduct()
	{
		return productsName.getText().toUpperCase();
	}
	
	public PaymentConfirmationPage checkout()
	{
		scrollDownByPixel(150);
		waitUntillElementIsClickable(btnCheckout, 10);
		btnCheckout.click();
		return new PaymentConfirmationPage(driver);
	}

}
