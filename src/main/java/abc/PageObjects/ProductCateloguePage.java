package abc.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abc.AbstractComponents.AbstractComponents;

public class ProductCateloguePage extends AbstractComponents
{
	WebDriver driver;
	
	public ProductCateloguePage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(xpath="//div[@class='card-body']/h5/b")
	private List<WebElement> products;
	
	@FindBy(xpath="//button[normalize-space()='Add To Cart']")
	List<WebElement> AddToCart;
	
	@FindBy(id="toast-container")
	WebElement toastContainer;
	
	
	public List<WebElement> productList()
	{
		return products;
	}
	
	public void addToCart(List<WebElement> productsName, String productName)
	{
		for(int i=0;i<productsName.size();i++)
		{
			if(productsName.get(i).getText().equalsIgnoreCase(productName))
			{
				AddToCart.get(i).click();
			}
		}
	}
	
	public CartPage GoToCart()
	{
		waitUntilElementIsInvisible(toastContainer, 20);
		ClickOnCart();
		return new CartPage(driver);
	}
		
	
}
