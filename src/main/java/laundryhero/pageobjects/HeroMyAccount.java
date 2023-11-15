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

public class HeroMyAccount {
	WebDriver driver;
	public HeroMyAccount(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath="//h5[text()=' Avg. rating']")
	WebElement avgRating;
	public String getHeroAvgRating()
	{
		String rating = avgRating.getText();
		return rating;
	}
	
	@FindBy (xpath="//p[@class='mb-1 text-color']")
	WebElement heroEmail;
	public String getHeroEmail()
	{
		String email = heroEmail.getText();
		return email;
	}
	
	@FindBy (xpath="//button[text()='Switch to customer account']")
	List <WebElement> switchtoConsumer;
	@FindBy (xpath="//button[@class='btn btn-primary']")
	WebElement okCTA;
	public boolean switchToConsumer()
	{
		if (switchtoConsumer.size()>0)
		{	
			WebElement switchtoHeroCTA = switchtoConsumer.get(0);
			switchtoHeroCTA.click();
			okCTA.click();
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[@class='slider round']")));
			return true;
		}
		else return false;
	}
	
	@FindBy (xpath="//a[@href='/hero-profile']")
	WebElement profile;
	@FindBy (xpath="//a[@href='/payout']")
	WebElement payout;
	@FindBy (xpath="//a[@href='/hero-transactions']")
	WebElement heroTransactions;
	@FindBy (xpath="//a[@href='/hero-availability']")
	WebElement heroAvailability;
	public void goToHeroProfile()
	{
		profile.click();
	}
	public void goTopayout()
	{
		payout.click();
	}
	public void goToHeroTransactions()
	{
		heroTransactions.click();
	}
	public void goToHeroAvailability()
	{
		heroAvailability.click();
	}
	@FindBy (xpath="//button[text()='Delete Hero Account']")
	WebElement deleteHeroAccount;
	@FindBy (xpath="//button[@class='btn btn-primary']")
	WebElement okCTA1;
	public boolean deleteHeroAccount() throws InterruptedException
	{
		deleteHeroAccount.click();
		okCTA1.click();
		Thread.sleep(4000);
		if (driver.getCurrentUrl().equals("https://consumer.freshify.io/login"))
		{
			return true;
		}
		return false;
	}
}
