package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.Loginpage;
import com.crm.qa.util.TestUtil;

public class ContactspageTest extends TestBase{
	
	Loginpage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	
	String sheetName = "contacts";
	
	public ContactspageTest(){
		super();
		
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		testUtil = new TestUtil();
		contactsPage = new ContactsPage();
		loginPage = new Loginpage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil.switchToFrame();
		contactsPage = homePage.clickOnContactsLink();
	}
	
	@Test(priority=1)
	public void verifyContactspageLabel(){
		Assert.assertTrue(contactsPage.verifyContactsLabel(),"contacts label is missing on the page");
	}
	
	@Test(priority=2)
	public void selectContactsTest(){
		contactsPage.selectContactsByName("Vedant2 Jagani2");
	}
	
	@Test(priority=3)
	public void selectMultipleContactsTest(){
		contactsPage.selectContactsByName("Vedant2 Jagani2");
		contactsPage.selectContactsByName("Vedant3 Jagani3");
	}
	
	@DataProvider
	public Object[][] getCRMTestData(){
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	//Data from Excel file
	@Test(priority=4, dataProvider="getCRMTestData")
	public void validateCreateNewContact(String title, String firstname, String lastname, String company){
		homePage.clickOnNewContactLink();
	//	contactsPage.createNewContact("Mr.", "Tom", "Peter", "Google");
		contactsPage.createNewContact(title, firstname, lastname, company);
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
