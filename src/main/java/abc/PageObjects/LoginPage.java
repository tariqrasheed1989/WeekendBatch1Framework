package abc.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abc.AbstractComponents.AbstractComponents;

public class LoginPage extends AbstractComponents
{
	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{	super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
@FindBy(id="userEmail")
private WebElement username;

@FindBy(id="userPassword")
private WebElement password;

@FindBy(id="login")
private WebElement btnLogin;

@FindBy(css="div#toast-container")
private WebElement ToastMsg;

//	WebElement username=driver.findElement(By.id("userEmail"));
//	WebElement password=driver.findElement(By.id("userPassword"));
//	WebElement btnLogn=driver.findElement(By.id("login"));

public ProductCateloguePage login(String uName,String pwd)
{
	username.sendKeys(uName);
	password.sendKeys(pwd);
	btnLogin.click();
	
	ProductCateloguePage productCateloguePage=new ProductCateloguePage(driver);
	return productCateloguePage;
}
public void launchApplication()
{
	driver.get("https://rahulshettyacademy.com/client");
}

public String getText()
{
	//waitUntilElementIsVisible(ToastMsg, 5);
	return ToastMsg.getText();
	
}

}
