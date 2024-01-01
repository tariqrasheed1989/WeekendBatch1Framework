package StandaloneTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import abc.PageObjects.LoginPage;
import abc.PageObjects.OrderConfirmationPage;
import abc.PageObjects.ProductCateloguePage;

public class BaseClass 
{
	WebDriver driver;
	Properties prop;
	LoginPage loginPage;
	public WebDriver initializeBrowser() throws IOException
	{
		prop=new Properties();
		String fileLocation=System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\Properties.properties";
		FileInputStream fis=new FileInputStream(fileLocation);
		prop.load(fis);
		String browser=prop.getProperty("browser");//chrome
		if(browser.equalsIgnoreCase("Chrome"))
		{
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}
		else if(browser.equalsIgnoreCase("Edge"))
		{
			driver=new EdgeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}	else if(browser.equalsIgnoreCase("safari"))
		{
			//safari browser
		}
		return driver;
	}
	@BeforeMethod (alwaysRun = true)
	public void DashboardPage() throws IOException
	{		
		driver =initializeBrowser();
		loginPage=new LoginPage(driver);
		loginPage.launchApplication();		
	}
	@AfterMethod(alwaysRun = true)
	public void closeBrower()
	{
		driver.close();;
	}

}
