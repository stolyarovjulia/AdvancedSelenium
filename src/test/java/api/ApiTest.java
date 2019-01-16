package api;

import static io.restassured.RestAssured.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ApiTest extends BaseTest {
	@Test(description = "GET YNET return 200")
	public void StatusCode200Ynet() throws InterruptedException {

		{
			given().when().get("home/0,7340,L-8,00.html").then().statusCode(200);

		}
	}

	@Test(description = "GET does not return Forbiden")
	public void StatusCodeIsNot403() throws InterruptedException {

		{
			RequestSpecification httpRequest = RestAssured.given();
			Response response = httpRequest.get("home/0,7340,L-8,00.html1");
			Assert.assertNotEquals(403, response.getStatusCode(), "Test Failed Response is" + response.getStatusCode());

		}

	}
}
