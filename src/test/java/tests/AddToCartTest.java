package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.CompletePage;
import pageobjects.LoginPage;
import pageobjects.OverViewPage;
import pageobjects.ProductsPage;
import pageobjects.YourCartPage;
import pageobjects.YourInfoPage;

public class AddToCartTest extends BaseTest{
	
	@Test
	public void addToCartCancel() throws InterruptedException {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login("standard_user", "secret_sauce");
		
		ProductsPage pPage = new ProductsPage(driver);
		pPage.addToCart("Sauce Labs Bolt T-Shirt");
		pPage.addToCart("Sauce Labs Fleece Jacket");
		pPage.openCart();
		
		YourCartPage ycPage = new YourCartPage(driver);
		ycPage.checkOut();
		
		YourInfoPage yipPage = new YourInfoPage(driver);
		yipPage.addYourInfo("gal", "ester", "555");
		
		OverViewPage ovPage = new OverViewPage(driver);
		ovPage.cancel();
		
		pPage = new ProductsPage(driver);
		System.out.println(pPage.getNumberOfProductInCart());
		Assert.assertEquals(pPage.getNumberOfProductInCart(), 2);
	}
	
	@Test
	public void addToCartSucceed() {
		ProductsPage pPage = new ProductsPage(driver);
		pPage.openCart();
		
		YourCartPage ycPage = new YourCartPage(driver);
		ycPage.checkOut();
		
		YourInfoPage yipPage = new YourInfoPage(driver);
		yipPage.addYourInfo("gal", "ester", "555");
		
		OverViewPage ovPage = new OverViewPage(driver);
		ovPage.finish();
		
		CompletePage cPage = new CompletePage(driver);
		Assert.assertEquals(cPage.getMessage(), "THANK YOU FOR YOUR ORDER");
	}
	
	

}
