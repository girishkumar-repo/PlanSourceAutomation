package pageObjects;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BenefitPage extends HomePage{

	public BenefitPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//a[normalize-space()='New Hire Enrollment']") WebElement link_new_hire_enrollment;
	@FindBy(xpath = "//a[@id='enrollmentStepOne']") WebElement btn_getStarted;
	@FindBy(xpath = "//span[normalize-space()='Next: Review My Family']") WebElement btn_reviewMyFamily;
	@FindBy(xpath = "//a[normalize-space()='Add Family Member']") WebElement link_addFamilyMember;
	@FindBy(xpath = "//span[@data-content-type='title']") WebElement title_dependentInfo;
	@FindBy(xpath = "//input[@id='first_name']") WebElement txt_firstname;
	@FindBy(xpath = "//input[@id='last_name']") WebElement txt_lastname;
	@FindBy(xpath = "(//*[contains(text(),'Select Gender')])[1]") WebElement dropdown_gender;
	@FindBy(xpath = "//*[@id='gender']") WebElement select_gender;
	@FindBy(xpath = "//input[@id='birthdate']") WebElement birth_date;
	@FindBy(xpath = "//select[@id='relationship']") WebElement sel_relationship;
	@FindBy(xpath = "//span[normalize-space()='Save']") WebElement btn_save;
	@FindBy(xpath = "//span[normalize-space()='Next: Shop for Benefits']") WebElement btn_shopBenefits;
	@FindBy(xpath = "//div[1]//div[1]//main[1]//div[2]//div[1]//div[2]//div[2]//div[1]//div[1]//div[1]//div[1]//h1[1]") WebElement header_CurrentBenefits;
	@FindBy(xpath = "//section[@aria-labelledby='Medical']//a[@class='btn benefit-btn btn-primary'][normalize-space()='Shop Plans']") WebElement btn_shopplans;
	@FindBy(xpath = "//button[@id='updateCartBtn']") WebElement btn_updatecart;
	@FindBy(xpath = "//span[@data-content-type='title']") WebElement title_hsasurvey;
	@FindBy(xpath = "//span[normalize-space()='No']") WebElement rbtn_no;
	@FindBy(xpath = "//button[@id='next']") WebElement btn_next;
	@FindBy(xpath = "//*[text()='Benefits & Family']") WebElement header_benfits;
	@FindBy(xpath = "//*[text()='To Benefits']") WebElement return_toBenefits;
	@FindBy(xpath = "//button[@type='submit']//span[contains(text(),'Checkout')]") WebElement btn_checkout;
	@FindBy(xpath = "//p[@class='p-y-xs']") WebElement enrollment_message;
	@FindBy(xpath = "//*[contains(text(),'Medical: Full PPO Savings')]") WebElement header_medical;
	
	
	
	public void clickNewHireEnrollment() 
	{
		wait.until(ExpectedConditions.visibilityOf(link_new_hire_enrollment));
		js.executeScript("arguments[0].scrollIntoView();", header_benfits);
		link_new_hire_enrollment.click();
	}
	
	public void clickGetStarted()
	{
		wait.until(ExpectedConditions.visibilityOf(btn_getStarted));
		btn_getStarted.click();
	}
	
    public void clickReviewMyFamily() {
    	js.executeScript("arguments[0].scrollIntoView();", btn_reviewMyFamily);
    	btn_reviewMyFamily.click();
    }
    
    public void enterDependentDetails(String first_name, String last_name, String birthdate) 
    {
    	wait.until(ExpectedConditions.visibilityOf(title_dependentInfo));
    	link_addFamilyMember.click();
    	txt_firstname.sendKeys(first_name);
    	txt_lastname.sendKeys(last_name);
    	dropdown_gender.click();
    	Select gender = new Select(select_gender);
    	gender.selectByValue("F");
    	birth_date.sendKeys(birthdate);
    	Select sel = new Select(sel_relationship);
    	sel.selectByValue("spouse");
    	btn_save.click();
    	
    }
    
    public void shopMedicalPlan()
    {
    	js.executeScript("arguments[0].scrollIntoView();", btn_shopBenefits);
    	btn_shopBenefits.isDisplayed();
    	btn_shopBenefits.click();
        wait.until(ExpectedConditions.visibilityOf(header_CurrentBenefits));
        btn_shopplans.click();
//        js.executeScript("arguments[0].scrollIntoView();", header_medical);
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        wait.until(ExpectedConditions.elementToBeClickable(btn_updatecart));
        btn_updatecart.click();
    }
    
    public void hsaSurveyAnswer() {
    	wait.until(ExpectedConditions.visibilityOf(title_hsasurvey));
    	rbtn_no.click();
    	btn_next.click();
    	btn_save.click();
    }
    
    public void returnToBenefitsLink()
    {
    	return_toBenefits.click();
    }
    
    public void clickOnCheckout()
    {
    	btn_checkout.click();
    }
    
    public String getEnrollmentMessage()
	{
    	try {
    		return (enrollment_message.getText());
    	}catch(Exception e)
    	{
    		return (e.getMessage());
    	}
	}
}
