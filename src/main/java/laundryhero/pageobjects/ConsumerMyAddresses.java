package laundryhero.pageobjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ConsumerMyAddresses {
	
	WebDriver driver;
	public ConsumerMyAddresses(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath="//a[@href='/my-addresses']")
	WebElement myAddresses;
	
	@FindBy (xpath="//button[text()='Add New Address']")
	WebElement addNewAddressCTA;
	
	@FindBy (name="addressName")
	WebElement inputAddressName;
	
	@FindBy (xpath="//input[@placeholder='Type Street address']")
	WebElement inputStreetAddress;
	
	@FindBy (xpath="//button[@class='rounded-4 btn btn-primary']")
	WebElement continueCTA;
	
	@FindBy (xpath="(//button[text()='Delete'])[1]")
	WebElement deleteCTA;
	
	public void goToAddresses()
	{
		myAddresses.click();
	}
	public boolean addNewAddress(String addressName, String address) throws InterruptedException
	{
		addNewAddressCTA.click();
		inputAddressName.sendKeys(addressName);
		inputStreetAddress.sendKeys(address);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@aria-expanded='true']")));
		inputStreetAddress.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", continueCTA);
		Thread.sleep(2000);
		String onPage = driver.getCurrentUrl();
		System.out.println(onPage);
		if (onPage.equals("https://consumer.freshify.io/my-addresses"))
		{
			return true;
		}
		else return false;
	}
	public boolean deleteAddress()
	{
		if (deleteCTA.isDisplayed()) {
		deleteCTA.click(); //delete the first one
		return true;
		}
		else return false;
	}
	
	public void viewAddress(String addresstoView)
	{
		List <WebElement> addresses= driver.findElements(By.xpath("//h4[@class='card-title text-secondary']"));
		WebElement viewAddress = addresses.stream()
			    .filter(address -> address.getText().contains(addresstoView))
			    .findFirst()
			    .orElse(null);
		viewAddress.click();
	}
}
