package laundryhero.pageobjects;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HeroMyOrders {
	WebDriver driver;
	public HeroMyOrders(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy (xpath="(//a[@class='nav-link'])[2]")
	WebElement allTime;
	@FindBy (xpath="//div[@class='tab-content text-muted']//div[@class='tab-pane active']//div[@class='card-body']")
	List <WebElement> allTimeOrders;
	public boolean openAlltimeOrders() throws InterruptedException
	{
		allTime.click();
		/*
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
		LocalDate localDate = LocalDate.parse(orderDate, formatter);
		String xpathExpression = "//h5[contains(text(), '" + localDate + "')]";
		List <WebElement> todayDateOrders = driver.findElements(By.xpath(xpathExpression));
		*/
		for (int i = 0; i < allTimeOrders.size(); i++) 
		{
	        WebElement allTimeOrder = allTimeOrders.get(i);
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center' });", allTimeOrder);
			Thread.sleep(1000);
			allTimeOrder.click();
			Thread.sleep(3000);
			driver.navigate().back();
			Thread.sleep(3000);
			allTime.click();
		}
		return true;
	}
	@FindBy (xpath="//a[@class='active nav-link']")
	WebElement today;
	@FindBy (xpath="//div[@class='tab-pane active']//div[@class='card-body']")
	List <WebElement> todayDateOrders;
	@FindBy (xpath="(//div[text()='No Orders Available'])[1]")
	WebElement noOrderAvailable1;
	public boolean openTodayOrders() throws InterruptedException
	{
		today.click();
	if (!noOrderAvailable1.isDisplayed()) {
		for (int i = 0; i < todayDateOrders.size(); i++) 
		{
	        WebElement todayDateOrder= todayDateOrders.get(i);
	        JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center' });", todayDateOrder);
			Thread.sleep(1000);
			todayDateOrder.click();
			Thread.sleep(3000);
			driver.navigate().back();
			Thread.sleep(3000);
			today.click();
		}
		return true;
	}else return false;
	}
	@FindBy (xpath="//div[@class='form-group p-0 input-group']")
	WebElement selectDate;
	@FindBy (xpath="//span[@class='flatpickr-day']")
	List <WebElement> days;
	@FindBy (xpath="(//div[text()='No Orders Available'])[2]")
	WebElement noOrderAvailable2;
	@FindBy (xpath="//div[@class='tab-pane active']//div[@class='card-body']")
	List <WebElement> selectedDateOrders;
	@FindBy (xpath="(//a[contains(@class, 'nav-link')])[2]")
	WebElement dateTab;
	
	public boolean viewRandomDateOrders() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(selectDate));
		selectDate.click();
		Thread.sleep(1000);
		int randomIndex = new Random().nextInt(days.size());
		WebElement randomDay = days.get(randomIndex);
		wait.until(ExpectedConditions.elementToBeClickable(randomDay));
		randomDay.click();
		Thread.sleep(1000);
		if (noOrderAvailable2.isDisplayed() || selectedDateOrders.isEmpty())
		{
			return false;
		}
		else return true;
	}
		
}

