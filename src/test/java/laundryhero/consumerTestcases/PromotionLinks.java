package laundryhero.consumerTestcases;

import org.testng.annotations.Test;

import junit.framework.Assert;
import laundryhero.TestComponents.BaseTest;
import laundryhero.pageobjects.ConsumerHome;
import laundryhero.pageobjects.LoginPage;

public class PromotionLinks extends BaseTest{

	@Test
	public void openAllPromotionLinks() throws InterruptedException
	{
		initializeDriver();
		LoginPage loginPage = new LoginPage(driver);
		loginPage.goTO();
		loginPage.loginApplication("elorajames@yopmail.com", "qwerty123");
		ConsumerHome consumerHome = new ConsumerHome(driver);
		boolean status = consumerHome.openPromotionLinks();
		Assert.assertTrue(status);
		driver.quit();
	}
}
