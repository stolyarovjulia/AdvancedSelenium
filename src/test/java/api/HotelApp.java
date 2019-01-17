package api;

import static io.restassured.RestAssured.*;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HotelApp extends BaseTest {

	@Test(description = "Body Assertion")
	public void PostCreateNewHotel() throws InterruptedException {
		{
			String Body = "{\r\n\"city\": \"Hod Hasharon\",\r\n\"description\": \"Automation Hotel\",\r\n\"name\":\"Nir Great hotel\",\r\n\"rating\":5\r\n}";
			given().body(Body).when().post("http://localhost:8090/example/v1/hotels").then().statusCode(201);
		}
	}

}
