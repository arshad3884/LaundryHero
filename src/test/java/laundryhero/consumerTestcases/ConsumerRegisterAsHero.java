package laundryhero.consumerTestcases;

import org.testng.annotations.Test;

import junit.framework.Assert;
import laundryhero.TestComponents.BaseTest;
import laundryhero.pageobjects.ConsumerHome;
import laundryhero.pageobjects.ConsumerMyAccount;
import laundryhero.pageobjects.LoginPage;
import laundryhero.pageobjects.RegisterAsHero;

public class ConsumerRegisterAsHero extends BaseTest{
	
	@Test
	public void checkIsAlreadyApplied()
	{
		initializeDriver();
		LoginPage loginPage = new LoginPage(driver);
		loginPage.goTO();
		loginPage.loginApplication("elorajames@yopmail.com", "qwerty123");
		ConsumerHome consumerHome = new ConsumerHome(driver);
		consumerHome.goToRegisterAsHero();
		RegisterAsHero registerAsHero = new RegisterAsHero(driver);
		Boolean status = registerAsHero.checkIsAlreadyApplied();
		Assert.assertTrue(status);
		driver.close();
	}
	@Test
	public void consumerApplyAsHero()
	{
		initializeDriver();
		LoginPage loginPage = new LoginPage(driver);
		loginPage.goTO();
		loginPage.loginApplication("tester124@yopmail.com", "qwerty123");
		ConsumerHome consumerHome = new ConsumerHome(driver);
		consumerHome.goToRegisterAsHero();
		RegisterAsHero registerAsHero = new RegisterAsHero(driver);
		Boolean status = registerAsHero.consumerApplyAsHero();
		Assert.assertTrue(status);
		driver.close();
	}
	@Test
	public void switchToHero()
	{
		initializeDriver();
		LoginPage loginPage = new LoginPage(driver);
		loginPage.goTO();
		loginPage.loginApplication("tester123@yopmail.com", "qwerty123");
		ConsumerHome consumerHome = new ConsumerHome(driver);
		consumerHome.goToMyAccount();
		ConsumerMyAccount consumerMyAccount = new ConsumerMyAccount(driver);
		Boolean status = consumerMyAccount.switchToHero();
		Assert.assertTrue(status);
		driver.close();
	}
	
}
