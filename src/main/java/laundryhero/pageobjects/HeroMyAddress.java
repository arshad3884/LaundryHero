package laundryhero.pageobjects;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HeroMyAddress {

	WebDriver driver;
	public HeroMyAddress(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy (xpath="//a[@href='/address/edit-hero-address']")
	WebElement heroAddress;
	@FindBy (xpath="//input[@name='addressName']")
	WebElement addressName;
	@FindBy (xpath="//input[@placeholder='Type Street address']")
	WebElement streetAddress;
	@FindBy (xpath="(//div[@class='shadow shadow-md p-2 cursor-pointer'])[1]")
	WebElement addressFirstSuggession;
	@FindBy (xpath="(//div[@class='mb-3 row'])[2]")
	WebElement continueCTA;
	
	public boolean updateHeroAddress(String name, String address) throws InterruptedException
	{
		heroAddress.click(); //edit the address
		addressName.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		addressName.sendKeys(name);
		streetAddress.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		streetAddress.sendKeys(address);
		Thread.sleep(1000);
		addressFirstSuggession.click();
		Thread.sleep(1000);
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", continueCTA);
		Thread.sleep(1000);
		continueCTA.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.urlToBe("https://consumer.freshify.io/hero-home"));
		if (driver.getCurrentUrl().equals("https://consumer.freshify.io/hero-home"))
		{
			return true;
		}
		else return false;
	}
}
