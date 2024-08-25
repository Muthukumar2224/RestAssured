package day1;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;

import org.testng.annotations.Test;

public class HttpRequests {
int id;
	@Test(priority=1)
	void getUser() {
		
		given()
		.when()
		  .get("https://reqres.in/api/users?page=2")
		.then()
		 .statusCode(200)
		 .body("page",equalTo(2))
		 .log().all();
	}
	@Test(priority=2)
	void createuser()
	{
		HashMap data =new HashMap();
		data.put("name", "pavan");
		data.put("job","trainer");
		
		id = given()
		  .contentType("application/json")
		  .body(data)
		.when()
		  .post("https://reqres.in/api/users")
		  .jsonPath().getInt("id");
//		.then()
//		  .statusCode(201)
//		  .log().all();
	}
	@Test(priority=3,dependsOnMethods= {"createuser"})
	void updateUser()
	{
		HashMap data = new HashMap();
		data.put("name","John");
		data.put("job","teacher");
		
		given()
			.contentType("application/json")
			.body(data)
			
		.when()
		   .put("https://reqres.in/api/users/"+id)
		
		.then()
		    .statusCode(200)
		    .log().all();
	}
	@Test(priority=4)
	void deleteuser()
	{
		given()
		.when().delete("https://reqres.in/api/users/"+id)
		.then().statusCode(204).log().all();
	}
}
