package laundryhero.pageobjects;

import java.time.Duration;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HeroHome {
	WebDriver driver;
	public HeroHome(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy (xpath="//button[text()='Route']")
	WebElement route;
	
	@FindBy (xpath="//button[text()='Accept ']")
	WebElement accept;
	
	@FindBy (xpath="//div[text()='Order accepted']")
	WebElement orderSuccessfulToast;
	
	@FindBy (xpath="//a[@href='/hero-address']")
	WebElement goToMyAddress;
	
	public void goToMyAddress()
	{
		goToMyAddress.click();
	}
	public boolean acceptPendingOrder() throws InterruptedException
	{
		if (route.isDisplayed())//confirms that pending orders are available
		{
			JavascriptExecutor js = (JavascriptExecutor)driver;
			int scrollValue = 300; // Adjust the value as per your requirement
			js.executeScript("window.scrollBy(0, arguments[0]);", scrollValue);
			Thread.sleep(2000);
			accept.click();
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			wait.until(ExpectedConditions.visibilityOf(orderSuccessfulToast));
			if (orderSuccessfulToast.isDisplayed())
			{
				return true;
			}
			else return false;
		}
		return false;
	}
	@FindBy (xpath="//button[text()='Decline']")
	WebElement decline;
	@FindBy (xpath="//textarea[@name='textArea']")
	WebElement declineCommentbox;
	@FindBy (xpath="//button[text()='Yes, decline order']")
	WebElement confirmDecline;
	public void declinePendingOrder() throws InterruptedException
	{
		if (route.isDisplayed())//confirms that pending orders are available
		{
			JavascriptExecutor js = (JavascriptExecutor)driver;
			int scrollValue = 300; // Adjust the value as per your requirement
			js.executeScript("window.scrollBy(0, arguments[0]);", scrollValue);
			Thread.sleep(2000);
			decline.click();
			declineCommentbox.sendKeys("Not Interesting in this Order!!");
			confirmDecline.click();
		}
	}
	public void viewPendingOrdersRoute()
	{
		if (route.isDisplayed())//confirms that pending orders are available
		{
			route.click();
		}
	}
	@FindBy (xpath="(//a[@class='nav-link'])[1]")
	WebElement today;
	public void viewTodayOrders()
	{
		today.click();
	}
	@FindBy (xpath="(//a[@class='nav-link'])[2]")
	WebElement allTime;
	public void viewAllTimeOrders()
	{
		allTime.click();
	}
	@FindBy (xpath="(//input[@placeholder='Select Date'])[2]")
	WebElement selectDate;
	@FindBy (xpath="//select[@aria-label='Month']")
	WebElement monthList;
	@FindBy (xpath="//span[@class='flatpickr-day']")
	List <WebElement> days;
	public void viewRandomDateOrders()
	{
		selectDate.click();
		//Selecting month randomly
		Select month = new Select(monthList);
		Random random = new Random();
		month.selectByIndex(random.nextInt(11));
		//Selecting day randomly
		Collections.shuffle(days);// shuffle the days elements in the list 
		WebElement randomDate = days.get(0); //get the first element after shuffle
		randomDate.click(); 
	}
	@FindBy (xpath="//h5[text()='Active: Awaiting Pickup']")
	WebElement awaitingPickupHeading;
	@FindBy (xpath="//a[@href='/hero-management']//span[text()='Pickup']")
	List <WebElement> awaitingPickupOrders;
	@FindBy (xpath="(//button[@class='sc-beqWaB cvyJEp rec rec-arrow rec rec-arrow-right'])[1]")
	WebElement swipeRight1;
	public boolean viewAllAwaitingPickupOrders() throws InterruptedException
	{
		if (awaitingPickupHeading.isDisplayed())
		{
			JavascriptExecutor js = (JavascriptExecutor)driver;
			int scrollValue = 500; // Adjust the value as per your requirement
			js.executeScript("window.scrollBy(0, arguments[0]);", scrollValue);
			for(WebElement awaitingPickupOrder:awaitingPickupOrders)
			{
				Thread.sleep(2000);
				Actions actions = new Actions(driver);
		        actions.keyDown(Keys.CONTROL).click(awaitingPickupOrder).keyUp(Keys.CONTROL).build().perform();
		        int size = awaitingPickupOrders.size();
		        int count=0;
		        if (count<size)
		        	{	count++;
		        		swipeRight1.click();
		        	}
			}
			return true;
		}
		return false;
		
	}
	@FindBy (xpath="//h5[text()='Active: Awaiting Drop-off']")
	WebElement awaitingDropoffHeading;
	@FindBy (xpath="//span[text()='Delivery']")
	List <WebElement> awaitingDropoffOrders;
	@FindBy (xpath="(//button[@class='sc-beqWaB cvyJEp rec rec-arrow rec rec-arrow-right'])[2]")
	WebElement swipeRight2;
	public boolean viewAllAwaitingDropoffOrders() throws InterruptedException
	{
		if (awaitingDropoffHeading.isDisplayed())
		{
			JavascriptExecutor js = (JavascriptExecutor)driver;
			//int scrollValue = 900; // Adjust the value as per your requirement
			js.executeScript("window.scrollBy(0, document.body.scrollHeight)");
			for(WebElement awaitingDropoffOrder:awaitingDropoffOrders)
			{
				Thread.sleep(2000);
				Actions actions = new Actions(driver);
		        actions.keyDown(Keys.CONTROL).sendKeys(Keys.ENTER).keyUp(Keys.CONTROL).click(awaitingDropoffOrder).build().perform();
				int size = awaitingDropoffOrders.size();
				int count=0;
				if (count<size)
				{	count++;
		        	swipeRight2.click();
				}
			}
			return true;
		}
		return false;
	}
	@FindBy (xpath="//a[@href='/hero-orders']")
	WebElement myOrders;
	public void goToMyOrders()
	{
		myOrders.click();
	}
	@FindBy (xpath="//a[@href='/hero-account']")
	WebElement myAccount;
	public void goToHeroAccount()
	{
		myAccount.click();
	}
	@FindBy (xpath="//a[@href='/hero-support?id=admintoken']")
	WebElement contactSupport;
	public void goTOContactSupport()
	{
		contactSupport.click();
	}
	@FindBy (xpath="//a[@href='/hero-support?id=admintoken']")
	WebElement legal;
	public void goToLegal()
	{
		legal.click();
	}
	@FindBy (xpath="//span[text()='Logout']")
	WebElement logout;
	public void logoutHero()
	{
		logout.click();
	}
	@FindBy (xpath="//span[@class='slider round']")
	WebElement statusToggle;
	@FindBy (xpath="//input[@value='AVAILABLE']")
	WebElement availableTag;
	@FindBy (xpath="//input[@value='NOT_AVAILABLE']")
	WebElement unavailableTag;
	public boolean changeHeroStatusToInactive() throws InterruptedException 
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(statusToggle));
		Thread.sleep(3000);
	try {
		if (availableTag.isEnabled())
		{	
			statusToggle.click();
			return true;
		}
	}catch(NoSuchElementException e){
		return true;
	}
	return false;
	}
	public boolean changeHeroStatusToActive() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(statusToggle));
		Thread.sleep(3000);
	try {
		if (unavailableTag.isEnabled())
		{	
			statusToggle.click();
			return true;
		}
	}catch(NoSuchElementException e){
			return true;
	}
	return false;
	}
}

