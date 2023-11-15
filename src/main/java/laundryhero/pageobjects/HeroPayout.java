package laundryhero.pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HeroPayout {
	WebDriver driver;
	public HeroPayout(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy (xpath="//div[@class='my-3']//input[@id='subject']")
	WebElement city;
	@FindBy (xpath="(//input[@placeholder='Date of Birth'])[2]")
	WebElement dob;
	@FindBy (xpath="//input[@aria-label='Year']")
	WebElement dobYear;
	@FindBy (xpath="//select[@aria-label='Month']")
	WebElement dobMonth;
	@FindBy (xpath="(//input[@placeholder='Line Number'])[1]")
	WebElement lineNumber;
	@FindBy (xpath="//input[@placeholder='Postel Code']")
	WebElement postalCode;
	@FindBy (xpath="//input[@placeholder='State']")
	WebElement statename;	
	@FindBy (xpath="//select[@name='gender']")
	WebElement gender;
	@FindBy (xpath="//button[text()='Create Account']")
	WebElement createAccount;
	public boolean createHeroPayoutAccount(String City, String DOByear, String DOBmonth, String DOBday, String address, String zip, String state, String sex) throws InterruptedException
	{	//Create a stripe connect account for hero
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		city.sendKeys(City);
		dob.click();
		dobYear.click();
		dobYear.sendKeys(DOByear);
		Select month = new Select(dobMonth);
		month.selectByVisibleText(DOBmonth);
		String dynamicXPath = String.format("(//span[@class='flatpickr-day'])[text()='%s']", DOBday);
		driver.findElement(By.xpath(dynamicXPath)).click();
		lineNumber.sendKeys(address);
		postalCode.sendKeys(zip);
		statename.sendKeys(state);
		Select genderlist = new Select(gender);
		genderlist.selectByVisibleText(sex);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);", createAccount);
		Thread.sleep(2000);
		Actions action = new Actions(driver);
		action.moveToElement(createAccount).click().perform();
		return true;
	}
	
	@FindBy (xpath="//button[text()='Add new debit card']")
	WebElement addCardButton;
	@FindBy (xpath="//iframe[@title='Secure card number input frame']")
	WebElement cardNoFrame;
	@FindBy (xpath="//input[@placeholder='1234 1234 1234 1234']")
	WebElement cardNumber;
	@FindBy (xpath="//iframe[@title='Secure expiration date input frame']")
	WebElement expiryFrame;
	@FindBy (name="exp-date")
	WebElement cardExpiry;
	@FindBy (xpath="//iframe[@title='Secure CVC input frame']")
	WebElement cvcFrame;
	@FindBy (name="cvc")
	WebElement cvc;
	@FindBy (xpath="//button[text()='Save']")
	WebElement save;
	@FindBy (xpath="//div[text()='your card is saved 👌']")
	WebElement successToast;
	public boolean addHeroPayoutMethod(String cardNo, String expiry, String CVC)
	{
		addCardButton.click();	
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(save));
		driver.switchTo().frame(cardNoFrame);
		cardNumber.sendKeys(cardNo);
		driver.switchTo().parentFrame();
		driver.switchTo().frame(expiryFrame);
		cardExpiry.sendKeys(expiry);
		driver.switchTo().parentFrame();
		driver.switchTo().frame(cvcFrame);
		cvc.sendKeys(CVC);
		driver.switchTo().parentFrame();
		save.click();
		wait.until(ExpectedConditions.visibilityOf(successToast));
		return true;
	}
}
