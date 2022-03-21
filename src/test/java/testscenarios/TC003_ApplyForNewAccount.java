package testscenarios;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import base.BaseClass;
import pages.ApplyForNewAccountPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ApplyPage;

public class TC003_ApplyForNewAccount extends BaseClass{
	
	@BeforeTest
	public void testCaseSetUp() {
		excelFile = "TC003";
	}	
	
	@Test(priority = 1)
	public void ApplyForNewAccountValidation() {
		boolean result = new LoginPage(driver)
		.typeUserName("ramnad")
		.typePassword("kannakku234")
		.clickSignOn()
		.validateHomePage()
		.clickApplyForNewAccount()
		.verifyAllTheAcctFields();
		
		new ApplyForNewAccountPage(driver)
		.clickApply()
		.verifyAccountCreatePage()
		
		//new ApplyPage(driver)
		.clickOnViewAccout()
		.clickonLogout();
		
		Assert.assertTrue(result);
	}
	
	@Test(priority = 2,dataProvider = "TestCaseData")
	public void accountCreation(String accountNickName,String typeOfAccount) {
		boolean result = new LoginPage(driver)
		.typeUserName("ramnad")
		.typePassword("kannakku234")
		.clickSignOn()
		.clickApplyForNewAccount()
		.enterAccountNicktName(accountNickName+getRandomIntNumber(1000,10000))
		.selectTypeOfAccount(typeOfAccount)
		.clickApply()
		.verifyAccountCreateResult();
		if (result) {
			
			System.out.println("Account Verified");
			new ApplyPage(driver)
			.clickOnViewAccout(accountNickName)
			.clickonLogout();
			
			
			
		}else {
			System.out.println("Account not much with the Given Name");
			new ApplyPage(driver)
			.clickOnViewAccout()
			.clickonLogout();
			
		}
		
		
		
//		.clickOnRegistrationLink()
//		.enterFirstName(firstName)
//		.selectTitle("Mr")
//		.enterMiddleName()
//		.enterLastName(lastName)
//		.selectGender("Male")
//		.enterUserName(userName+getRandomIntNumber(1000,10000))
//		.enterEmail(email+getRandomIntNumber(1000,10000)+"@credosystemz.com")
//		.enterPassword(password)
//		.clickRegisterLink()
//		.verifyUserRegistration()
//		.clickOnLogin();
	}
	
//	@Test(priority = 3)
//	public void registrationWithMandatoryAndOptionalFields() {
//		new LoginPage(driver)
//		.clickOnRegistrationLink()
//		.enterFirstName("Credo")
//		.selectTitle("Mr")
//		.enterMiddleName()
//		.enterLastName("Systemz")
//		.selectGender("Male")
//		.enterUserName("Credo"+getRandomIntNumber(1000,10000))
//		.enterEmail("credo"+getRandomIntNumber(1000,10000)+"@credosystemz.com")
//		.enterPassword("Credo@123")
//		.enterEmploymentStatus("Part-time")
//		.enterAge("10/10/1980")
//		.enterMartialStatus("Married")
//		.enterNumberOfDependents("3")
//		.clickRegisterLink()
//		.verifyUserRegistration()
//		.clickOnLogin();
//	}
	
	public static int getRandomIntNumber(int min,int max) {
		Random ran = new Random();
		int result = ran.nextInt((max-min)+1)+min;
		return result;
	}

}
