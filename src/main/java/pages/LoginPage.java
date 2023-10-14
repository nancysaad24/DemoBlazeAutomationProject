package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	private WebDriver driver;

	@FindBy(id = "loginusername")
	WebElement usernameLoginTextBox;

	@FindBy(id = "loginpassword")
	WebElement passwordLoginTextBox;

	@FindBy(xpath = "//button[text()='Log in']/..//button[text()='Close']")
	WebElement closeLoginBtn;

	@FindBy(xpath = "//button[text()='Log in']")
	WebElement loginBtn;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void login(String usernameLogin, String passwordLogin) {
		usernameLoginTextBox.clear();
		passwordLoginTextBox.clear();
		usernameLoginTextBox.sendKeys(usernameLogin);
		passwordLoginTextBox.sendKeys(passwordLogin);
		loginBtn.click();
	}

	public void clickLogin() {
		loginBtn.click();
	}

	public void closeLoginWindow() {
		closeLoginBtn.click();
	}

}
