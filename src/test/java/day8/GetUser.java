package day8;

import static io.restassured.RestAssured.given;

import org.testng.ITestContext;
import org.testng.annotations.Test;

public class GetUser {
	@Test
	void testCreateUser(ITestContext context)
	{
		int id=(Integer) context.getAttribute("user_id");
		String bearerToken="e8c7d3d8262111a9fa0baca9ef9bba86ea8909110362e52bb493f6f79a8e5343";
		
		given()
		.headers("Authorization","Bearer "+bearerToken)
	     .pathParam("id",id)
		
		.when()
		.get("https://gorest.co.in/public/v2/users/{id}")
		.then()
		.statusCode(200)
		.log().all();	
	}
}
