package Tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.Base;
import pages.Alerts;
import pages.HomePage;
import pages.ProductPage;

public class ProductPageTests extends Base{
	public WebDriver driver;
	public Actions actions;
	HomePage hp;
	Base base;
	ProductPage productpage;
	Alerts alerts;

	
	@BeforeTest
	public void productPageBeforeTest() throws IOException  {
		driver = initializeDriver();
		actions = new Actions(driver);
		hp = new HomePage(driver);
		base = new Base();
		productpage = new ProductPage(driver);
		alerts = new Alerts(driver);
		navigateToURL();
	}
	
	@BeforeMethod
	public void productPageBeforeMethod()  {
		hp.clickHome();	
	}
	
	
	@Test(enabled = true)
	public void case01_checkAnyMobileProductPage() {
		hp.clickCategories();
		hp.choosePhones();
		hp.chooseNokiaLumia1520();
		Assert.assertEquals(productpage.getProductName(), "Nokia lumia 1520");
		productpage.addToCart();
		Assert.assertEquals(alerts.getAlertMsg(), "Product added");
		
	}
	
	@Test(enabled = true)
	public void case02_checkAnyLaptopProductPage() {
		hp.clickCategories();
		hp.chooseLaptops();
		hp.chooseMacBook();
		Assert.assertEquals(productpage.getProductName(), "MacBook air");
		productpage.addToCart();
		Assert.assertEquals(alerts.getAlertMsg(), "Product added");
		
	}
	
	@Test(enabled = true)
	public void case03_checkAnyMonitorProductPage() {
		hp.clickCategories();
		hp.chooseMonitors();
		hp.chooseAppleMonitor();
		Assert.assertEquals(productpage.getProductName(), "Apple monitor 24");
		productpage.addToCart();
		Assert.assertEquals(alerts.getAlertMsg(), "Product added");
		
	}
	
	
	@AfterMethod
	public void afterMethod()  {
		alerts.clickOkAlert();
		productpage.clickHome();
	}
	
	@AfterClass(alwaysRun = true)
	public void productPageafterClass() {
		tearDownTest();
	}
	
}
