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
public class LoginPage {
	/**
	 * It is used to store all the login elements
	 */
	@FindBy(xpath="//a[text()=' GEARS ']")
	private WebElement gearsbtn;
	
	@FindBy (xpath="(//a[@class='ignorelink'])[16]")
	private WebElement skillrarydemoapp;
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public skillraryDemoLoginPage demoApp(WebDriver driver)
	{
		gearsbtn.click();
		skillrarydemoapp.click();
		return new skillraryDemoLoginPage(driver);
	}

	public WebElement getGearsbtn() {
		return gearsbtn;
	}

	public WebElement getSkillrarydemoapp() {
		return skillrarydemoapp;
	}

}
