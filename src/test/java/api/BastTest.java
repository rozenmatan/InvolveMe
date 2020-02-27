package api;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeSuite;
import io.restassured.http.ContentType;

public class BastTest {

	@BeforeSuite
	public void checkResponseStatus() {

		given().when().get("https://app.involve.me/login").then().statusCode(200);
	}

	@BeforeSuite
	public void checkContentType() {

		given().when().get("https://app.involve.me/login").then().contentType(ContentType.HTML);
	}

	@BeforeSuite
	public void checkTitleTag() {

		given().when().get("https://app.involve.me/login").then().body("html.head.title",
				equalTo("Login | involve.me"));
	}

	@BeforeSuite
	public void checkResponseTime() {

		given().when().get("https://app.involve.me/login").then().time(lessThan(2L), TimeUnit.SECONDS);
	}
}
