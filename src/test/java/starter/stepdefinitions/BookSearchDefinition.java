package starter.stepdefinitions;

import static org.hamcrest.Matchers.is;

import java.io.IOException;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;

public class BookSearchDefinition {
	public String BASE_URL = "https://fakerestapi.azurewebsites.net/api/v1/books/";
	public RestAssured rest;
	public Response response, getBookTit;

	@Given("He checks link available")
	public void he_checks_link_available() throws IOException {
		SerenityRest.given().contentType("application/json").header("Content-Type", "application/json").when()
				.get(BASE_URL);

	}

	@When("He checks a {int} in list")
	public void he_checks_a_code_in_list(int code) {
		RestAssured.given().basePath(BASE_URL).baseUri("/" + code);

	}

	@Then("The status code should be return (\\d+)")
	public void the_status_code_should_be_return() {
		SerenityRest.given().when().get(BASE_URL).then().statusCode(200);
	}

	@Given("A link to verify")
	public void a_link_to_verify() {
		SerenityRest.given().contentType("application/json").header("Content-Type", "application/json").when()
				.get(BASE_URL);
	}

	@When("I get the total of book")
	public void i_get_the_total_of_book() {
		response = SerenityRest.given().header("Accept", "application/json").when().get(BASE_URL).then().extract()
				.response();
	}

	@Then("The total of book should be {int}")
	public void the_total_of_book_should_be(int total) {
		int tbook = response.jsonPath().getList("id").size();
		Assert.assertEquals(tbook, total);

	}

	// Get book by book title
	@Given("A link to get book {int}")
	public void a_link_to_get_book(int bookId) {
		getBookTit = SerenityRest.when().get(BASE_URL + bookId);
	}

	@When("Validate a book by {string}")
	public void validate_a_book_by_book(String bookTitle) {
		getBookTit.then().body("title", is(bookTitle));
		Assert.assertFalse(bookTitle, false);

	}

	@Then("The status code shoud be return {int}")
	public void the_status_code_shoud_be_return(int statusCode) {
		getBookTit.then().statusCode(statusCode);

	}

}
