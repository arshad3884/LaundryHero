package laundryhero.HeroTestcases;

import org.testng.annotations.Test;

import junit.framework.Assert;
import laundryhero.TestComponents.BaseTest;
import laundryhero.pageobjects.HeroHome;
import laundryhero.pageobjects.LoginPage;

public class HeroHomeOrders extends BaseTest{

	@Test
	public void acceptPendingOrder() throws InterruptedException
	{
		initializeDriver();
		LoginPage loginPage = new LoginPage(driver);
		loginPage.goTO();
		loginPage.loginApplication("abchero5@yopmail.com", "qwerty123");
		HeroHome heroHome= new HeroHome(driver);
		boolean status = heroHome.acceptPendingOrder();
		Assert.assertTrue(status);
		driver.close();
	}
	@Test
	public void declinePendingOrder() throws InterruptedException
	{
		initializeDriver();
		LoginPage loginPage = new LoginPage(driver);
		loginPage.goTO();
		loginPage.loginApplication("abchero1@yopmail.com", "qwerty123");
		HeroHome heroHome= new HeroHome(driver);
		heroHome.declinePendingOrder();
		Assert.assertTrue(true);
		driver.close();
	}
	@Test
	public void viewPendingOrdersRoute()
	{
		initializeDriver();
		LoginPage loginPage = new LoginPage(driver);
		loginPage.goTO();
		loginPage.loginApplication("abchero5@yopmail.com", "qwerty123");
		HeroHome heroHome= new HeroHome(driver);
		heroHome.viewPendingOrdersRoute();
		String currentURL = driver.getCurrentUrl();
		if (currentURL.equals("https://consumer.freshify.io/plan-your-route"))
		{
		Assert.assertTrue(true);
		}
		else Assert.assertTrue(false);
		driver.close();
	}
	@Test
	public void viewTodayOrders()
	{
		initializeDriver();
		LoginPage loginPage = new LoginPage(driver);
		loginPage.goTO();
		loginPage.loginApplication("abchero5@yopmail.com", "qwerty123");
		HeroHome heroHome= new HeroHome(driver);
		heroHome.viewTodayOrders();
		Assert.assertTrue(true);
		driver.close();
	}
	@Test
	public void viewAllTimeOrders()
	{
		initializeDriver();
		LoginPage loginPage = new LoginPage(driver);
		loginPage.goTO();
		loginPage.loginApplication("abchero5@yopmail.com", "qwerty123");
		HeroHome heroHome= new HeroHome(driver);
		heroHome.viewAllTimeOrders();
		Assert.assertTrue(true);
		driver.close();
	}
	@Test
	public void viewRandomDateOrders()
	{
		initializeDriver();
		LoginPage loginPage = new LoginPage(driver);
		loginPage.goTO();
		loginPage.loginApplication("abchero5@yopmail.com", "qwerty123");
		HeroHome heroHome= new HeroHome(driver);
		heroHome.viewRandomDateOrders();
		Assert.assertTrue(true);
		driver.close();
	}
	@Test
	public void viewAllAwaitingPickupOrders() throws InterruptedException
	{
		initializeDriver();
		LoginPage loginPage = new LoginPage(driver);
		loginPage.goTO();
		loginPage.loginApplication("abchero5@yopmail.com", "qwerty123");
		HeroHome heroHome= new HeroHome(driver);
		Boolean status = heroHome.viewAllAwaitingPickupOrders();
		Assert.assertTrue(status);
		driver.quit();
	}
	@Test
	public void viewAwaitingDropoffOrders() throws InterruptedException
	{
		initializeDriver();
		LoginPage loginPage = new LoginPage(driver);
		loginPage.goTO();
		loginPage.loginApplication("abchero5@yopmail.com", "qwerty123");
		HeroHome heroHome= new HeroHome(driver);
		Boolean status = heroHome.viewAllAwaitingDropoffOrders();
		Assert.assertTrue(status);
		driver.quit();
	}
	
}
