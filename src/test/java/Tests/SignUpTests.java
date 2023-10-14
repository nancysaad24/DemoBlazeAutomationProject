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
import pages.SignUpPage;

public class SignUpTests extends Base{
	public WebDriver driver;
	public Actions actions;
	HomePage hp;
	Base base;
	SignUpPage signup;
	Alerts alerts;
	
	@BeforeTest
	public void signUpBeforeTest() throws IOException  {
		driver = initializeDriver();
		actions = new Actions(driver);
		hp = new HomePage(driver);
		base = new Base();
		signup = new SignUpPage(driver);
		alerts = new Alerts(driver);
		navigateToURL();
	}
	
	@BeforeMethod
	public void signUpBeforeMethod() throws IOException, InterruptedException  {
		hp.homeSignUp();	
	}
	
	@Test(priority = 1)
	public void case01_signUpWithValidInputs() {
		String un = alerts.randomString();
		String username = un+"@gmail.com";
		String pwd = alerts.randomString();
		signup.signUp(username, pwd);
		Assert.assertEquals(alerts.getAlertMsg(), "Sign up successful.");
		alerts.clickOkAlert();
	}
	
	
	@Test(priority = 2)
	public void case02_signUpWithValidUsernameEmptyPassword() {
		String un = alerts.randomString();
		String username = un+"@gmail.com";
		signup.signUp(username, "");
		Assert.assertEquals(alerts.getAlertMsg(), "Please fill out Username and Password.");
		alerts.clickOkAlert();
		signup.closeSignUpWindow();
		
	}
	
	
	@Test(priority = 3)
	public void case03_signUpWithEmptyUsernameValidPassword() {
		String pwd = alerts.randomString();
		signup.signUp("", pwd);
		Assert.assertEquals(alerts.getAlertMsg(), "Please fill out Username and Password.");
		alerts.clickOkAlert();
		signup.closeSignUpWindow();
	}
	
	
	@Test(priority = 4)
	public void case04_signUpWithEmptyBothEmptyFields() {
		signup.signUp("", "");
		Assert.assertEquals(alerts.getAlertMsg(), "Please fill out Username and Password.");
		alerts.clickOkAlert();
		signup.closeSignUpWindow();
	}
	
	@AfterClass(alwaysRun = true)
	public void signUpAfterClass() {
		tearDownTest();
	}
	

}
