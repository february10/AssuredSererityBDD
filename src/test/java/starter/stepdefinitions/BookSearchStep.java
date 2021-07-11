package starter.stepdefinitions;

import org.junit.runner.RunWith;
import org.testng.annotations.BeforeClass;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Step;
@RunWith(SerenityRunner.class)
public class BookSearchStep {

	final String BASE_URI = "https://fakerestapi.azurewebsites.net";
	final String BASE_PATH = "/api/v1/Books";
	
	
	@BeforeClass
	public void setup() {
		// Setting BaseURI once
		RestAssured.baseURI = BASE_URI;
		// Setting BasePath once
		RestAssured.basePath = BASE_PATH;
	}
	
	@Step
	public void request1() {
		RequestSpecification request = RestAssured.given();

		Response response = request.get();

		System.out.println(response.asString());
	}
	
	@Step
	public void request2() {
		RequestSpecification request = RestAssured.given();

		Response response = request.get();

		System.out.println(response.asString());
	}
}
