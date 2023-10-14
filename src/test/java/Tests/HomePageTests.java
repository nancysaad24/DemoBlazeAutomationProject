package Tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.Base;
import pages.HomePage;

public class HomePageTests extends Base {

	public WebDriver driver;
	public Actions actions;
	HomePage hp;

	@BeforeTest
	public void homePageBeforeTest() throws IOException {
		driver = initializeDriver();
		actions = new Actions(driver);
		hp = new HomePage(driver);
		navigateToURL();
	}
	
	@BeforeMethod
	public void homePageBeforeMethod()  {
		hp.clickHome();	
	}

	@Test(enabled = true)
	public void case01_checkCategories() {
		hp.clickCategories();
		hp.choosePhones();
		Assert.assertTrue(hp.isNokiaLumiaDisplayed());
		hp.chooseLaptops();
		Assert.assertTrue(hp.isMacBookDisplayed());
		hp.chooseMonitors();
		Assert.assertTrue(hp.isAppleMonitorisplayed());

	}
	
	@AfterClass(alwaysRun = true)
	public void homePageAfterClass() {
		tearDownTest();
	}
}
