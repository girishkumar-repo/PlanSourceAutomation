package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage{

	public HomePage(WebDriver driver) {
		super(driver);
	}
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	JavascriptExecutor js = (JavascriptExecutor)driver;
	
	@FindBy(xpath = "//img[@alt='Testing Plansource Client']") WebElement pageTitle;
	@FindBy(xpath = "//a[normalize-space()='Add a New Employee']") WebElement add_newemployee_link;
	@FindBy(xpath = "//span[@class='theme-primary-bg-color theme-primary-bg-color-before-after']") WebElement item_list_menu;
	@FindBy(xpath = "//a[@data-submenu-key='admin']") WebElement admin;
	@FindBy(xpath = "//*[text() ='Proceed to Checkout']") WebElement checkout;
	
	public void clickAddNewEmployeeLink() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@alt='Testing Plansource Client']")));
		add_newemployee_link.click();
	}
	
	public void clickOnMenuListBar()
    {
		wait.until(ExpectedConditions.visibilityOf(item_list_menu));
    	item_list_menu.click();
    }
	
	public void clickonAdminAndSelectProceedToCheckout() {
		admin.click();
		checkout.click();
		
	}
	
	

}
