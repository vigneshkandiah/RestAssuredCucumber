package Hooks;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.restassured.RestAssured;

public class CucumberAnnotations {
	
	@Before
	public void init() {
		
		
		RestAssured.baseURI="https://dev65622.service-now.com/api/now/table/incident";
		RestAssured.authentication=RestAssured.basic("admin", "Password@1");
		
		
		
	}
	@After
	public void tearDown(Scenario sc) {
		
		System.out.println(sc.getId());
		
		System.out.println(sc.getStatus());
		
		System.out.println(sc.getName());
		
	}

}
