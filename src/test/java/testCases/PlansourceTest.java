package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.BenefitPage;
import pageObjects.EmployeePage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class PlansourceTest extends BaseClass{
	
	
	
	@Test
	public void login_PlanSource()
	{
		logger.info("**** Starting Plan Source Test ****");
		LoginPage login = new LoginPage(driver);
		logger.info("**** Entering Login Details ****");
		login.enterLoginDetails(prop.getProperty("username"), prop.getProperty("password"));
		logger.info("**** Logged in Successfully ****");
	}
	@Test(dependsOnMethods = {"login_PlanSource"})
	public void enter_Employee_Details()
	{
		logger.info("**** Entering Employee Details ****");
		EmployeePage page = new EmployeePage(driver);
		page.clickLinkAddEmployee();
		page.addEmployeeDetails("Jeetu_5293", "Robert", "Clive", randomNumber(), "1258 State Rd"
		, "Aurora", "Ohio", "44202", "United States", 
		"11051991", "Male", "Single", "125946", "235");
		logger.info("**** Entered Employee Details ****");
		
	}
	@Test(dependsOnMethods = {"enter_Employee_Details"})
	public void do_new_enrollment_and_select_medical_plan()
	{
		logger.info("**** Starting New Hire Enrollment ****");
		BenefitPage bp = new BenefitPage(driver);
		bp.clickNewHireEnrollment();
		bp.clickGetStarted();
		bp.clickReviewMyFamily();
		logger.info("**** Adding Dependent ****");
		bp.enterDependentDetails("Sansa", "Stark", "07051995");
		bp.shopMedicalPlan();
		bp.hsaSurveyAnswer();
		bp.returnToBenefitsLink();
		logger.info("**** Clicking Admin from Menu-bar and Selecting Proceed to checkout ****");
		HomePage hm = new HomePage(driver);
		hm.clickOnMenuListBar();
		hm.clickonAdminAndSelectProceedToCheckout();
		bp.clickOnCheckout();
		String enrollmentmsg = bp.getEnrollmentMessage();
		if(enrollmentmsg.equals("Congratulations. You have completed the new hire enrollment process and confirmed your benefits."))
		{
			Assert.assertTrue(true);
		}
		else
		{	
		logger.error("Test Failed");
		logger.debug("debug logs...");
		Assert.assertTrue(false);
		}
	}

} 
