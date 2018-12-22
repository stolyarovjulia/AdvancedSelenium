package tests;

import org.testng.annotations.Test;

import pageobjects.LoginPage;

public class LoginTest extends BaseTest{
	
	@Test
	public void lg1_loginFailed() throws InterruptedException {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login("standard_user", "111");
		
	}
	
	@Test
	public void lg11_loginFailed() throws InterruptedException {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login("standard_user", "333");
	}
	
	@Test
	public void lg2_loginSucced() throws InterruptedException {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login("standard_user", "secret_sauce");
	}
	
	
}
