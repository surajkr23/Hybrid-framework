package com.EducationalDomain.wipro.PomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * 
 * @author surajkumar
 *
 */
public class skillraryDemoLoginPage {
	/**
	 * It is used to store all the skillraryDemoApp elements
	 */
	@FindBy(xpath="//a[text()='COURSE']")
	private WebElement coursebtn;
	
	@FindBy(xpath="(//a[text()='Selenium Training'])[2]")
	private WebElement seleniumtrainning;

	public skillraryDemoLoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getCoursebtn() {
		return coursebtn;
	}

	public WebElement getSeleniumtrainning() {
		return seleniumtrainning;
	}
	
	public addToCartPage course(WebDriver driver)
	{
		seleniumtrainning.click();
		return new addToCartPage(driver);
	}
}
