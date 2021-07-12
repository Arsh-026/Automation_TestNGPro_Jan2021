package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class ValidatePage extends BasePage {
	
	@FindBy(how=How.NAME, using = "categorydata") WebElement  ADD_CATEGORY_VALUE;
	@FindBy(how=How.CSS, using = "input[value='Add category']") WebElement  ADD_CATEGORY_BUTTON;
	@FindBy(how=How.NAME, using = "due_day") WebElement  DUE_DATE;
	@FindBy(how=How.NAME, using = "due_month") WebElement  DUE_MONTH;
	@FindBy(how=How.NAME, using = "due_year") WebElement  DUE_YEAR;
	
	public void insertCategoryValue(String addCategoryValue) {
		ADD_CATEGORY_VALUE.sendKeys(addCategoryValue);
	}
	
	public void clickAddCategoryButton() {
		ADD_CATEGORY_BUTTON.click();
	}
	
	public void chooseDateOption(String date) {
		SelectDropDown(DUE_DATE, date);
		
	}
	
	public void chooseMonthOption(String month) {
		SelectDropDown(DUE_MONTH, month);
		
	}
	
	public void chooseYearOption(String year) {
		SelectDropDown(DUE_YEAR, year);
		
	}
	public void SelectDropDown(WebElement elementLocator, String visibleText) {
		Select select = new Select(elementLocator);
		select.selectByVisibleText(visibleText);
	}
		
		
}
