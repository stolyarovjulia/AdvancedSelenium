package api;

import static io.restassured.RestAssured.*;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HotelApp extends BaseTest {

	@Test(description = "Post", enabled = false)
	public void PostCreateNewHotel() throws InterruptedException {
		{
			String Body = "{\r\n\"city\": \"Hod Hasharon\",\r\n\"description\": \"Automation Hotel\",\r\n\"name\":\"Nir Great hotel\",\r\n\"rating\":5\r\n}";
			given().body(Body).when().post("http://localhost:8090/example/v1/hotels").then().statusCode(201);
		}
	}
	
	@Test(description = "Delete", enabled = false)
	public void DeleteNewHotel() throws InterruptedException {
		{
			given().pathParam("hotelId", 9).when().delete("http://localhost:8090/example/v1/hotels/{hotelId}").then().statusCode(204);
		}
	}

	@Test(description = "PUT", enabled = true)
	public void PUTNewHotel() throws InterruptedException {
		{
			String Body = "{\n \"id\": 10,\n\"city\": \"Safed1 \",\n\"description\": \"AirBNB\",\n\"name\":\"BMC hotel\",\n\"rating\":10\n}";
			given().body(Body).when().put("http://localhost:8090/example/v1/hotels/10").then().statusCode(204);

			
		}
	}

}
