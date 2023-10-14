package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage{
	private WebDriver driver;
	private WebDriverWait wait;

	@FindBy(xpath = "//a[text()='Add to cart']")
	WebElement addToCartBtn;

	@FindBy(className = "name")
	WebElement productName;
	
	@FindBy(xpath = "//a[text()='Home ']")
	WebElement home;

	
	public ProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 15);
	}
	public void addToCart() {
		addToCartBtn.click();
	}

	public String getProductName() {
		return productName.getText();
	}

	public void clickHome() {
		home.click();
	}
}
