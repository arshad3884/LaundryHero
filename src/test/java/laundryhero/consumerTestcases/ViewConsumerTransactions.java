package laundryhero.consumerTestcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import junit.framework.Assert;
import laundryhero.TestComponents.BaseTest;
import laundryhero.pageobjects.ConsumerHome;
import laundryhero.pageobjects.ConsumerMyAccount;
import laundryhero.pageobjects.ConsumerTransactions;
import laundryhero.pageobjects.LoginPage;

public class ViewConsumerTransactions extends BaseTest{
	
	@Test
	public void viewConsumerTransactionsThisWeek()
	{
		initializeDriver();
		LoginPage loginPage = new LoginPage(driver);
		loginPage.goTO();
		loginPage.loginApplication("elorajames@yopmail.com", "qwerty123");
		ConsumerHome consumerHome = new ConsumerHome(driver);
		consumerHome.goToMyAccount();
		ConsumerMyAccount consumerAccount = new ConsumerMyAccount(driver);
		consumerAccount.goToConsumerTransactions();
		ConsumerTransactions consumertrx = new ConsumerTransactions(driver);
		consumertrx.viewThisWeekTransactions();
		Assert.assertTrue(true);
		driver.close();
	}
	@Test
	public void viewConsumerTransactionsThisMonth()
	{
		WebDriver driver = initializeDriver();
		LoginPage loginPage = new LoginPage(driver);
		loginPage.goTO();
		loginPage.loginApplication("elorajames@yopmail.com", "qwerty123");
		ConsumerHome consumerHome = new ConsumerHome(driver);
		consumerHome.goToMyAccount();
		ConsumerMyAccount consumerAccount = new ConsumerMyAccount(driver);
		consumerAccount.goToConsumerTransactions();
		ConsumerTransactions consumertrx = new ConsumerTransactions(driver);
		consumertrx.viewThisMonthTransactions();
		Assert.assertTrue(true);
		driver.close();
	}

	@Test
	public void viewConsumerTransactionsRandomDays()
	{
		WebDriver driver = initializeDriver();
		LoginPage loginPage = new LoginPage(driver);
		loginPage.goTO();
		loginPage.loginApplication("testqatester81@gmail.com", "qwerty123");
		ConsumerHome consumerHome = new ConsumerHome(driver);
		consumerHome.goToMyAccount();
		ConsumerMyAccount consumerAccount = new ConsumerMyAccount(driver);
		consumerAccount.goToConsumerTransactions();
		ConsumerTransactions consumertrx = new ConsumerTransactions(driver);
		consumertrx.viewRandomDateTransactions();
		Assert.assertTrue(true);
		driver.close();
	}

}
