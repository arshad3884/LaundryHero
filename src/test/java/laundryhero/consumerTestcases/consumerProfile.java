package laundryhero.consumerTestcases;

import org.testng.annotations.Test;

import junit.framework.Assert;
import laundryhero.TestComponents.BaseTest;
import laundryhero.pageobjects.ConsumerHome;
import laundryhero.pageobjects.ConsumerMyAccount;
import laundryhero.pageobjects.ConsumerMyProfile;
import laundryhero.pageobjects.LoginPage;

public class consumerProfile extends BaseTest {
	
	@Test
	public void updateConsumerProfile() throws InterruptedException
	{
		initializeDriver();
		LoginPage loginPage = new LoginPage(driver);
		loginPage.goTO();
		loginPage.loginApplication("hannahjames@yopmail.com", "qwerty123");
		ConsumerHome consumerHome = new ConsumerHome(driver);
		consumerHome.goToMyAccount();
		ConsumerMyAccount consumerAccount = new ConsumerMyAccount(driver);
		consumerAccount.goToConsumerProfile();
		ConsumerMyProfile myProfile = new ConsumerMyProfile(driver);
		boolean status = myProfile.updateConsumerProfile("Hannah", "James", "4586523689", "C:\\Users\\hp\\Pictures\\Dummy pics\\avatar_32.jpg");
		Assert.assertTrue(status);
		driver.close();
	}
	@Test
	public void updateConsumerPassword() throws InterruptedException
	{
		initializeDriver();
		LoginPage loginPage = new LoginPage(driver);
		loginPage.goTO();
		loginPage.loginApplication("hannahjames@yopmail.com", "qwerty123");
		ConsumerHome consumerHome = new ConsumerHome(driver);
		consumerHome.goToMyAccount();
		ConsumerMyAccount consumerAccount = new ConsumerMyAccount(driver);
		consumerAccount.goToConsumerProfile();
		ConsumerMyProfile myProfile = new ConsumerMyProfile(driver);
		boolean status = myProfile.updateConsumerPassword("qwerty123");
		Assert.assertTrue(status);
		driver.close();
	}

}
