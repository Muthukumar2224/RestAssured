package day8;

import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class UpdateUser {
	@Test
	void testUpdateUser(ITestContext context)
	{
		Faker faker = new Faker();
		JSONObject data = new JSONObject();
		
		data.put("name",faker.name().fullName());
		data.put("gender","Male");
		data.put("email",faker.internet().emailAddress());
		data.put("status","active");
		
		String bearerToken="e8c7d3d8262111a9fa0baca9ef9bba86ea8909110362e52bb493f6f79a8e5343";
		int id =(Integer) context.getAttribute("user_id");
	     given()
		.headers("Authorization","Bearer "+bearerToken)
		.contentType("application/json")
		.body(data.toString())
		.pathParam("id",id)
		
		
		.when()
		.put("https://gorest.co.in/public/v2/users/{id}")
		.then()
		.statusCode(200)
		.and().log().all();
		System.out.println(id);
	}
}
