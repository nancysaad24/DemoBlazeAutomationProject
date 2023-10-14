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
import pages.HomePage;
import pages.LoginPage;

public class LoginTests extends Base {
	public WebDriver driver;
	public Actions actions;
	HomePage hp;
	Base base;
	LoginPage loginpage;
	Alerts alerts;
	String un = "DemoTest@Test.com";
	String pwd = "12345678";

	@BeforeTest
	public void loginBeforeTest() throws IOException {
		driver = initializeDriver();
		actions = new Actions(driver);
		hp = new HomePage(driver);
		base = new Base();
		loginpage = new LoginPage(driver);
		alerts = new Alerts(driver);
		navigateToURL();

	}

	@BeforeMethod
	public void loginBeforeMethod() throws IOException, InterruptedException {
		hp.login();
	}

	@Test(priority = 1)
	public void case01_signInWithEmptyFields() {
		loginpage.login("", "");
		Assert.assertEquals(alerts.getAlertMsg(), "Please fill out Username and Password.");
		alerts.clickOkAlert();
		loginpage.closeLoginWindow();
	}

	@Test(priority = 2)
	public void case02_signInWithValidUsernameInvalidPW() {
		String pw = alerts.randomString();
		loginpage.login(un, pw);
		Assert.assertEquals(alerts.getAlertMsg(), "Wrong password.");
		alerts.clickOkAlert();
		loginpage.closeLoginWindow();
	}

	@Test(priority = 3)
	public void case03_signInWithInValidUsernameValidPW() {
		String user = alerts.randomString();
		String username = user + "@gmail.com";
		loginpage.login(username, pwd);
		Assert.assertEquals(alerts.getAlertMsg(), "User does not exist.");
		alerts.clickOkAlert();
		loginpage.closeLoginWindow();
	}

	@Test(priority = 4)
	public void case04_signInWithValidInputs() throws InterruptedException {
		loginpage.login(un, pwd);
		Thread.sleep(2000);
		Assert.assertTrue(hp.isLogoutShown());
		hp.logout();
	}
	
	@AfterClass(alwaysRun = true)
	public void loginAfterClass() {
		tearDownTest();
	}
}
