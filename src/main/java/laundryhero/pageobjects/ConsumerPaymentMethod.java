package laundryhero.pageobjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ConsumerPaymentMethod {
	WebDriver driver;
	public ConsumerPaymentMethod(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy (xpath="//button[text()='Add New Method']")
	WebElement addPaymentMethod;
	
	@FindBy (xpath="(//iframe[contains(@src,'stripe.com/v3/elements-inner-card')])[1]")
	WebElement frame1;
	
	@FindBy (xpath="(//iframe[contains(@src,'stripe.com/v3/elements-inner-card')])[2]")
	WebElement frame2;
	
	@FindBy (xpath="(//iframe[contains(@src,'stripe.com/v3/elements-inner-card')])[3]")
	WebElement frame3;
	
	@FindBy (xpath="//input[@placeholder='1234 1234 1234 1234']")
	WebElement cardNumber;
	
	@FindBy (xpath="//input[@placeholder='MM / YY']")
	WebElement expiryDate;
	
	@FindBy (xpath="//input[@placeholder='CVC']")
	WebElement cvc;

	@FindBy (xpath="//button[text()='Add Card']")
	WebElement addCardCTA;
	
	@FindBy (xpath="//div[text()='your card is saved 👌']")
	WebElement confirmationToast;
	
	@FindBy (xpath="//button[@id='dropdown-basic']")
	WebElement dropdownoption;
	
	@FindBy (xpath="//a[text()='Set as default']")
	WebElement setAsDefault;
	
	@FindBy (xpath="//div[text()='Card set as default payment method successfully']")
	WebElement defaultConfirmation;
	
	@FindBy (xpath="//a[text()='Delete payment method']")
	WebElement deletePayment;
	
	@FindBy (xpath="//div[text()='Card Deleted Successfully']")
	WebElement deleteConfirmation;
	
	public boolean addNewPaymentMethod(String cardNo, String expiry, String cvcNo) throws InterruptedException
	{
		addPaymentMethod.click();
		Thread.sleep(2000);
		
        driver.switchTo().frame(frame1);
		cardNumber.sendKeys(cardNo);
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame(frame2);
		expiryDate.sendKeys(expiry);
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame(frame3);
		cvc.sendKeys(cvcNo);
		driver.switchTo().defaultContent();
		
		addCardCTA.click();
		Thread.sleep(3000);
		String currentURL = driver.getCurrentUrl();
		if (currentURL.equals("https://consumer.freshify.io/payment"))
		{
		return true;
		}
		else return false;
	}
	public boolean makePaymentMethodDefault()
	{
		dropdownoption.click();
		setAsDefault.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(defaultConfirmation));
		if (defaultConfirmation.isDisplayed())
		{
			return true;
		}
		else return false;
	}
	public boolean deletePaymentMethod()
	{
		dropdownoption.click();
		deletePayment.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(deleteConfirmation));
		if (deleteConfirmation.isDisplayed())
		{
			return true;
		}
		else return false;
	}
}

