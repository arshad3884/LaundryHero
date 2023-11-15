package laundryhero.consumerTestcases;

import org.testng.annotations.Test;

import junit.framework.Assert;
import laundryhero.TestComponents.BaseTest;
import laundryhero.pageobjects.Forgot_Reset_Password;
import laundryhero.pageobjects.LoginPage;

public class Forgot_or_Reset_Password extends BaseTest{
	
	@Test
	public void forgotPassword()
	{
		initializeDriver();
		LoginPage loginpage = new LoginPage(driver);
		loginpage.goTO();
		loginpage.loginApplication("elorajames@yopmail.com", "qwerty123");
		loginpage.goTOforgotPassword();
		Forgot_Reset_Password setpassword = new Forgot_Reset_Password(driver);
		setpassword.goToforgotPassword("testqatester81@gmail.com");
		driver.close();
	}

	public void resetPassword() throws InterruptedException
	{
		initializeDriver();
		LoginPage loginpage = new LoginPage(driver);
		loginpage.goTO();
		loginpage.loginApplication("elorajames@yopmail.com", "qwerty123");
		loginpage.goTOforgotPassword();
		Forgot_Reset_Password setpassword = new Forgot_Reset_Password(driver);
		setpassword.goToforgotPassword("testqatester81@gmail.com");
		boolean status = setpassword.Resetpassword("123456789", "qwerty123");
		Assert.assertTrue(status);
		driver.close();
	}	
	
}
