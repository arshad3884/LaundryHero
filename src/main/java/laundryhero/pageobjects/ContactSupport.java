package laundryhero.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactSupport {
	WebDriver driver;
	public ContactSupport(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy (xpath="(//a[@href='/support'])[1]")
	WebElement adminSupport;
	@FindBy (xpath="//input[@placeholder='Enter Message...']")
	WebElement inputChat;
	@FindBy (xpath="(//button[@type='button'])[2]")
	WebElement sendCTA; 
	@FindBy (xpath="//i[@id='Emojitooltip']")
	WebElement emojiTooltip;
	@FindBy (xpath="//button[@data-unified='1f600']")
	WebElement smileEmoji;
	public void helloToAdminSupport()
	{
		adminSupport.click();
		inputChat.sendKeys("Hello Admin!");
		sendCTA.click();
		emojiTooltip.click();
		smileEmoji.click();
		sendCTA.click();
	}
}
