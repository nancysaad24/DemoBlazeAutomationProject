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
import pages.Alerts;
import pages.Cart;
import pages.HomePage;
import pages.ProductPage;

public class CartTests extends Base {
	public WebDriver driver;
	public Actions actions;
	HomePage hp;
	Base base;
	ProductPage productpage;
	Cart cart;
	Alerts alerts;

	@BeforeTest
	public void CartBeforeTest() throws IOException {
		driver = initializeDriver();
		actions = new Actions(driver);
		hp = new HomePage(driver);
		base = new Base();
		productpage = new ProductPage(driver);
		alerts = new Alerts(driver);
		cart = new Cart(driver);
		navigateToURL();
		hp.clickCategories();
		hp.choosePhones();
		hp.chooseNokiaLumia1520();
		productpage.addToCart();
		alerts.clickOkAlert();
		hp.clickHome();
		hp.clickCategories();
		hp.chooseLaptops();
		hp.chooseMacBook();
		productpage.addToCart();
		alerts.clickOkAlert();
		
	}

	@BeforeMethod
	public void cartBeforeMethod() {
		hp.clickHome();
	}

	@Test(priority = 1)
	public void case01_checkTotalPrice() {
		hp.cart();
		Assert.assertEquals(cart.getPrice(), 1520);
	}

	@Test(priority = 2)
	public void case02_deleteProduct() {
		hp.cart();
		cart.deleteProduct(1);
	}

	@Test(priority = 3)
	public void case03_purchaseOrder() throws InterruptedException {
		hp.cart();
		Thread.sleep(1000);
		cart.clickPlaceOrder();
		cart.enterPlaceOrderData("Demo", "UAE", "Dubai", "12345678926174862", "10", "2024");
		cart.clickPurchase();
		cart.okSuccessfulPopup();
		Assert.assertEquals(hp.getUrl(),"https://www.demoblaze.com/index.html");
	}
	
	@AfterClass(alwaysRun = true)
	public void cartAfterClass() {
		tearDownTest();
	}

}
