package laundryhero.consumerTestcases;

import org.testng.annotations.Test;

import junit.framework.Assert;
import laundryhero.TestComponents.BaseTest;
import laundryhero.pageobjects.ConsumerMyAddresses;
import laundryhero.pageobjects.HeroHome;
import laundryhero.pageobjects.HeroMyAddress;
import laundryhero.pageobjects.LoginPage;

public class AddRemoveAddress extends BaseTest{

	@Test
	public void AddConsumerAddress() throws InterruptedException
	{
		initializeDriver();
		LoginPage loginpage = new LoginPage(driver);
		loginpage.goTO();
		loginpage.loginApplication("elorajames@yopmail.com", "qwerty123");
		ConsumerMyAddresses myaddress= new ConsumerMyAddresses(driver);
		myaddress.goToAddresses();
		boolean status = myaddress.addNewAddress("Home","Rochester NY");
		Assert.assertTrue(status);
		driver.close();
	}
	@Test
	public void DeleteConsumerAddress()
	{
		initializeDriver();
		LoginPage loginpage = new LoginPage(driver);
		loginpage.goTO();
		loginpage.loginApplication("elorajames@yopmail.com", "qwerty123");
		ConsumerMyAddresses myaddress= new ConsumerMyAddresses(driver);
		myaddress.goToAddresses();
		boolean status = myaddress.deleteAddress();
		Assert.assertTrue(status);
		driver.close();
	}
	@Test
	public void ViewConsumerAddress()
	{
		initializeDriver();
		LoginPage loginpage = new LoginPage(driver);
		loginpage.goTO();
		loginpage.loginApplication("elorajames@yopmail.com", "qwerty123");
		ConsumerMyAddresses myaddress= new ConsumerMyAddresses(driver);
		myaddress.goToAddresses();
		myaddress.viewAddress("Home");
		if (driver.getCurrentUrl().equals("https://consumer.freshify.io/address/edit-address"))
		{
			Assert.assertTrue(true);
		}
		else {Assert.assertTrue(false);}
		driver.close();
	}
	@Test 
	public void updateHeroAddress() throws InterruptedException
	{
		initializeDriver();
		LoginPage loginpage = new LoginPage(driver);
		loginpage.goTO();
		loginpage.loginApplication("abchero5@yopmail.com", "qwerty123");
		HeroHome heroHome = new HeroHome(driver);
		heroHome.goToMyAddress();
		HeroMyAddress heroMyAddress = new HeroMyAddress(driver);
		Boolean status = heroMyAddress.updateHeroAddress("Home", "Rochester NY");
		Assert.assertTrue(status);
		driver.close();
	}
}
