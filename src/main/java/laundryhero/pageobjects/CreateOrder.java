package laundryhero.pageobjects;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateOrder {
	
	WebDriver driver;
	public CreateOrder(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy (xpath="(//select[@class='form-select'])[1]")
	WebElement selectAddress;
	
	@FindBy (xpath="(//select[@class='form-select'])[2]")
	WebElement pickupTime;
	
	@FindBy (css="li[class='next'] a")
	WebElement nextCTA;
	
	@FindBy (css=".form-group.mb-3.input-group")
	WebElement deliveryDate;
	
	@FindBy (xpath="((//div[@class='flatpickr-days'])[2]//span[@class='flatpickr-day'])[1]")
	WebElement selectDeliveryDate;
	
	@FindBy (xpath="(//select[@class='form-select'])[3]")
	WebElement dropTime;
	
	@FindBy (xpath="//select[@placeholder='Select number of bags']")
	WebElement bags;
	
	@FindBy (css="li[class='next'] a")
	WebElement placeOrderCTA;
	
	public boolean createOrder() throws InterruptedException
	{
		Select address = new Select(selectAddress);
		address.selectByIndex(1);
		Select pickupTimeslot = new Select(pickupTime);
		pickupTimeslot.selectByIndex(1);
		nextCTA.click();
		
		deliveryDate.click();
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(selectDeliveryDate));
		selectDeliveryDate.click();
		Select dropTimeslot = new Select(dropTime);
		dropTimeslot.selectByIndex(1);
		nextCTA.click();
		
		Select selectBag= new Select(bags);
		selectBag.selectByIndex(4);
		nextCTA.click();
		
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", placeOrderCTA);
		Thread.sleep(2000);
		placeOrderCTA.click();
		
		Thread.sleep(4000);
		String currentPage = driver.getCurrentUrl();
		if (currentPage.equalsIgnoreCase("https://consumer.freshify.io/thank-you")) 
		{
			return true;
		}
		else return false;
	}
	
}
