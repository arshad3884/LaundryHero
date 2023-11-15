package laundryhero.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConsumerInviteFriends {
	WebDriver driver;
	public ConsumerInviteFriends(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy (css=".share-button")
	WebElement shareButton;
	
	@FindBy (xpath="//button[@aria-label='facebook']")
	WebElement facebook;
	
	@FindBy (xpath="//button[@aria-label='whatsapp']")
	WebElement whatsapp;

	@FindBy (xpath="//button[@aria-label='twitter']")
	WebElement twitter;

	@FindBy (xpath="//button[@aria-label='telegram']")
	WebElement telegram;

	@FindBy (xpath="//button[@aria-label='pinterest']")
	WebElement pinterest;

	@FindBy (xpath="//button[@aria-label='reddit']")
	WebElement reddit;

	@FindBy (xpath="//button[@aria-label='tumblr']")
	WebElement tumblr;

	@FindBy (xpath="//button[@aria-label='email']")
	WebElement email;
	
	public void sendInviteOnAllSocialLinks() throws InterruptedException
	{
		shareButton.click();
		Thread.sleep(2000);
		facebook.click();
		whatsapp.click();
		twitter.click();
		telegram.click();
		pinterest.click();
		reddit.click();
		tumblr.click();
		email.click();
		Thread.sleep(8000);
	}
}
