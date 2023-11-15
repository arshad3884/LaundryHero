package laundryhero.consumerTestcases;

import org.testng.annotations.Test;

import junit.framework.Assert;
import laundryhero.TestComponents.BaseTest;
import laundryhero.pageobjects.ConsumerHome;
import laundryhero.pageobjects.ConsumerMyAccount;
import laundryhero.pageobjects.ConsumerNotifications;
import laundryhero.pageobjects.LoginPage;

public class EnableDisableConsumerNotifications extends BaseTest {
	@Test
	public void enableDisableConsumerNotifications()
	{
		initializeDriver();
		LoginPage loginPage = new LoginPage(driver);
		loginPage.goTO();
		loginPage.loginApplication("elorajames@yopmail.com", "qwerty123");
		ConsumerHome consumerHome = new ConsumerHome(driver);
		consumerHome.goToMyAccount();
		ConsumerMyAccount consumerMyAccount= new ConsumerMyAccount(driver);
		consumerMyAccount.goToConsumerNotification();
		ConsumerNotifications consumerNotifications = new ConsumerNotifications(driver);
		Boolean status = consumerNotifications.enableDisableAppNotifications();
		status = consumerNotifications.enableDisableEmailNotifications();
		status = consumerNotifications.enableDisableSMSNotifications();
		Assert.assertTrue(status);
		driver.close();
	}

}
