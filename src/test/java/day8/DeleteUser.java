package day8;

import static io.restassured.RestAssured.given;

import org.testng.ITestContext;
import org.testng.annotations.Test;

public class DeleteUser {
@Test
	void testDeleteUser(ITestContext context)
	{
		
		String bearerToken="e8c7d3d8262111a9fa0baca9ef9bba86ea8909110362e52bb493f6f79a8e5343";
		int id =(Integer)context.getAttribute("user_id");
	     given()
		.headers("Authorization","Bearer "+bearerToken)
		.pathParam("id",id)
		
		.when()
		.delete("https://gorest.co.in/public/v2/users/{id}")
		.then()
		.statusCode(204)
		.and().log().all();
	}
	
}
