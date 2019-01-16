package api;

import org.testng.annotations.BeforeClass;

import io.restassured.RestAssured;

public class BaseTest {
	@BeforeClass
	protected void setup() {
		RestAssured.baseURI = "https://www.ynet.co.il/";
		RestAssured.proxy("localhost",8888); 
		RestAssured.useRelaxedHTTPSValidation();

	}
}
