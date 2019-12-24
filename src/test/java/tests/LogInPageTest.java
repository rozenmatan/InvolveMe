package tests;



import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pageobjects.LoginPage;
import org.testng.annotations.DataProvider;


@Epic("Login page")
public class LogInPageTest extends BaseTest{

	@Override
	@BeforeClass
	public void setupLogin() {}
	
	@Severity(SeverityLevel.CRITICAL)
	@Description("Checks the case of invaild email and password")
	@Test(dataProvider = "getCredentials", description = "Invalid Login")
	public void loginWithWrongPassword(String email,String password) {//
		LoginPage loginPage = new LoginPage(driver);
		String errorMessage = loginPage.login(email,password,"wrongCredentials");
		AssertJUnit.assertEquals(errorMessage,"These credentials do not match our records.");
	}

	@DataProvider
	public Object[][] getCredentials(){
		Object[][] myData = {
				{"rozenmatan1989@gmail.com","k6v5f3x7x"},
				{"jrelkdglo@gmail.com","R5ibng9"},
		};
		return myData;
	}
}
