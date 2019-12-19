package com.involveme.InvolveMeMaven;



import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;



public class LogInPageTest extends BaseTest{

	@Override
	@BeforeClass
	public void setupLogin() {}//override the method at baseTest because the tests are checks case of wrong credentials
	
	@Test
	public void loginWithWrongPassword() {//the method checks the case of wrong password
		LoginPage loginPage = new LoginPage(driver);
		String errorMessage = loginPage.login("rozenmatan1989@gmail.com","k6v5f3x7x","wrongCredentials");
		AssertJUnit.assertEquals(errorMessage,"These credentials do not match our records.");
	}
	@Test
	public void loginWithWrongCredentials() {//the method checks the case of wrong email and password
		LoginPage loginPage = new LoginPage(driver);
		String errorMessage = loginPage.login("jrelkdglo@gmail.com","R5ibng9","wrongCredentials");
		AssertJUnit.assertEquals(errorMessage,"These credentials do not match our records.");
	}

}
