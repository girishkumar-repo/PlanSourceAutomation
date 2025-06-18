package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//input[@id='user_name']") WebElement txt_username;
	@FindBy(xpath = "//input[@id='password']") WebElement txt_password;
	@FindBy(xpath = "//input[@id='logon_submit']") WebElement loginbtn;
	
	public void enterLoginDetails(String username, String password)
	{
        txt_username.sendKeys(username);
		txt_password.sendKeys(password);
		loginbtn.click();
	}
	
	
	
	

}
