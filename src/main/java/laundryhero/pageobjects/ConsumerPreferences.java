package laundryhero.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConsumerPreferences {
	WebDriver driver;
	public ConsumerPreferences(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy (xpath="//label[@for='btnradio-Yes-0-0']")
	WebElement fabSoftnerYes;
	@FindBy (xpath="//label[@for='btnradio-No-1-0']")
	WebElement fabSoftnerNo;
	
	@FindBy (xpath="//label[@for='btnradio-Ironed-0-1']")
	WebElement pantsIroned;
	@FindBy (xpath="//label[@for='btnradio-Non Ironed-1-1']")
	WebElement pantsNonIroned;
	
	@FindBy (xpath="//label[@for='btnradio-Yes-0-2']")
	WebElement dryersheetYes;
	@FindBy (xpath="//label[@for='btnradio-No-1-2']")
	WebElement dryersheetNo;
	
	@FindBy (xpath="//label[@for='btnradio-Cold-0-3']")
	WebElement whitewashCold;
	@FindBy (xpath="//label[@for='btnradio-Warm-1-3']")
	WebElement whitewashWarm;
	@FindBy (xpath="//label[@for='btnradio-Hot-2-3']")
	WebElement whitewashHot;
	
	@FindBy (xpath="//label[@for='btnradio-Ironed-0-4']")
	WebElement shirtIroned;
	@FindBy (xpath="//label[@for='btnradio-Non Ironed-1-4']")
	WebElement shirtNonIroned;
	
	@FindBy (xpath="//label[@for='btnradio-Special-0-5']")
	WebElement detergentSpecial;
	@FindBy (xpath="//label[@for='btnradio-Normal-1-5']")
	WebElement detergentNormal;
	
	@FindBy (xpath="//label[@for='btnradio-Low-0-6']")
	WebElement whitedryerheatLow;
	@FindBy (xpath="//label[@for='btnradio-Medium-1-6']")
	WebElement whitedryerheatMedium;
	@FindBy (xpath="//label[@for='btnradio-High-2-6']")
	WebElement whitedryerheatHigh;
	
	@FindBy (xpath="//label[@for='btnradio-Low-0-7']")
	WebElement whitedryersheatLow;
	@FindBy (xpath="//label[@for='btnradio-Medium-1-7']")
	WebElement whitedryersheatMedium;
	@FindBy (xpath="//label[@for='btnradio-High-2-7']")
	WebElement whitedryersheatHigh;
	
	@FindBy (xpath="//label[@for='btnradio-Cold-0-8']")
	WebElement coldwashtempCold;
	@FindBy (xpath="//label[@for='btnradio-Warm-1-8']")
	WebElement coldwashtempWarm;
	@FindBy (xpath="//label[@for='btnradio-Hot-2-8']")
	WebElement coldwashtempHot;
	
	@FindBy (xpath="//label[@for='btnradio-Cold-0-9']")
	WebElement colddryertempCold;
	@FindBy (xpath="//label[@for='btnradio-Warm-1-9']")
	WebElement colddryertempWarm;
	@FindBy (xpath="//label[@for='btnradio-Hot-2-9']")
	WebElement colddryertempHot;
	
	public boolean updatePreferences() throws InterruptedException
	{
		fabSoftnerNo.click();
		Thread.sleep(2000);
		fabSoftnerYes.click();
		Thread.sleep(2000);
		pantsNonIroned.click();
		Thread.sleep(2000);
		pantsIroned.click();
		Thread.sleep(2000);
		dryersheetNo.click();
		Thread.sleep(2000);
		dryersheetYes.click();
		Thread.sleep(2000);
		whitewashWarm.click();
		Thread.sleep(2000);
		whitewashHot.click();
		Thread.sleep(2000);
		whitewashCold.click();
		Thread.sleep(2000);
		shirtNonIroned.click();
		Thread.sleep(2000);
		shirtIroned.click();
		Thread.sleep(2000);
		detergentNormal.click();
		Thread.sleep(2000);
		detergentSpecial.click();
		Thread.sleep(2000);
		whitedryerheatMedium.click();
		Thread.sleep(2000);
		whitedryerheatHigh.click();
		Thread.sleep(2000);
		whitedryerheatLow.click();
		Thread.sleep(2000);
		whitedryersheatMedium.click();
		Thread.sleep(2000);
		whitedryersheatHigh.click();
		Thread.sleep(2000);
		whitedryersheatLow.click();
		Thread.sleep(2000);
		coldwashtempWarm.click();
		Thread.sleep(2000);
		coldwashtempHot.click();
		Thread.sleep(2000);
		coldwashtempCold.click();
		Thread.sleep(2000);
		colddryertempWarm.click();
		Thread.sleep(2000);
		colddryertempHot.click();
		Thread.sleep(2000);
		colddryertempCold.click();
		return true;
	}
}
