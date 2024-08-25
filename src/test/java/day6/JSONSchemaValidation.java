package day6;
import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.module.jsv.JsonSchemaValidator;



@Test
public class JSONSchemaValidation 
{

	void jsonschemavalidation() {
	given()
	.when()
	 .get("http://localhost:3000/store")
	.then()
	  .assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("storejsonschema.json"));
			  
}	
}
