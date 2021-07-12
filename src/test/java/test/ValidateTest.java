package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.ValidatePage;
import util.BrowserFactory;

public class ValidateTest {
	
	WebDriver driver;
	
	@Test
	public void validUserShouldBeAbleToValidateTest() {
		driver = BrowserFactory.init();
		
		ValidatePage validatePage = PageFactory.initElements(driver, ValidatePage.class);
		validatePage.insertCategoryValue("TFTest21");
		validatePage.clickAddCategoryButton();
		validatePage.chooseDateOption("5");
		validatePage.chooseMonthOption("Feb");
		validatePage.chooseYearOption("2022");
		
		BrowserFactory.tearDown();
	}

}
