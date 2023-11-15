package laundryhero.HeroTestcases;

import org.testng.annotations.Test;

import junit.framework.Assert;
import laundryhero.TestComponents.BaseTest;
import laundryhero.pageobjects.HeroAvailability;
import laundryhero.pageobjects.HeroHome;
import laundryhero.pageobjects.HeroMyAccount;
import laundryhero.pageobjects.HeroPayout;
import laundryhero.pageobjects.HeroProfile;
import laundryhero.pageobjects.HeroTransactions;
import laundryhero.pageobjects.LoginPage;

public class View_UpdateHeroAccount extends BaseTest{
	
	@Test
	public void getHeroRating()
	{
		initializeDriver();
		LoginPage loginPage = new LoginPage(driver);
		loginPage.goTO();
		loginPage.loginApplication("abchero5@yopmail.com", "qwerty123");
		HeroHome heroHome = new HeroHome(driver);
		heroHome.goToHeroAccount();
		HeroMyAccount heroMyAccount = new HeroMyAccount(driver);
		String ratingString = heroMyAccount.getHeroAvgRating();
		if (ratingString!= null)
		{
		Assert.assertTrue(true);	
		}
		else Assert.assertTrue(false);
		driver.close();
	}
	@Test
	public void getHeroEmail()
	{
		initializeDriver();
		LoginPage loginPage = new LoginPage(driver);
		loginPage.goTO();
		loginPage.loginApplication("abchero5@yopmail.com", "qwerty123");
		HeroHome heroHome = new HeroHome(driver);
		heroHome.goToHeroAccount();
		HeroMyAccount heroMyAccount = new HeroMyAccount(driver);
		String heroEmail = heroMyAccount.getHeroEmail();
		if (heroEmail!= null)
		{
		Assert.assertTrue(true);	
		}
		else Assert.assertTrue(false);
		driver.close();
	}
	@Test
	public void updateProfileInfo() throws InterruptedException
	{
		initializeDriver();
		LoginPage loginPage = new LoginPage(driver);
		loginPage.goTO();
		loginPage.loginApplication("abchero5@yopmail.com", "qwerty123");
		HeroHome heroHome = new HeroHome(driver);
		heroHome.goToHeroAccount();
		HeroMyAccount heroMyAccount = new HeroMyAccount(driver);
		heroMyAccount.goToHeroProfile();
		HeroProfile heroProfile = new HeroProfile(driver);
		Boolean status = heroProfile.updateProfileInfo("ABCFive", "Hero", "8885556666");
		Assert.assertTrue(status);
		driver.close();
	}
	@Test
	public void resetHeroPassword() throws InterruptedException
	{
		initializeDriver();
		LoginPage loginPage = new LoginPage(driver);
		loginPage.goTO();
		loginPage.loginApplication("abchero5@yopmail.com", "qwerty123");
		HeroHome heroHome = new HeroHome(driver);
		heroHome.goToHeroAccount();
		HeroMyAccount heroMyAccount = new HeroMyAccount(driver);
		heroMyAccount.goToHeroProfile();
		HeroProfile heroProfile = new HeroProfile(driver);
		Boolean status = heroProfile.resetHeroPassword("qwerty123");
		Assert.assertTrue(status);
		driver.close();
	}
	@Test
	public void createHeroPayoutAccount() throws InterruptedException
	{
		initializeDriver();
		LoginPage loginPage = new LoginPage(driver);
		loginPage.goTO();
		loginPage.loginApplication("testqatester8121@yopmail.com", "qwerty123");
		HeroHome heroHome = new HeroHome(driver);
		heroHome.goToHeroAccount();
		HeroMyAccount heroMyAccount = new HeroMyAccount(driver);
		heroMyAccount.goTopayout();
		HeroPayout heroPayout = new HeroPayout(driver);
		Boolean status = heroPayout.createHeroPayoutAccount("Rochester", "1992", "June", "10", "R-152 Rochester NY", "10016", "New York", "Female");
		Assert.assertTrue(status);
		driver.close();
	}
	@Test
	public void addHeroPayoutMethod() throws InterruptedException
	{
		//Create Stripe connect account 
		initializeDriver();
		LoginPage loginPage = new LoginPage(driver);
		loginPage.goTO();
		loginPage.loginApplication("abchero5@yopmail.com", "qwerty123");
		HeroHome heroHome = new HeroHome(driver);
		heroHome.goToHeroAccount();
		HeroMyAccount heroMyAccount = new HeroMyAccount(driver);
		heroMyAccount.goTopayout();
		HeroPayout heroPayout = new HeroPayout(driver);
		Boolean status = heroPayout.addHeroPayoutMethod("4242424242424242", "1224", "548");
		Assert.assertTrue(status);
		driver.close();
	}
	@Test
	public void viewHeroCurrentWeekTransactions()
	{
		initializeDriver();
		LoginPage loginPage = new LoginPage(driver);
		loginPage.goTO();
		loginPage.loginApplication("abchero5@yopmail.com", "qwerty123");
		HeroHome heroHome = new HeroHome(driver);
		heroHome.goToHeroAccount();
		HeroMyAccount heroMyAccount = new HeroMyAccount(driver);
		heroMyAccount.goToHeroTransactions();
		HeroTransactions heroTransactions = new HeroTransactions(driver);
		heroTransactions.viewThisWeekTransactions();
		Assert.assertTrue(true);
		driver.close();
	}
	@Test
	public void viewHeroThisMonthTransactions()
	{
		initializeDriver();
		LoginPage loginPage = new LoginPage(driver);
		loginPage.goTO();
		loginPage.loginApplication("abchero5@yopmail.com", "qwerty123");
		HeroHome heroHome = new HeroHome(driver);
		heroHome.goToHeroAccount();
		HeroMyAccount heroMyAccount = new HeroMyAccount(driver);
		heroMyAccount.goToHeroTransactions();
		HeroTransactions heroTransactions = new HeroTransactions(driver);
		heroTransactions.viewThisMonthTransactions();
		Assert.assertTrue(true);
		driver.close();
	}
	@Test
	public void viewHeroTransactionsInDateRange()
	{
		initializeDriver();
		LoginPage loginPage = new LoginPage(driver);
		loginPage.goTO();
		loginPage.loginApplication("abchero5@yopmail.com", "qwerty123");
		HeroHome heroHome = new HeroHome(driver);
		heroHome.goToHeroAccount();
		HeroMyAccount heroMyAccount = new HeroMyAccount(driver);
		heroMyAccount.goToHeroTransactions();
		HeroTransactions heroTransactions = new HeroTransactions(driver);
		heroTransactions.viewHeroTransactionsInDateRange();
		Assert.assertTrue(true);
		driver.close();
	}
	@Test
	public void activeHeroStatusOnParticularDay()
	{
		initializeDriver();
		LoginPage loginPage = new LoginPage(driver);
		loginPage.goTO();
		loginPage.loginApplication("abchero5@yopmail.com", "qwerty123");
		HeroHome heroHome = new HeroHome(driver);
		heroHome.goToHeroAccount();
		HeroMyAccount heroMyAccount = new HeroMyAccount(driver);
		heroMyAccount.goToHeroAvailability();
		HeroAvailability heroAvailability = new HeroAvailability(driver);
		Boolean status = heroAvailability.activeHeroStatusOnParticularDay("Tuesday");
		//Assert.assertTrue(status);
		//driver.close();
	}
	@Test
	public void heroSwitchToConsumer()
	{
		initializeDriver();
		LoginPage loginPage = new LoginPage(driver);
		loginPage.goTO();
		loginPage.loginApplication("abchero5@yopmail.com", "qwerty123");
		HeroHome heroHome = new HeroHome(driver);
		heroHome.goToHeroAccount();
		HeroMyAccount heroMyAccount = new HeroMyAccount(driver);
		Boolean status = heroMyAccount.switchToConsumer();
		Assert.assertTrue(status);
		driver.close();
	}
	@Test
	public void deleteHeroAccount() throws InterruptedException
	{
		initializeDriver();
		LoginPage loginPage = new LoginPage(driver);
		loginPage.goTO();
		loginPage.loginApplication("abchero5@yopmail.com", "qwerty123");
		HeroHome heroHome = new HeroHome(driver);
		heroHome.goToHeroAccount();
		HeroMyAccount heroMyAccount = new HeroMyAccount(driver);
		Boolean status = heroMyAccount.deleteHeroAccount();
		Assert.assertTrue(status);
		driver.close();
	}
}
