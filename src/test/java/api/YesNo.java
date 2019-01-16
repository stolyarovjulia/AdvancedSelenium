package api;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.*;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class YesNo extends BaseTest{
	@Test(description = "Body Assertion")
	public void bodyAssertion() throws InterruptedException {
		{
			when().get("https://yesno.wtf/api").then().body("answer", equalTo("yes"));

		}
	}

	@Test(description = "Get Value From Response")
	public void getValueFromResponse() throws InterruptedException {
		{
			Response response = when().get("https://yesno.wtf/api").then().extract().response();
			String Answer = response.path("answer");
			System.out.println(Answer);

		}
	}

	@Test(description = "Retrive Body")
	public void retriveBody() throws InterruptedException {

		{
			String Body = when().get("https://yesno.wtf/api").asString();
			System.out.println(Body);
		}
	}

	@Test(description = "Check and retrive Body")
	public void retriveBody1() throws InterruptedException {
		{
			Response response = when().get("https://yesno.wtf/api").then().contentType(ContentType.XML).extract()
					.response();
			// will run only if response type XML
			System.out.println(response.asString());
		}
	}

}
