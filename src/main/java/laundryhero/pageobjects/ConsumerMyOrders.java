package laundryhero.pageobjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConsumerMyOrders {
	
	WebDriver driver;
	public ConsumerMyOrders(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath="//a[@href='/orders']")
	WebElement myOrders;
	
	@FindBy (xpath="(//span[@class='d-none d-sm-block'])[2]")
	WebElement history;
	
	@FindBy (xpath="(//span[@class='d-none d-sm-block'])[1]")
	WebElement inProgess;
	
	@FindBy (xpath = "//a[text()='Details']")
	List<WebElement> pendingOrders; 
	
	@FindBy (xpath="//button[text()='Detail']")
	List<WebElement> completedOrders;
	
	@FindBy (xpath="//button[text()='Detail']")
	WebElement completedOrder;
	
	@FindBy (xpath="//*[name()='path' and @fill='#fff']")
	WebElement heartIcon;
	
	@FindBy (xpath="//*[name()='path']")
	WebElement favouriteHero;
	
	@FindBy (xpath="(//button[text()='Rate your Experience'])[1]")
	WebElement rateExp;
	
	@FindBy (xpath="(//span[@style='cursor: pointer; display: inline-block; position: relative;'])[4]")
	WebElement punctuality;
	
	@FindBy (xpath="(//span[@style='cursor: pointer; display: inline-block; position: relative;'])[9]")
	WebElement cleanliness;
	
	@FindBy (xpath="(//span[@style='cursor: pointer; display: inline-block; position: relative;'])[14]")
	WebElement smell;
	
	@FindBy (xpath="(//span[@style='cursor: pointer; display: inline-block; position: relative;'])[19]")
	WebElement folding;
	
	@FindBy (xpath="(//span[@style='cursor: pointer; display: inline-block; position: relative;'])[24]")
	WebElement friendliness;
	
	@FindBy (xpath="//textarea[@name='optionalMsg']")
	WebElement optionalMsg;
	
	@FindBy (xpath="//button[text()='Submit Your Ratings']")
	WebElement submitRating;
	
	public boolean goToMyOrders()
	{
		myOrders.click();
		return true;
	}
	public boolean goToOrderDetail(String orderID)
	{
		driver.get("https://consumer.freshify.io/orders/"+orderID);
		if (driver.getCurrentUrl().contains(orderID))
			{
			return true;
			}
		else return false;
	}
	public boolean showCompletedOrderslist()
	{
		if (history.isDisplayed())
		{
		history.click();
		return true;
		}
		else return false;
	}
	public boolean showPendingOrderslist()
	{
		if (inProgess.isDisplayed())
		{
		inProgess.click();
		return true;
		}
		else return false;
		
	}
	public boolean openAllPendingOrders() throws InterruptedException
	{
		for (WebElement pendingOrder: pendingOrders)
		{
			//Open all pending orders in new tab
			 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", pendingOrder);
		     Thread.sleep(1000);
		     //Actions actions = new Actions(driver);
		     //actions.keyDown(Keys.CONTROL).click(pendingOrder).keyUp(Keys.CONTROL).build().perform();
		     pendingOrder.sendKeys(Keys.CONTROL,Keys.ENTER);
		}
		return true;
	}
	public boolean openAllCompletedOrders() throws InterruptedException
	{
		for (WebElement completedOrder:completedOrders)
		{
			//Open all completed orders in new tab
			history.click();
			//Actions actions = new Actions(driver);
			//actions.keyDown(Keys.CONTROL).click(completedOrder).keyUp(Keys.CONTROL).build().perform();
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", completedOrder);
		     Thread.sleep(1000);
		     completedOrder.sendKeys(Keys.CONTROL,Keys.ENTER);
		}
		return true;
	}
	public boolean addHeroToFavourite() throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		completedOrder.click();
		Thread.sleep(3000);
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        //jsExecutor.executeScript("arguments[0].scrollIntoView(true);", heartIcon);
		 // Scroll to a specific offset on the page
        int scrollOffset = 500; // Change this value to the desired offset
        jsExecutor.executeScript("window.scrollTo(0, " + scrollOffset + ");");
		//Actions actions = new Actions(driver);
		//actions.moveToElement(heartIcon, 1140,303).click().perform();
        Thread.sleep(2000);
	try {
        heartIcon.click();
		return true;
		}
	catch (NoSuchElementException e) {
		return false;
	}
	}
	
	public boolean removeHeroFromFavourite() throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		try {
		favouriteHero.click(); //to mark favorite hero as unfavorite 
		return true;
		}
		catch (NoSuchElementException e) {	
		return false;
		}
	}
	public boolean rateYourOrder() throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		history.click();
			JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
			//jsExecutor.executeScript("arguments[0].scrollIntoView();", rateExp);
			Thread.sleep(2000);
			rateExp.click();//click on first order available for rating
			jsExecutor.executeScript("window.scrollTo(0, 0)");
			Thread.sleep(2000);
			punctuality.click();
			cleanliness.click();
	        int scrollOffset = 1000; // Change this value to the desired offset
	        jsExecutor.executeScript("window.scrollTo(0, " + scrollOffset + ");");
	        Thread.sleep(2000);
	        smell.click();
	        folding.click();
			friendliness.click();
			optionalMsg.sendKeys("Good Job done!");
			submitRating.click();
			Thread.sleep(3000);
			String currentURL = driver.getCurrentUrl();
			if (currentURL.equals("https://consumer.freshify.io/rating-success"))
			{
			return true;
			}else return false;
	}
}
