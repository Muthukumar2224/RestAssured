package day7;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import org.testng.annotations.Test;
public class Authentications {
//Basic Authentication
	//@Test
	void testBasicAuthentication()
	{
		given()
		.auth().basic("postman","password")
		.when()
		.get("https://postman-echo.com/basic-auth")
		.then()
		.statusCode(200)
		.body("authenticated",equalTo(true))
		.log().all();
	}
	//DigestAuthentication
	void testDigestAuthentication()
	{
		given()
		.auth().digest("postman","password")
		.when()
		.get("https://postman-echo.com/basic-auth")
		.then()
		.statusCode(200)
		.body("authenticated",equalTo(true))
		.log().all();
	}
	//PreemptiveAuthentication
	void testPreemptiveAuthentication()
	{
		given()
		.auth().preemptive().basic("postman","password")
		.when()
		.get("https://postman-echo.com/basic-auth")
		.then()
		.statusCode(200)
		.body("authenticated",equalTo(true))
		.log().all();
	}
	//BearerToken Auth
	//@Test
	void testBearerTokenAuthentication()
	{
		String BearerToken = "";
		
		given()
		.headers("Authorization","Bearer "+BearerToken)
		.when()
		.get("https://api.github.com/users/repos")
		.then()
		.statusCode(200)
		.log().all();
	}
	//@Test
	void testOAuth2Authentication()
	{
			
		given()
		.auth().oauth2("")
		.when()
		.get("https://api.github.com/users/repos")
		.then()
		.statusCode(200)
		.log().all();
	}
	@Test
	void APIKeyAuthentication()
	{
			
		given()
		.queryParam("appid","4a09276527f73effbc25eefee249a3cf")
		.when()
		.get("https://api.openweathermap.org/data/2.5/weather?q=Salem&appid=4a09276527f73effbc25eefee249a3cf")
		.then()
		.statusCode(200)
		.log().all();
	}

	
	
}
