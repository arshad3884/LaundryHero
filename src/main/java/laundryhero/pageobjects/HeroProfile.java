package laundryhero.pageobjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HeroProfile {
	WebDriver driver;
	public HeroProfile(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy (xpath="//input[@name='firstName']")
	WebElement firstName;
	@FindBy (xpath="//input[@name='lastName']")
	WebElement lastName;
	@FindBy (xpath="//input[@placeholder='1 (702) 123-4567']")
	WebElement phone;
	@FindBy (xpath="//input[@id='imageInput']")
	WebElement profileImage;
	@FindBy (xpath="//button[text()='Update']")
	WebElement update;
	@FindBy (xpath="//div[@class='Toastify__toast-body']//div[text()='User Updated Successfully']")
	List <WebElement> successfulToast;
	public boolean updateProfileInfo(String FirstName, String LastName, String phoneNo) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		//wait.until(ExpectedConditions.elementToBeClickable(firstName));
		Thread.sleep(10000);
		firstName.clear();
		firstName.sendKeys(FirstName);
		Thread.sleep(1000);
		lastName.clear();
		lastName.sendKeys(LastName);
		Thread.sleep(1000);
		phone.clear();
		Thread.sleep(1000);
		phone.sendKeys(phoneNo);
		Thread.sleep(1000);
		profileImage.sendKeys("C:\\Users\\hp\\Pictures\\Dummy pics\\avatar_17.jpg");
		Thread.sleep(1000);
		update.click();
		Thread.sleep(3000);
		if (successfulToast.size()>0)
		{
			return true;
		}
		else return false;
	}
	@FindBy (xpath="//button[@class='reset-password-button mt-3']")
	WebElement resetPassword;
	@FindBy (xpath="//input[@placeholder='Create new Password']")
	WebElement newPassword;
	@FindBy (xpath="//input[@placeholder='Confirm new Password']")
	WebElement confirmPassword;
	@FindBy (xpath="//button[text()='Submit']")
	WebElement submit;
	public boolean resetHeroPassword(String password) throws InterruptedException
	{
		resetPassword.click();
		newPassword.sendKeys(password);
		confirmPassword.sendKeys(password);
		submit.click();
		Thread.sleep(4000);
		if (driver.getCurrentUrl().equalsIgnoreCase("https://consumer.freshify.io/hero-home"))
			{
			return true;
			}
		else return false;
	}
	
}
