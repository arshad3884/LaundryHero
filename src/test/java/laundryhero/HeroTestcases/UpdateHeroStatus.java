package laundryhero.HeroTestcases;

import org.testng.annotations.Test;

import junit.framework.Assert;
import laundryhero.TestComponents.BaseTest;
import laundryhero.pageobjects.HeroHome;
import laundryhero.pageobjects.LoginPage;

public class UpdateHeroStatus extends BaseTest{
	
	@Test
	public void changeHeroStatusasInactive() throws InterruptedException 
	{
		initializeDriver();
		LoginPage loginPage = new LoginPage(driver);
		loginPage.goTO();
		loginPage.loginApplication("abchero5@yopmail.com", "qwerty123");
		HeroHome heroHome = new HeroHome(driver);
		boolean status = heroHome.changeHeroStatusToInactive();
		System.out.println(status);
		Assert.assertTrue(status);
		driver.close();
	}
	@Test
	public void changeHeroStatusasActive() throws InterruptedException
	{
		initializeDriver();
		LoginPage loginPage = new LoginPage(driver);
		loginPage.goTO();
		loginPage.loginApplication("abchero5@yopmail.com", "qwerty123");
		HeroHome heroHome = new HeroHome(driver);
		boolean status = heroHome.changeHeroStatusToActive();
		System.out.println(status);
		Assert.assertTrue(status);
		driver.close();
	}
}
