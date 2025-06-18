package pageObjects;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EmployeePage extends BasePage{

	public EmployeePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//a[normalize-space()='Add a New Employee']") WebElement link_addEmployee;
	@FindBy(xpath = "//input[@id='password']") WebElement text_password;
	@FindBy(xpath = "//input[@id='first_name']") WebElement text_username;
	@FindBy(xpath = "//input[@id='last_name']") WebElement text_lastname;
	@FindBy(xpath = "//input[@id='ssn_text']") WebElement ssn;
	@FindBy(xpath = "//input[@id='address_1']") WebElement text_address;
	@FindBy(xpath = "//input[@id='city']") WebElement text_city;
	@FindBy(xpath = "//input[@id='stateTypeahead']") WebElement text_state;
	@FindBy(xpath = "//input[@id='zip_code']") WebElement text_zipcode;
	@FindBy(xpath = "//input[@id='countryTypeahead']") WebElement text_country;
	@FindBy(xpath = "//input[@id='birthdate']") WebElement text_birthdate;
	@FindBy(xpath = "//select[@id='gender']") WebElement text_gender;
	@FindBy(xpath = "//select[@id='marital_status']") WebElement text_marital_status;
	@FindBy(xpath = "//input[@id='hire_date']") WebElement hiredate;
	@FindBy(xpath = "//input[@id='benefits_start_date']") WebElement start_date;
	@FindBy(xpath = "//select[@id='employment_level']") WebElement select_emp_level;
	@FindBy(xpath = "//select[@id='location']") WebElement select_location;
	@FindBy(xpath = "//input[@id='current_salary']") WebElement text_current_salary;
	@FindBy(xpath = "//input[@id='benefit_salary']") WebElement text_benifit_salary;
	@FindBy(xpath = "//button[@id='btn_save']") WebElement btn_save;
	
	public void clickLinkAddEmployee(){
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='Add a New Employee']")));
		link_addEmployee.click();
		
	}
	
	
	public void addEmployeeDetails(String password, String username, String lastname, String ssnno, 
			String address, String city, String state, String zipcode, String country, String birthdate, String gender, 
			String marital_status, String current_salary, String benifit_salary) {
		
		text_password.sendKeys(password);
		text_username.sendKeys(username);
		text_lastname.sendKeys(lastname);
		ssn.sendKeys(ssnno);
		text_address.sendKeys(address);
		text_city.sendKeys(city);
		text_state.sendKeys(state);
		text_zipcode.sendKeys(zipcode);
		text_country.sendKeys(country);
		text_birthdate.sendKeys(birthdate);
		text_gender.sendKeys(gender);
		text_marital_status.sendKeys(marital_status);
		LocalDate beforeDate = LocalDate.now().minusDays(2);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		String newDate = beforeDate.format(formatter);
		hiredate.sendKeys(newDate);
		start_date.sendKeys(newDate);
		Select emplevel = new Select(select_emp_level);
		emplevel.selectByValue("F");
		Select loc = new Select(select_location);
		loc.selectByValue("SCA");
		text_current_salary.sendKeys(current_salary);
		text_benifit_salary.sendKeys(benifit_salary);
		btn_save.click();	
	}
	
	public void addEmployeeDetail(String password, String username) {
		
		text_password.sendKeys(password);
		text_username.sendKeys(username);
	}

}
