package laundryhero.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConsumerSignup {
	
	WebDriver driver;
	public ConsumerSignup(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy (name="email_or_phone")
	WebElement email_or_phone;
	
	@FindBy (name="password")
	WebElement setPassword;
	
	@FindBy (name="confirmpassword")
	WebElement confirmPassword;
	
	@FindBy (name="conditions")
	WebElement privacyCheckbox;
	
	@FindBy (css=".main-button")
	WebElement signupCTA;
	
	@FindBy (name="otp")
	WebElement otpfield;
	
	@FindBy (css=".main-button")
	WebElement SubmitVerifyOTP;
	
	public void createConsumerAccount(String email_phone, String password)
	{
		email_or_phone.sendKeys(email_phone);
		setPassword.sendKeys(password);
		confirmPassword.sendKeys(password);
		privacyCheckbox.click();
		signupCTA.click();
	}
	
	public void verifyConsumerAccount(String OTP)
	{
		otpfield.sendKeys(OTP);
		SubmitVerifyOTP.click();
	}
}

