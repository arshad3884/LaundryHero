package laundryhero.consumerTestcases;

import org.testng.annotations.Test;

import junit.framework.Assert;
import laundryhero.TestComponents.BaseTest;
import laundryhero.pageobjects.ConsumerHome;
import laundryhero.pageobjects.ConsumerMyAccount;
import laundryhero.pageobjects.ConsumerPreferences;
import laundryhero.pageobjects.LoginPage;

public class UpdateConsumerPreferences extends BaseTest {

	@Test
	public void updateConsumerPreferences() throws InterruptedException
	{
		initializeDriver();
		LoginPage loginPage = new LoginPage(driver);
		loginPage.goTO();
		loginPage.loginApplication("elorajames@yopmail.com", "qwerty123");
		ConsumerHome consumerHome = new ConsumerHome(driver);
		consumerHome.goToMyAccount();
		ConsumerMyAccount consumerMyAccount= new ConsumerMyAccount(driver);
		consumerMyAccount.goToConsumerPreferences();
		ConsumerPreferences consumerPref = new ConsumerPreferences(driver);
		boolean status = consumerPref.updatePreferences();
		Assert.assertTrue(status);
		driver.close();
	}
}
