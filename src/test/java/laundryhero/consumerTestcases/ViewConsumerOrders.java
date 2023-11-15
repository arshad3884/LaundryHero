package laundryhero.consumerTestcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import junit.framework.Assert;
import laundryhero.TestComponents.BaseTest;
import laundryhero.pageobjects.ConsumerHome;
import laundryhero.pageobjects.ConsumerMyOrders;
import laundryhero.pageobjects.LoginPage;

public class ViewConsumerOrders extends BaseTest{

	@Test
	public void goToConsumerOrdersPage()
	{
		initializeDriver();
		LoginPage loginpage = new LoginPage(driver);
		loginpage.goTO();
		loginpage.loginApplication("elorajames@yopmail.com", "qwerty123");
		ConsumerHome consumerHome = new ConsumerHome(driver);
		consumerHome.goToMyOrders();
		ConsumerMyOrders consumerOrders = new ConsumerMyOrders(driver);
		boolean status = consumerOrders.goToMyOrders();
		Assert.assertTrue(status);
		driver.close();
	}
	
	@Test
	public void goToConsumerOrderDetail()
	{
		WebDriver driver = initializeDriver();
		LoginPage loginpage = new LoginPage(driver);
		loginpage.goTO();
		loginpage.loginApplication("elorajames@yopmail.com", "qwerty123");
		ConsumerHome consumerHome = new ConsumerHome(driver);
		consumerHome.goToMyOrders();
		ConsumerMyOrders consumerOrders = new ConsumerMyOrders(driver);
		//Will open detail of specific order 
		boolean status = consumerOrders.goToOrderDetail("644b74eacfc9a4748f973925");
		Assert.assertTrue(status);
		driver.close();
	}

	@Test
	public void showConsumerPendingOrdersList()
	{
		WebDriver driver = initializeDriver();
		LoginPage loginpage = new LoginPage(driver);
		loginpage.goTO();
		loginpage.loginApplication("elorajames@yopmail.com", "qwerty123");
		ConsumerHome consumerHome = new ConsumerHome(driver);
		consumerHome.goToMyOrders();
		ConsumerMyOrders consumerOrders = new ConsumerMyOrders(driver);
		//Open list of inprogress orders list of consumer
		boolean status = consumerOrders.showPendingOrderslist();
		Assert.assertTrue(status);
		driver.close();
	}
	@Test
	public void showConsumerCompletedOrdersList()
	{
		WebDriver driver = initializeDriver();
		LoginPage loginpage = new LoginPage(driver);
		loginpage.goTO();
		loginpage.loginApplication("elorajames@yopmail.com", "qwerty123");
		ConsumerHome consumerHome = new ConsumerHome(driver);
		consumerHome.goToMyOrders();
		ConsumerMyOrders consumerOrders = new ConsumerMyOrders(driver);
		//Open list of completed orders list of consumer
		boolean status = consumerOrders.showCompletedOrderslist();
		Assert.assertTrue(status);
		driver.close();
	}

	@Test
	public void openConsumerAllPendingOrder() throws InterruptedException
	{
		WebDriver driver = initializeDriver();
		LoginPage loginpage = new LoginPage(driver);
		loginpage.goTO();
		loginpage.loginApplication("elorajames@yopmail.com", "qwerty123");
		ConsumerHome consumerHome = new ConsumerHome(driver);
		consumerHome.goToMyOrders();
		ConsumerMyOrders consumerOrders = new ConsumerMyOrders(driver);
		//Open all pending orders in new tabs
		boolean status = consumerOrders.openAllPendingOrders();
		Assert.assertTrue(status);
	}
	@Test
	public void openConsumerAllCompletedOrder() throws InterruptedException
	{
		WebDriver driver = initializeDriver();
		LoginPage loginpage = new LoginPage(driver);
		loginpage.goTO();
		loginpage.loginApplication("elorajames@yopmail.com", "qwerty123");
		ConsumerHome consumerHome = new ConsumerHome(driver);
		consumerHome.goToMyOrders();
		ConsumerMyOrders consumerOrders = new ConsumerMyOrders(driver);
		//Open all completed orders in new tabs
		boolean status = consumerOrders.openAllCompletedOrders();
		Assert.assertTrue(status);
		driver.quit();
	}
	@Test
	public void addHerotoFavourite() throws InterruptedException
	{
		WebDriver driver = initializeDriver();
		LoginPage loginpage = new LoginPage(driver);
		loginpage.goTO();
		loginpage.loginApplication("elorajames@yopmail.com", "qwerty123");
		ConsumerHome consumerHome = new ConsumerHome(driver);
		consumerHome.goToMyOrders();
		ConsumerMyOrders consumerOrders = new ConsumerMyOrders(driver);
		consumerOrders.showCompletedOrderslist();
		boolean status = consumerOrders.addHeroToFavourite();
		Assert.assertTrue(status);
		driver.close();
	}
	@Test
	public void removeHeroFromFavourite() throws InterruptedException
	{
		WebDriver driver = initializeDriver();
		LoginPage loginpage = new LoginPage(driver);
		loginpage.goTO();
		loginpage.loginApplication("elorajames@yopmail.com", "qwerty123");
		ConsumerHome consumerHome = new ConsumerHome(driver);
		consumerHome.goToMyHeroes();
		ConsumerMyOrders consumerOrders = new ConsumerMyOrders(driver);
		boolean status = consumerOrders.removeHeroFromFavourite();
		Assert.assertTrue(status);
		driver.close();
	}
	@Test
	public void rateCompletedOrder() throws InterruptedException
	{
		WebDriver driver = initializeDriver();
		LoginPage loginpage = new LoginPage(driver);
		loginpage.goTO();
		loginpage.loginApplication("hannahjames@yopmail.com", "qwerty123");
		ConsumerHome consumerHome = new ConsumerHome(driver);
		consumerHome.goToMyOrders();
		ConsumerMyOrders consumerOrders = new ConsumerMyOrders(driver);
		boolean status = consumerOrders.rateYourOrder();
		Assert.assertTrue(status);
		driver.close();
	}
}
