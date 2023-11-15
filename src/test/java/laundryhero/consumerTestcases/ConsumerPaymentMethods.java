package laundryhero.consumerTestcases;

import org.testng.annotations.Test;

import junit.framework.Assert;
import laundryhero.TestComponents.BaseTest;
import laundryhero.pageobjects.ConsumerHome;
import laundryhero.pageobjects.ConsumerMyAccount;
import laundryhero.pageobjects.ConsumerPaymentMethod;
import laundryhero.pageobjects.LoginPage;

public class ConsumerPaymentMethods extends BaseTest{
	
	@Test
	public void addConsumerPaymentMethod() throws InterruptedException
	{
		initializeDriver();
		LoginPage loginpage = new LoginPage(driver);
		loginpage.goTO();
		loginpage.loginApplication("elorajames@yopmail.com", "qwerty123");
		ConsumerHome consumerHome = new ConsumerHome(driver);
		consumerHome.goToMyAccount();
		ConsumerMyAccount myAccount = new ConsumerMyAccount(driver);
		myAccount.goToConsumerPaymentMethod();
		ConsumerPaymentMethod consumerPayment = new ConsumerPaymentMethod(driver);
		Boolean status = consumerPayment.addNewPaymentMethod("4242424242424242", "1226", "456");
		Assert.assertTrue(status);
		driver.close();
	}

	@Test
	public void makePaymentMethodDefault() throws InterruptedException
	{
		initializeDriver();
		LoginPage loginpage = new LoginPage(driver);
		loginpage.goTO();
		loginpage.loginApplication("elorajames@yopmail.com", "qwerty123");
		ConsumerHome consumerHome = new ConsumerHome(driver);
		consumerHome.goToMyAccount();
		ConsumerMyAccount myAccount = new ConsumerMyAccount(driver);
		myAccount.goToConsumerPaymentMethod();
		ConsumerPaymentMethod consumerPayment = new ConsumerPaymentMethod(driver);
		Boolean status = consumerPayment.makePaymentMethodDefault();
		Assert.assertTrue(status);
		driver.close();
	}
	@Test
	public void deletePaymentMethod() throws InterruptedException
	{
		initializeDriver();
		LoginPage loginpage = new LoginPage(driver);
		loginpage.goTO();
		loginpage.loginApplication("elorajames@yopmail.com", "qwerty123");
		ConsumerHome consumerHome = new ConsumerHome(driver);
		consumerHome.goToMyAccount();
		ConsumerMyAccount myAccount = new ConsumerMyAccount(driver);
		myAccount.goToConsumerPaymentMethod();
		ConsumerPaymentMethod consumerPayment = new ConsumerPaymentMethod(driver);
		Boolean status = consumerPayment.deletePaymentMethod();
		Assert.assertTrue(status);
		driver.close();
	}
}
