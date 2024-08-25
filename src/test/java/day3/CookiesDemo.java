package day3;
import static io.restassured.RestAssured.given;

import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class CookiesDemo {
   // @Test
	void  testCookies()
	{
		given()
		
		.when()
		   .get("https://www.google.com/")
		.then()
		   .cookie("AEC","AVYB7cpH7lKYGDd3IHpph6QYfK_V9AEf2sVli-pNLnBp0urdp-mafQccXoQ")
		   .log().all();
	}
    @Test(priority=2)
    void  getCookiesInfo()
	{
		Response res = given()
		
		.when()
		   .get("https://www.google.com/");
		//get single cookie info
		
//		String cookie_value = res.getCookie("AEC");
//		System.out.println(cookie_value);
		
		//get all cookies info
		 Map<String, String> cookie_values = res.getCookies();
		 
		 for(String k:cookie_values.keySet())
		 {
			 String cookie_value = res.getCookie(k);
			 System.out.println(k+"   "+cookie_value);
		 }
		
	}
}
