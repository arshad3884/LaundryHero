package laundryhero.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConsumerNotifications {
	WebDriver driver;
	public ConsumerNotifications(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy (xpath="(//span[@class='slider round'])[1]")
	WebElement app;

	@FindBy (xpath="(//span[@class='slider round'])[2]")
	WebElement sms;
	
	@FindBy (xpath="(//span[@class='slider round'])[3]")
	WebElement email;
	
	public boolean enableDisableAppNotifications()
	{
		app.click();
		return true;
	}
	public boolean enableDisableSMSNotifications()
	{
		sms.click();
		return true;
	}
	public boolean enableDisableEmailNotifications()
	{
		email.click();
		return true;
	}
}
