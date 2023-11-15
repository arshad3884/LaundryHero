package laundryhero.pageobjects;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConsumerTransactions {
	
	WebDriver driver;
	public ConsumerTransactions(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath="//button[text()='This week']")
	WebElement thisweek;
	@FindBy (xpath="//button[text()='This month']")
	WebElement thismonth;
	@FindBy (xpath="//button[text()='Date range']")
	WebElement dateRange;
	
	@FindBy (xpath="//button[contains(@class, 'react-calendar__tile')]")
	List <WebElement> days;
	
	@FindBy (xpath="//button[contains(@class, 'react-calendar__navigation__prev2-button')]")
	WebElement calendarBackNavg;
	
	public void viewThisWeekTransactions()
	{
		thisweek.click();
	}
	public void viewThisMonthTransactions()
	{
		thismonth.click();
	}
	public void viewRandomDateTransactions()
	{
		dateRange.click();
		int NoOfDays = days.size(); // size is 35
		Random random = new Random(); // create a random class object
		int randomIndex1 = random.nextInt(NoOfDays); //it will give a number btw 1 to 35 
		WebElement from= days.get(randomIndex1); //get a specific webelement on particular random number
		from.click();
		calendarBackNavg.click(); // Go to previous year 
		int randomIndex2 = random.nextInt(NoOfDays);
		WebElement to = days.get(randomIndex2);
		to.click();
	}
}
