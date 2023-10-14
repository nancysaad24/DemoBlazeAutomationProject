package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	private WebDriver driver;
	

	@FindBy(xpath = "//img[@src='bm.png']")
	WebElement logo;

	@FindBy(xpath = "//a[text()='Home ']")
	WebElement home;

	@FindBy(xpath = "//a[text()='Sign up']")
	WebElement signUpLink;

	@FindBy(xpath = "//a[text()='Log in']")
	WebElement loginBtn;

	@FindBy(xpath = "//a[@href='cart.html']")
	WebElement cartBtn;

	@FindBy(xpath = "//a[text()='Contact']")
	WebElement contactBtn;

	@FindBy(xpath = "//a[text()='About us']")
	WebElement aboutUsBtn;

	@FindBy(xpath = "//a[text()='CATEGORIES']")
	WebElement categoriesLink;

	@FindBy(xpath = "//a[text()='Phones']")
	WebElement phonesLink;

	@FindBy(xpath = "//a[text()='Nokia lumia 1520']")
	WebElement nokiaLumia1520;

	@FindBy(xpath = "//a[text()='Laptops']")
	WebElement laptopsLink;

	@FindBy(xpath = "//a[text()='MacBook air']")
	WebElement macBookAir;

	@FindBy(xpath = "//a[text()='Monitors']")
	WebElement monitorsLink;

	@FindBy(xpath = "//a[text()='Apple monitor 24']")
	WebElement appleMonitor;

	@FindBy(xpath = "//Button[text()='Previous']")
	WebElement previousBtn;

	@FindBy(xpath = "//Button[text()='Next']")
	WebElement nextBtn;

	@FindBy(xpath = "//span[@class='carousel-control-next-icon']")
	WebElement nextRightArrow;

	@FindBy(xpath = "//span[@class='carousel-control-prev-icon']")
	WebElement previousLeftArrow;

	@FindBy(xpath = "//a[text()='Log out']")
	WebElement logoutbtn;

	
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void clickHome() {
		home.click();
	}

	public boolean islogoDisplayed() {
		return logo.isDisplayed();
	}

	public boolean isLogoutShown() {
		return logoutbtn.isDisplayed();
	}

	public void logout() {
		logoutbtn.click();
	}

	public void homeSignUp() {
		signUpLink.click();
	}

	public void login() {
		loginBtn.click();
	}

	public void cart() {
		cartBtn.click();
	}

	public void contactUs() {
		contactBtn.click();
	}

	public void aboutUs() {
		aboutUsBtn.click();
	}

	public void clickCategories() {
		categoriesLink.click();
	}

	public void chooseLaptops() {
		laptopsLink.click();
	}

	public void choosePhones() {
		phonesLink.click();
	}

	public void chooseMonitors() {
		monitorsLink.click();
	}

	public void chooseNokiaLumia1520() {
		nokiaLumia1520.click();
	}

	public boolean isNokiaLumiaDisplayed() {
		return nokiaLumia1520.isDisplayed();
	}

	public void chooseMacBook() {
		macBookAir.click();
	}

	public boolean isMacBookDisplayed() {
		return macBookAir.isDisplayed();
	}

	public void chooseAppleMonitor() {
		appleMonitor.click();
	}

	public boolean isAppleMonitorisplayed() {
		return appleMonitor.isDisplayed();
	}

	public void clickNext() {
		nextBtn.click();
	}

	public void clickPrevious() {
		previousBtn.click();
	}

	public void clickPreviousLeftArrow() {
		previousLeftArrow.click();
	}

	public void clickNextRightArrow() {
		nextRightArrow.click();
	}

	  public String getUrl() {
	        return driver.getCurrentUrl();
	    }
}
