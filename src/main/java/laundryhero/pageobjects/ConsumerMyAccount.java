package laundryhero.pageobjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ConsumerMyAccount {

	WebDriver driver;
	public ConsumerMyAccount(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy (xpath="//a[@href='/profile']")
	WebElement profile;
	
	@FindBy (xpath="//a[@href='/notification']")
	WebElement notification;
	
	@FindBy (xpath="//a[@href='/payment']")
	WebElement payment;
	
	@FindBy (xpath="//a[@href='/prefrrence']")
	WebElement preferences;
	
	@FindBy (xpath="//a[@href='/transactions']")
	WebElement transactions;
	
	@FindBy (xpath="//button[text()='Delete Account']")
	WebElement deleteAccount;
	
	@FindBy (xpath="//button[@class='btn btn-primary']")
	WebElement popupOK;
	
	@FindBy (xpath="//button[text()='Switch to hero account']")
	List <WebElement> switchtoHero;
	@FindBy (xpath="//button[@class='btn btn-primary']")
	WebElement okCTA;
	
	public void goToConsumerProfile()
	{
		profile.click();
	}
	public void goToConsumerNotification()
	{
		notification.click();
	}
	public void goToConsumerPaymentMethod()
	{
		payment.click();
	}
	public void goToConsumerPreferences()
	{
		preferences.click();
	}
	public void goToConsumerTransactions()
	{
		transactions.click();
	}
	public boolean deleteConsumerAccount() throws InterruptedException
	{
		deleteAccount.click();
		popupOK.click();
		Thread.sleep(2000);
		String currentURL = driver.getCurrentUrl();
		if (currentURL.equals("https://consumer.freshify.io/login"))
		{
			return true;
		}
		else return false;
	}
	public boolean switchToHero()
	{
		if (switchtoHero.size()>0)
		{	
			WebElement switchtoHeroCTA = switchtoHero.get(0);
			switchtoHeroCTA.click();
			okCTA.click();
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[text()='Register as Hero']")));
			return true;
		}
		else return false;
	}
	
}
