package laundryhero.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Forgot_Reset_Password {

	WebDriver driver;
	public Forgot_Reset_Password(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy (name="email_or_phone")
	WebElement email_or_phone;
	
	@FindBy (css=".main-button")
	WebElement submit;
	
	@FindBy (name="otp")
	WebElement otpfield;
	
	@FindBy (name="password")
	WebElement newPassword;
	
	@FindBy (name="confirmpassword")
	WebElement confirmPassword;
	
	@FindBy (css=".main-button")
	WebElement resetPassword;
	
	public void goToforgotPassword(String phone_email)
	{
		email_or_phone.sendKeys(phone_email);
		submit.click();
		// waiting for OTP screen
	}
	
	public boolean Resetpassword(String OTP, String newpassword) throws InterruptedException
	{
		otpfield.sendKeys(OTP);
		newPassword.sendKeys(newpassword);
		confirmPassword.sendKeys(newpassword);
		resetPassword.click();
		Thread.sleep(2000);
		String currentURL = driver.getCurrentUrl();
		if (currentURL.equals("https://consumer.freshify.io/login"))
		{		
		return true;
		}
		else return false;
	}
}
