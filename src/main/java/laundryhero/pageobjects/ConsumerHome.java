package laundryhero.pageobjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ConsumerHome {
	
	WebDriver driver;
	public ConsumerHome(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath="//a[@href='/my-addresses']")
	WebElement myAddresses;
	
	@FindBy (xpath="//a[@href='/orders']")
	WebElement myOrders;
	
	@FindBy (xpath="//a[@href='/my-heroes']")
	WebElement myHeroes;
	
	@FindBy (xpath="//a[@href='/invite']")
	WebElement inviteFriends;
	
	@FindBy (xpath="//a[@href='/my-account']")
	WebElement myAccount;
	
	@FindBy (xpath="//a[@href='/support?id=admintoken']")
	WebElement contactSupport;
	
	@FindBy (xpath="//a[@href='/bussines-account']")
	WebElement businessAccount;
	
	@FindBy (xpath="//a[@href='/register']")
	WebElement registerAsHero;
	
	@FindBy (xpath="//a[@href='/legal']")
	WebElement legal;
	
	@FindBy (xpath="//p[@class='abc mb-0']")
	WebElement logout;
	
	@FindBy (xpath="//img[@alt='promo-code']")
	List <WebElement> sliderItems;
	
	@FindBy (css=".rec-arrow-right")
	WebElement rightArrow;
	public void clickCreateOrder() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.get("https://consumer.freshify.io/order/module");
		/*
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement elementCTA = driver.findElement(By.xpath("//a[@href='/order/module']//button[contains(text(),'Start a new order')]"));
		// wait for the element to be visible
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/order/module']//button[contains(text(),'Start a new order')]")));
		//JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		//jsExecutor.executeScript("arguments[0].scrollIntoView(true);", elementCTA);
		Actions actions = new Actions(driver);
		actions.moveToElement(elementCTA).perform();
		//jsExecutor.executeScript("arguments[0].click();", elementCTA);
		elementCTA.click();
		*/
	}
	public void goToMyAddresses()
	{
		myAddresses.click();
	}
	public void goToMyOrders()
	{
		myOrders.click();
	}
	public void goToMyHeroes()
	{
		myHeroes.click();
	}
	public void goToInviteFirends()
	{
		inviteFriends.click();
	}
	public void goToMyAccount()
	{
		myAccount.click();
	}
	public void goToContactSupport()
	{
		contactSupport.click();
	}
	public void goToBusinessAccount()
	{
		businessAccount.click();
	}
	public void goToRegisterAsHero()
	{
		registerAsHero.click();
	}
	public void goToLegal()
	{
		legal.click();
	}
	public void logout()
	{
		logout.click();
	}
	public boolean openPromotionLinks() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@alt='promo-code']")));
		
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//img[@alt='promo-code']")));
        Thread.sleep(3000);
        
        for (WebElement sliderItem: sliderItems)
		{
	     //Open the link in a new tab
        	Actions action = new Actions(driver);
            action.keyDown(Keys.CONTROL).click(sliderItem).keyUp(Keys.CONTROL).build().perform();
            rightArrow.click();
            
		}
		return true;
	}
}
