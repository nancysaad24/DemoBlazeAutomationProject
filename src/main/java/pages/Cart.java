package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Cart {
	private WebDriver driver;
	private WebDriverWait wait;
	int numOfProducts = 0;

	@FindBy(id = "totalp")
	WebElement totalPrice;

	@FindBy(xpath = "//tr[@class='success']/td[3]")
	List<WebElement> listOfPrices;

	@FindBy(linkText = "//a[text()='Delete']")
	List<WebElement> linkDelete;

	@FindBy(xpath = "//button[text()='Place Order']")
	WebElement placeOrderBtn;

	@FindBy(id = "name")
	WebElement nameField;

	@FindBy(id = "country")
	WebElement countryField;

	@FindBy(id = "city")
	WebElement cityField;

	@FindBy(id = "card")
	WebElement cardField;

	@FindBy(id = "month")
	WebElement monthField;

	@FindBy(id = "year")
	WebElement yearField;

	@FindBy(xpath = "//button[text()='Purchase']")
	WebElement purchaseBtn;

	@FindBy(xpath = "//h2[text()='Thank you for your purchase!']")
	WebElement successfulPurchaseWindow;

	@FindBy(xpath = "//button[text()='OK']")
	WebElement okBtnWindow;

	@FindBy(xpath = "//button[text()='Close']")
	WebElement closeBtnWindow;

	public Cart(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 30);
	}

	public int getPrice() {
		wait.until(ExpectedConditions.visibilityOf(totalPrice));
		return Integer.parseInt(totalPrice.getText());
	}

	public void clickPlaceOrder() {
		placeOrderBtn.click();
	}

	public void enterPlaceOrderData(String name, String country, String city, String card, String month, String year) {
		nameField.sendKeys(name);
		countryField.sendKeys(country);
		cityField.sendKeys(city);
		cardField.sendKeys(card);
		monthField.sendKeys(month);
		yearField.sendKeys(year);
	}

	public void clickPurchase() {
		purchaseBtn.click();

	}

	public void okSuccessfulPopup() throws InterruptedException {
		Thread.sleep(4000);
		okBtnWindow.click();

	}

	public void deleteProduct(int index) {
		 if (index >= 0 && index < linkDelete.size()) {
			 linkDelete.remove(index);
		 }
	  numOfProducts = linkDelete.size();
	}

	public boolean isProductDeleted() {
		return numOfProducts > linkDelete.size();
	}
}
