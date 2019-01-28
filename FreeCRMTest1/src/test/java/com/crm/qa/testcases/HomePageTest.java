package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.Loginpage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase{
	Loginpage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	
	
	
	public HomePageTest(){
		super();
		
	}
	
	// calling initialization method Test Base class
	// Test case should be separated -- independent with each other
	// Before each test case launch browser and login 
	//After each test case --- close the browser
	
	@BeforeMethod
	public void setUp(){
		initialization();
		testUtil = new TestUtil();
		contactsPage = new ContactsPage();
		loginPage = new Loginpage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	//Verify Home page title
	@Test(priority=1)
	public void verifyHomePageTitleTest(){
		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "CRMPRO", "Home page title not matched");
	}
	
	// for this method Xpath is not able to find , UserName is within the frame so created Frame
	@Test(priority=2)
	public void verifyUserNameTest(){
		testUtil.switchToFrame();
		Assert.assertTrue(homePage.verifyCorrenctUserName());
	}
	
	@Test(priority=3)
	public void verifyContactsLinkTest(){
		testUtil.switchToFrame();
		contactsPage =homePage.clickOnContactsLink();
	}
	
	
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
