package api;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class HotelApp extends BaseTest {

	@Test(description = "Static Post", enabled = false)
	public void PostCreateNewHotelStatic() throws InterruptedException {
		{
			given().body(
					"{\r\n\"city\": \"Hod Hasharon\",\r\n\"description\": \"Automation Hotel\",\r\n\"name\":\"Nir Great hotel\",\r\n\"rating\":5\r\n}")
					.when().post("http://localhost:8090/example/v1/hotels").then().statusCode(201);
		}
	}

	@Test(description = "Dynamic Post", enabled = false)
	public void PostCreateNewHotelDynamic() throws InterruptedException {
		{
			createFakeHotel("hod Hasharon", "Automation Hotel", "Nir Great hotel", 5);
		}
	}

	@Test(description = "Dynamic Post", enabled = false, invocationCount = 50)
	public void PostCreateNewHotelDynamic1() throws InterruptedException {
		{
			createFakeHotel();
		}
	}

	@Test(description = "Delete Static", enabled = false)
	public void DeleteNewHotelStatic() throws InterruptedException {
		{
			given().pathParam("hotelId", 11).when().delete("http://localhost:8090/example/v1/hotels/{hotelId}").then()
					.statusCode(204);
		}
	}

	@Test(description = "Delete All Hotels", enabled = true)
	public void DeleteNewHotelDynamic() throws InterruptedException {
		{
			Response response = when().get("http://localhost:8090/example/v1/hotels").then().extract().response();
			ArrayList<Integer> hotelIDS = new ArrayList<>();
			hotelIDS.addAll(response.path("content.id"));
			hotelIDS.forEach(ID -> {
				given().pathParam("hotelId", ID).when().delete("http://localhost:8090/example/v1/hotels/{hotelId}")
						.then().statusCode(204);
			});
		}
	}

	@Test(description = "PUT", enabled = false)
	public void PUTExistingHotel() throws InterruptedException {
		{
			String Body = "{\n \"id\": 10,\n\"city\": \"Safed1 \",\n\"description\": \"AirBNB\",\n\"name\":\"BMC hotel\",\n\"rating\":10\n}";
			given().body(Body).when().put("http://localhost:8090/example/v1/hotels/10").then().statusCode(204);

		}
	}

	private void createFakeHotel(String city, String description, String Name, int rating) {
		given().log().all()
				.body(String.format(
						"{\r\n\"city\": \"%s\",\r\n\"description\": \"%s\",\r\n\"name\":\"%s\",\r\n\"rating\":%d\r\n}",
						city, description, Name, rating))
				.when().post("http://localhost:8090/example/v1/hotels").then().statusCode(201);
	}

	private void createFakeHotel() {
		given().log().all()
				.body(String.format(
						"{\r\n\"city\": \"%s\",\r\n\"description\": \"%s\",\r\n\"name\":\"%s\",\r\n\"rating\":%d\r\n}",
						faker.address().city(), faker.lorem().paragraph(), faker.company().name(),
						faker.number().randomDigit()))
				.when().post("http://localhost:8090/example/v1/hotels").then().statusCode(201);
	}

}
