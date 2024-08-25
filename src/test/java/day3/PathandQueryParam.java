package day3;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

public class PathandQueryParam {
//https://reqres.in/api/users?page=2&id=5
	
	@Test
	void PathandQueryPara()
	{
		given()
		.pathParam("mypath","users")
		.queryParam("page",2)
		.queryParam("id",5)
		
		.when()
		  .get("https://reqres.in/api/{mypath}")
		.then()
		  .statusCode(200)
		  .log().all();
	}
	
	
	
}
