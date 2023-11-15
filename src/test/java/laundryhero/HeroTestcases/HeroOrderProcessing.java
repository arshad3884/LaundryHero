package laundryhero.HeroTestcases;

import org.testng.annotations.Test;

import junit.framework.Assert;
import laundryhero.TestComponents.BaseTest;
import laundryhero.pageobjects.HeroHome;
import laundryhero.pageobjects.HeroMyOrders;
import laundryhero.pageobjects.LoginPage;

public class HeroOrderProcessing extends BaseTest{
	@Test
	public void openAlltimeOrders() throws InterruptedException
	{
		initializeDriver();
		LoginPage loginPage = new LoginPage(driver);
		loginPage.goTO();
		loginPage.loginApplication("abchero5@yopmail.com", "qwerty123");
		HeroHome heroHome = new HeroHome(driver);
		heroHome.goToMyOrders();
		HeroMyOrders heroOrders = new HeroMyOrders(driver);
		Boolean status = heroOrders.openAlltimeOrders();
		Assert.assertTrue(status);
		driver.close();
	}
	@Test
	public void openTodayOrders() throws InterruptedException
	{
		initializeDriver();
		LoginPage loginPage = new LoginPage(driver);
		loginPage.goTO();
		loginPage.loginApplication("abchero5@yopmail.com", "qwerty123");
		HeroHome heroHome = new HeroHome(driver);
		heroHome.goToMyOrders();
		HeroMyOrders heroOrders = new HeroMyOrders(driver);
		Boolean status = heroOrders.openTodayOrders();
		Assert.assertTrue(status);
		driver.close();
	}
	@Test
	public void viewRandomDateOrders() throws InterruptedException
	{
		initializeDriver();
		LoginPage loginPage = new LoginPage(driver);
		loginPage.goTO();
		loginPage.loginApplication("abchero5@yopmail.com", "qwerty123");
		HeroHome heroHome = new HeroHome(driver);
		heroHome.goToMyOrders();
		HeroMyOrders heroOrders = new HeroMyOrders(driver);
		Boolean status = heroOrders.viewRandomDateOrders();
		System.out.println(status);
		Assert.assertTrue(status);
		driver.close();
	}
}
