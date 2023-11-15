package laundryhero.pageobjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConsumerMyProfile {
	WebDriver driver;
	public ConsumerMyProfile(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy (xpath="//input[@name='firstName']")
	WebElement firstName;
	
	@FindBy (xpath="//input[@name='lastName']")
	WebElement lastName;
	
	@FindBy (xpath="//input[@name='email']")
	WebElement email;
	
	@FindBy (xpath="//input[@placeholder='1 (702) 123-4567']")
	WebElement phoneField;
	
	@FindBy (xpath="//button[@class='reset-password-button mt-3']")
	WebElement resetPassword;
	
	@FindBy (xpath="//input[@placeholder='Create new Password']")
	WebElement newPassword;
	
	@FindBy (xpath="//input[@placeholder='Confirm new Password']")
	WebElement confirmNewPassword;
	
	@FindBy (xpath="//button[text()='Submit']")
	WebElement submitNewPassword;
	
	@FindBy (id="imageInput")
	WebElement imageUpload;
	
	@FindBy (xpath="//button[text()='Update']")
	WebElement updateCTA;
	
	@FindBy (css=".Toastify__toast-body")
	WebElement toastMessage;
	
	public boolean updateConsumerProfile(String fName, String LName, String phone, String imgURL) throws InterruptedException
	{
		Thread.sleep(2000);
		firstName.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
		lastName.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
		phoneField.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
		
		Actions action = new Actions(driver);
		Thread.sleep(2000);
		action.click(firstName).sendKeys(fName).build().perform();
		Thread.sleep(2000);
		action.click(lastName).sendKeys(LName).build().perform();
		Thread.sleep(2000);
		action.click(phoneField).sendKeys(phone).build().perform();
		Thread.sleep(1000);
		imageUpload.sendKeys(imgURL);
		Thread.sleep(2000);
		updateCTA.click();
		Thread.sleep(2000);
		
		if (toastMessage.isDisplayed())
		{
			return true;
		}
		else return false;
		
	}
	public boolean updateConsumerPassword(String newpass) throws InterruptedException 
	{
		resetPassword.click();
		newPassword.sendKeys(newpass);
		confirmNewPassword.sendKeys(newpass);
		submitNewPassword.click();
		Thread.sleep(2000);
		String currentURL = driver.getCurrentUrl();
		if (currentURL.equals("https://consumer.freshify.io/login"))
		{
			return true;
		}
		else return false;
	}
}
