package laundryhero.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeroTransactions {
	WebDriver driver;
	public HeroTransactions(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy (xpath="//button[text()='This week']")
	WebElement thisWeek;
	@FindBy (xpath="//button[text()='This month']")
	WebElement thisMonth;
	@FindBy (xpath="//button[text()='Date range']")
	WebElement dateRange;
	@FindBy (xpath="//button[@class='react-calendar__navigation__label']")
	WebElement calendarNavigationLabel;
	@FindBy (xpath="(//button[contains(@class, \"react-calendar__tile react-calendar__month-view__days__day\")])[7]")
	WebElement startDate;
	@FindBy (xpath="(//button[contains(@class, \"react-calendar__tile react-calendar__month-view__days__day\")])[29]")
	WebElement endDate;
	public void viewThisWeekTransactions()
	{
		thisWeek.click();
	}
	public void viewThisMonthTransactions()
	{
		thisMonth.click();
	}
	public void viewHeroTransactionsInDateRange()
	{
		dateRange.click();
		startDate.click();
		endDate.click();
	}
}
