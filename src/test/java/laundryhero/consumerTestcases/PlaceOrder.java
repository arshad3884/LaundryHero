package laundryhero.consumerTestcases;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import junit.framework.Assert;
import laundryhero.TestComponents.BaseTest;
import laundryhero.pageobjects.ConsumerHome;
import laundryhero.pageobjects.CreateOrder;
import laundryhero.pageobjects.LoginPage;

public class PlaceOrder extends BaseTest {

	@Test
	public void loginApplication() {
		initializeDriver();
		LoginPage loginpage = new LoginPage(driver);
		loginpage.goTO();
		loginpage.loginApplication("elorajames@yopmail.com", "qwerty123");
		driver.close();
	}
	
	@Test
	public void placeNewOrder() throws InterruptedException {
		initializeDriver();
		LoginPage loginpage = new LoginPage(driver);
		loginpage.goTO();
		loginpage.loginApplication("elorajames@yopmail.com", "qwerty123");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.jsReturnsValue("return document.readyState === 'complete'"));
		ConsumerHome consumerHome = new ConsumerHome(driver);
		consumerHome.clickCreateOrder();
		CreateOrder createorder = new CreateOrder(driver);
		boolean status = createorder.createOrder();
		Assert.assertTrue(status);
		driver.close();
	}
}
