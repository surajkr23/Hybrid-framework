package com.EducationalDomain.wipro;

import org.testng.annotations.Test;

import com.EducationalDomain.wipro.PomPages.LoginPage;
import com.EducationalDomain.wipro.PomPages.addToCartPage;
import com.EducationalDomain.wipro.PomPages.skillraryDemoLoginPage;
import com.EducationalDomain.wipro.genericLib.BaseClass;
public class TestCase1 extends BaseClass{
	@Test
	public void testcase1()
	{
		LoginPage l=new LoginPage(driver);
		skillraryDemoLoginPage da = l.demoApp(driver);
		utilities.switchTabs(driver);
		utilities.mouseHover(driver, da.getCoursebtn());
		addToCartPage cart = da.course(driver);
		utilities.doubleclick(driver, cart.getAddbtn());
		cart.getAddtocartbtn();
		utilities.alertPopupOk(driver);
		
	}
}
