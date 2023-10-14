package pages;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Alerts {

	private WebDriver driver;
	private WebDriverWait wait;
	
	public Alerts(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 15);
	}
	
	
	public String getAlertMsg() {
		wait.until(ExpectedConditions.alertIsPresent());
		return driver.switchTo().alert().getText();
		
	}
	
	public void clickOkAlert() {
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
	}
	
	public  String randomString()
	{
		String generatedString = RandomStringUtils.randomAlphabetic(8);
		return generatedString;
	}
}
