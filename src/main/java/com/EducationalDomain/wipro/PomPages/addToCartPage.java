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
public class addToCartPage {
	/**
	 * It is used to store all the add to cart elements
	 */
	@FindBy(id="add")
	private WebElement addbtn;
	
	@FindBy(xpath="//button[text()=' Add to Cart']")
	private WebElement addtocartbtn;

	public addToCartPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getAddbtn() {
		return addbtn;
	}

	public WebElement getAddtocartbtn() {
		return addtocartbtn;
	}
	
	
}
