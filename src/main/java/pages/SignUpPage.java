package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage {
	
	private WebDriver driver;
	
	@FindBy(id = "sign-username")
	WebElement usernameTextBox;
	
	@FindBy(id = "sign-password")
	WebElement passwordTextBox;
	
	@FindBy(xpath ="//div[2]//button[text()='Close']")
	WebElement closeBtn;
	
	@FindBy(xpath ="//button[text()='Sign up']")
	WebElement signUpBtn;
	
	@FindBy(xpath ="//div[2]//span[text()='×']")
	WebElement xBtn;
	
	
	public SignUpPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	

	
	public void signUp(String username, String password) {
		usernameTextBox.clear();
		passwordTextBox.clear();
		usernameTextBox.sendKeys(username);
		passwordTextBox.sendKeys(password);
		signUpBtn.click();
	}
	
	public void clickSignUp() {
		signUpBtn.click();
	}
	
	public void closeSignUpWindow() {
		closeBtn.click();
	}
	
	public void closeSignUpWindowFromX() {
		xBtn.click();
	}
	

	

}
