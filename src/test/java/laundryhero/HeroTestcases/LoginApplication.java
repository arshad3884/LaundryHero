package laundryhero.HeroTestcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import junit.framework.Assert;
import laundryhero.TestComponents.BaseTest;
import laundryhero.pageobjects.LoginPage;

public class LoginApplication extends BaseTest{

	@Test
	public void loginAsHeroUsingValidCreds()
	{
		initializeDriver();
		LoginPage loginPage = new LoginPage(driver);
		loginPage.goTO();
		loginPage.loginApplication("abchero5@yopmail.com", "qwerty123");
		String currentURL = driver.getCurrentUrl();
		if (currentURL.equals("https://consumer.freshify.io/hero-home"))
		{
			Assert.assertTrue(true);
		}
		driver.close();
	}
	@Test
	public void loginAsHeroUsingInvalidCreds()
	{
		initializeDriver();
		LoginPage loginPage = new LoginPage(driver);
		loginPage.goTO();
		loginPage.loginApplication("invalidEmail@yopmail.com", "qwerty123");
		WebElement errorToast = driver.findElement(By.xpath("//div[@class='Toastify__toast Toastify__toast-theme--light Toastify__toast--error Toastify__toast--close-on-click']"));
		if (errorToast.isDisplayed())
		{
			Assert.assertTrue(true);
		}
		driver.close();
	}
	
}
