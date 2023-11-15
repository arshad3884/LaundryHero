package laundryhero.pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import laundryhero.resources.XPathUtils;

public class HeroAvailability {
	WebDriver driver;
	public HeroAvailability(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath="//button[text()='Save']")
	WebElement save;
	@FindBy (xpath="//div[text()='Updated successfully']")
	WebElement successfullToast;
	public boolean activeHeroStatusOnParticularDay(String day)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		int xpathIndex = 0;
		if (day.equalsIgnoreCase("Monday"))
		{
			xpathIndex = 2;
		}
		else if (day.equalsIgnoreCase("Tuesday"))
		{
			xpathIndex = 3;
		}
		else if (day.equalsIgnoreCase("Wednesday"))
		{
			xpathIndex = 4;
		}
		else if (day.equalsIgnoreCase("Thursday"))
		{
			xpathIndex = 5;
		}
		else if (day.equalsIgnoreCase("Friday"))
		{
			xpathIndex = 6;
		}
		else if (day.equalsIgnoreCase("Saturday"))
		{
			xpathIndex = 7;
		}
		else if (day.equalsIgnoreCase("Sunday"))
		{
			xpathIndex = 8;
		}
		
		String selectedDateToggleText = String.format("(//label[@class='switch'])[%s]",xpathIndex);
		WebElement selectedDateToggle = driver.findElement(By.xpath(selectedDateToggleText));
		String togglePreviousStatusText = String.format("(//label[@class='switch']//input[@type='checkbox'])[%s]", xpathIndex);
		WebElement togglePreviousStatus = driver.findElement(By.xpath(togglePreviousStatusText));
		if (!togglePreviousStatus.isSelected())
		{
			selectedDateToggle.click();
			save.click();
			wait.until(ExpectedConditions.visibilityOf(successfullToast));
			return true;
		}
		if (togglePreviousStatus.isSelected())
		{
			return true;
		}
		else return false;
	}
}
