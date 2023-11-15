package laundryhero.consumerTestcases;

import org.testng.annotations.Test;

import junit.framework.Assert;
import laundryhero.TestComponents.BaseTest;
import laundryhero.pageobjects.ConsumerHome;
import laundryhero.pageobjects.ConsumerMyAccount;
import laundryhero.pageobjects.LoginPage;

public class DeleteConsumerAccount extends BaseTest{

	@Test
	public void deleteConsumerAccount() throws InterruptedException 
	{
		initializeDriver();
		LoginPage loginPage = new LoginPage(driver);
		loginPage.goTO();
		loginPage.loginApplication("hannahjames@yopmail.com", "qwerty123");
		ConsumerHome consumerHome = new ConsumerHome(driver);
		consumerHome.goToMyAccount();
		ConsumerMyAccount consumerAccount = new ConsumerMyAccount(driver);
		boolean status = consumerAccount.deleteConsumerAccount();
		Assert.assertTrue(status);
		driver.close();
	}
}
