package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{
	
	//User's First and Last login name
	@FindBy(xpath="//td[contains(text(),'User: Vedant Jagani')]")
	@CacheLookup  // This one will create memory and store into the element . This one take from case. It will store in Cache memory| If page refresh than it will fail
	              // How to improve your test script.... User @CascheLookup
	WebElement usernameLabel;
	
	@FindBy(xpath="//a[contains(text(), 'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath="//a[contains(text(), 'New Contact')]")
	WebElement newContactLink;
	
	@FindBy(xpath="//a[contains(text(), 'Deals')]")
	WebElement dealsLink;
	
	@FindBy(xpath="//a[contains(text(), 'Tasks')]")
	WebElement tasksLink;
	
	//Initializing the Page Objects
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle(){
		return driver.getTitle();
	}
	
	public boolean verifyCorrenctUserName(){
		return usernameLabel.isDisplayed();
	}
	public ContactsPage clickOnContactsLink(){
		contactsLink.click();
		return new ContactsPage();
		
	}
	
	public DealsPage clickOnDealsLink(){
		dealsLink.click();
		return new DealsPage();
		
	}
	
	public TasksPage clickOnTasksLink(){
		tasksLink.click();
		return new TasksPage();
		
	}
	
	public void clickOnNewContactLink(){
		Actions action = new Actions(driver);
		action.moveToElement(contactsLink).build().perform();
		newContactLink.click();
		
	}
	
	
	
}


