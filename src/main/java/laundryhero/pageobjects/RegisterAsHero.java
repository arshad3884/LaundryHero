package laundryhero.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterAsHero {
	WebDriver driver;
	public RegisterAsHero(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy (xpath="//h1[text()='Thanks for your interest in becoming a Laundry Hero. We are reviewing your case and will get in touch as soon as possible.']")
	List <WebElement> alreadyApplied;
	@FindBy (xpath="//input[@name='Dlicense']")
	WebElement dLicenseNo;
	@FindBy (xpath="//input[@id='imageInput']")
	WebElement dLicenseImage;
	@FindBy (xpath="//input[@name='SSN']")
	WebElement SSN;
	@FindBy (xpath="(//input[@name='condition'])[1]")
	WebElement authorizeCheck;
	@FindBy (xpath="(//input[@name='condition'])[2]")
	WebElement termsCondition;
	@FindBy (xpath="//button[text()='Continue']")
	WebElement continueCTA;
	
	public boolean checkIsAlreadyApplied() 
	{
		if (alreadyApplied.size()>0)
		{
			return true;
		}
		else return false;
	}
	public boolean consumerApplyAsHero()
	{
		boolean applied = checkIsAlreadyApplied();
		if (!applied)
		{
			dLicenseNo.sendKeys("455 484 848");
			dLicenseImage.sendKeys("C:\\Users\\hp\\Pictures\\Dress shirt.jpg");
			SSN.sendKeys("448-445-484");
			authorizeCheck.click();
			termsCondition.click();
			continueCTA.click();
			return true;
		}
		else return false;
	}
}
