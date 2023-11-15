package laundryhero.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (name="email_or_phone")
	WebElement email_phone;
	
	@FindBy (name="password")
	WebElement userPassword;
	
	@FindBy (css =".main-button")
	WebElement loginCTA;
	
	@FindBy (xpath="//a[@href='/forgot-password']")
	WebElement ForgotPass;
	
	@FindBy (xpath="//a[@href='/signup']")
	WebElement createAccountlink;
	
	public void goTO()
	{
		driver.get("https://consumer.freshify.io/login");
	}
	public void loginApplication(String email, String password)
	{
		email_phone.sendKeys(email);
		userPassword.sendKeys(password);
		loginCTA.click();
	}
	public void goTOforgotPassword()
	{
		ForgotPass.click();
	}
	public void goTOCreateAccount()
	{
		createAccountlink.click();
	}
}
