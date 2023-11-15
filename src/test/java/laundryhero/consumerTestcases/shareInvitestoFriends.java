package laundryhero.consumerTestcases;

import org.testng.annotations.Test;

import laundryhero.TestComponents.BaseTest;
import laundryhero.pageobjects.ConsumerHome;
import laundryhero.pageobjects.ConsumerInviteFriends;
import laundryhero.pageobjects.LoginPage;

public class shareInvitestoFriends extends BaseTest{
	@Test
	public void openAllInviteLinks() throws InterruptedException
	{
		initializeDriver();
		LoginPage loginPage = new LoginPage(driver);
		loginPage.goTO();
		loginPage.loginApplication("elorajames@yopmail.com", "qwerty123");
		ConsumerHome consumerHome = new ConsumerHome(driver);
		consumerHome.goToInviteFirends();
		ConsumerInviteFriends inviteFriends = new ConsumerInviteFriends(driver);
		inviteFriends.sendInviteOnAllSocialLinks();
		driver.quit();
		
	}

}
