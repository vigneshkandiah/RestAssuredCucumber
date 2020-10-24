package steps;

import static org.hamcrest.Matchers.equalTo;

import java.io.File;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class StepsForCreateIncidentWithoutBody {
	public static RequestSpecification response;
	public static Response post;
//	File jsonFile = new File("./(.*)$");
	
	
	public static RequestSpecification specification;
	
	@Given("Set the End Point")
	public void set_the_End_Point() {
	    // Write code here that turns the phrase above into concrete actions
		
		RestAssured.baseURI="https://dev65622.service-now.com/api/now/table/incident";
	    
	}

	@And("Set the Authendication")
	public void set_the_Authendication() {
		RestAssured.authentication=RestAssured.basic("admin", "Password@1");
	    
	}

	@And("Set the contentType as Json")
	
	public void set_the_contentType_as_Json() {
		specification = RestAssured.given().contentType(ContentType.JSON);
	    
	}

	@When("Create a new incident without body using Post method")
	public void create_a_new_incident_without_body_using_Post_method() {
		post = specification.when()
		.body("{\"short_description\" : \"My New Incident1\",\"category\":\"Hardware\"}")

		.accept(ContentType.JSON)

		.post();
	    
	}
	
	@When("Create a new incident with body using (.*)$")
	public void create_a_new_incident_with_body_using_File_for_Post_method(String FileName) {
	    post=specification.when().body(new File(FileName)).accept(ContentType.JSON).post();
	}

	@Then("The Incident is created in ServioceNow")
	public void the_Incident_is_created_in_ServioceNow() {
		post.then().contentType(ContentType.JSON).assertThat()
		.statusCode(201)
		.extract().response();
		
		post.prettyPrint();
	    
	}

}
