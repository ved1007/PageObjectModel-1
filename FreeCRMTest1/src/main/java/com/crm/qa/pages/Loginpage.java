package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class Loginpage extends TestBase{
	
	// Page Factory = Object Repository 
	
	//User Name
	@FindBy(name="username")
	WebElement username;
	
	//Password
	@FindBy(name="password")
	WebElement password;
	
	//Login btn
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginbtn;
	
	//SignUpBtn
	@FindBy(xpath="//button[contains(text(), 'Sign Up')]")
	WebElement signUpBtn;
	
	
	//SignUpBtn
	@FindBy(xpath="//img[contains(@class, 'img-responsive')]")
	WebElement crmLogo;
	
	
	// How will you initialize your page factory? We have method PageFactory.initElements
	// "this" word is for all method in class
	//driver is coming from TestBase class Ctrl + Click
	
	public Loginpage(){
		PageFactory.initElements(driver, this);
	}

	public static String validateLoginPageTitle(){
		return driver.getTitle();
		
	}
	
	public boolean validateCRMIMage(){
		return crmLogo.isDisplayed();
		
		
	}
	
	// Wrote HomePage because we are returning HomePage
	public HomePage login(String un, String pwd){
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginbtn.click();
		
		return new HomePage();
		
	}
	
	
}
