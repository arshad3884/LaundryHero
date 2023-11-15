package laundryhero.consumerTestcases;

import org.testng.annotations.Test;

import laundryhero.TestComponents.BaseTest;
import laundryhero.pageobjects.ConsumerHome;
import laundryhero.pageobjects.ContactSupport;
import laundryhero.pageobjects.LoginPage;

public class ChatModule extends BaseTest{
	@Test
	public void helloToAdminSupport()
	{
		initializeDriver();
		LoginPage loginPage = new LoginPage(driver);
		loginPage.goTO();
		loginPage.loginApplication("elorajames@yopmail.com", "qwerty123");
		ConsumerHome consumerHome = new ConsumerHome(driver);
		consumerHome.goToContactSupport();
		ContactSupport contactSupport = new ContactSupport(driver);
		contactSupport.helloToAdminSupport();
		driver.close();
	}

}
